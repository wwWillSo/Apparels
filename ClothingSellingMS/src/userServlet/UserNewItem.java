package userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;

@SuppressWarnings("serial")
public class UserNewItem extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		try {
			//get user
			User user = (User)request.getSession().getAttribute("user");
			int product_id = Integer.parseInt(request.getParameter("product_id")); 
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String username = user.getName();
			String content = request.getParameter("remark");
		}catch(Exception e){
			e.printStackTrace();		
		}
	}
}
