package userServlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.Order;

@SuppressWarnings("serial")
public class ShowAllOrdersServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			List<Order> allOrders = DAOFactory.getOrderDAOInstance().findAll() ;
			request.setAttribute("allOrders", allOrders);
			
			//Ìø×ª
			response.sendRedirect("show_all_pictures.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
