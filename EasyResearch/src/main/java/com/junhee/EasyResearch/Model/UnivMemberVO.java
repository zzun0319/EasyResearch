package com.junhee.EasyResearch.Model;

public class UnivMemberVO {

	private String idNumber;
	private String registeredName;
	private String univEmail;
	private String sort;
	private String major;
	private boolean isUsing;
	
	public UnivMemberVO() {}

	public UnivMemberVO(String idNumber, String registeredName, String univEmail, String sort, String major,
			boolean isUsing) {
		this.idNumber = idNumber;
		this.registeredName = registeredName;
		this.univEmail = univEmail;
		this.sort = sort;
		this.major = major;
		this.isUsing = isUsing;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getRegisteredName() {
		return registeredName;
	}

	public void setRegisteredName(String registeredName) {
		this.registeredName = registeredName;
	}

	public String getUnivEmail() {
		return univEmail;
	}

	public void setUnivEmail(String univEmail) {
		this.univEmail = univEmail;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public boolean isUsing() {
		return isUsing;
	}

	public void setUsing(boolean isUsing) {
		this.isUsing = isUsing;
	}

	@Override
	public String toString() {
		return "UnivMemberVO [idNumber=" + idNumber + ", registeredName=" + registeredName + ", univEmail=" + univEmail
				+ ", sort=" + sort + ", major=" + major + ", isUsing=" + isUsing + "]";
	}

}
