package userServlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.Note;
import vo.User;

@SuppressWarnings("serial")
public class UserComment extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		try {
			//get user
			User user = (User)request.getSession().getAttribute("user");
			int product_id = Integer.parseInt(request.getParameter("product_id")); 
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String username = user.getName();
			String content = request.getParameter("remark");
			String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); 
			
			Note n =  new Note();
			n.setContent(content);
			n.setDate(datetime);
			n.setProductid(product_id);
			n.setUserid(user_id);
			
			DAOFactory.getNoteDAOInstance().doCreate(n);
			
		}catch(Exception e){
			e.printStackTrace();		
		}
	}
}
