package entity;

public class Users{
	private String id;
	private String password;
	private String lable;
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id =id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", password=" + password + ", lable=" + lable + "]";
	}
	
	
	public Users(String id, String password, String lable) {
		super();
		this.id = id;
		this.password = password;
		this.lable = lable;
	}
	public Users() {
		super();
	}
}
