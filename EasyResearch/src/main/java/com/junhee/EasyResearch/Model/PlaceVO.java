package com.junhee.EasyResearch.Model;

public class PlaceVO {

	private String placeName; // ��Ҹ�
	private int maxPeople; // ������ ���� ������ �ο���
	
	public PlaceVO() {}
	
	public PlaceVO(String placeName, int maxPeople) {
		this.placeName = placeName;
		this.maxPeople = maxPeople;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	@Override
	public String toString() {
		return "PlaceVO [placeName=" + placeName + ", maxPeople=" + maxPeople + "]";
	}
	
}
