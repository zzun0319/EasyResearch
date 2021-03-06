package com.junhee.EasyResearch.commons;

public class PageVO {
	
	private int pageNum;
	private int cntPerPage;
	private int offset;
	
	public PageVO() {
		this.pageNum = 1;
		this.cntPerPage = 10;
		this.offset = 0;
	}

	public PageVO(int pageNum, int cntPerPage) {
		this.pageNum = pageNum;
		this.cntPerPage = cntPerPage;
		this.offset = (pageNum-1) * cntPerPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.offset = (pageNum-1) * this.cntPerPage;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "PageVO [pageNum=" + pageNum + ", cntPerPage=" + cntPerPage + ", offset=" + offset + "]";
	}
	
}
