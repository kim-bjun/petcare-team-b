package com.petcare.web.utills;

public class Paging {

	int startPage;
	int endPage;
	int pageCount=10;
	int totalEnd;
	boolean next;
	boolean prev;
	
	public Paging(int pageNo, int totalCount, int perPage){
		
		totalEnd=(int)Math.ceil(totalCount/(float)perPage);
		startPage=(int)(Math.ceil((float)pageNo/(float)pageCount)-1)*10+1;
		endPage=Math.min(totalEnd,startPage+9);
		prev=startPage==1? false:true;
		next=totalEnd>endPage? true:false;
		
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
