package com.junhee.EasyResearch.Research.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.junhee.EasyResearch.Model.CommentVO;
import com.junhee.EasyResearch.Model.PlaceVO;
import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Model.TimeslotVO;
import com.junhee.EasyResearch.Model.TmpDateTimeDTO;
import com.junhee.EasyResearch.commons.MajorSearchVO;
import com.junhee.EasyResearch.commons.TimeslotSearchVO;

public interface IResearchService {
	
	// 연구 개설
	public String RegisterResearch(ResearchVO rvo, MultipartFile file) throws IllegalStateException, IOException;

	// 내가 개설한 연구 보기
	public List<ResearchVO> GetMyResearch(String userId);
	
	// 연구 상세 보기
	public ResearchVO GetResearchInfo(int researchId);
	
	// 파일 저장 경로 리턴
	public String GetFullPath(String fileName);
	
	// 연구 승인 위해 지도교수 전공과 같은 대학원생의 연구만 얻어오기 + 페이징, 검색 기능 추가
	public List<ResearchVO> GetSameMajorResearch(MajorSearchVO msvo);
	
	// 조회된 전체 연구 수 구하기
	public int GetTotalSameMajorResearchCnt(MajorSearchVO msvo);
	
	// 연구 승인하기
	public String PermitResearch(ResearchVO rvo);
	
	// 피드백(댓글) 등록
	public int RegisterComment(CommentVO cvo);
		
	// 연구에 달린 피드백 리스트 얻기
	public List<CommentVO> GetResearchComments(int researchId);
	
	// 모든 장소 정보 가져오기
	public List<PlaceVO> GetAllLocationInfo();
		
	// 연구별 타임슬롯 가져오기
	public List<TimeslotVO> GetTimeslotsByResearchId(int researchId);
	
	// 연구 타임슬롯 등록하기
	public String RegisterTimeslot(TimeslotVO tsvo, TmpDateTimeDTO tdt);
	
	// 연구 번호, 페이징
	public int GetTotalTimeslotsCnt(TimeslotSearchVO tss);
	
	// 타임 슬롯 검색, 페이징
	public List<TimeslotVO> GetTimeslots(TimeslotSearchVO tss);
}
