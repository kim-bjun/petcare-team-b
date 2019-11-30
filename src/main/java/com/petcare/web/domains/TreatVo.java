package com.petcare.web.domains;

import lombok.Data;

@Data
public class TreatVo {
	private int treatNo;
	private String userId;
	private int aniNo;
	private String treatItem;
	private String treatDate;
	private String treatState;
	
	private String reserTime;
}
