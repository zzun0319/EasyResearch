package com.junhee.EasyResearch.Research.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.junhee.EasyResearch.Model.CommentVO;
import com.junhee.EasyResearch.Model.PlaceVO;
import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Model.TimeslotVO;
import com.junhee.EasyResearch.Model.TmpDateTimeDTO;
import com.junhee.EasyResearch.Research.Repository.IResearchMapper;
import com.junhee.EasyResearch.commons.MajorSearchVO;
import com.junhee.EasyResearch.commons.TimeslotSearchVO;
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

	@Override
	public List<ResearchVO> GetSameMajorResearch(MajorSearchVO msvo) {
		return mapper.GetSameMajorResearch(msvo);
	}
	
	@Override
	public int GetTotalSameMajorResearchCnt(MajorSearchVO msvo) {
		return mapper.GetTotalSameMajorResearchCnt(msvo);
	}

	@Override
	public String PermitResearch(ResearchVO rvo) {
		mapper.PermitResearch(rvo);
		return "연구 승인 정보가 변경되었습니다.";
	}

	@Override
	public int RegisterComment(CommentVO cvo) {
		
		int resultNum = 0;
		if(cvo != null) {
			mapper.RegisterComment(cvo);
			resultNum = 1;
		}
		
		return resultNum;
	}

	@Override
	public List<CommentVO> GetResearchComments(int researchId) {
		return mapper.GetResearchComments(researchId);
	}

	@Override
	public List<PlaceVO> GetAllLocationInfo() {
		return mapper.GetAllLocationInfo();
	}

	@Override
	public List<TimeslotVO> GetTimeslotsByResearchId(int researchId) {
		return mapper.GetTimeslotsByResearchId(researchId);
	}

	@Override
	public String RegisterTimeslot(TimeslotVO tsvo, TmpDateTimeDTO tdt) {
		
		if(tsvo.getStartTime().before(tdt.getTomorrow())) {
			return "연구 시작 시간은 현재 시간으로부터 24시간 이후부터 설정가능합니다.";
		}
		
		if(tsvo.getMaxCnt() > mapper.GetMaxPeople(tdt.getResearchPlace())) { // 최대수용가능인원 넘으면 타임슬롯 생성안되도록
			return "해당 장소의 수용 가능 인원보다 더 많은 인원을 입력하셨습니다.";
		}
		
		if(mapper.TimeslotsAfterTomorrowCnt(tdt) != mapper.NotOvelapCnt(tdt)) { // 장소와 시간이 중복되는 타임슬롯이 있으면 
			return "이미 존재하는 타임슬롯과 연구 기한 또는 장소가 겹칩니다. 타임슬롯을 만들 수 없습니다.";
		}
		else {
			mapper.RegisterTimeslot(tsvo);
			return "타임슬롯이 생성되었습니다.";
		}
		
	}

	@Override
	public int GetTotalTimeslotsCnt(TimeslotSearchVO tss) {
		System.out.println("서비스 타임슬롯개수:" + mapper.GetTotalTimeslotsCnt(tss));
		 System.out.println(tss);
		return mapper.GetTotalTimeslotsCnt(tss);
	}

	@Override
	public List<TimeslotVO> GetTimeslots(TimeslotSearchVO tss) {
		System.out.println("서비스 타임슬롯 사이즈:" + mapper.GetTimeslots(tss).size());
		System.out.println(tss);
		return mapper.GetTimeslots(tss);
	}
	

}
