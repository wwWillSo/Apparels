package dao.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.ProductDAOImpl;
import vo.Product;

public class ProductDAOProxy implements IDAO<Product>{
	private DatabaseConnectionA dbc = null ;
	private ProductDAOImpl dao = null;
	public ProductDAOProxy() throws Exception{
		this.dbc = new DatabaseConnectionA();
		this.dao = new ProductDAOImpl(this.dbc.getConnection());
	}
	public boolean doCreate(Product vo) throws Exception {
		boolean flag = false ;
		
		try {
			if (this.dao.findById(vo.getId()) == null) {
				flag = this.dao.doCreate(vo) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return flag ;
	}

	public boolean doDelete(int id) throws Exception {
		boolean flag = false ;
		
		try {
			if (this.dao.findById(id) != null) {
				flag = this.dao.doDelete(id) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return flag ;
	}

	public boolean doUpdate(Product vo) throws Exception {
		boolean flag = false ;
		
		try {
			if (this.dao.findById(vo.getId()) != null) {
				flag = this.dao.doUpdate(vo) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return flag ;
	}

	public List<Product> findAll() throws Exception {
		List<Product> all = new ArrayList<Product>();
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}

	public List<Product> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Product findById(int id) throws Exception {
		Product product = new Product();
		try {
			product = this.dao.findById(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return product ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
