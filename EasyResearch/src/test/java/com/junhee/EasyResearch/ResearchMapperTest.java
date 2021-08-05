package com.junhee.EasyResearch;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junhee.EasyResearch.Model.CommentVO;
import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Model.UserVO;
import com.junhee.EasyResearch.Research.Repository.IResearchMapper;

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
		rvo.setDuration(30);
		rvo.setUploadFileName("d:/upload/연구1.doc");
		
		UserVO researcher = new UserVO();
		researcher.setUserId("master1111");
		
		rvo.setResearcher(researcher);
		mapper.RegisterResearch(rvo);
	}
	
	@Test
	public void GetMyResearchTest() {
		
		List<ResearchVO> list = mapper.GetMyResearch("master1111");
		for(ResearchVO rvo : list) {
			System.out.println(rvo);
		}
	}
	
	@Test
	public void GetResearchInfoTest() {
		System.out.println(mapper.GetResearchInfo(3));
	}
	
	@Test
	public void GetSameMajorResearchTest() {
		
		for(ResearchVO rvo : mapper.GetSameMajorResearch("응용인지심리")) {
			System.out.println(rvo);
		}
		
	}
	
	@Test
	public void PermitResearchTest() {
		ResearchVO rvo = new ResearchVO();
		rvo.setResearchId(4);
		rvo.setPermission(true);
		System.out.println(mapper.GetResearchInfo(4));
		mapper.PermitResearch(rvo);
		System.out.println(mapper.GetResearchInfo(4));
		
	}

	@Test
	public void RegisterCommentTest() {
		/*
		CommentVO cvo = new CommentVO();
		cvo.setContent("연구 방법을 좀 더 구체적으로 써야겠구나");
		cvo.setResearchId(4);
		UserVO uvo = new UserVO();
		uvo.setUserId("prof1111");
		cvo.setWriter(uvo);
		mapper.RegisterComment(cvo);
		*/
		CommentVO cvo = new CommentVO();
		cvo.setContent("연구 방법을 좀 더 구체적으로 수정했습니다");
		cvo.setResearchId(4);
		UserVO uvo = new UserVO();
		uvo.setUserId("master1111");
		cvo.setWriter(uvo);
		mapper.RegisterComment(cvo);
	}
	
	@Test
	public void GetResearchCommentsTest() {
		
		for(CommentVO cvo : mapper.GetResearchComments(4)) {
			System.out.println(cvo);
		}
		
	}
	
}
