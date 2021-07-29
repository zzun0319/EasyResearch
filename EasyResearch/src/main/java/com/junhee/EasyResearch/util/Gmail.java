package com.junhee.EasyResearch.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// 보내는 사람(admin)의 Gmail아이디와 비밀번호, 해당 계정은 보안 수준이 낮은 앱이 접근 가능하도록 보안 옵션을 바꿔야함.
		return new PasswordAuthentication("aer38783@gmail.com", "choiparkkim123!");
	}

}
