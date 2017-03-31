package userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.User;
import vo.UserInfo;

@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String username = request.getParameter("username") ;
		String password = request.getParameter("password") ;
		
		try {
			if (DAOFactory.getUserDAOInstance().findByUserName(username) != null) {
				if (DAOFactory.getUserDAOInstance().findByUserName(username).getPassword().equals(password)) {
					User user = DAOFactory.getUserDAOInstance().findByUserName(username) ;
					UserInfo userinfo = user.getUserinfo() ;
					
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("userinfo", userinfo);
					
					response.sendRedirect("../webpage/navigation.html") ;
				}
			} else {
				response.sendRedirect("../webpage/navigation.html");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
