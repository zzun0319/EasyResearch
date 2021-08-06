package com.junhee.EasyResearch.commons;

public class SearchVO extends PageVO{

	private String keyword;
	private String condition; // 연구자 이름, 연구 제목, 보상 종류
	
	public SearchVO() {
		super();
		this.keyword = "";
		this.condition = "";
	}

	public SearchVO(String keyword, String condition) {
		super();
		this.keyword = keyword;
		this.condition = condition;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "SearchVO [keyword=" + keyword + ", condition=" + condition + "]";
	}
	
}
