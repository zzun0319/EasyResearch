package com.junhee.EasyResearch.User.Service;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Model.UserVO;
import com.junhee.EasyResearch.User.Repository.IUserMapper;
import com.junhee.EasyResearch.util.Gmail;
import com.junhee.EasyResearch.util.SHA256;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserMapper mapper;
	
	@Override
	public UnivMemberVO GetUnivMemberInfoByIdNum(String idNumber) {
		return mapper.GetUnivMemberInfoByIdNum(idNumber);
	}

	@Override
	public String CheckUnivMemberInfo(UnivMemberVO umvo) {
		
		String result = null;
		
		UnivMemberVO newUmvo = mapper.GetUnivMemberInfoByIdNum(umvo.getIdNumber());
		
		if(newUmvo == null) {
			result = "해당 학번/교번과 일치하는 정보가 학교 데이터베이스에 없습니다.";
		}
		else {
			if(!newUmvo.getRegisteredName().equals(umvo.getRegisteredName())) {
				result = "입력하신 이름이 학교 데이터베이스에 등록된 이름과 일치하지 않습니다."; 
			}
			else if(!newUmvo.getSort().equals(umvo.getSort())) {
				result = "선택하신 회원분류가 학교 데이터베이스에 등록된 회원분류와 일치하지 않습니다.";
			}
			else if(!newUmvo.getUnivEmail().equals(umvo.getUnivEmail())) {
				result = "입력하신 이메일이 학교계정 이메일과 일치하지 않습니다.";
			}
			else if(newUmvo.isUsing()) {
				result = "이미 가입되어 있습니다.";
			}
			else {
				result = "모든 정보가 일치합니다.";
			}
		}
		return result;
	}

	@Override
	public void Register(UserVO user) {
		
		if(user.getUserType().equals("박사과정대학원생") || user.getUserType().equals("석사과정대학원생") || user.getUserType().equals("학부생")) {
			user.setParticipationRight(true);
		}
		if(user.getUserType().equals("지도교수") || user.getUserType().equals("교수") || user.getUserType().equals("박사과정대학원생") || user.getUserType().equals("석사과정대학원생")) {
			user.setSetupRight(true);
		}
		if(user.getUserType().equals("지도교수") || user.getUserType().equals("교수") || user.getUserType().equals("박사과정대학원생") || user.getUserType().equals("강사")) {
			user.setClassRegiRight(true);
		}
		if(user.getUserType().equals("지도교수")) {
			user.setPermissionRight(true);
		}
		
		// 해시값 추가
		user.setEmailHash(SHA256.getSHA256(user.getEmail()));
		
		// univ_members에도 사용중으로 바꾸기
		mapper.UpdateRegiState(user.getUnivIdNum(), true);
		
		// 등록
		mapper.Register(user);
	}

	@Override
	public UserVO GetERUserInfoById(String userId) {
		return mapper.GetERUserInfoById(userId);
	}
	
	@Override
	public String AuthenticationMailSend(String userId) {

		UserVO user = mapper.GetERUserInfoById(userId);
		
		String host = "http://localhost:8282/";
		String from = "aer38783@gmail.com"; /* 관리자의 이메일 계정 */
		String to = user.getEmail(); // 사용자의 이메일 계정
		String subject = "회원가입 인증 이메일입니다.";
		String content = "다음 링크에 접속하여 이메일 인증을 진행하세요." +
			"<a href='" + host + "user/emailAuthentication?userId=" + userId + "&code=" + new SHA256().getSHA256(to) + "'> 이메일 인증하기 </a>";
	
		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.googlemail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		try{
			
			Authenticator auth = new Gmail();
			Session ses = Session.getInstance(p, auth);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address formAddr = new InternetAddress(from);
			msg.setFrom(formAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html;charset=UTF8");
			Transport.send(msg); // 실제 전송하는 부분
			
		} catch (Exception e){
			e.printStackTrace();
			return "인증 메일 전송 실패";
		}
		
		return "인증 메일 전송 성공";
	}

	@Override
	public String Authentication(String code, String userId) {

		UserVO user = mapper.GetERUserInfoById(userId);
		
		if(code.equals(user.getEmailHash())) {
			mapper.SetEmailChecked(user.getUserId());
			return "이메일 인증에 성공했습니다.";
		}
		return "이메일 인증에 실패했습니다.";
	}

	@Override
	public String Login(UserVO user) {
		
		UserVO compareVO = mapper.GetERUserInfoById(user.getUserId());
		
		String result = null;
		
		if(compareVO == null) {
			result = "일치하는 아이디가 없습니다.";
		}
		else {
			if(!compareVO.getUserPw().equals(user.getUserPw())) {
				result = "비밀번호가 일치하지 않습니다.";
			}
			else {
				result = "로그인 성공";
			}
		}
		return result;
	}

	@Override
	public void UpdateUserInfo(UserVO user) {
		mapper.UpdateUserInfo(user);
	}
	

	@Override
	public String DeleteUser(UserVO user) {
		UserVO compareVO = mapper.GetERUserInfoById(user.getUserId());
		if(compareVO.getUserPw().equals(user.getUserPw())) {
			mapper.DeleteUser(user.getUserId());
			return "회원 탈퇴 완료";
		}
		else {
			return "비밀번호가 일치하지 않습니다. 회원 탈퇴에 실패했습니다.";
		}
	}

	@Override
	public String EmailCheck(String email) {
		UserVO user = mapper.CheckEmail(email);
		if(user == null) {
			return "OK";
		}
		else {
			return "NO";
		}
	}

	@Override
	public String UpdatePassword(UserVO user) {
		mapper.UpdatePassword(user);
		return "변경 성공";
	}
	
	

}
