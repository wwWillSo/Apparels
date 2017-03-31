package dao.proxy;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.UserInfoDAOImpl;
import vo.User;
import vo.UserInfo;

public class UserInfoDAOProxy implements IDAO<UserInfo>{
	private DatabaseConnectionA  dbc = null ;
	private UserInfoDAOImpl dao = null ;
	
	public UserInfoDAOProxy() throws Exception {
		this.dbc = new DatabaseConnectionA() ;
		this.dao = new UserInfoDAOImpl(this.dbc.getConnection()) ;
	}
	public boolean doCreate(UserInfo vo) throws Exception {
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
	
	public Object doCreateGetId(UserInfo vo) throws Exception {
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

	public boolean doUpdate(UserInfo vo) throws Exception {
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

	public List<UserInfo> findAll() throws Exception {
		List<UserInfo> all = new ArrayList<UserInfo>() ;
		
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}

	public List<UserInfo> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInfo findById(int id) throws Exception {
		UserInfo userinfo = null ;
		
		try {
			userinfo = this.dao.findById(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return userinfo ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
