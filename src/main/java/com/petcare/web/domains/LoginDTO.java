package com.petcare.web.domains;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

	private String userId;
	private String userPass;
	private boolean useCookie;

	


}
