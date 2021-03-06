package com.junhee.EasyResearch;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junhee.EasyResearch.Model.CommentVO;
import com.junhee.EasyResearch.Model.PlaceVO;
import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Model.TimeslotVO;
import com.junhee.EasyResearch.Model.TmpDateTimeDTO;
import com.junhee.EasyResearch.Model.UserVO;
import com.junhee.EasyResearch.Research.Repository.IResearchMapper;
import com.junhee.EasyResearch.commons.MajorSearchVO;
import com.junhee.EasyResearch.commons.TimeslotSearchVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ResearchMapperTest {
	
	@Autowired
	private IResearchMapper mapper;
	
	@Test
	public void RegisterResearchTest() {
		
		for(int i = 8; i < 59; i++) {
			
		ResearchVO rvo = new ResearchVO();
		rvo.setResearchType("오프라인 실험");
		rvo.setTitle("연구" + i);
		rvo.setPurpose("목적" + i);
		rvo.setMethod("이렇게 해서 저렇게 한 후 그렇게 한다." + i);
		rvo.setRewardType("학점");
		rvo.setRewardValue(1);
		rvo.setDuration(30);
		
		UserVO researcher = new UserVO();
		researcher.setUserId("master1111");
		
		rvo.setResearcher(researcher);
		mapper.RegisterResearch(rvo);
		}
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
		
		
		MajorSearchVO msvo = new MajorSearchVO("응용인지심리");
		msvo.setCondition("title");
		msvo.setKeyword("박사");
		
		for(ResearchVO rvo : mapper.GetSameMajorResearch(msvo)) {
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
	
	
	@Test
	public void GetTotalSameMajorResearchCntTest() {
		
		MajorSearchVO msvo = new MajorSearchVO("응용인지심리");
		msvo.setCondition("researcher");
		msvo.setKeyword("mas");
		int totalNum = mapper.GetTotalSameMajorResearchCnt(msvo);
		System.out.println(totalNum);
	}
	
	@Test
	public void GetAllLocationInfoTest() {
		
		for(PlaceVO pvo : mapper.GetAllLocationInfo()) {
			System.out.println(pvo);
		}
		
	}
	
	@Test
	public void RegisterTimeslotTest() {
		TimeslotVO tsvo = new TimeslotVO();
		tsvo.setStartTime(Timestamp.valueOf("2021-08-12 19:10:00"));
		tsvo.setEndTime(Timestamp.valueOf("2021-08-12 19:50:00"));
		
		PlaceVO pvo = new PlaceVO("율곡관 371호", 4);
		tsvo.setPlace(pvo);
		
		ResearchVO rvo = new ResearchVO();
		rvo.setResearchId(4);
		tsvo.setResearch(rvo);
		
		mapper.RegisterTimeslot(tsvo);
	}
	
	@Test
	public void TimeslotsAfterTomorrowCntTest() {
		
		TmpDateTimeDTO tdt = new TmpDateTimeDTO();
		tdt.setStartTimestamp(Timestamp.valueOf("2021-08-11 02:05:00"));
		tdt.setEndTimestamp(Timestamp.valueOf("2021-08-11 02:51:00"));
		tdt.setResearchPlace("율곡관 371호");
		
		System.out.println(mapper.TimeslotsAfterTomorrowCnt(tdt));
		System.out.println(mapper.NotOvelapCnt(tdt));
		
		System.out.println();
	}
	
	@Test
	public void GetTotalTimeslotsCntTest() {
		TimeslotSearchVO tst = new TimeslotSearchVO();
		
		tst.getResearch().setResearchId(4);;
		tst.setIsParticipant(true);
		tst.getTdt().setStartTimestamp(Timestamp.valueOf("2021-08-09 10:00:00"));
		tst.getTdt().setEndTimestamp(Timestamp.valueOf("2021-08-19 10:00:00"));
		System.out.println(tst);
		System.out.println(mapper.GetTotalTimeslotsCnt(tst));
	}
	
	@Test
	public void GetTimeslotsTest() {
		TimeslotSearchVO tst = new TimeslotSearchVO();
		ResearchVO rvo = new ResearchVO();
		rvo.setResearchId(4);
		rvo.setTitle("1");
		tst.setResearch(rvo);
		tst.setIsParticipant(false);
		tst.getTdt().setStartTimestamp(Timestamp.valueOf("2021-08-09 10:00:00"));
		tst.getTdt().setEndTimestamp(Timestamp.valueOf("2021-08-19 10:00:00"));
		System.out.println(tst);
		for(TimeslotVO tsv : mapper.GetTimeslots(tst)) {
			System.out.println(tsv);
		}
	}
	
	@Test
	public void GetMaxPeopleTest() {
		System.out.println(mapper.GetMaxPeople("율곡관 371호"));
		System.out.println(mapper.GetMaxPeople("율곡관 412호"));
		System.out.println(mapper.GetMaxPeople("종합관 101호"));
	}
	
}
