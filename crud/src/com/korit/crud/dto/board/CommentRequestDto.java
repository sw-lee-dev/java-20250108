package com.korit.crud.dto.board;

import java.util.Scanner;

public class CommentRequestDto {
	
	private String contents;
	private Integer boardNumber;
	
	public CommentRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("게시물 번호 : ");
		this.boardNumber = scanner.nextInt();
		System.out.print("내용 : ");
		this.contents = scanner.nextLine();
	}

	public String getContents() {
		return contents;
	}
	
	public Integer getBoardNumber() {
		return boardNumber;
	}
	
	public boolean validate() {
		if (!isNotNull() || !contentsCheck()) {
			System.out.println("모두 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return contents != null;
	}
	
	private boolean contentsCheck() {
		return !contents.isBlank();
	}
}
