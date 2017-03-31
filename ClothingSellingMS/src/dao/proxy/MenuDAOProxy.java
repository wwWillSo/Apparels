package dao.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.dbc.DatabaseConnectionA;
import dao.impl.AdminDAOImpl;
import dao.impl.MenuDAOImpl;
import vo.Menu;

public class MenuDAOProxy implements IDAO<Menu>{
	private DatabaseConnectionA  dbc = null ;
	private MenuDAOImpl dao = null ;
	public MenuDAOProxy() throws Exception{
		this.dbc = new DatabaseConnectionA();
		this.dao = new MenuDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean doDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean doUpdate(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Menu findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Menu> findAll() throws Exception {
		List<Menu> all = new ArrayList<Menu>() ;
		
		try {
			all = this.dao.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close() ;
		}
		
		return all ;
	}
	@Override
	public List<Menu> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
