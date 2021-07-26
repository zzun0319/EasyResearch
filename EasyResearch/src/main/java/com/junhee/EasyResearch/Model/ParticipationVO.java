package com.junhee.EasyResearch.Model;

public class ParticipationVO {

	private int participationNum; // 참가 정보 식별번호
	private UserVO participant; // 참가자 정보
	private TimeslotVO timeslot; // 타임슬롯 정보
	private String partState; // 참가 상태 - 대기 중, 참여 완료, 불참, 무단 불참
	
	public ParticipationVO() {}

	public ParticipationVO(int participationNum, UserVO participant, TimeslotVO timeslot, String partState) {
		this.participationNum = participationNum;
		this.participant = participant;
		this.timeslot = timeslot;
		this.partState = partState;
	}

	public int getParticipationNum() {
		return participationNum;
	}

	public void setParticipationNum(int participationNum) {
		this.participationNum = participationNum;
	}

	public UserVO getParticipant() {
		return participant;
	}

	public void setParticipant(UserVO participant) {
		this.participant = participant;
	}

	public TimeslotVO getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(TimeslotVO timeslot) {
		this.timeslot = timeslot;
	}

	public String getPartState() {
		return partState;
	}

	public void setPartState(String partState) {
		this.partState = partState;
	}

	@Override
	public String toString() {
		return "ParticipationVO [participationNum=" + participationNum + ", participant=" + participant + ", timeslot="
				+ timeslot + ", partState=" + partState + "]";
	}
	
}
