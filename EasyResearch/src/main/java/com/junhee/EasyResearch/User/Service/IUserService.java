package com.junhee.EasyResearch.User.Service;

import java.util.List;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Model.UserVO;

public interface IUserService {
	
	// 회원 가입 시 입력한 정보가 모두 일치할 경우 다음 페이지에 입력했던 것들을 자동으로 입력시키기 위해 정보를 넘겨주는 메서드
	public UnivMemberVO GetUnivMemberInfoByIdNum(String idNumber);
	
	// 회원 가입 시 입력한 정보가 학교 쪽에 등록된 정보와 일치하는지 검사하는 메서드
	public String CheckUnivMemberInfo(UnivMemberVO umvo);

	// 회원 가입 매서드
	public void Register(UserVO user);
	
	// 아이디로 EasyResearch 회원정보 조회 메서드
	public UserVO GetERUserInfoById(String userId);
	
	// 인증 메일을 보내는 메서드
	public String AuthenticationMailSend(String userId);
	
	// 인증 메일 클릭해서 넘어온 해시값을 비교하여 인증을 완료하는 메서드
	public String Authentication(String code, String userId);
	
	// 로그인 체크 메서드
	public String Login(UserVO user);
	
	// 회원 정보 수정 기능
	public void UpdateUserInfo(UserVO user);
	
	// 회원 탈퇴 기능
	public String DeleteUser(UserVO user);
	
	// 이메일 체크 기능
	public String EmailCheck(String email);
	
	// 비밀번호 변경 요청 시 현재 비밀번호 비교, 맞으면 바꿔주는 기능
	public String UpdatePassword(UserVO user);
}
