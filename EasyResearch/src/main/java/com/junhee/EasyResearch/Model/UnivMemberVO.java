package com.junhee.EasyResearch.Model;

public class UnivMemberVO {

	private String idNumber;
	private String registeredName;
	private String univEmail;
	private String sort;
	
	public UnivMemberVO() {}

	public UnivMemberVO(String idNumber, String registeredName, String univEmail, String sort) {
		this.idNumber = idNumber;
		this.registeredName = registeredName;
		this.univEmail = univEmail;
		this.sort = sort;
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

	@Override
	public String toString() {
		return "UnivMemberVO [idNumber=" + idNumber + ", registeredName=" + registeredName + ", univEmail=" + univEmail
				+ ", sort=" + sort + "]";
	}
	
}
