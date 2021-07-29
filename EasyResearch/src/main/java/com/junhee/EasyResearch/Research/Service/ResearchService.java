package com.junhee.EasyResearch.Research.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.junhee.EasyResearch.Model.ResearchVO;
import com.junhee.EasyResearch.Research.Repository.IResearchMapper;

@Service
public class ResearchService implements IResearchService {

	@Autowired
	private IResearchMapper mapper;
	
	@Override
	public void RegisterResearch(ResearchVO rvo) {
		// TODO Auto-generated method stub

	}

}