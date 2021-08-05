package com.junhee.EasyResearch.Research.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.junhee.EasyResearch.Model.ResearchVO;

public interface IResearchService {
	
	// 연구 개설
	public String RegisterResearch(ResearchVO rvo, MultipartFile file) throws IllegalStateException, IOException;

	// 내가 개설한 연구 보기
	public List<ResearchVO> GetMyResearch(String userId);
	
	// 연구 상세 보기
	public ResearchVO GetResearchInfo(int researchId);
	
	// 파일 저장 경로 리턴
	public String GetFullPath(String fileName);
	
	// 연구 승인 위해 지도교수 전공과 같은 대학원생의 연구만 얻어오기
	public List<ResearchVO> GetSameMajorResearch(String major);
}
