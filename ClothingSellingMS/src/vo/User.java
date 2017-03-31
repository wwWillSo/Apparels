package vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	private int id ;
	private String name ;
	private String password ;
	private String avatars;
	private UserInfo userinfo ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public void setAvatars(String avatars) {
		this.avatars = avatars;
	}
	public String getAvatars() {
		return avatars;
	}
	
}
