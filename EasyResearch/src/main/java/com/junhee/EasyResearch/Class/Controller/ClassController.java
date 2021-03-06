package com.junhee.EasyResearch.Class.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junhee.EasyResearch.Class.Service.ClassService;
import com.junhee.EasyResearch.Model.ClassVO;

@Controller
@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassService service;
	
	@GetMapping("/registerClassForResearch")
	private void RegisterClassForResearchPage() {
		System.out.println("클래스 연구참여과목 등록 페이지로 이동");
	}
	
	@GetMapping("/showMyClasses")
	private void ShowMyClassesPage(String instructorId, Model model) {
		System.out.println(instructorId + "의 연구참여 수업으로 등록한 수업들 목록보기 페이지");
		model.addAttribute("classList", service.GetClassesList(instructorId));
	}
	
	@GetMapping("/addTakingClasses")
	private void AddTakingClasses(String studentId) {
		System.out.println("수강 중인 강의 보기 페이지로 이동");
		
	}
	
	@PostMapping("/registerClassForResearch")
	private String RegisterClassForResearch(ClassVO cvo, RedirectAttributes ra) {
		
		System.out.println("해당 클래스를 연구참여과목으로 등록 요청: " + cvo.getClassName());
		ra.addFlashAttribute("msg", service.RegisterClassForResearch(cvo));
		return "redirect:/user/mypage";
	}
	
	@PostMapping("/deleteClass")
	private String DeleteClass(ClassVO cvo, RedirectAttributes ra) {
		System.out.println(cvo.getClassId() + "번 수업 삭제 요청");
		ra.addFlashAttribute("msg", service.DeleteClass(cvo.getClassId()));
		return "redirect:/class/showMyClasses?instructorId=" + cvo.getInstructorId();
	}
	
}
