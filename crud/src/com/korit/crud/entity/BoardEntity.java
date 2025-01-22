package com.korit.crud.entity;

public class BoardEntity  {
	private int boardNumber;
	private String id;
	private String title;
	private String writeDate;
	private String contents;
	
	public BoardEntity(int boardNumber, String id, String title, String writeDate, String contents) {
		this.boardNumber = boardNumber;
		this.id = id;
		this.title = title;
		this.writeDate = writeDate;
		this.contents = contents;
	}
	
	public int getBoardNumber() {
		return boardNumber;
	}
	public String getId() {
		return id;
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
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
