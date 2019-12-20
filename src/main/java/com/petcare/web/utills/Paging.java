package com.petcare.web.utills;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Paging {

	int startPage;
	int endPage;
	int pageCount=10;
	int totalEnd;
	boolean next;
	boolean prev;
	String searchType;
	String searchContent;
	
	public Paging(int pageNo, int totalCount, int perPage){
		

//		System.out.println(Math.ceil(totalCount/perPage));
		totalEnd=(int)Math.ceil(totalCount/(float)perPage);
		startPage=(int)(Math.ceil((float)pageNo/(float)pageCount)-1)*10+1;

		endPage=Math.min(totalEnd,startPage+9);
		prev=startPage==1? false:true;
		next=totalEnd>endPage? true:false;
		
	}
	
	public String makeQuery(int pageNo) {
		
		UriComponents uriComponents=UriComponentsBuilder.newInstance()
				.queryParam("pageNo",pageNo)
				.queryParam("searchType",searchType)
				.queryParam("searchContent", searchContent)
				.build();
		
		return uriComponents.toString();
	}

	@Override
	public String toString() {
		return "Paging [startPage=" + startPage + ", endPage=" + endPage + ", pageCount=" + pageCount + ", totalEnd="
				+ totalEnd + ", next=" + next + ", prev=" + prev + "]";
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	
	
}
