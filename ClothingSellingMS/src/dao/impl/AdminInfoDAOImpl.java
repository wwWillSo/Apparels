package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vo.Admin;
import vo.AdminInfo;
import vo.Product;
import dao.IDAO;

public class AdminInfoDAOImpl implements IDAO<AdminInfo>{
	
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	
	public AdminInfoDAOImpl(Connection conn) {
		this.conn = conn ;
	}
	
	public boolean doCreate(AdminInfo vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO admininfo VALUES (?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, vo.getId()) ;
		this.pstmt.setString(2, vo.getPhone());
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
boolean flag = false ;
		
		String sql = "DELETE admininfo WHERE admininfo_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		
		this.pstmt.close();
		
		return flag;
	}

	public boolean doUpdate(AdminInfo vo) throws Exception {
boolean flag = false ;
		
		String sql = "UPDATE admininfo SET admin_TEL=? WHERE admininfo_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		
		this.pstmt.setString(1, vo.getPhone());
		this.pstmt.setInt(2, vo.getId()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public List<AdminInfo> findAll() throws Exception {
		List<AdminInfo> all = new ArrayList<AdminInfo>() ;
		String sql = "SELECT * FROM admininfo" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		
		while (rs.next()) {
			AdminInfo ai = new AdminInfo() ;
			ai.setId(rs.getInt(1));
			ai.setPhone(rs.getString(2));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM admin WHERE "
					+ "admininfo_id = "
					+ rs.getInt(1)) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				Admin admin = new Admin() ;
				admin.setId(rs2.getInt(1));
				admin.setName(rs2.getString(2));
				admin.setPassword(rs2.getString(3));
				admin.setAdmininfo(ai);
				ai.setAdmin(admin);
			}
			rs2.close();
			all.add(ai) ;
		}
		rs.close();
		this.pstmt.close() ;
		
		return all;
	}

	public List<AdminInfo> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public AdminInfo findById(int id) throws Exception {
		AdminInfo ai = null ;
		String sql = "SELECT * FROM admininfo WHERE admininfo_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		
		if (rs.next()) {
			ai = new AdminInfo() ;
			ai.setId(rs.getInt(1));
			ai.setPhone(rs.getString(2));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM admin WHERE "
					+ "admininfo_id = "
					+ rs.getInt(1)) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				Admin admin = new Admin() ;
				admin.setId(rs2.getInt(1));
				admin.setName(rs2.getString(2));
				admin.setPassword(rs2.getString(3));
				admin.setAdmininfo(ai);
				ai.setAdmin(admin);
			}
			rs2.close();
		}
		rs.close();
		this.pstmt.close() ;
		
		return ai;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	//display all the products
	public Set<Product> getAllPictureByUserId(int userid) throws Exception {
		Set<Product> pictures = new HashSet<Product> () ;
		String sql = "SELECT * FROM picture WHERE user_id = ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, userid) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Product p = new Product() ;
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setType(rs.getString(3));
			p.setPrice(rs.getDouble(4));
			p.setDetail(rs.getString(5));
			p.setSize(rs.getString(6));
			p.setAmount(rs.getInt(7));
			p.setPath(rs.getString(8));
			
			pictures.add(p) ;
		}
		rs.close();
		this.pstmt.close() ;
		
		
		return pictures ;
	}
}
