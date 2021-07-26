package com.junhee.EasyResearch.Model;

import java.sql.Timestamp;

public class TimeslotVO {

	private int slotNum; // ���� �ĺ� ��ȣ
	private ResearchVO research; // ���� ����
	private Timestamp startTime; // ���� ���� �ð�
	private Timestamp endTime; // ���� ���� �ð�
	private PlaceVO place; // ���� ��� ����
	
	public TimeslotVO() {}

	public TimeslotVO(int slotNum, ResearchVO research, Timestamp startTime, Timestamp endTime, PlaceVO place) {
		this.slotNum = slotNum;
		this.research = research;
		this.startTime = startTime;
		this.endTime = endTime;
		this.place = place;
	}

	public int getSlotNum() {
		return slotNum;
	}

	public void setSlotNum(int slotNum) {
		this.slotNum = slotNum;
	}

	public ResearchVO getResearch() {
		return research;
	}

	public void setResearch(ResearchVO research) {
		this.research = research;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public PlaceVO getPlace() {
		return place;
	}

	public void setPlace(PlaceVO place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "TimeslotVO [slotNum=" + slotNum + ", research=" + research + ", startTime=" + startTime + ", endTime="
				+ endTime + ", place=" + place + "]";
	}
	
}
