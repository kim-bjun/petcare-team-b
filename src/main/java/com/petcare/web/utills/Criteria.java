package com.petcare.web.utills;

public class Criteria {

	int pageNo;
	int perPage;
	
	Criteria(){
		this.pageNo=1;
		this.perPage=10;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPageStart() {
		return (this.pageNo-1)*perPage;
	}

	@Override
	public String toString() {
		return "Criteria [pageNo=" + pageNo + ", perPage=" + perPage + "]";
	}
	
	
	
}
