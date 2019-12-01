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
	

}
