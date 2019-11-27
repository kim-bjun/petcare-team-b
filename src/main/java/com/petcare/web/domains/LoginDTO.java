package com.petcare.web.domains;

public class LoginDTO {
	private String userId;
	private String userPass;
	private boolean useCookie;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", userPass=" + userPass + ", useCookie=" + useCookie + "]";
	}
	

}
