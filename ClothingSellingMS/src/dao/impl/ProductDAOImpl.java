package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Product;
import dao.IDAO;

public class ProductDAOImpl implements IDAO<Product>{

	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	public ProductDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	public boolean doCreate(Product vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO product VALUES(?, ?, ?, ?, ?, ?, ?, ?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1,vo.getId());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setString(3, vo.getType());
		this.pstmt.setDouble(4, vo.getPrice());
		this.pstmt.setString(5,vo.getDetail());
		this.pstmt.setString(6,vo.getSize());
		this.pstmt.setDouble(7,vo.getAmount());
		this.pstmt.setString(8,vo.getPath());
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		} else {
		}
		
		this.pstmt.close() ;
		
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
		boolean flag = false ; 
		
		String sql = "DELETE product WHERE product_id = ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id) ;
		
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		return flag ;
	}

	public boolean doUpdate(Product vo) throws Exception {
		boolean flag = false ;
		
		String sql = "UPDATE picture SET product_name=?, product_type=?, product_deatil=?,product_size=?, product_Amount=?, image=?WHERE pic_id=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setString(3, vo.getType());
		this.pstmt.setDouble(4, vo.getPrice());
		this.pstmt.setString(5,vo.getDetail());
		this.pstmt.setString(6,vo.getSize());
		this.pstmt.setDouble(7,vo.getAmount());
		this.pstmt.setString(8,vo.getPath());
		
		if (this.pstmt.executeUpdate() != 0) {
			flag = true ;
		}
		this.pstmt.close() ;
		
		return flag ;
	}

	public List<Product> findAll() throws Exception {
		List<Product> all = new ArrayList<Product>();	
		
		String sql = "SELECT * FROM product" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		Product product = null;
		if (rs.next()) {
			product = new Product() ;
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setType(rs.getString(3));
			product.setPrice(rs.getDouble(4));
			product.setDetail(rs.getString(5));
			product.setSize(rs.getString(6));
			product.setAmount(rs.getInt(7));
			product.setPath(rs.getString(8));
			
			all.add(product);
	
		}
		rs.close();
		this.pstmt.close() ;
		
		return all ;
	}

	public List<Product> findAll(String keyWord) throws Exception {
		List<Product> all = new ArrayList<Product>();	
		
		String sql = "SELECT * FROM product WHERE product_type LIKE ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, keyWord);
		
		ResultSet rs = this.pstmt.executeQuery() ;
		Product product = null;
		if (rs.next()) {
			product = new Product() ;
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setType(rs.getString(3));
			product.setPrice(rs.getDouble(4));
			product.setDetail(rs.getString(5));
			product.setSize(rs.getString(6));
			product.setAmount(rs.getInt(7));
			product.setPath(rs.getString(8));
			
			all.add(product);
	
		}
		rs.close();
		this.pstmt.close() ;
		
		return all ;
	}

	public Product findById(int id) throws Exception {
		Product product = null ; 
		
		String sql = "SELECT * FROM product WHERE product_id = ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			product = new Product() ;
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setType(rs.getString(3));
			product.setPrice(rs.getDouble(4));
			product.setDetail(rs.getString(5));
			product.setSize(rs.getString(6));
			product.setAmount(rs.getInt(7));
			product.setPath(rs.getString(8));
			
//			this.pstmt = this.conn.prepareStatement("SELECT * FROM [user] WHERE "
//					+ " user_id = " + 
//					rs.getInt(6)) ;
//			ResultSet rs2 = this.pstmt.executeQuery() ;
			
//			rs2.close();
		}
		rs.close();
		this.pstmt.close() ;
		
		return product ;
	}

	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
