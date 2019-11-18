package com.petcare.web.domains;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class HospitalVo implements Serializable{
	private static final long serialVersionUID= 1L;

	private String hos_id, hos_pass, hos_name, hos_email, hos_phone, hos_address, hos_site, hos_optime, hos_open, hos_close, hos_major_treatment_target, hos_course_of_treatment, hos_feature, hos_service, hos_intro, hos_photo, treat_no;
	private int hos_no;
}
