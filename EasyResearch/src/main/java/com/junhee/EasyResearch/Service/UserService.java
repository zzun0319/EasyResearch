package com.junhee.EasyResearch.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Model.UserVO;
import com.junhee.EasyResearch.Repository.IUserMapper;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserMapper mapper;

	@Override
	public UnivMemberVO checkUnivMember(UnivMemberVO univInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void Register(UserVO user) {
		// TODO Auto-generated method stub

	}


}
