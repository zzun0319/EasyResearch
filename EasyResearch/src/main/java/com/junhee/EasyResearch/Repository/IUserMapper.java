package com.junhee.EasyResearch.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.junhee.EasyResearch.Model.UserVO;

public interface IUserMapper {

	// ȸ�� ���� ���
	void Register(UserVO user);
		
	// �α��� üũ ��� (���� ���� ���ε� üũ�ؾ���)
	//UserVO getOneUserInfo(String userId);
		
	// ȸ�� ���� ���� ���
	//void UpdateUserInfo(UserVO user);
		
	// ��� ��ȣ ���� ���
	//void UpdatePassword(@Param("userId") String userId, @Param("userPw") String userPw);
	// MyBatis�� �Ķ���͸� 2�� �̻� ���� �� ����. @Param ���ų� Map<String,String> �� �̿��ؼ� �ްų�, �׳� ��ü�� ��°�� �޾ƾ���.
		
	// ȸ�� Ż�� ���
	//void DeleteUser(String userId);
		
	// ���� ����Ʈ�� ������ ���
	//List<UserVO> getMajors();
	
	// �й� �ߺ� Ȯ�� ���
	//UserVO checkIdNum(String identifiedNum);
	
	// �������� - ���� ���� ���п��� ���Խ�û �������� �л����� ��������
	//List<UserVO> getGStudentsInfo(String major);
		
	//void ChangePermit(UserVO user);
	
}