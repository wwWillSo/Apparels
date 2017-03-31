package test;

import dao.factory.DAOFactory;
import vo.User;
import vo.UserInfo;

public class TestDAOInsert {
	public static void main(String[] args) throws Exception{
		User user = null;
		UserInfo ui  = null;
		user = new User();
		user.setName("Dean");
		user.setPassword("123456");
		user.setAvatars("F:/Jacilynn/桌面/hair.png");
		ui = new UserInfo();
		ui.setId(1);
		ui.setZIP("邮政");
		ui.setEmail("Dean@gmail.com");
		ui.setTEL("3344556");
		user.setUserinfo(ui);
		DAOFactory.getUserInfoDAOInstance().doCreate(ui);
		DAOFactory.getUserDAOInstance().doCreate(user);
		
		System.out.println("插入成功");
	}
}
