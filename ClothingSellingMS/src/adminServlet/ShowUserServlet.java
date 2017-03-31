package adminServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.Admin;
import vo.User;

public class ShowUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			User user = (User)request.getSession().getAttribute("user") ;
			
			//根据user_id取得item
		//	Admin admin = DAOFactory.getAdminDAOInstance().findById(1) ;
			List<Admin> ad = DAOFactory.getAdminDAOInstance().findAll();
			//将basket放进session
			
			
			//request.setAttribute("admin", admin);
			request.setAttribute("adminlist", ad);
			//跳转
			request.getRequestDispatcher("../user/ShowBasket.jsp").forward(request,response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
