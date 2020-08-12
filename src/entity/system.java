package entity;

public class system {
	private String min;
	private String max;
	private String count;
	private String sname;
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "system [min=" + min + ", max=" + max + ", count=" + count + ", sname=" + sname + "]";
	}
	
	public system(String min, String max, String count, String sname) {
		super();
		this.min = min;
		this.max = max;
		this.count = count;
		this.sname = sname;
	}
	public system() {
		super();
	}
	
	
}
