package com.junhee.EasyResearch.Model;

import java.sql.Timestamp;

public class TimeslotVO {

	private int slotNum; // 슬롯 식별 번호
	private ResearchVO research; // 연구 정보
	private Timestamp startTime; // 연구 시작 시간
	private Timestamp endTime; // 연구 종료 시간
	private PlaceVO place; // 연구 장소 정보
	
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
