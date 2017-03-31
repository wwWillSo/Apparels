package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vo.Basket;
import dao.IDAO;

public class BasketDAOImpl implements IDAO<Basket>{
	
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	
	public BasketDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	public boolean doCreate(Basket vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO basket (item_id, item_size, item_amount, item_sum, product_id, user_id, is_bought) VALUES (?, ?, ?, ?, ?, ?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, vo.getId()) ;
		this.pstmt.setString(2, vo.getSize()) ;
		this.pstmt.setInt(3, vo.getAmount());
		this.pstmt.setDouble(4, vo.getSum());
		this.pstmt.setDouble(5, vo.getProductid()) ;
		this.pstmt.setDouble(6, vo.getUserid());
		this.pstmt.setInt(7, vo.getIsBought());
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
		boolean flag = false ;
		
		String sql = "DELETE basket WHERE item_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		
		this.pstmt.close();
		
		return flag;
	}

	public boolean doUpdate(Basket vo) throws Exception {
		boolean flag = false ;
		
		String sql = "UPDATE basket SET item_size=?, item_amount=?, item_sum=?, is_bought=? WHERE item_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		
		this.pstmt.setString(1, vo.getSize()) ;
		this.pstmt.setInt(2, vo.getAmount());
		this.pstmt.setDouble(3, vo.getSum()) ;
		this.pstmt.setInt(4, vo.getIsBought()) ;
		this.pstmt.setInt(5, vo.getId());
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}

	public List<Basket> findAll() throws Exception {
		List<Basket> all = new ArrayList<Basket>() ;
		String sql = "SELECT * FROM basket ORDER BY item_id DESC" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Basket basket = new Basket() ;
			basket.setId(rs.getInt(1));
			basket.setSize(rs.getString(2));
			basket.setAmount(rs.getInt(3));
			basket.setSum(rs.getDouble(4));
			basket.setProductid(rs.getInt(5));
			basket.setUserid(rs.getInt(6));
			all.add(basket) ;
		}
		this.pstmt.close() ;
		
		return all;
	}

	public List<Basket> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Basket findById(int id) throws Exception {
		Basket basket = null ;
		String sql = "SELECT item_id, item_size, item_amount, item_sum, product_id, user_id FROM basket WHERE item_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			basket = new Basket() ;
			basket.setId(rs.getInt(1));
			basket.setSize(rs.getString(2));
			basket.setAmount(rs.getInt(3));
			basket.setSum(rs.getDouble(4));			
			basket.setProductid(rs.getInt(5));
			basket.setUserid(rs.getInt(6));
		}
		rs.close();
		this.pstmt.close() ;
		return basket ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
