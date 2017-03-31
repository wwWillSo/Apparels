package dao.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.OrderDAOImpl;
import vo.Order;

public class OrderDAOProxy implements IDAO<Order>{
	private DatabaseConnectionA dbc = null ;
	private OrderDAOImpl dao = null;
	public OrderDAOProxy() throws Exception{
		this.dbc = new DatabaseConnectionA();
		this.dao = new OrderDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(Order vo) throws Exception {
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

	public boolean doUpdate(Order vo) throws Exception {
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

	public List<Order> findAll() throws Exception {
		List<Order> all = new ArrayList<Order>();
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}

	public List<Order> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Order findById(int id) throws Exception {
		Order order = new Order();
		
		try {
			order = this.dao.findById(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return order ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
