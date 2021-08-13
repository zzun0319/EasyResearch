package com.junhee.EasyResearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junhee.EasyResearch.Class.Repository.IClassMapper;
import com.junhee.EasyResearch.Model.ClassVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ClassMapperTest {
	
	@Autowired
	private IClassMapper mapper;
	
	@Test
	public void RegisterClassForResearchTest() {
		ClassVO cvo = new ClassVO();
		cvo.setInstructorId("prof1111");
		cvo.setInstructorName("지도교수1");
		cvo.setClassName("사고과정의 이해");
		cvo.setClassSchedule("월D목D");
		cvo.setResearchCredit(10);
		mapper.RegisterClassForResearch(cvo);
	}
	
	@Test
	public void GetClassesListTest() {
		
		ClassVO cvo = new ClassVO();
		//cvo.setInstructorId("prof1111");
		
		for(ClassVO cvvo : mapper.GetClassesList(cvo)){
			System.out.println(cvvo);
		}
		
	}
	
}
