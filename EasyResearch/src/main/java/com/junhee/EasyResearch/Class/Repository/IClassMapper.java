package com.junhee.EasyResearch.Class.Repository;

import java.util.List;

import com.junhee.EasyResearch.Model.ClassVO;

public interface IClassMapper {

	// 클래스를 연구참여과목으로 등록하는 메서드
	public void RegisterClassForResearch(ClassVO cvo);
	
	// 연구참여과목으로 등록한 수업 리스트 보기 (전체 & 강사id로 검색 둘 다)
	public List<ClassVO> GetClassesList(ClassVO cvo);
	
	// 연구참여과목으로 등록한 수업 삭제하기
	public void DeleteClass(int classId);
}
