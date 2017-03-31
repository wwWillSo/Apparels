package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import dao.IDAO;
import vo.User;
import vo.UserInfo;

public class UserInfoDAOImpl implements IDAO<UserInfo>{
	
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	public UserInfoDAOImpl(Connection conn){
		this.conn = conn;
	}

	public boolean doCreate(UserInfo vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO userinfo VALUES (?, ?, ?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, vo.getId()) ;
		this.pstmt.setString(2, vo.getZIP()) ;
		this.pstmt.setString(3, vo.getEmail());
		this.pstmt.setString(4, vo.getTEL());
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}
	
	public Object doCreateGetId(UserInfo vo) throws Exception {
		Object flag = false ;
		String sql = "INSERT INTO userinfo (user_zip, user_email, user_TEL) VALUES (?, ?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
		this.pstmt.setString(1, vo.getZIP()) ;
		this.pstmt.setString(2, vo.getEmail());
		this.pstmt.setString(3, vo.getTEL());
		if (this.pstmt.executeUpdate() != 0) {
			ResultSet rs = this.pstmt.getGeneratedKeys() ;
			if (rs.next()) {
				flag = rs.getObject(1) ;
			}
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
		boolean flag = false ;
		
		String sql = "DELETE userinfo WHERE userinfo_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		
		this.pstmt.close();
		
		return flag;
	}

	public boolean doUpdate(UserInfo vo) throws Exception {
		boolean flag = false ;
		
		String sql = "UPDATE userinfo SET user_ZIP=?, user_email=?, uiser_TEL=? WHERE userinfo_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		
		this.pstmt.setString(1, vo.getZIP()) ;
		this.pstmt.setString(2, vo.getEmail());
		this.pstmt.setString(3, vo.getTEL());
		this.pstmt.setInt(4, vo.getId()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public List<UserInfo> findAll() throws Exception {
		List<UserInfo> all = new ArrayList<UserInfo>() ;
		String sql = "SELECT * FROM userinfo" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		
		while (rs.next()) {
			UserInfo ui = new UserInfo() ;
			ui.setId(rs.getInt(1));
			ui.setZIP(rs.getString(2));
			ui.setEmail(rs.getString(3));
			ui.setTEL(rs.getString(4));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM userinfo WHERE userinfo_id = "+ ui.getId()) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				User user = new User() ;
				user.setId(rs2.getInt(1));
				user.setName(rs2.getString(2)) ;
				user.setPassword(rs2.getString(3)) ;
				user.setAvatars(rs2.getString(4));
				user.setUserinfo(ui);
				ui.setUser(user);
			}
			rs2.close();
			all.add(ui) ;
		}
		rs.close();
		this.pstmt.close() ;
			
		return all ;
	}

	public List<UserInfo> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInfo findById(int id) throws Exception {
		UserInfo ui = null ;
		String sql = "SELECT * FROM userinfo WHERE userinfo_id = ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery() ;
		
		if (rs.next()) {
			ui = new UserInfo() ;
			ui.setId(rs.getInt(1));
			ui.setZIP(rs.getString(2));
			ui.setEmail(rs.getString(3));
			ui.setTEL(rs.getString(4));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM userinfo WHERE userinfo_id = "
					+ rs.getInt(1)) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				User user = new User() ;
				user.setId(rs2.getInt(1));
				user.setName(rs2.getString(2)) ;
				user.setPassword(rs2.getString(3)) ;
				user.setAvatars(rs2.getString(4));
				user.setUserinfo(ui);
				ui.setUser(user);
			}
			rs2.close();
		}
		rs.close();
		this.pstmt.close() ;
			
		return ui ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
