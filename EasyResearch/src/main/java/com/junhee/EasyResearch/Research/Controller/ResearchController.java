package com.junhee.EasyResearch.Research.Controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;

import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Research.Service.ResearchService;

@Controller
@RequestMapping("/research")
public class ResearchController {

	@Autowired
	private ResearchService service;
	
	@GetMapping("/openResearch")
	private void OpenResearchPage() {
		System.out.println("연구 개설 페이지로 이동");
	}
	
	@GetMapping("/showMyResearch")
	private void ShowMyReseachPage(String userId, Model model) {
		System.out.println("내 연구 보기 페이지로 이동");
		model.addAttribute("myResearchList", service.GetMyResearch(userId));
	}
	
	@GetMapping("/showOneResearch")
	private void ShowOneResearchPage(int researchId, Model model) {
		System.out.println(researchId + "번 연구 상세 보기 페이지로 이동");
		System.out.println(service.GetResearchInfo(researchId));
		model.addAttribute("selectedResearch", service.GetResearchInfo(researchId));
	}
	
	@GetMapping("/acceptResearch/{major}")
	private void AccecptResearchPage(@PathVariable String major, Model model) {
		model.addAttribute("registedResearchList", service.GetSameMajorResearch(major));
	}
	
	// 이 방법도 되고 
	@GetMapping("/download/{researchId}") // 파일 다운로드 메서드
	private ResponseEntity<Resource> DownloadAttachedFile(@PathVariable int researchId) throws MalformedURLException{
		
		ResearchVO rvo = service.GetResearchInfo(researchId);
		String savedFileName = rvo.getSavedFileName();
		String uploadFileName = rvo.getUploadFileName();
		
		UrlResource resource = new UrlResource("file:" + service.GetFullPath(savedFileName));
		
		
		String encodedUploadFileName = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
		String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
		
	}
	
	/* 이 방법도 된다.
	@ResponseBody
	@PostMapping("/download")
	private byte[] DownloadAttachedFile(HttpServletResponse response, int researchId) throws IOException {
		
		ResearchVO rvo = service.GetResearchInfo(researchId);
		String savedFileName = rvo.getSavedFileName();
		String uploadFileName = rvo.getUploadFileName();
		
		File file = new File(service.GetFullPath(savedFileName));		
		
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		
		String fn = new String(rvo.getUploadFileName().getBytes(), "utf-8");
		System.out.println(fn);
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		response.setContentLength(bytes.length);
		return bytes;
	}
	*/
	
	//////////////////////////////////////////////////////////////
	
	@PostMapping("/openResearch")
	private String OpenResearchDetailPage(@ModelAttribute("rewardType") String rewardType, @ModelAttribute("researchType") String researchType) {
		System.out.println("연구 상세 기술 페이지로 이동! 연구 유형: " + researchType + "보상 유형: " + rewardType);
		return "/research/openResearch_detail";
	}
	
	@PostMapping("/openResearch_detail")
	private String RegisterResearch(ResearchVO research, MultipartFile file, RedirectAttributes ra) throws IllegalStateException, IOException {
		System.out.println("연구 개설 요청");
		String result = service.RegisterResearch(research, file);
		ra.addFlashAttribute("msg", result);
		return "redirect:/user/mypage";
	}
}
