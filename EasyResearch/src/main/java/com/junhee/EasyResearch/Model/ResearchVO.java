package com.junhee.EasyResearch.Model;

public class ResearchVO {

	private int researchId; // 연구 식별 id
	private String researchType; // 오프라인 실험, 오프라인 설문, 온라인 실험, 온라인 설문, 기타(오프라인), 기타(온라인)
	private String title; // 연구 제목
	private String purpose; // 연구 목적
	private String method; // 연구 방법 및 절차
	private UserVO researcher; // 연구자 정보
	private String rewardType; // 보상 타입 - 연구 참여 점수, 참가비, 기타 3개 증 택 1 
	private int rewardValue; // 보상 정도 (~점, ~원, ~개)
	private int duration; // 연구 소요 시간
	private boolean permission; // 연구 진행 승인 여부
	private String uploadFileName; // 업로드한 파일 이름
	private String savedFileName; // 파일 이름이 같을 경우 구분하기 위해 uuid를 붙인 파일 이름
	
	public ResearchVO() {}

	public ResearchVO(int researchId, String researchType, String title, String purpose, String method,
			UserVO researcher, String rewardType, int rewardValue, int duration, boolean permission,
			String uploadFileName, String savedFileName) {
		this.researchId = researchId;
		this.researchType = researchType;
		this.title = title;
		this.purpose = purpose;
		this.method = method;
		this.researcher = researcher;
		this.rewardType = rewardType;
		this.rewardValue = rewardValue;
		this.duration = duration;
		this.permission = permission;
		this.uploadFileName = uploadFileName;
		this.savedFileName = savedFileName;
	}

	public int getResearchId() {
		return researchId;
	}

	public void setResearchId(int researchId) {
		this.researchId = researchId;
	}

	public String getResearchType() {
		return researchType;
	}

	public void setResearchType(String researchType) {
		this.researchType = researchType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public UserVO getResearcher() {
		return researcher;
	}

	public void setResearcher(UserVO researcher) {
		this.researcher = researcher;
	}

	public String getRewardType() {
		return rewardType;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public int getRewardValue() {
		return rewardValue;
	}

	public void setRewardValue(int rewardValue) {
		this.rewardValue = rewardValue;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isPermission() {
		return permission;
	}

	public void setPermission(boolean permission) {
		this.permission = permission;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavedFileName() {
		return savedFileName;
	}

	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}

	@Override
	public String toString() {
		return "ResearchVO [researchId=" + researchId + ", researchType=" + researchType + ", title=" + title
				+ ", purpose=" + purpose + ", method=" + method + ", researcher=" + researcher + ", rewardType="
				+ rewardType + ", rewardValue=" + rewardValue + ", duration=" + duration + ", permission=" + permission
				+ ", uploadFileName=" + uploadFileName + ", savedFileName=" + savedFileName + "]";
	}

}
