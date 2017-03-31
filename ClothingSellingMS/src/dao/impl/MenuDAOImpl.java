package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import vo.Admin;
import vo.AdminInfo;
import vo.Menu;

public class MenuDAOImpl implements IDAO<Menu>{
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	
	public MenuDAOImpl(Connection conn) {
		this.conn = conn ;
	}

	@Override
	public boolean doCreate(Menu vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO menu VALUES ( ?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, vo.getMenuName());
		this.pstmt.setInt(2, vo.getMenuShowOrder()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
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
		List<Menu> list = new ArrayList<Menu>() ;
		
		String sql = "select id, menu_name, menu_show_order, enable from menu where enable = 0 order by menu_show_order" ;
		
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Menu menu = new Menu() ;
			menu.setId(rs.getInt(1));
			menu.setMenuName(rs.getString(2));
			menu.setMenuShowOrder(rs.getInt(3));
			menu.setEnable(rs.getInt(4));
			
			list.add(menu) ;
		}
		
		rs.close();
		
		this.pstmt.close();
		
		return list ;
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
