package com.petcare.web.domains;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class HospitalVo implements Serializable{
	private static final long serialVersionUID= 1L;

	private String hosId, hosPass, hosName, hosEmail, hosPhone, hosAddress, hosSite, hosOptime, hosOpen, hosClose
		, hosMajorTreatmentTarget, hosCourseOfTreatment, hosFeature, hosService, hosIntro, hosPhoto, treatNo;
	private int hosNo;
}
