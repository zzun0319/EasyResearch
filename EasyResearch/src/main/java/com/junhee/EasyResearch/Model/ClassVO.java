package com.junhee.EasyResearch.Model;

public class ClassVO {

	private int classId; // ���� �ĺ� id
	private String instructorName; // ���� �̸�
	private String instructorId; // ���� id
	private String className; // ������
	private String classSchedule; // ���� �ð�ǥ
	private int researchCredit; // ä���� �� ���� ����
	
	public ClassVO() {}

	public ClassVO(int classId, String instructorName, String instructorId, String className, String classSchedule,
			int researchCredit) {
		this.classId = classId;
		this.instructorName = instructorName;
		this.instructorId = instructorId;
		this.className = className;
		this.classSchedule = classSchedule;
		this.researchCredit = researchCredit;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(String classSchedule) {
		this.classSchedule = classSchedule;
	}

	public int getResearchCredit() {
		return researchCredit;
	}

	public void setResearchCredit(int researchCredit) {
		this.researchCredit = researchCredit;
	}

	@Override
	public String toString() {
		return "ClassVO [classId=" + classId + ", instructorName=" + instructorName + ", instructorId=" + instructorId
				+ ", className=" + className + ", classSchedule=" + classSchedule + ", researchCredit=" + researchCredit
				+ "]";
	}
	
}