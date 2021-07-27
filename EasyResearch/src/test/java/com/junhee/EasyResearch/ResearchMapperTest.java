package com.junhee.EasyResearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Model.UserVO;
import com.junhee.EasyResearch.Repository.IResearchMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ResearchMapperTest {
	
	@Autowired
	private IResearchMapper mapper;
	
	@Test
	public void RegisterResearchTest() {
		
		ResearchVO rvo = new ResearchVO();
		rvo.setResearchType("오프라인 실험");
		rvo.setTitle("연구1");
		rvo.setPurpose("그냥1");
		rvo.setMethod("이렇게 해서 저렇게 한 후 그렇게 한다.");
		rvo.setRewardType("연구 참여 점수");
		rvo.setRewardValue(2);
		rvo.setDuratiom(30);
		rvo.setFilePath("d:/upload/연구1.doc");
		
		UserVO uvo = new UserVO();
		uvo.setUserId("master1111");
		
		rvo.setResearcher(uvo);
		mapper.RegisterResearch(rvo);
	}

}
