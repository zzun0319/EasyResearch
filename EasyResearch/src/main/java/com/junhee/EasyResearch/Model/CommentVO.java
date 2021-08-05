package com.junhee.EasyResearch.Model;

import java.sql.Timestamp;

public class CommentVO {
	
	private long commentId;
	private UserVO writer; // 글쓴이 정보, 아이디 + 이름까지 필요해서 UserVO로 선언
	private int researchId; // 연구 번호
	private String content; // 피드백 내용
	private Timestamp writeDate;
	
	public CommentVO() {}

	public CommentVO(long commentId, UserVO writer, int researchId, String content, Timestamp writeDate) {
		this.commentId = commentId;
		this.writer = writer;
		this.researchId = researchId;
		this.content = content;
		this.writeDate = writeDate;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public UserVO getWriter() {
		return writer;
	}

	public void setWriter(UserVO writer) {
		this.writer = writer;
	}

	public int getResearchId() {
		return researchId;
	}

	public void setResearchId(int researchId) {
		this.researchId = researchId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "CommentVO [commentId=" + commentId + ", writer=" + writer + ", researchId=" + researchId + ", content="
				+ content + ", writeDate=" + writeDate + "]";
	}
	
}
