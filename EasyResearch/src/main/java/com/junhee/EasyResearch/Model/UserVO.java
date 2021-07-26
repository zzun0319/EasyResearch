package com.junhee.EasyResearch.Model;

public class UserVO {
	
	private String userId; // ���̵�
	private String userPw; // ��й�ȣ
	private String univIdNum; // �й�, ����
	private String email; // �б� �̸���
	private String tel; // �޴��� ��ȣ
	private String major; // ���� - ����, �ڻ�, ����, ����������
	private String userType; // �кλ�, ����, �ڻ�, ����, ����, �������� �� �� 1
	private boolean participationRight; // ���� ���� ����
	private boolean setupRight; // ���� ���� ����
	private boolean classRegiRight; // ���Ǹ� ���������������� ����ϴ� ����
	private boolean permissionRight; // ������ ������ �����ϴ� ����
	
	public UserVO() {}

	public UserVO(String userId, String userPw, String univIdNum, String email, String tel, String major,
			String userType, boolean participationRight, boolean setupRight, boolean classRegiRight,
			boolean permissionRight) {
		this.userId = userId;
		this.userPw = userPw;
		this.univIdNum = univIdNum;
		this.email = email;
		this.tel = tel;
		this.major = major;
		this.userType = userType;
		this.participationRight = participationRight;
		this.setupRight = setupRight;
		this.classRegiRight = classRegiRight;
		this.permissionRight = permissionRight;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUnivIdNum() {
		return univIdNum;
	}

	public void setUnivIdNum(String univIdNum) {
		this.univIdNum = univIdNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isParticipationRight() {
		return participationRight;
	}

	public void setParticipationRight(boolean participationRight) {
		this.participationRight = participationRight;
	}

	public boolean isSetupRight() {
		return setupRight;
	}

	public void setSetupRight(boolean setupRight) {
		this.setupRight = setupRight;
	}

	public boolean isClassRegiRight() {
		return classRegiRight;
	}

	public void setClassRegiRight(boolean classRegiRight) {
		this.classRegiRight = classRegiRight;
	}

	public boolean isPermissionRight() {
		return permissionRight;
	}

	public void setPermissionRight(boolean permissionRight) {
		this.permissionRight = permissionRight;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", univIdNum=" + univIdNum + ", email=" + email
				+ ", tel=" + tel + ", major=" + major + ", userType=" + userType + ", participationRight="
				+ participationRight + ", setupRight=" + setupRight + ", classRegiRight=" + classRegiRight
				+ ", permissionRight=" + permissionRight + "]";
	}
	
}
