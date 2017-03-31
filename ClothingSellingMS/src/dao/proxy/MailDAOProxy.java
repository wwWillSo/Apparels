package dao.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.MailDAOImpl;
import vo.Mail;

public class MailDAOProxy implements IDAO<Mail>{
	private DatabaseConnectionA dbc = null ;
	private MailDAOImpl dao = null;
	public MailDAOProxy() throws Exception{
		this.dbc = new DatabaseConnectionA();
		this.dao = new MailDAOImpl(this.dbc.getConnection());
	}
	
	public boolean doCreate(Mail vo) throws Exception {
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

	public boolean doUpdate(Mail vo) throws Exception {
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

	public List<Mail> findAll() throws Exception {
		List<Mail> all = new ArrayList<Mail>();
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}

	public List<Mail> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Mail findById(int id) throws Exception {
		Mail mail = new Mail();
		try {
			mail = this.dao.findById(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return mail ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
