package com.junhee.EasyResearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Model.UserVO;
import com.junhee.EasyResearch.User.Repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserMapperTest {

	@Autowired
	private IUserMapper mapper;
	
	@Test
	public void GetUnivMemberInfoByIdNumTest() {
		
		UnivMemberVO newumvo = mapper.GetUnivMemberInfoByIdNum("200320007");
		System.out.println(newumvo);
		
	}
	
	@Test
	public void UpdateRegiStateTest() {
		
		System.out.println(mapper.GetUnivMemberInfoByIdNum("200220011"));
		mapper.UpdateRegiState("200220011", false);
		System.out.println(mapper.GetUnivMemberInfoByIdNum("200220011"));
	}
	
	@Test
	public void RegisterTest() {
		UserVO user = new UserVO();
		user.setUserId("teacher5");
		user.setUserPw("teacher5!");
		user.setUnivIdNum("201920010");
		user.setEmail("instructor5@ajou.ac.kr");
		user.setTel("01077778888");
		user.setUserType("강사");
		user.setClassRegiRight(true);
		user.setUserName("강사5");
		mapper.Register(user);
		System.out.println(mapper.GetERUserInfoById(user.getUserId()));
	}
	
	@Test
	public void UpdateUserInfoTest() {
		UserVO user = new UserVO();
		user.setUserId("doctor1111");
		System.out.println(mapper.GetERUserInfoById(user.getUserId()));
		user.setEmail("dododo@naver.com");
		user.setTel("01090909090");
		mapper.UpdateUserInfo(user);
		System.out.println(mapper.GetERUserInfoById(user.getUserId()));
	}

	@Test
	public void CheckEmailTest() {
		UserVO user = mapper.CheckEmail("dododo@naver.com");
		if(user == null) {
			System.out.println("없음");
		}
		else {
			System.out.println("있음");
		}
	}
	
}
