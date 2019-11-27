package com.petcare.web.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.petcare.web.domains.ReviewBrdVo;
import com.petcare.web.utills.Proxy;

@Repository
public interface ReviewBrdMapper {
	
	public int cntReview(String hosNo);
	public List<ReviewBrdVo> selectReview(Proxy pxy);
	
}
