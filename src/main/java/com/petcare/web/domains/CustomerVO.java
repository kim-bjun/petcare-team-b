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

	private String	userId;		//고객 ID
	private String	userPass;		//고객 Password
	private String	userPassConf;	//고객 Password 체크
	private String	userName;		//고객 성명
	private String	userPhone;		//고객 전화
	private String	userEmail;		//고객 이메일
	private String	userAddress;	//고객 주소
	private String  userAuth ;

}
