package com.junhee.EasyResearch.commons;

public class PageVO {
	
	private int pageNum;
	private int cntPerPage;
	
	public PageVO() {
		this.pageNum = 1;
		this.cntPerPage = 10;
	}

	public PageVO(int pageNum, int cntPerPage) {
		this.pageNum = pageNum;
		this.cntPerPage = cntPerPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	@Override
	public String toString() {
		return "PageVO [pageNum=" + pageNum + ", cntPerPage=" + cntPerPage + "]";
	}
	
}
