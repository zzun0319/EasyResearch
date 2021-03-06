package com.junhee.EasyResearch.User.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Model.UserVO;
import com.junhee.EasyResearch.User.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/register_checkUnivMember")
	public void RegisterPage() {
		System.out.println("회원가입(학번 및 회원분류 확인) 페이지로 이동");
	}
	
	@GetMapping("/register_otherInfo")
	public void RegisterOtherInfoPage() {
		System.out.println("회원가입(나머지 정보 입력) 페이지로 이동");
	}
	
	@GetMapping("/login")
	public void LoginPage() {
		System.out.println("로그인 페이지로 이동");
	}
	
	@GetMapping("/mypage")
	public void MyPage() {
		System.out.println("마이 페이지로 이동");
	}
	
	@GetMapping("/updateUserInfo")
	public void UpdateUserInfoPage() {
		System.out.println("회원 정보 변경 페이지로 이동");
	}
	
	@GetMapping("/deleteUser")
	public void DeleteUserPage() {
		System.out.println("회원 탈퇴 페이지로 이동");
	}
	
	@GetMapping("/updatePw_current")
	public void UpdatePw_CurrentPage() {
		System.out.println("비밀번호 변경 페이지 / 현재 비밀번호 확인 페이지로 이동");
	}
	
	@GetMapping("/updatePw_new")
	public void UpdatePw_NewPage() {
		System.out.println("비밀번호 변경 페이지로 이동");
	}
	
	@GetMapping("/logout")
	public String Logout(HttpSession session, RedirectAttributes ra) {
		session.invalidate();
		ra.addFlashAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:/";
	}
	
	@GetMapping("/sendAuthenticationMail")
	public String SendAuthenticationMail(String userId, RedirectAttributes ra) {
		
		System.out.println("인증 메일 발송 요청");
		
		String msg = service.AuthenticationMailSend(userId);
		ra.addFlashAttribute("msg", msg);
		if(msg.equals("인증 메일 전송 성공")) {
			return "user/afterSendAuthMail";
		}
		else {
			return "redirect:/user/mypage";
		}
		
	}
	
	@GetMapping("/emailAuthentication")
	public String EmailAuthentication(String code, String userId, HttpSession session, RedirectAttributes ra) {
		
		System.out.println("이메일 인증 요청");
		String msg = service.Authentication(code, userId);
		ra.addFlashAttribute("msg", msg);
		
		UserVO user = (UserVO) session.getAttribute("user");
		if(user == null) { // 다른 브라우저에서 인증 메일을 클릭하면 세션이 없으니까
			return "redirect:/user/login";
		}
		else {
			session.setAttribute("user", service.GetERUserInfoById(user.getUserId()));
			return "redirect:/user/mypage";
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/register_checkUnivMember")
	public String RegisterCheckUnivInfo(UnivMemberVO umvo, Model model, RedirectAttributes ra) {
		
		System.out.println("학교 멤버 테이블에 담긴 정보와 일치하는지 검사 요청" + umvo.getIdNumber());
		
		String result = service.CheckUnivMemberInfo(umvo);
		ra.addFlashAttribute("msg", result);
		
		if(result.equals("모든 정보가 일치합니다.")) {
			model.addAttribute("umvo", service.GetUnivMemberInfoByIdNum(umvo.getIdNumber()));
			return "/user/register_otherInfo";
		}
		else {
			return "redirect:/user/register_checkUnivMember";
		}
		
	}
	
	@PostMapping("/register_otherInfo")
	public String Register(UserVO user, RedirectAttributes ra) {
		
		System.out.println("회원가입 요청");
		
		service.Register(user);
		ra.addFlashAttribute("msg", "가입이 완료되었습니다.");
		return "redirect:/user/login";
	}
	
	@PostMapping("/login")
	public String Login(UserVO user, HttpSession session, RedirectAttributes ra) {
		
		System.out.println("로그인 요청" + user.getUserId());
		
		String msg = service.Login(user);
		ra.addFlashAttribute("msg", msg);
		if(msg.equals("로그인 성공")) {
			session.setAttribute("user", service.GetERUserInfoById(user.getUserId()));
			return "redirect:/user/mypage";
		}
		else {
			return "redirect:/user/login";
		}
	}
	
	@PostMapping("/updateUserInfo")
	public String UpdateUserInfo(UserVO user, RedirectAttributes ra, HttpSession session) {
		
		System.out.println("회원정보 변경 요청" + user.getUserId());
		service.UpdateUserInfo(user);
		session.setAttribute("user", service.GetERUserInfoById(user.getUserId()));
		ra.addFlashAttribute("msg", "정상적으로 변경되었습니다.");
		return "redirect:/user/mypage";
	}
	
	@PostMapping("/deleteUser")
	public String DeleteUser(UserVO user, HttpSession session, RedirectAttributes ra) {
		System.out.println("회원 탈퇴 요청" + user.getUserId());
		
		String result = service.DeleteUser(user);
		ra.addFlashAttribute("msg", result);
		if(result.equals("회원 탈퇴 완료")) {
			session.invalidate();
			return "redirect:/";
		}
		else {
			return "redirect:/user/mypage";
		}
	}
	
	@PostMapping("/updatePw_current")
	public String updatePwCurrentCheck(UserVO user, RedirectAttributes ra) {
		
		System.out.println("비밀번호 변경 요청, 현재비밀번호 확인" + user.getUserId());
		
		String msg = service.Login(user);;
		if(msg.equals("로그인 성공")) {
			ra.addFlashAttribute("confirm", "OK");
			return "redirect:/user/updatePw_new";
		}
		else {
			ra.addFlashAttribute("msg", "현재 비밀번호가 일치하지 않습니다.");
			return "redirect:/user/updatePw_current";
		}
	}
	
	@PostMapping("/updatePw_new")
	public String updatePwNew(UserVO user, RedirectAttributes ra) {
		String result = service.UpdatePassword(user);
		if(result == null) {
			ra.addFlashAttribute("msg", "변경 실패");
		}
		if(result.equals("변경 성공")) {
			ra.addFlashAttribute("msg", result);
		}
		return "redirect:/user/mypage";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@ResponseBody
	@PostMapping("/checkId")
	public String CheckId(@RequestParam("id") String id) {
		
		System.out.println("아이디 중복 체크: " + id);
		
		if(service.GetERUserInfoById(id) != null) {
			return "NO";
		}
		else {
			return "OK";
		}
	}
	
	@ResponseBody
	@PostMapping("/checkEmail")
	public String CheckEmail(@RequestParam("emailModified") String emailModified) {
		
		System.out.println("이메일 중복 체크: " + emailModified);
		return service.EmailCheck(emailModified);
	}
	
}
