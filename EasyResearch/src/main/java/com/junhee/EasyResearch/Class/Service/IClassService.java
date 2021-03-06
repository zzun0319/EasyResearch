package com.junhee.EasyResearch.Class.Service;

import java.util.List;

import com.junhee.EasyResearch.Model.ClassVO;

public interface IClassService {

	// 클래스를 연구과목으로 등록하는 메서드
	public String RegisterClassForResearch(ClassVO cvo);
	
	// 연구참여과목으로 등록한 수업 리스트 보기
	public List<ClassVO> GetClassesList(String instructorId);
	
	// 연구참여과목으로 등록한 수업 삭제하기
	public String DeleteClass(int classId);
}
