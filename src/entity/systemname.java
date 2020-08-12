package entity;

public class systemname {
	private String id;
	private String system;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return system;
	}

	public void setName(String name) {
		this.system = name;
	}


	@Override
	public String toString() {
		return "systemname [id=" + id + ", name=" + system + "]";
	}

	
	public systemname(String id, String name) {
		super();
		this.id = id;
		this.system = name;
	}

	public systemname() {
		super();
	}
	
}
