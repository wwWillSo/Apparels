package dao.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.AdminInfoDAOImpl;
import vo.AdminInfo;

public class AdminInfoDAOProxy implements IDAO<AdminInfo>{
	private DatabaseConnectionA  dbc = null ;
	private AdminInfoDAOImpl dao = null ;
	public AdminInfoDAOProxy() throws Exception{
		this.dbc = new DatabaseConnectionA();
		this.dao = new AdminInfoDAOImpl(this.dbc.getConnection());
	}
	public boolean doCreate(AdminInfo vo) throws Exception {
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

	public boolean doUpdate(AdminInfo vo) throws Exception {
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

	public List<AdminInfo> findAll() throws Exception {
		List<AdminInfo> all = new ArrayList<AdminInfo>() ;
		
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}

	public List<AdminInfo> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public AdminInfo findById(int id) throws Exception {
		AdminInfo admininfo = null ;
		
		try {
			admininfo = this.dao.findById(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return admininfo ;
	}	

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
