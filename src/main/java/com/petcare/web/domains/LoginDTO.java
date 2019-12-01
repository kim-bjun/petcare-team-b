package com.petcare.web.domains;

public class LoginDTO {
	private String user_id;
	private String user_pass;
	private boolean useCookie;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "LoginDTO [user_id=" + user_id + ", user_pass=" + user_pass + ", useCookie=" + useCookie + "]";
	}
	

}
