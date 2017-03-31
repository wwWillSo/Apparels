package dao.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.ProductTypeDAOImpl;
import vo.Admin;
import vo.ProductType;

public class ProductTypeDAOProxy implements IDAO<ProductType>{
	private DatabaseConnectionA  dbc = null ;
	private ProductTypeDAOImpl dao = null ;
	public ProductTypeDAOProxy() throws Exception{
		this.dbc = new DatabaseConnectionA();
		this.dao = new ProductTypeDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(ProductType vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean doDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean doUpdate(ProductType vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ProductType findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProductType> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProductType> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<ProductType> findAllByMenuId(int menuId) throws Exception {
		List<ProductType> all = new ArrayList<ProductType>() ;
		
		try {
			all = this.dao.findAllByMenuId(menuId) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}
}
