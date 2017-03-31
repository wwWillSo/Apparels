package vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminInfo implements Serializable{
	private int id ;
	private String phone ;
	private Admin admin ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
