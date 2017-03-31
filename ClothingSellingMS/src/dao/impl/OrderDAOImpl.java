package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import vo.Order;

public class OrderDAOImpl implements IDAO<Order>{
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	public OrderDAOImpl(Connection conn){
		this.conn = conn;
	}
	public boolean doCreate(Order vo) throws Exception {
		boolean flag = false ;
	String sql = "INSERT INTO `order` (order_id, order_status, order_date, order_remark, order_amount, order_size, product_id, user_id, transaction_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
	this.pstmt = this.conn.prepareStatement(sql) ;
	this.pstmt.setInt(1, vo.getId()) ;
	this.pstmt.setString(2, vo.getStatus()) ;
	this.pstmt.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(vo.getDate()));
	this.pstmt.setString(4, vo.getRemark());
	this.pstmt.setInt(5, vo.getAmount()) ;
	this.pstmt.setString(6, vo.getSize());
	this.pstmt.setInt(7, vo.getProductid());
	this.pstmt.setInt(8, vo.getUserid());
	this.pstmt.setString(9, vo.getTransactionId());
	if (this.pstmt.executeUpdate() != 0) {
		flag = true ;
	}
	this.pstmt.close() ;
	
	return flag;
	}
	public boolean doDelete(int id) throws Exception {
		boolean flag = false ;
		
		String sql = "DELETE `order` WHERE order_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		
		this.pstmt.close();
		
		return flag;
	}
	public boolean doUpdate(Order vo) throws Exception {
		boolean flag = false ;
		
		String sql = "UPDATE `order` SET order_status=? WHERE order_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, vo.getStatus()) ;
		this.pstmt.setInt(2, vo.getId()) ;
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag;
	}
	public List<Order> findAll() throws Exception {
		List<Order> all = new ArrayList<Order>() ;
		String sql = "SELECT * FROM `order`" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Order order = new Order() ;
			order.setId(rs.getInt(1));
			order.setStatus(rs.getString(2));
			order.setDate(rs.getDate(3));
			order.setRemark(rs.getString(4));
			order.setAmount(rs.getInt(5));
			order.setSize(rs.getString(6));
			order.setProductid(rs.getInt(7));
			order.setUserid(rs.getInt(8));
		}
		rs.close();
		this.pstmt.close() ;
		
		return all;
	}
	public List<Order> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public Order findById(int id) throws Exception {
		Order order = null ;
		String sql = "SELECT * FROM `order` WHERE order_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			order = new Order() ;
			order.setId(rs.getInt(1));
			order.setStatus(rs.getString(2));
			order.setDate(rs.getDate(3));
			order.setRemark(rs.getString(4));
			order.setAmount(rs.getInt(5));
			order.setSize(rs.getString(6));
			order.setProductid(rs.getInt(7));
			order.setUserid(rs.getInt(8));
		}
		rs.close();
		this.pstmt.close() ;
		
		return order ;
	}
	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
