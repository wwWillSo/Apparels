package userServlet.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.Order;
import vo.Product;
import vo.User;

@SuppressWarnings("serial")
public class UserNewOrder extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//…Ë÷√±‡¬Î
		request.setCharacterEncoding("utf-8");
		
		Order order = new Order();
		try {
			User user = (User)request.getSession().getAttribute("user") ;
			Product product = (Product)request.getSession().getAttribute("product");
			int product_id = Integer.parseInt("product_id");
			int user_id = Integer.parseInt("user_id");
			
			int order_amount = Integer.parseInt("order_amount");
			String order_size = request.getParameter("order_size"); 
			String remark = request.getParameter("remark");
			java.util.Date date = new java.util.Date();
			product.setId(product_id);
			user.setId(user_id);
			double sum = order_amount * product.getPrice(); 
			
			order.setRemark(remark);
			order.setAmount(order_amount);
			order.setSize(order_size);
			order.setDate(date);
			order.setSum(sum);
			order.setProductid(product_id);
			order.setUserid(user_id);
			
			DAOFactory.getOrderDAOInstance().doCreate(order) ;
			
			response.sendRedirect("order_success.jsp");
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
		this.doGet(request, response);
	}
}
