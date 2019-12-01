package com.petcare.web.domains;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class TreatVo {
	private int treatNo;
	private String userId;
	private int aniNo;
	private String treatItem;
	private String treatDate;
	private String treatState;
}
