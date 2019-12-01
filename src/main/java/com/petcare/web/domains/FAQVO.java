package com.petcare.web.domains;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class FAQVO {
	
	int faqNo;
	String faqCat, faqName, faqCont;

}
