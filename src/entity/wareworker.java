package entity;


public class wareworker {
	private String workerid;
	private String workername;
	private String workertel;
// private double countScore;//额外添加一个属性来记录总成绩
	private String wareid;
	private String warename;
	private String waredd;
	private ware ware;
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public String getWorkername() {
		return workername;
	}
	public void setWorkername(String workername) {
		this.workername = workername;
	}
	public String getWorkertel() {
		return workertel;
	}
	public void setWorkertel(String workertel) {
		this.workertel = workertel;
	}
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
	public String getWaredd() {
		return waredd;
	}
	public void setWaredd(String waredd) {
		this.waredd = waredd;
	}
	public ware getWare() {
		return ware;
	}
	public void setWare(ware ware) {
		this.ware = ware;
	}
	@Override
	public String toString() {
		return "wareworker [workerid=" + workerid + ", workername=" + workername + ", workertel=" + workertel
				+ ", wareid=" + wareid + ", warename=" + warename + ", waredd=" + waredd + ", ware=" + ware + "]";
	}
	public wareworker(String workerid, String workername, String workertel, String wareid, String warename,
			String waredd, entity.ware ware) {
		super();
		this.workerid = workerid;
		this.workername = workername;
		this.workertel = workertel;
		this.wareid = wareid;
		this.warename = warename;
		this.waredd = waredd;
		this.ware = ware;
	}
	public wareworker() {
		super();
	}
	
	
}
