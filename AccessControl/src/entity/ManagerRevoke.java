package entity;

public class ManagerRevoke {
	private String managerrole;
	private String revokerole;
	
	public String getManagerrole() {
		return managerrole;
	}
	public void setManagerrole(String managerrole) {
		this.managerrole = managerrole;
	}
	public String getRevokerole() {
		return revokerole;
	}
	public void setRevokerole(String revokerole) {
		this.revokerole = revokerole;
	}
	
	@Override
	public String toString() {
		return "ManagerRevoke [managerrole=" + managerrole + ", revokerole="
				+ revokerole + "]";
	}
	
}
