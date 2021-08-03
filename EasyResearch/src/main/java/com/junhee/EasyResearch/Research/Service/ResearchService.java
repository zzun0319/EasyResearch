package com.junhee.EasyResearch.Research.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Research.Repository.IResearchMapper;
import com.junhee.EasyResearch.util.FileProcessor;

@Service
public class ResearchService implements IResearchService {

	@Autowired
	private IResearchMapper mapper;
	
	@Autowired
	private FileProcessor fileProcessor;
	
	@Override
	public String RegisterResearch(ResearchVO rvo, MultipartFile file) throws IllegalStateException, IOException {
		
		if(rvo.getRewardType().equals("학점")) {
			if(rvo.getDuration() <= 30) {
				rvo.setRewardValue(1);
			} else if(rvo.getDuration() > 30 && rvo.getDuration() <= 60) {
				rvo.setRewardValue(2);
			} else if(rvo.getDuration() > 60 && rvo.getDuration() <= 90) {
				rvo.setRewardValue(3);
			} else {
				rvo.setRewardValue(4);
			}
		}
		
		String originalFileName = null;
		String savedFileName = null;
		
		if(!file.isEmpty()) {
			originalFileName = file.getOriginalFilename();
			savedFileName = fileProcessor.GetSavedFileName(originalFileName);
			rvo.setUploadFileName(originalFileName);
			rvo.setSavedFileName(savedFileName);
		}

		String result = fileProcessor.StoreFile(file, savedFileName);
		if(result.equals("파일 저장 성공")) {
			result = "연구 개설이 완료되었습니다. 연구 승인 후 타임슬롯을 열 수 있습니다. (file O)";
		}
		else {
			result = "연구 개설이 완료되었습니다. 연구 승인 후 타임슬롯을 열 수 있습니다. (file X)";
		}
		mapper.RegisterResearch(rvo);
		return result;
	}

	@Override
	public List<ResearchVO> GetMyResearch(String userId) {
		return mapper.GetMyResearch(userId);
	}

	@Override
	public ResearchVO GetResearchInfo(int researchId) {
		return mapper.GetResearchInfo(researchId);
	}

	@Override
	public String GetFullPath(String fileName) {
		return fileProcessor.GetFullPath(fileName);
	}

}
