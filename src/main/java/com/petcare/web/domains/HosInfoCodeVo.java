package com.petcare.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class HosInfoCodeVo  implements Serializable{
	private static final long serialVersionUID= 1L;
	
	private int hosInfoCode;
	private String codeName;
	
}
