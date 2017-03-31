
package userServlet.basket;

import java.io.IOException;
import java.util.List;

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

			//第二个参数是isBought, 0表示未下单，1表示已下单 ，null表示查询全部
			List<Basket> basketList = DAOFactory.getUserDAOInstance().getAllBasketByUserId(user.getId(), "0") ;
			
			for (Basket basket : basketList) {
				basket.setUser(user);
				Product product = DAOFactory.getProductDAOInstance().findById(basket.getProductid()) ;
				basket.setProduct(product);
			}
			
			request.setAttribute("basketList", basketList);
			//��ת
			request.getRequestDispatcher("ShowBasket.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
