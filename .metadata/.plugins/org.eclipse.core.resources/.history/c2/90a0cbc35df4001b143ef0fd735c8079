package com.junhee.EasyResearch.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileProcessor {
	
	@Autowired
	@Qualifier("uploadPath")
	private String uploadPath;

	// full 경로를 반환하는 메서드
	public String GetFullPath(String fileName) {
		return uploadPath + fileName;
	}
	
	// 확장자를 추출 및 반환해주는 메서드
	public String ExtractExtension(String originalFileName) {
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}
	
	// uuid로 만들어진 savedFileName을 반환하는 메서드
	public String GetSavedFileName(String originalFileName) {
		
		String extension = ExtractExtension(originalFileName);
		String uuid = UUID.randomUUID().toString();
		
		return uuid + extension;
	}
	
	// 파일을 실제 파일저장소에 저장하는 메서드
	public String StoreFile(MultipartFile file) throws IllegalStateException, IOException {
		if(file.isEmpty()) {
			return "파일이 비어있습니다.";
		}
		else {
			String originalFileName = file.getOriginalFilename();
			String savedFileName = GetSavedFileName(originalFileName);
			file.transferTo(new File(GetFullPath(savedFileName)));
			return "파일 저장 성공";
		}
	}
	
}
