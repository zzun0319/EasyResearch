package com.junhee.EasyResearch.commons;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageCreator {

	protected PageVO pageInfo; // 몇 페이지인지, 페이지 당 보여줄 연구 or 타임슬롯의 개수
	protected int totalCnt; // 뷰에 보여줄 연구 or 타임슬롯의 전체 개수
	protected int endPageNum; // 뷰에 보여질 페이지 숫자들 중 마지막 숫자
	protected int startPageNum; // 뷰에 보여질 페이지 숫자들 중 첫번째 숫자
	protected boolean prev; // '이전' 버튼 활성화 여부
	protected boolean next; // '다음' 버튼 활성화 여부
	
	protected final int displayPageNumCnt = 10; // 뷰에 보여지는 페이지 숫자들의 개수 (10개로 고정)

	public void SetAllData() {
		
		// 펼쳐진 페이지 중 마지막 숫자 계산
		endPageNum = ((int)Math.ceil(pageInfo.getPageNum() / (double)displayPageNumCnt)) * displayPageNumCnt;
		
		// 펼쳐진 페이지 중 첫번째 숫자 계산
		startPageNum = endPageNum - displayPageNumCnt + 1;
		
		// 이전 버튼 활성화 여부 체크
		prev = (startPageNum == 1) ? false : true;
		
		// 다음 버튼 활성화 여부 체크
		next = (totalCnt > endPageNum * pageInfo.getCntPerPage()) ? true : false;
		
		// 마지막 페이지 번호 보정
		if(!next) {
			endPageNum = (int)Math.ceil(totalCnt / (double)pageInfo.getCntPerPage());
		}
	}

	public String MakeURI(int pageNum) {
		UriComponents uc = UriComponentsBuilder.newInstance().queryParam("pageNum", pageNum).
				queryParam("cntPerPage", pageInfo.getCntPerPage()).
				queryParam("keyword", ((SearchVO)pageInfo).getKeyword()).
				queryParam("condition", ((SearchVO)pageInfo).getCondition()).
				build();
		return uc.toUriString();
	}
	
	public PageVO getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageVO pageInfo) {
		this.pageInfo = pageInfo;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		SetAllData();
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
}
