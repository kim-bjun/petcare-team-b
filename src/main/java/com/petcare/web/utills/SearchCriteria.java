package com.petcare.web.utills;

public class SearchCriteria extends Criteria {

	String searchType;
	String searchContent;
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
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", searchContent=" + searchContent + ", pageNo=" + pageNo
				+ ", perPage=" + perPage + "]";
	}
	
	
}
