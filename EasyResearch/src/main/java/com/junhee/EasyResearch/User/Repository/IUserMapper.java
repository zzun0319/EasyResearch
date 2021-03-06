package com.junhee.EasyResearch.User.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Model.UserVO;

public interface IUserMapper {
	
	// 학번/교번으로 학교쪽 등록 데이터 조회
	public UnivMemberVO GetUnivMemberInfoByIdNum(String idNumber);

	// 학교쪽 정보 가입 상태 바꾸기 (회원가입: false -> true, 회원탈퇴: true -> false)
	public void UpdateRegiState(@Param("idNumber") String idNumber, @Param("isUsing") boolean isUsing);
	
	// 회원 가입 기능
	public void Register(UserVO user);
	
	// 아이디로 EasyResearch 회원정보 조회
	public UserVO GetERUserInfoById(String userId);
	
	// 이메일 인증 true로 바꾸기
	public void SetEmailChecked(String userId);
		
	// 회원 정보 수정 기능
	public void UpdateUserInfo(UserVO user);
	
	// 회원 탈퇴 기능
	public void DeleteUser(String userId);
	
	// 이메일 중복 체크
	public UserVO CheckEmail(String email);
	
	// 비밀 번호 수정 기능 
	void UpdatePassword(UserVO user);
	
	/*	
	// 전공 리스트로 얻어오기 기능
	List<UserVO> GetMajors();
		
	// 학번 중복 확인 기능
	UserVO CheckIdNum(String identifiedNum);
		
	// 지도교수 - 전공 같은 대학원생 가입신청 승인위해 학생정보 가져오기
	List<UserVO> GetGStudentsInfo(String major);
	*/
}
