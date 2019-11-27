package com.petcare.web.domains;

import java.sql.Date;

import lombok.Data;

@Data
public class ReservationVo {
	
	private int treat_no; 	// 예약 번호
	private String user_id; 	//유저 번호
	private int ani_no;  	//동물번호
	private int hos_no; 	//병원 번호
	private String res_dt;  	//예약일
	private String res_time;   //예약시간
	private String res_item;//증상
	private String reg_dt; 	//작성일
	
	private String hos_name;
	private String ani_name;

	
	
	
}
	


