package com.petcare.web.domains;

public class FAQVO {
	
	int faqNo;
	String faqCat;
	String faqName;
	String faqCont;
	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public String getFaqCat() {
		return faqCat;
	}
	public void setFaqCat(String faqCat) {
		this.faqCat = faqCat;
	}
	public String getFaqName() {
		return faqName;
	}
	public void setFaqName(String faqName) {
		this.faqName = faqName;
	}
	public String getFaqCont() {
		return faqCont;
	}
	public void setFaqCont(String faqCont) {
		this.faqCont = faqCont;
	}
	@Override
	public String toString() {
		return "FAQVO [faqNo=" + faqNo + ", faqCat=" + faqCat + ", faqName=" + faqName + ", faqCont=" + faqCont + "]";
	}
	

}
