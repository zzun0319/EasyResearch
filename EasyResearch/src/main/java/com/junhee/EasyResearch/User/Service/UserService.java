package com.junhee.EasyResearch.User.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Model.UserVO;
import com.junhee.EasyResearch.User.Repository.IUserMapper;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserMapper mapper;

	@Override
	public UnivMemberVO CheckUnivMember(UnivMemberVO univInfo) {
		return mapper.CheckUnivMember(univInfo);
	}
	
	@Override
	public void Register(UserVO user) {
		// TODO Auto-generated method stub

	}


}
