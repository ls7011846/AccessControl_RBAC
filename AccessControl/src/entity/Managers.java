package entity;

public class Managers {
	private String managername;
	private String managerpsd;
	private String managerrole;

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManagerpsd() {
		return managerpsd;
	}

	public void setManagerpsd(String managerpsd) {
		this.managerpsd = managerpsd;
	}

	public String getManagerrole() {
		return managerrole;
	}

	public void setManagerrole(String managerrole) {
		this.managerrole = managerrole;
	}

	@Override
	public String toString() {
		return "Managers [managername=" + managername + ", managerpsd="
				+ managerpsd + ", managerrole=" + managerrole + "]";
	}

}
