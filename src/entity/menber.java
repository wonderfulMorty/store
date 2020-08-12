package entity;

import java.util.List;

public class menber {
	private String mid;
	private String mname;
	private String msex;
	private String mtel;
	private String mcount;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMsex() {
		return msex;
	}
	public void setMsex(String msex) {
		this.msex = msex;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	
	public String getMcount() {
		return mcount;
	}
	public void setMcount(String mcount) {
		this.mcount = mcount;
	}
	@Override
	public String toString() {
		return "menber [mid=" + mid + ", mname=" + mname + ", msex=" + msex + ", mtel=" + mtel + ", mcount=" + mcount
				+ "]";
	}
	
	public menber(String mid, String mname, String msex, String mtel, String mcount) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.msex = msex;
		this.mtel = mtel;
		this.mcount = mcount;
	}
	public menber() {
		super();
	}
	
	
}
