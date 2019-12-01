package com.petcare.web.domains;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AnimalVO {
	
	private String	user_id, ani_no, ani_kind, ani_name, ani_breed;


}
