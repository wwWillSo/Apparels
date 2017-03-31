package userServlet.basket;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.Basket;
import vo.User;

@SuppressWarnings("serial")
public class EditBasket extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			User user = (User)request.getSession().getAttribute("user") ;
			
			int basketId = Integer.parseInt(request.getParameter("basketId")) ;
			int productId = Integer.parseInt(request.getParameter("productId")) ;
			int amount = Integer.parseInt(request.getParameter("amount")) ;
			String size = request.getParameter("size") ;
			
			Basket basket = DAOFactory.getBasketDAOInstance().findById(basketId) ;
			basket.setAmount(amount);
			basket.setProductid(productId);
			basket.setSize(size);
			
			//¼ÆËã×Ü¶î
			double sum = DAOFactory.getProductDAOInstance().findById(basket.getProductid()).getPrice() * amount;
			basket.setSum(sum);
			
			DAOFactory.getBasketDAOInstance().doUpdate(basket) ;
			
			//Ìø×ª
//			request.getRequestDispatcher("/user/userShowBasket").forward(request, response);
			response.sendRedirect("userShowBasket") ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
