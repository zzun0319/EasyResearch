package com.junhee.EasyResearch.Model;

import java.sql.Date;
import java.sql.Timestamp;

public class TmpDateTimeDTO {

	private Date researchDate;
	private Date startDate;
	private Date endDate;
	private String startTime; // jsp파일에서 넘어오는 time은 String으로 받아야함. 연구 시작 시간
	private String endTime;
	private Timestamp startTimestamp;
	private Timestamp endTimeStamp;
	
	int duration; // 실험 소요 시간
	
	public TmpDateTimeDTO() {}

	////////// 장소를 사용 중인 날짜 조회 시 사용할 생성자 //////////////////////////////////////////////////////////
	/*
	public TmpDateTimeDTO(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		setPeriodForInquiry();
	}
	*/
	public void setPeriodForInquiry() { // 두 날짜를 입력 받으면 그 날짜들을 타임스탬프 형식으로 만들어주는 메서드
		startTimestamp = Timestamp.valueOf(startDate + " 00:00:00");
		endTimeStamp = Timestamp.valueOf(endDate + " 00:00:00");
	}
	
	////////// 연구 타임 슬롯 만들 때 받는 연구날짜, 시작시간, 종료시간 ///////////////////////////////////////////////

	public void setResearchTimestamps() { // Timeslot객체에 넣어주기 위한 Timestamp들을 만들어주는 메서드
		startTimestamp = Timestamp.valueOf(startDate + " " + startTime);
		calEndTimeEndDateEndTimestamp();
	}
	
	
	public void calEndTimeEndDateEndTimestamp() {
		
		String times[] = startTime.split(":");
		int startHour = Integer.parseInt(times[0]);
		int startMinute = Integer.parseInt(times[1]);
		
		int endHour = startHour;
		int endMinute = startMinute + duration;
		endDate = startDate;
		String dates[] = endDate.toString().split("-");
		int endYear = Integer.parseInt(dates[0]);
		int endMonth = Integer.parseInt(dates[1]);
		int endDay = Integer.parseInt(dates[2]);
		
		
		if(endMinute >= 60) {
			int hours = endMinute / 60;
			endMinute -= (60 * hours);
			endHour += hours;
			
			if(endHour >= 24) {
				int days = endHour / 24;
				endHour -= 24 * days;
				endDay += days;
				
				int daysPerMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
				
				if(CalcLeapYear(endYear)) { // 윤년이라면
					daysPerMonth[1] = 29; // 2월달을 29일까지로 바꿔주고
				}
				
				if(endDay > daysPerMonth[endMonth - 1]) {
					// int months 이렇게까지 한 타임슬롯이 긴 건 배제하는걸로.. 입력하는 부분에 제약 걸겠음.
					endDay = 1;
					endMonth += 1;
					
					if(endMonth > 12) {
						endMonth = 1;
						endYear += 1;
					}
				}
			}
		}
		endTime = endHour + ":" + endMinute + ":00";
		endDate = Date.valueOf(endYear + "-" + endMonth + "-" + endDay);
		endTimeStamp = Timestamp.valueOf(endDate + " " + endTime);
	}
	
	public boolean CalcLeapYear(int year) { // 윤년인지 판별
		if((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
			return true;
		}
		else if((year % 4 == 0) && (year % 100 == 0)) {
			return false;
		}
		else if(year % 4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////

	public Date getResearchDate() {
		return researchDate;
	}

	public void setResearchDate(Date researchDate) {
		this.researchDate = researchDate;
		this.startDate = researchDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
		//startTimestamp = Timestamp.valueOf(startDate + " 00:00:00");
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime + ":00";
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime + ":00";
	}

	public Timestamp getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Timestamp getEndTimeStamp() {
		return endTimeStamp;
	}

	public void setEndTimeStamp(Timestamp endTimeStamp) {
		this.endTimeStamp = endTimeStamp;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "TmpDateTimeDTO [researchDate=" + researchDate + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", startTimestamp=" + startTimestamp
				+ ", endTimeStamp=" + endTimeStamp + ", duration=" + duration + "]";
	}

}
