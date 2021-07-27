package com.junhee.EasyResearch.Service;

import java.util.List;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Model.UserVO;

public interface IUserService {
	
	// 회원 가입 전 멤버 유형, 학번으로 1차 검사 - 실제 학교 멤버인지. 일치한다면 학교메일, 이름까지 담아서 가입 2단계로 보내기
	UnivMemberVO CheckUnivMember(UnivMemberVO univInfo);

	// 회원 가입 기능
	void Register(UserVO user);
	
	/*
	// 로그인 체크 기능 (가입 승인 여부도 체크해야함)
	UserVO getOneUserInfo(UserVO user);
		
	//로그인 체크 기능
	String getLoginCheckMessage(UserVO user);
			
	// 회원 정보 수정 기능
	void UpdateUserInfo(UserVO user);
			
	// 비밀 번호 수정 기능
	void UpdatePassword(String userId, String userPw);
		
	// 회원 탈퇴 기능
	void DeleteUser(String userId);
		
	// 전공 리스트 가져오기
	List<String> getMajors();
		
	// 학번 중복 체크
	String checkIdNum(String identifiedNum);
		
	// 대학원생 리스트 반환
	List<UserVO> getGStudentsInfo(String major);
	*/
}
