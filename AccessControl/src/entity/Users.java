package entity;

public class Users {
	private String username;
	private String userpsd;
	private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpsd() {
		return userpsd;
	}
	public void setUserpsd(String userpsd) {
		this.userpsd = userpsd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", userpsd=" + userpsd
				+ ", role=" + role + "]";
	}

}
