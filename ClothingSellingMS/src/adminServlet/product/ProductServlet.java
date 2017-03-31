package adminServlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.Product;

@SuppressWarnings("serial")
public class ProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			List<Product> pl = DAOFactory.getProductDAOInstance().findAll();			
			
			request.setAttribute("productlist", pl);
			//Ìø×ª
			request.getRequestDispatcher("ProductList.jsp").forward(request,response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
