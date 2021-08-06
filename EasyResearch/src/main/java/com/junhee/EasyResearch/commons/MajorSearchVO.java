package com.junhee.EasyResearch.commons;

public class MajorSearchVO extends SearchVO {

	private String major;
	
	public MajorSearchVO() {
		super();
	}

	public MajorSearchVO(String major) {
		super();
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
