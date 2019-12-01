package com.petcare.web.domains;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {

	private String	user_id;		//고객 ID
	
	private String	user_pass;		//고객 Password

	private String	user_pass_conf;	//고객 Password 체크

	private String	user_name;		//고객 성명
	
	private String	user_phone;		//고객 전화
	
	private String	user_email;		//고객 이메일
	
	private String	user_address;	//고객 주소
	
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
	
	public String getUser_pass_conf() {
		return user_pass_conf;
	}

	public void setUser_pass_conf(String user_pass_conf) {
		this.user_pass_conf = user_pass_conf;
	}

	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}
	
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public String getUser_address() {
		return user_address;
	}
	
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

}
