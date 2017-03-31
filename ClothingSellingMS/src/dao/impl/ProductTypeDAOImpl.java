package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import vo.Admin;
import vo.AdminInfo;
import vo.ProductType;

public class ProductTypeDAOImpl implements IDAO<ProductType>{
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	
	public ProductTypeDAOImpl(Connection conn) {
		this.conn = conn ;
	}

	@Override
	public boolean doCreate(ProductType vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(ProductType vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductType findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductType> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductType> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllCount(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<ProductType> findAllByMenuId(int menuId) throws Exception {
		List<ProductType> list = new ArrayList<ProductType>() ;
		
		String sql = "select id, menu_id, type_name, type_resource, type_show_order, enable from product_type where enable=0 and menu_id = ? order by type_show_order" ;
		
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, menuId) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		
		while (rs.next()) {
			ProductType vo = new ProductType() ;
			vo.setId(rs.getInt(1));
			vo.setMenuId(rs.getInt(2));
			vo.setTypeName(rs.getString(3));
			vo.setTypeResource(rs.getString(4));
			vo.setTypeShowOrder(rs.getInt(5));
			vo.setEnable(rs.getInt(6));
			
			list.add(vo) ;
		}
		
		rs.close();
		this.pstmt.close();
		
		return list ;
	}

}
