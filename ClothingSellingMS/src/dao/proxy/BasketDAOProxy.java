package dao.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.BasketDAOImpl;
import vo.Basket;

public class BasketDAOProxy implements IDAO<Basket>{
	private DatabaseConnectionA dbc = null ;
	private BasketDAOImpl dao = null ;
	public BasketDAOProxy()throws Exception{
		this.dbc = new DatabaseConnectionA() ;
		this.dao = new BasketDAOImpl(this.dbc.getConnection()) ;
	}
	public boolean doCreate(Basket vo) throws Exception {
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

	public boolean doUpdate(Basket vo) throws Exception {
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

	public List<Basket> findAll() throws Exception {
		List<Basket> all = new ArrayList<Basket>();
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}

	public List<Basket> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Basket findById(int id) throws Exception {
		Basket basket = null ;
		
		try {
			basket = this.dao.findById(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return basket ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
