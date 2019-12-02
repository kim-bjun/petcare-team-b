package com.petcare.web.domains;

import java.util.List;

import lombok.Data;

@Data
public class DummyHospitalVo extends HospitalVo{
	private static final long serialVersionUID = 1L;
	
	private List<HosInfoVo> hosInfoList;
	
}
