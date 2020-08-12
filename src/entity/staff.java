package entity;

public class staff {
	private String id;
	private String pass;
	private String realname;
	private String iden;
	private String income;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIden() {
		return iden;
	}
	public void setIden(String iden) {
		this.iden = iden;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	@Override
	public String toString() {
		return "staff [id=" + id + ", pass=" + pass + ", realname=" + realname + ", iden=" + iden + ", income=" + income
				+ "]";
	}
	public staff(String id, String pass, String realname, String iden, String income) {
		super();
		this.id = id;
		this.pass = pass;
		this.realname = realname;
		this.iden = iden;
		this.income = income;
	}
	public staff() {
		super();
	}
	
	
}
