package userServlet.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;

@SuppressWarnings("serial")
public class UserDeleteOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		try{
			
			int order_id = Integer.parseInt(request.getParameter("order_id"));
			
			DAOFactory.getOrderDAOInstance().doDelete(order_id);
			
			if ("self".equals(request.getParameter("flag"))) {
				//response.sendRedirect("show_pictures.jsp");
				String script = "<script>alert('DELETED!')</script>" ;
				response.getWriter().println(script);
//				request.getRequestDispatcher("index.jsp")
//				.forward(request, response);
				response.sendRedirect("./WebRoot/user/ShowAllOrders.jsp");
			} else {
				//response.sendRedirect("show_all_pictures.jsp");
				String script = "<script>alert('DELETED!')</script>" ;
				response.getWriter().println(script);
//				request.getRequestDispatcher("index.jsp")
//				.forward(request, response);
				response.sendRedirect("./WebRoot/user/ShowAllOrders.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
