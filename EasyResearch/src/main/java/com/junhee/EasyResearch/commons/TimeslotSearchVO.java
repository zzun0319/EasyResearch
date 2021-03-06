package com.junhee.EasyResearch.commons;

import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Model.TmpDateTimeDTO;

public class TimeslotSearchVO extends SearchVO {

	private ResearchVO research; // 참가자가 참여가능한 타임슬롯 검색시 검색조건이 여러개이므로 이것으로 여러 정보를 받아서 null인지 아닌지 검사하여 동적 sql 수행
	private TmpDateTimeDTO tdt; // 기간 검색을 하기 위해 이것으로 Date 형태를 view로부터 넘겨받아 계산. 참가자는 24시간 이후에 있는 타임슬롯에 참여가능하므로 해당 클래스의 tomorrow활용
	private boolean isParticipant; // 참가자인지 아닌지를 넘겨받아서 연구자는 자신의 연구의 타임슬롯을 과거까지 모두 볼 수 있고, 참가자가 참여가능한 연구 검색시에는 24시간 이후의 타임슬롯만 검색되도록 하기 위해 필요한 bool 값
	
	public TimeslotSearchVO() {
		super();
		tdt = new TmpDateTimeDTO();
		research = new ResearchVO();
		isParticipant = false; // 디폴트는 연구자
	}

	public TimeslotSearchVO(ResearchVO research, TmpDateTimeDTO tdt) {
		super();
		this.research = research;
		this.tdt = tdt;
	}

	public ResearchVO getResearch() {
		return research;
	}
	
	public void setResearch(ResearchVO research) {
		this.research = research;
	}

	public TmpDateTimeDTO getTdt() {
		return tdt;
	}

	public void setTdt(TmpDateTimeDTO tdt) {
		this.tdt = tdt;
	}
	
	public boolean isParticipant() {
		return isParticipant;
	}
	
	public void setIsParticipant(boolean isParticipant) {
		this.isParticipant = isParticipant;
	}

	@Override
	public String toString() {
		return "TimeslotSearchVO [research=" + research + ", tdt=" + tdt + "isParticipant=" + isParticipant + "]"
	+ getCntPerPage() + " " + getPageNum() + " " + getOffset();
	}
	
}
