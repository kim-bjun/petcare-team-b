package com.petcare.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class HosInfoVo  implements Serializable{
	private static final long serialVersionUID= 1L;
	
	private int hosNo, hosInfoCode;
	
}
