package userServlet.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.Basket;
import vo.Order;
import vo.Product;
import vo.User;

@SuppressWarnings("serial")
public class UserNewOrder extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("utf-8");
		
		try {
			User user = (User)request.getSession().getAttribute("user") ;
			
			//这里拿回来的itemId是 “213,214,215,” 的格式，需要拆开来用
			String itemIdStr = request.getParameter("item") ;
			//这里将会变成 	{"213", "214", "215"}  这样的数组
			String[] itemIdStrArray = itemIdStr.split(",") ;
			
			//遍历购物篮
			for (String itemId : itemIdStrArray) {
				Basket basket = DAOFactory.getBasketDAOInstance().findById(Integer.parseInt(itemId)) ;
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss") ;
				Date today = new Date() ;
				
				//订单号    时间 + userId
				String transactionId = sdf.format(today) + basket.getUserid() ;
				
				Product product = DAOFactory.getProductDAOInstance().findById(basket.getProductid()) ;
				
				int order_amount = basket.getAmount() ;
				String order_size = basket.getSize() ; 
				String remark = request.getParameter("remark");
				
				double sum = order_amount * product.getPrice(); 
				
				Order order = new Order();
				
				order.setStatus("SUCCESS");
				order.setRemark(remark);
				order.setAmount(order_amount);
				order.setSize(order_size);
				order.setDate(today);
				order.setSum(sum);
				order.setProductid(basket.getProductid());
				order.setUserid(basket.getUserid());
				order.setTransactionId(transactionId);
				
				DAOFactory.getOrderDAOInstance().doCreate(order) ;
				
				//将此basket标记为“已下单”
				basket.setIsBought(1);
				DAOFactory.getBasketDAOInstance().doUpdate(basket) ;
			}
			
			response.sendRedirect("order_success.jsp");
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
		this.doGet(request, response);
	}
}
