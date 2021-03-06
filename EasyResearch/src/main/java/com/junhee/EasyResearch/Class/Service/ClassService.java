package com.junhee.EasyResearch.Class.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junhee.EasyResearch.Class.Repository.IClassMapper;
import com.junhee.EasyResearch.Model.ClassVO;

@Service
public class ClassService implements IClassService {

	@Autowired
	private IClassMapper mapper;
	
	@Override
	public String RegisterClassForResearch(ClassVO cvo) {

		mapper.RegisterClassForResearch(cvo);
		return cvo.getClassName() + "을 연구참여과목으로 등록하였습니다.";
	}

	@Override
	public List<ClassVO> GetClassesList(String instructorId) {
		ClassVO cvo = new ClassVO();
		cvo.setInstructorId(instructorId);
		return mapper.GetClassesList(cvo);
	}

	@Override
	public String DeleteClass(int classId) {
		mapper.DeleteClass(classId);
		return "클래스가 연구참여과목에서 삭제되었습니다.";
	}

}
