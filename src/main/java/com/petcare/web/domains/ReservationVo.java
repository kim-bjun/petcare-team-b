package com.petcare.web.domains;

import java.sql.Date;

import lombok.Data;

@Data
public class ReservationVo {
	
	private int res_no; 	// 예약 번호
	private int user_no; 	//유저 번호
	private int ani_no;  	//동물번호
	private int hos_no; 	//병원 번호
	private Date res_dt;  	//예약일
	private int res_time;   //예약시간
	private String res_item;//증상
	private Date reg_dt; 	//작성일
	
}
	


