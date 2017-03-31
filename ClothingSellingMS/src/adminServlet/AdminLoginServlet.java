package adminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.Admin;
import vo.AdminInfo;

@SuppressWarnings("serial")
public class AdminLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String adminname = request.getParameter("adminname") ;
			String password = request.getParameter("password") ;
			
			if (DAOFactory.getAdminDAOInstance().findByName(adminname) != null) {
				if (DAOFactory.getAdminDAOInstance().findByName(adminname).getPassword().equals(password)) {
					Admin admin = DAOFactory.getAdminDAOInstance().findByName(adminname) ;
					AdminInfo admininfo = admin.getAdmininfo() ;
					
					request.getSession().setAttribute("admin", admin);
					request.getSession().setAttribute("admininfo", admininfo);
					
					response.sendRedirect("../webpage/navigation.html") ;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
