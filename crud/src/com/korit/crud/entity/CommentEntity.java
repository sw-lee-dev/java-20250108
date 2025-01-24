package com.korit.crud.entity;

import com.korit.crud.dto.board.CommentRequestDto;

public class CommentEntity {

	private Integer commentNumber;
	private Integer boardNumber;
	private String writerId;
	private String contets;
	private String writeDatetime;
	private boolean status;
	private Integer parentComment;
	
	public CommentEntity(Integer commentNumber, Integer boardNumber, String writerId, String contets,
			String writeDatetime, boolean status, Integer parentComment) {
		this.commentNumber = commentNumber;
		this.boardNumber = boardNumber;
		this.writerId = writerId;
		this.contets = contets;
		this.writeDatetime = writeDatetime;
		this.status = status;
		this.parentComment = parentComment;
	}
	
	public CommentEntity(CommentRequestDto requestDto, String writerId) {
		this.contets = requestDto.getContents();
		this.writerId = writerId;
	}

	public Integer getCommentNumber() {
		return commentNumber;
	}
	public Integer getBoardNumber() {
		return boardNumber;
	}
	public String getWriterId() {
		return writerId;
	}
	public String getContets() {
		return contets;
	}
	public String getWriteDatetime() {
		return writeDatetime;
	}
	public boolean isStatus() {
		return status;
	}
	public Integer getParentComment() {
		return parentComment;
	}
	
	
}
