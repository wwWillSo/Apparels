package dao.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.AdminDAOImpl;
import vo.Admin;

public class AdminDAOProxy implements IDAO<Admin>{
	private DatabaseConnectionA  dbc = null ;
	private AdminDAOImpl dao = null ;
	public AdminDAOProxy() throws Exception{
		this.dbc = new DatabaseConnectionA();
		this.dao = new AdminDAOImpl(this.dbc.getConnection());
	}
	
	public boolean doCreate(Admin vo) throws Exception {
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

	public boolean doUpdate(Admin vo) throws Exception {
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

	public List<Admin> findAll() throws Exception {
		List<Admin> all = new ArrayList<Admin>() ;
		
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}

	public List<Admin> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin findById(int id) throws Exception {
		Admin admin = null ;
		
		try {
			admin = this.dao.findById(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return admin ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Admin findByName(String adminname) throws Exception{
		return this.dao.findByName(adminname) ;
	}
	
}
