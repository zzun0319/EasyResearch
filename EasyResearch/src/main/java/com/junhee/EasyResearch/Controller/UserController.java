package com.junhee.EasyResearch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junhee.EasyResearch.Model.UnivMemberVO;
import com.junhee.EasyResearch.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/register_chooseType")
	public void GoToRegisterPage1() {
		System.out.println("회원가입(학번 및 회원분류 확인) 페이지로 이동");
	}
	
	@PostMapping("/register_chooseType")
	public String RegisterCheckIdNumPage(String userType, String univIdNum, Model model, RedirectAttributes ra) {
		
		UnivMemberVO umvo = new UnivMemberVO(); // 회원 가입하는 클라이언트가 넘긴 두 정보를 채운 UnivMemberVO형 객체를 service객체에 넘긴다.
		umvo.setIdNumber(univIdNum);
		umvo.setSort(userType);
		
		UnivMemberVO returnUmvo = service.CheckUnivMember(umvo); // 서비스 객체는 두 정보와 일치하는 튜플이 있다면 모든 정보를 채워 반환하고, 일치하는 정보 없으면 null 반환 
		
		if(returnUmvo == null) {
			ra.addFlashAttribute("msg", "학교 데이터베이스에 해당 분류 및 학번/교번과 일치하는 정보가 없습니다.");
			return "redirect:/user/register_chooseType";
		}
		else {
			model.addAttribute("umvo", returnUmvo);
			return "/user/register_emailConfirm";
		}
		
	}
	
	@GetMapping("/register_emailConfirm")
	public void RegisterEmailConfirmPage() {
		System.out.println("회원가입(이메일 인증) 페이지로 이동");
	}
	
}