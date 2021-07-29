package com.junhee.EasyResearch.User.Controller;

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

	@GetMapping("/register_checkUnivMember")
	public void GoToRegisterPage1() {
		System.out.println("회원가입(학번 및 회원분류 확인) 페이지로 이동");
	}
	
	@PostMapping("/register_checkUnivMember")
	public String RegisterCheckIdNumPage(UnivMemberVO umvo, Model model, RedirectAttributes ra) {
		
		String result = service.CheckUnivMemberInfo(umvo); // 서비스 객체는 모든 정보와 일치하는 튜플이 있다면 모든 정보를 채워 반환하고, 일치하는 정보 없으면 null 반환 
		ra.addFlashAttribute("msg", result);
		
		if(result.equals("모든 정보가 일치합니다.")) {
			model.addAttribute("umvo", service.GetUnivMemberInfoByIdNum(umvo.getIdNumber()));
			return "/user/register_otherInfo";
		}
		else {
			return "redirect:/user/register_checkUnivMember";
		}
		
	}
	
	@GetMapping("/register_otherInfo")
	public void RegisterOtherInfoPage() {
		System.out.println("회원가입(나머지 정보 입력) 페이지로 이동");
	}
	
	@ResponseBody
	@PostMapping("/checkId")
	public String checkId(@RequestParam("id") String id) {
		
		System.out.println("아이디 중복 체크: " + id);
		
		if(service.GetERUserInfoById(id) != null) {
			return "NO";
		}
		else {
			return "OK";
		}
	}
	
	@PostMapping("/register_otherInfo")
	public String Register(UserVO user, RedirectAttributes ra) {
		
		service.Register(user);
		ra.addFlashAttribute("msg", "가입이 완료되었습니다.");
		return "redirect:/user/login";
	}
	
	
	
}
