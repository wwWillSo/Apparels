package vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserInfo implements Serializable{
	private int id ;
	private String ZIP ;
	private String email ;
	private String TEL ;
	private User user ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZIP() {
		return ZIP;
	}
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
