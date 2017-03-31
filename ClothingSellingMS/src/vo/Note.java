package vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Note implements Serializable{
	private int id;
	private String content;
	private String datetime;
	private int userid;
	private int productid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public void setDate(String datetime) {
		this.datetime = datetime;
	}
	public String getDate() {
		return datetime;
	}

}
