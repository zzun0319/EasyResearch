package com.junhee.EasyResearch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junhee.EasyResearch.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/register_chooseType")
	public void GoToRegisterPage1() {
		System.out.println("회원가입 페이지로 이동");
	}
	
	@PostMapping("/register_chooseType")
	public String CheckIdNumAndGoToNextPage(@ModelAttribute("userType") String userType, @ModelAttribute("univIdNum") String univIdNum) {
	
		return null;
	}
	
}
