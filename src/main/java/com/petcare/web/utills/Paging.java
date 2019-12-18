package com.petcare.web.utills;

public class Paging {

	int startPage;
	int endPage;
	int pageCount=10;
	int totalEnd;
	boolean next;
	boolean prev;
	
	public Paging(int pageNo, int totalCount, int perPage){
		
//		System.out.println(Math.ceil(totalCount/perPage));
		totalEnd=(int)Math.ceil(totalCount/perPage);
		startPage=(pageNo/pageCount)*10+1;
		endPage=Math.min(totalEnd,startPage+9);
		prev=startPage==1? false:true;
		next=totalEnd>endPage? true:false;
		
	}

	@Override
	public String toString() {
		return "Paging [startPage=" + startPage + ", endPage=" + endPage + ", pageCount=" + pageCount + ", totalEnd="
				+ totalEnd + ", next=" + next + ", prev=" + prev + "]";
	}
	
	
	
}
