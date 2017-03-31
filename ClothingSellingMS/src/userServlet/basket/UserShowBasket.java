
package userServlet.basket;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.Basket;
import vo.Product;
import vo.User;

@SuppressWarnings("serial")
public class UserShowBasket extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			User user = (User)request.getSession().getAttribute("user") ;
			
			//根据user_id取得item
			Set<Basket> basketList = DAOFactory.getUserDAOInstance().getAllBasketByUserId(user.getId()) ;
			//将basket放进session
			
			for (Basket basket : basketList) {
				basket.setUser(user);
				Product product = DAOFactory.getProductDAOInstance().findById(basket.getProductid()) ;
				basket.setProduct(product);
			}
			
			request.setAttribute("basketList", basketList);
			//跳转
			request.getRequestDispatcher("ShowBasket.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
