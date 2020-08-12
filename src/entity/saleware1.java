package entity;

public class saleware1 {
	private String wareid;
	private String warename;
	private String size;
	private String color;
	private String warenum;
	private String realprize;
	private String sumprize;
	private String saletime;
	private String sname;
	public String getWareid() {
		return wareid;
	}
	public void setWareid(String wareid) {
		this.wareid = wareid;
	}
	public String getWarename() {
		return warename;
	}
	public void setWarename(String warename) {
		this.warename = warename;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWarenum() {
		return warenum;
	}
	public void setWarenum(String warenum) {
		this.warenum = warenum;
	}
	public String getRealprize() {
		return realprize;
	}
	public void setRealprize(String realprize) {
		this.realprize = realprize;
	}
	public String getSumprize() {
		return sumprize;
	}
	public void setSumprize(String sumprize) {
		this.sumprize = sumprize;
	}
	public String getSaletime() {
		return saletime;
	}
	public void setSaletime(String saletime) {
		this.saletime = saletime;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "saleware1 [wareid=" + wareid + ", warename=" + warename + ", size=" + size + ", color=" + color
				+ ", warenum=" + warenum + ", realprize=" + realprize + ", sumprize=" + sumprize + ", saletime="
				+ saletime + ", sname=" + sname + "]";
	}
	public saleware1(String wareid, String warename, String size, String color, String warenum, String realprize,
			String sumprize, String saletime, String sname) {
		super();
		this.wareid = wareid;
		this.warename = warename;
		this.size = size;
		this.color = color;
		this.warenum = warenum;
		this.realprize = realprize;
		this.sumprize = sumprize;
		this.saletime = saletime;
		this.sname = sname;
	}
	public saleware1() {
		super();
	}
	
}
