package dao.proxy;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.UserDAOImpl;
import vo.Basket;
import vo.User;

public class UserDAOProxy implements IDAO<User>{
	private DatabaseConnectionA dbc = null ;
	private UserDAOImpl dao = null ;
	
	public UserDAOProxy() throws Exception {
		this.dbc = new DatabaseConnectionA() ;
		this.dao = new UserDAOImpl(this.dbc.getConnection()) ;
	}
	public boolean doCreate(User vo) throws Exception {
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
	
	public Object doCreateGetId(User vo) throws Exception {
		return this.dao.doCreateGetId(vo) ;
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

	public boolean doUpdate(User vo) throws Exception {
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

	public List<User> findAll() throws Exception {
		List<User> all = new ArrayList<User>() ;
		
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}

	public List<User> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(int id) throws Exception {
		User user = null ;
		
		try {
			user = this.dao.findById(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return user ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public List<Basket> getAllBasketByUserId(int userid, String isBought) throws Exception {
		List<Basket> basket = new ArrayList<Basket>() ;
		try {
			basket = this.dao.getAllBasketByUserId(userid, isBought) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		
		return basket ;
	}
	public User findByUserName(String username) throws Exception{
		return this.dao.findByUserName(username) ;
	}

}
