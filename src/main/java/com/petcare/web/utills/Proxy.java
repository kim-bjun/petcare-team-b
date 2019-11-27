package com.petcare.web.utills;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.petcare.web.mapper.HospitalSearchMapper;
import lombok.Data;

@Data @Component
public class Proxy {
	private int totalCount, startRow, endRow, pageNo
			,pageCount, pageSize, startPage, endPage  
			,blockCount ,hosNo; 
	private boolean existNext,existPrev;
	private String searchWrd;
	private final int BLOCK_SIZE = 5 , PAGE_SIZE =10; 
	private List<Integer>blist ;
	private List<String> checkBoxList;	
	@Autowired HospitalSearchMapper hospitalMapper;
	
	public List<String> getCheckBoxList() {
		return this.checkBoxList;
	} 
	 
	public void setCheckBoxList(List<String> checkBoxList) {
		this.checkBoxList = checkBoxList;
	}
	
	public boolean getExistPrev() {
		return this.existPrev;
	}
	public boolean getExistNext() {
		return this.existNext;
	} 
	 
	public void setExistNext(boolean existNext) {
		this.existNext = existNext;
	}
	public void setExistPrev(boolean existPrev) {
		this.existPrev = existPrev;
	}	
	
	public void paging(int cnt) {
		totalCount = cnt;
		pageCount =(totalCount %PAGE_SIZE==0) ?  totalCount/PAGE_SIZE : (totalCount/PAGE_SIZE)+1;
		startRow = (pageNo-1) * PAGE_SIZE;
		endRow = (pageNo >= pageCount) ?   totalCount-1  : pageNo*PAGE_SIZE-1;
		blockCount = (pageCount %BLOCK_SIZE==0) ?  pageCount/BLOCK_SIZE : (pageCount/BLOCK_SIZE)+1; //블럭의 개수
		startPage =   ((pageNo-1)/BLOCK_SIZE)*BLOCK_SIZE+1; // 
		endPage = ((pageCount-startPage)<(BLOCK_SIZE) ) ?   pageCount : (startPage + BLOCK_SIZE -1); // 
		existPrev = (startPage < (BLOCK_SIZE+1) ) ? false : true;  // start Page가 BLOCK_SIZE+1보다 작으면 없음.
		existNext =  (pageCount <= endPage) ? false : true; // 페이지수가 endPage와 같으면 없음.
		blist = new ArrayList<>();
		for (int i = startPage;  i < endPage+1 ; i++) {
			blist.add(i);
		}
				
	}
	
	public int parseInt(String param) {
		Function<String, Integer> f = s-> Integer.parseInt(s);
		return f.apply(param);
	}
	
}