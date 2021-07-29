package com.junhee.EasyResearch.User.Service;

import java.util.List;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Model.UserVO;

public interface IUserService {
	
	// 회원 가입 전 멤버 유형, 학번으로 1차 검사 - 실제 학교 멤버인지. 일치한다면 학교메일, 이름까지 담아서 가입 2단계로 보내기
	UnivMemberVO CheckUnivMember(UnivMemberVO univInfo);

	// 회원 가입 기능
	void Register(UserVO user);
	
}
