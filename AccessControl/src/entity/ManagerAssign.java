package entity;

public class ManagerAssign {
	private String managerrole;
	private String userrole;
	private String assignrole;
	public String getManagerrole() {
		return managerrole;
	}
	public void setManagerrole(String managerrole) {
		this.managerrole = managerrole;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public String getAssignrole() {
		return assignrole;
	}
	public void setAssignrole(String assignrole) {
		this.assignrole = assignrole;
	}
	@Override
	public String toString() {
		return "ManagerAssign [managerrole=" + managerrole + ", userrole="
				+ userrole + ", assignrole=" + assignrole + "]";
	}
	
}
