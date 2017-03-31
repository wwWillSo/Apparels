package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import vo.Note;
import dao.IDAO;

public class NoteDAOImpl implements IDAO<Note>{
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	public NoteDAOImpl (Connection conn){
		this.conn = conn;
	}
	public boolean doCreate(Note vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO admin VALUES (?, ?, ?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, vo.getId()) ;
		this.pstmt.setString(2, vo.getContent()) ;
		this.pstmt.setString(3, vo.getDate());
		this.pstmt.setInt(4, vo.getUserid()) ;
		this.pstmt.setInt(5, vo.getProductid()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
		boolean flag = false ;
		
		String sql = "DELETE note WHERE note_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		
		this.pstmt.close();
		
		return flag;
	}

	public boolean doUpdate(Note vo) throws Exception {
		boolean flag = false ;
		
		String sql = "UPDATE note SET note_content=?, note_date=? WHERE note_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		
		this.pstmt.setString(1, vo.getContent()) ;
		this.pstmt.setString(2, vo.getDate());
		this.pstmt.setInt(3, vo.getId()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public List<Note> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Note> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Note findById(int productid, int noteid) throws Exception {
		Note note = new Note();
		String sql = "SELCET * FROM WHERE product_id=? AND note_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, productid);
		this.pstmt.setInt(2, noteid);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
					note = new Note();
					note.setContent(rs.getString(2));
					note.setDate(rs.getString(3));
					note.setProductid(rs.getInt(4));
					note.setUserid(rs.getInt(5));					
		}
		this.pstmt.close();
		return note;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public Note findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
