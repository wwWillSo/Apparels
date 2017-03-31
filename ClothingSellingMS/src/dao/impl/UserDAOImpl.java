package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vo.Basket;
import vo.User;
import vo.UserInfo;
import dao.IDAO;

public class UserDAOImpl implements IDAO<User>{
	private Connection conn = null ;
	private PreparedStatement pstmt = null ; 
	
	public UserDAOImpl(Connection conn) {
		this.conn = conn ;
	}
	
	public boolean doCreate(User vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO user (user_name, user_password, user_avatars, userinfo_id) VALUES (?, ?, ?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, vo.getName()) ;
		this.pstmt.setString(2, vo.getPassword());
		this.pstmt.setString(3, vo.getAvatars());
		this.pstmt.setInt(4, vo.getUserinfo().getId()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}
	
	public Object doCreateGetId(User vo) throws Exception {
		Object flag = false ;
		String sql = "INSERT INTO user VALUES (?, ?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, vo.getName()) ;
		this.pstmt.setString(2, vo.getPassword());
		this.pstmt.setString(3, vo.getAvatars());
		if (this.pstmt.executeUpdate() != 0) {
			ResultSet rs = this.pstmt.getGeneratedKeys() ;
			
			flag = rs.getObject(1) ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
boolean flag = false ;
		
		String sql = "DELETE user WHERE user_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		
		this.pstmt.close();
		
		return flag;
	}

	public boolean doUpdate(User vo) throws Exception {
boolean flag = false ;
		
		String sql = "UPDATE user SET user_name=?, user_password=?, user_avatars=?, userinfo_id=? WHERE user_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		
		this.pstmt.setString(1, vo.getName()) ;
		this.pstmt.setString(2, vo.getPassword());
		this.pstmt.setString(3, vo.getAvatars());
		this.pstmt.setInt(4, vo.getUserinfo().getId()) ;
		this.pstmt.setInt(5, vo.getId()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public List<User> findAll() throws Exception {
		List<User> all = new ArrayList<User>() ;
		String sql = "SELECT * FROM user" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		
		while (rs.next()) {
			User user = new User() ;
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setAvatars(rs.getString(4));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM userinfo WHERE userinfo_id = "
					+ rs.getInt(5)) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				UserInfo ui = new UserInfo() ;
				ui.setId(rs2.getInt(1));
				ui.setZIP(rs2.getString(2)) ;
				ui.setEmail(rs2.getString(3)) ;
				ui.setTEL(rs2.getString(4)) ;
				ui.setUser(user);
				user.setUserinfo(ui);
			}
			rs2.close();
			all.add(user) ;
		}
		rs.close();
		this.pstmt.close() ;
			
		return all ;
	}

	public List<User> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(int id) throws Exception {
		User user = null ;
		String sql = "SELECT * FROM user WHERE user_id = ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery() ;
		
		if (rs.next()) {
			user = new User() ;
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setAvatars(rs.getString(4));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM userinfo WHERE userinfo_id = "+ rs.getInt(1)) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				UserInfo ui = new UserInfo() ;
				ui.setId(rs2.getInt(1));
				ui.setZIP(rs2.getString(2));
				ui.setEmail(rs2.getString(3)) ;
				ui.setTEL(rs2.getString(4)) ;
				ui.setUser(user);
				user.setUserinfo(ui);
			}
			//user.getPictures().addAll(this.getAllPictureByUserId(id)) ;
			rs2.close();
			this.pstmt.close() ;
		}
		rs.close();
		return user ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<Basket> getAllBasketByUserId(int userid) throws Exception{
		Set<Basket> basket = new HashSet<Basket>();
		String sql = "SELECT item_id, item_size, item_amount, item_sum, product_id, user_id FROM basket WHERE user_id=?";
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, userid) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Basket b = new Basket();
			b.setId(rs.getInt(1));
			b.setSize(rs.getString(2));
			b.setAmount(rs.getInt(3));
			b.setSum(rs.getDouble(4));
			b.setProductid(rs.getInt(5));
			b.setUserid(userid);
			
			basket.add(b);
		}
			return basket;
	}

	public User findByUserName(String username) throws Exception{
		User user = null ;
		String sql = "SELECT user_id, user_name, user_password, user_avatars, userInfo_id FROM user WHERE user_name = ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, username);
		ResultSet rs = this.pstmt.executeQuery() ;
		
		if (rs.next()) {
			user = new User() ;
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setAvatars(rs.getString(4));
			
			this.pstmt = this.conn.prepareStatement("SELECT * FROM userinfo WHERE userinfo_id = "+ rs.getInt(5)) ;
			ResultSet rs2 = this.pstmt.executeQuery() ;
			if (rs2.next()) {
				UserInfo ui = new UserInfo() ;
				ui.setId(rs2.getInt(1));
				ui.setZIP(rs2.getString(2));
				ui.setEmail(rs2.getString(3)) ;
				ui.setTEL(rs2.getString(4)) ;
				ui.setUser(user);
				user.setUserinfo(ui);
			}
			//user.getPictures().addAll(this.getAllPictureByUserId(id)) ;
			rs2.close();
			this.pstmt.close() ;
		}
		rs.close();
		return user ;
	}

}
