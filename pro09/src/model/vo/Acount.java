package model.vo;

public abstract  class Acount   {
	private String name;
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean changePassword(String curPass, String changePass) {
		if (curPass.equals(changePass)) {
			setPassword(changePass);
		return true;
		}
		return false;
	}
	
	
	
	}
