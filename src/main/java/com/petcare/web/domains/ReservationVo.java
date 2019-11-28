package com.petcare.web.domains;

import java.sql.Date;

import lombok.Data;

@Data
public class ReservationVo {
	
	private int treatNo; 	// 예약 번호
	private String userId; 	//유저 번호
	private int aniNo;  	//동물번호
	private int hosNo; 	//병원 번호
	private String resDt;  	//예약일
	private String resTime;   //예약시간
	private String resItem;//증상
	private Date regDt; 	//작성일
	
	private String hosName;
	private String aniName;
	

	
	
	
}
	


