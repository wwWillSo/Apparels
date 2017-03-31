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
public class DeleteBasket extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			int basketId = Integer.parseInt(request.getParameter("basketId")) ;
			
			Basket basket = DAOFactory.getBasketDAOInstance().findById(basketId) ;
			
			DAOFactory.getBasketDAOInstance().doDelete(basketId) ;
			
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
