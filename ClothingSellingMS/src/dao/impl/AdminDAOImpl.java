package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import vo.AdminInfo;

import dao.IDAO;

public class AdminDAOImpl implements IDAO<Admin>{
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	
	public AdminDAOImpl(Connection conn) {
		this.conn = conn ;
	}

	public boolean doCreate(Admin vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO admin VALUES ( ?, ?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		//this.pstmt.setInt(1, vo.getId()) ;
		this.pstmt.setString(2, vo.getName()) ;
		this.pstmt.setString(3, vo.getPassword());
		this.pstmt.setInt(4, vo.getAdmininfo().getId()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
		boolean flag = false ;
		
		String sql = "DELETE admin WHERE admin_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		
		this.pstmt.close();
		
		return flag;
	}

	public boolean doUpdate(Admin vo) throws Exception {
		boolean flag = false ;
		
		String sql = "UPDATE admin SET admin_name=?, admin_password=?, admininfo_id=? WHERE admin_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		
		this.pstmt.setString(1, vo.getName()) ;
		this.pstmt.setString(2, vo.getPassword());
		this.pstmt.setInt(3, vo.getAdmininfo().getId()) ;
		this.pstmt.setInt(4, vo.getId()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public List<Admin> findAll() throws Exception {
		List<Admin> all = new ArrayList<Admin>() ;
		String sql = "SELECT * FROM admin" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Admin admin = new Admin() ;
			admin.setId(rs.getInt(1));
			admin.setName(rs.getString(2));
			admin.setPassword(rs.getString(3));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM admininfo"
					+ " WHERE admininfo_id = 1" );
//					rs.getInt(4)) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				AdminInfo ai = new AdminInfo() ;
				ai.setId(rs2.getInt(1));
				ai.setPhone(rs2.getString(2));
				ai.setAdmin(admin);
				admin.setAdmininfo(ai);
			}
			rs2.close();
			all.add(admin) ;
		}
		rs.close();
		this.pstmt.close() ;
		
		return all;
	}

	public List<Admin> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin findById(int id) throws Exception {
		Admin admin = null ;
		String sql = "SELECT * FROM admin WHERE admin_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			admin = new Admin() ;
			admin.setId(rs.getInt(1));
			admin.setName(rs.getString(2));
			admin.setPassword(rs.getString(3));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM admininfo"
					+ " WHERE admininfo_id = " + 
					id) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				AdminInfo ai = new AdminInfo() ;
				ai.setId(rs2.getInt(1));
				ai.setPhone(rs2.getString(2));
				ai.setAdmin(admin);
				admin.setAdmininfo(ai);
			}
			rs2.close();
		}
		rs.close();
		this.pstmt.close() ;
		
		return admin ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Admin findByName(String adminname) throws Exception{
		Admin admin = null ;
		String sql = "SELECT admin_id, admin_name, admin_password, admininfo_id FROM admin WHERE admin_name=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, adminname) ;
		
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			admin = new Admin() ;
			admin.setId(rs.getInt(1));
			admin.setName(rs.getString(2));
			admin.setPassword(rs.getString(3));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM admininfo"
					+ " WHERE admininfo_id = " + rs.getInt(4)) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				AdminInfo ai = new AdminInfo() ;
				ai.setId(rs2.getInt(1));
				ai.setPhone(rs2.getString(2));
				ai.setAdmin(admin);
				admin.setAdmininfo(ai);
			}
			rs2.close();
		}
		rs.close();
		this.pstmt.close() ;
		
		return admin ;
	}
}
