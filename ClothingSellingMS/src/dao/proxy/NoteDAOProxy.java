package dao.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.NoteDAOImpl;
import vo.Note;

public class NoteDAOProxy implements IDAO<Note>{
	private DatabaseConnectionA dbc = null ;
	private NoteDAOImpl dao = null;
	public  NoteDAOProxy() throws Exception{
		this.dbc = new DatabaseConnectionA();
		this.dao = new NoteDAOImpl(this.dbc.getConnection());
	}
	public boolean doCreate(Note vo) throws Exception {
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

	public boolean doUpdate(Note vo) throws Exception {
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

	public List<Note> findAll() throws Exception {
		List<Note> all = new ArrayList<Note>();
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}

	public List<Note> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Note findById(int id) throws Exception {
		Note note = new Note();
		try {
			note = this.dao.findById(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return note ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
