package com.junhee.EasyResearch.Model;

public class AttendeeVO {

	private int attendeeNum; // 학생 & 수업 짝 식별번호
	private UserVO student; // 수강생 정보
	private ClassVO tClass; // 수업 정보
	
	public AttendeeVO() {}

	public AttendeeVO(int attendeeNum, UserVO student, ClassVO tClass) {
		this.attendeeNum = attendeeNum;
		this.student = student;
		this.tClass = tClass;
	}

	public int getAttendeeNum() {
		return attendeeNum;
	}

	public void setAttendeeNum(int attendeeNum) {
		this.attendeeNum = attendeeNum;
	}

	public UserVO getStudent() {
		return student;
	}

	public void setStudent(UserVO student) {
		this.student = student;
	}

	public ClassVO gettClass() {
		return tClass;
	}

	public void settClass(ClassVO tClass) {
		this.tClass = tClass;
	}

	@Override
	public String toString() {
		return "AttendeeVO [attendeeNum=" + attendeeNum + ", student=" + student + ", tClass=" + tClass + "]";
	}
	
}
