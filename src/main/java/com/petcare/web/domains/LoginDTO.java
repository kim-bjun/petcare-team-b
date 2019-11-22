package com.petcare.web.domains;

public class LoginDTO {
	private String userid;
	private String userpass;
	private boolean useCookie;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "LoginDTO [userid=" + userid + ", userpass=" + userpass + ", useCookie=" + useCookie + "]";
	}
	

}
