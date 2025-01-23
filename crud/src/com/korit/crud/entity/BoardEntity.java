package com.korit.crud.entity;

import com.korit.crud.dto.board.WriteBoardRequestDto;

public class BoardEntity  {
	private Integer boardNumber;
	private String writerId;
	private String title;
	private String contents;
	private String writeDate;
	
	public BoardEntity(Integer boardNumber, String writerId, String title, String contents, String writeDate) {
		this.boardNumber = boardNumber;
		this.writerId = writerId;
		this.title = title;
		this.contents = contents;
		this.writeDate = writeDate;
	}
	
	// 실제 사용되는건 title 과 contents 뿐이고, user 테이블의 id 값을 외래키로 받아와서 nickname 을 받는 방식으로 작성
	public BoardEntity(WriteBoardRequestDto requestDto, String writerId) {
		this.title = requestDto.getTitle();
		this.contents = requestDto.getContents();
		this.writerId = writerId;
	}
	
	public Integer getBoardNumber() {
		return boardNumber;
	}
	public String getWriterId() {
		return writerId;
	}
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public String getWriteDate() {
		return writeDate;
	}
	
}
