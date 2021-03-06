package com.junhee.EasyResearch.Model;

import java.sql.Date;
import java.sql.Timestamp;

public class TmpDateTimeDTO {

	private Date researchDate;
	private Date startDate;
	private Date endDate;
	private String sTime; // jsp파일에서 넘어오는 time은 String으로 받아야함. 연구 시작 시간
	private String eTime;
	private Timestamp startTimestamp;
	private Timestamp endTimestamp;
	
	private int duration; // 실험 소요 시간
	private Timestamp tomorrow; // 현재 시간으로부터 24시간 후 타임스탬프
	private String researchPlace;
	
	public TmpDateTimeDTO() { // 빈 생성자 생성시 바로 24시간 후의 타임스탬프 계산하기
		tomorrow = new Timestamp(System.currentTimeMillis() + (24 * 60 * 60 * 1000));
	}

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
		endTimestamp = Timestamp.valueOf(endDate + " 23:59:59");
	}
	
	////////// 연구 타임 슬롯 만들 때 받는 연구날짜, 시작시간, 종료시간 ///////////////////////////////////////////////

	public void setResearchTimestamps() { // Timeslot객체에 넣어주기 위한 Timestamp들을 만들어주는 메서드
		startTimestamp = Timestamp.valueOf(startDate + " " + sTime);
		calEndTimeEndDateEndTimestamp();
	}
	
	
	public void calEndTimeEndDateEndTimestamp() {
		
		String times[] = sTime.split(":");
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
		eTime = endHour + ":" + endMinute + ":00";
		endDate = Date.valueOf(endYear + "-" + endMonth + "-" + endDay);
		endTimestamp = Timestamp.valueOf(endDate + " " + eTime);
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
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSTime() {
		return sTime;
	}

	public void setSTime(String sTime) {
		this.sTime = sTime + ":00";
	}

	public String getETime() {
		return eTime;
	}

	public void setEndTime(String eTime) {
		this.eTime = eTime + ":00";
	}

	public Timestamp getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Timestamp getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Timestamp endTimeStamp) {
		this.endTimestamp = endTimeStamp;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setTomorrow(Timestamp tomorrow) {
		this.tomorrow = tomorrow;
	}
	
	public Timestamp getTomorrow() {
		return tomorrow;
	}
	
	public void setResearchPlace(String researchPlace) {
		this.researchPlace = researchPlace;
	}
	
	public String getResearchPlace() {
		return researchPlace;
	}

	@Override
	public String toString() {
		return "TmpDateTimeDTO [researchDate=" + researchDate + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", sTime=" + sTime + ", eTime=" + eTime + ", startTimestamp=" + startTimestamp
				+ ", endTimestamp=" + endTimestamp + ", duration=" + duration + ", tomorrow=" + tomorrow + ", researchPlace=" + researchPlace + "]";
	}

}
