package adminServlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import fileupload.util.MultipartRequestWrapper;
import vo.Product;


@SuppressWarnings("serial")
public class AddProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		request = new MultipartRequestWrapper(request, "D:/ClothingSellingMS/ClothingSellingMS/WebContent/uploaded_images/");//重新包装
		String name = request.getParameter("name") ;//接着就可以像往常一样处理请求了
		String type = request.getParameter("type");//接着就可以像往常一样处理请求了
		String price = request.getParameter("price") == null ? "0" : request.getParameter("price") ;
		String size = request.getParameter("size") ;
		String detail = request.getParameter("detail") ;
		String img = request.getParameter("pimg") ;
		
		Product product = new Product() ;
		product.setAmount(0);
		product.setDetail(detail);
		product.setName(name);
		product.setPath("uploaded_images/" + img);
		product.setPrice(Double.parseDouble(price));
		product.setSize(size);
		product.setType(type);
		
		try {
			DAOFactory.getProductDAOInstance().doCreate(product) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response) ;
	}
	
}
