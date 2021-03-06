package com.junhee.EasyResearch.Research.Repository;

import java.util.List;

import com.junhee.EasyResearch.Model.CommentVO;
import com.junhee.EasyResearch.Model.PlaceVO;
import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Model.TimeslotVO;
import com.junhee.EasyResearch.Model.TmpDateTimeDTO;
import com.junhee.EasyResearch.commons.MajorSearchVO;
import com.junhee.EasyResearch.commons.TimeslotSearchVO;

public interface IResearchMapper {
	
	// 연구 개설
	public void RegisterResearch(ResearchVO rvo);
	
	// 내가 개설한 연구 보기
	public List<ResearchVO> GetMyResearch(String userId);
	
	// 연구 상세 보기
	public ResearchVO GetResearchInfo(int researchId);
	
	// 연구 승인 위해 지도교수 전공과 같은 대학원생의 연구만 얻어오기
	public List<ResearchVO> GetSameMajorResearch(MajorSearchVO msvo);
	
	// 조회된 전체 연구 수 구하기
	public int GetTotalSameMajorResearchCnt(MajorSearchVO msvo);
	
	// 연구 승인하기
	public void PermitResearch(ResearchVO rvo);
	
	// 피드백(댓글) 등록
	public void RegisterComment(CommentVO cvo);
	
	// 연구에 달린 피드백 리스트 얻기
	public List<CommentVO> GetResearchComments(int researchId);
	
	// 모든 장소 정보 가져오기
	public List<PlaceVO> GetAllLocationInfo();
	
	// 연구별 타임슬롯 가져오기
	public List<TimeslotVO> GetTimeslotsByResearchId(int researchId);
	
	// 연구 타임슬롯 등록하기
	public void RegisterTimeslot(TimeslotVO tsvo);
	
	// 24시간 이후의 해당 장소에 예약된 모든 타임슬롯의 개수
	public int TimeslotsAfterTomorrowCnt(TmpDateTimeDTO tdt);
	
	// 24시간 이후의 해당 장소에 내가 삽입하려는 타임슬롯과 겹치는 타임슬롯을 제외한 개수
	public int NotOvelapCnt(TmpDateTimeDTO tdt);
	
	// 연구 번호, 페이징
	public int GetTotalTimeslotsCnt(TimeslotSearchVO tss);
	
	// 타임 슬롯 검색, 페이징
	public List<TimeslotVO> GetTimeslots(TimeslotSearchVO tss);
	
	// 장소명을 받아 최대 수용 인원수를 리턴하는 메서드
	public int GetMaxPeople(String placeName);
	
	/*	
	// 연구 참여 과목 등록
	void RegisterClass(ClassVO cvo);
	
	// 자신의 연구참여 과목 리스트 보기
	List<ClassVO> GetMyClasses(String teacherId);
	
	// 연구 참여 과목 삭제
	void DeleteClass(ClassVO cvo);
	
	// 모든 연구참여 과목 리스트 보기
	List<ClassVO> GetAllClassList();
	
	// 수강 과목 추가
	void InsertClassStudentPair(TakingClassVO tcvo);
	
	// 클래스 정보 얻기
	ClassVO GetClassInfo(int classId);
	
	// 수강 중인 클래스 정보 얻기
	List<TakingClassVO> GetTakingClassList(String studentId);
	
	
	// 장소 최대인원 불러오기
	int GetMaxLimitPeople(String locationName);
	
	// 타임슬롯 예약하기
	void ReserveTimeslot(TsReserveVO tsvo);
	
	// 참여중인 타임슬롯 예약 리스트 가져오기
	List<TsReserveVO> GetAppliedTimeslots(String studentId);
	
	// 참여중인 타임슬롯 리스트 가져오기
	List<TimeSlotVO> GetTimeslotsApplied(String studentId);
	
	// 연구 & 멤버 조인 테이블 가져오기
	List<ResearchVO> GetJoinInfo(String researcher);
	*/
}
