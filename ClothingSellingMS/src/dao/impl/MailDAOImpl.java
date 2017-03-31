package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Mail;
import dao.IDAO;

public class MailDAOImpl implements IDAO<Mail>{
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	public MailDAOImpl(Connection conn){
		this.conn = conn;
	}
	public boolean doCreate(Mail vo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO mail VALUES (?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getId());
		this.pstmt.setString(2, vo.getName());
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
		boolean flag = false ;
		
		String sql = "DELETE mail WHERE mail_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		
		this.pstmt.close();
		
		return flag;
	}

	public boolean doUpdate(Mail vo) throws Exception {
		boolean flag = false ;
		
		String sql = "UPDATE mail SET mail_name=? WHERE mail_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		
		this.pstmt.setString(1, vo.getName()) ;
		this.pstmt.setInt(2, vo.getId()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public List<Mail> findAll() throws Exception {
		List<Mail> all = new ArrayList<Mail>();
		String sql = "SELECT * FROM mail";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Mail m = new Mail();
			m.setId(rs.getInt(1));
			m.setName(rs.getString(2));
		}
		rs.close();
		this.pstmt.close();
		return all;
	}

	public List<Mail> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Mail findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
