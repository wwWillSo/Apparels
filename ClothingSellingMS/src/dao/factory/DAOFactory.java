package dao.factory;

import dao.proxy.AdminDAOProxy;
import dao.proxy.AdminInfoDAOProxy;
import dao.proxy.BasketDAOProxy;
import dao.proxy.MailDAOProxy;
import dao.proxy.MenuDAOProxy;
import dao.proxy.NoteDAOProxy;
import dao.proxy.OrderDAOProxy;
import dao.proxy.ProductDAOProxy;
import dao.proxy.ProductTypeDAOProxy;
import dao.proxy.UserDAOProxy;
import dao.proxy.UserInfoDAOProxy;

public class DAOFactory {
	public static AdminDAOProxy getAdminDAOInstance() throws Exception {
		return new AdminDAOProxy() ;
	}
	public static AdminInfoDAOProxy getAdminInfoDAOInstance() throws Exception {
		return new AdminInfoDAOProxy() ;
	}
	public static UserDAOProxy getUserDAOInstance() throws Exception {
		return new UserDAOProxy() ;
	}
	public static UserInfoDAOProxy getUserInfoDAOInstance() throws Exception {
		return new UserInfoDAOProxy() ;
	}
	public static BasketDAOProxy getBasketDAOInstance() throws Exception{
		return new BasketDAOProxy();
	}
	public static MailDAOProxy getMailDAOInstance() throws Exception{
		return new MailDAOProxy();
	}
	public static NoteDAOProxy getNoteDAOInstance() throws Exception{
		return new NoteDAOProxy();
	}
	public static OrderDAOProxy getOrderDAOInstance() throws Exception{
		return new OrderDAOProxy();
	}
	public static ProductDAOProxy getProductDAOInstance() throws Exception{
		return new ProductDAOProxy();
	}
	public static MenuDAOProxy getMenuDAOInstance() throws Exception{
		return new MenuDAOProxy();
	}
	public static ProductTypeDAOProxy getProductTypeDAOInstance() throws Exception{
		return new ProductTypeDAOProxy();
	}
}
