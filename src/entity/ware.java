package entity;

public class ware {
		private String wareid;
		private String warename;
		private String waredd;
		private String color;
		private String size;
		private String inprize;
		private String outprize;
		private String num;
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
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getInprize() {
			return inprize;
		}
		public void setInprize(String inprize) {
			this.inprize = inprize;
		}
		public String getOutprize() {
			return outprize;
		}
		public void setOutprize(String outprize) {
			this.outprize = outprize;
		}
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
		@Override
		public String toString() {
			return "ware [wareid=" + wareid + ", warename=" + warename + ", waredd=" + waredd + ", color=" + color
					+ ", size=" + size + ", inprize=" + inprize + ", outprize=" + outprize + ", num=" + num + "]";
		}
		public ware(String wareid, String warename, String waredd, String color, String size, String inprize,
				String outprize, String num) {
			super();
			this.wareid = wareid;
			this.warename = warename;
			this.waredd = waredd;
			this.color = color;
			this.size = size;
			this.inprize = inprize;
			this.outprize = outprize;
			this.num = num;
		}
		public ware() {
			super();
		}
		
	
}
