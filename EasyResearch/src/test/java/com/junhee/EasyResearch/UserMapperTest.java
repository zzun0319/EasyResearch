package com.junhee.EasyResearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserMapperTest {

	@Autowired
	private IUserMapper mapper;
	
	@Test
	public void checkUnivMemberTest() {
		
		UnivMemberVO umvo = new UnivMemberVO();
		umvo.setIdNumber("202050011");
		umvo.setSort("학부생");
		
		UnivMemberVO newumvo = mapper.CheckUnivMember(umvo);
		System.out.println(newumvo);
	}
	
}
