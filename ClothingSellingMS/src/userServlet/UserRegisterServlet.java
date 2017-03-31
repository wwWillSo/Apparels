package userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import fileupload.util.MultipartRequestWrapper;
import vo.User;
import vo.UserInfo;

@SuppressWarnings("serial")
public class UserRegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		request = new MultipartRequestWrapper(request, "D:/MyEclipse8.5/workspace/ClothingSellingMS/WebRoot/images/avatars/");//重新包装
		
		String name = request.getParameter("name") ;
		String password = request.getParameter("password") ;
		String ZIP = request.getParameter("ZIP");
		String email = request.getParameter("email") ;
		String TEL = request.getParameter("TEL") ;
		
		String avatars = request.getParameter("avatars") ;
		
		
		//先存userInfo
		UserInfo userinfo = new UserInfo() ;
		userinfo.setZIP(ZIP);
		userinfo.setEmail(email);
		userinfo.setTEL(TEL);
		//再存user
		User user = new User() ;
		user.setName(name);
		user.setPassword(password);
		user.setAvatars("images/avatars/" + avatars);
		
		//调用方法添记录
		try {
			Object id = DAOFactory.getUserInfoDAOInstance().doCreateGetId(userinfo) ;
			userinfo.setId(Integer.parseInt(id.toString()));
			user.setUserinfo(userinfo);
			DAOFactory.getUserDAOInstance().doCreate(user) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("../webpage/navigation.html");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		this.doGet(request, response);
	}
}
