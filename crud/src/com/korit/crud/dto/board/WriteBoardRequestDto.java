package com.korit.crud.dto.board;

import java.util.Scanner;

public class WriteBoardRequestDto {
	private String title;
	private String contents;
	
	public WriteBoardRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("제목 : ");
		this.title = scanner.nextLine();
		System.out.println("내용 : ");
		this.contents = scanner.nextLine();
	}

	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	
	public boolean validate() {
		if (!isNotNull()) {
			System.out.println("모두 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return title != null && contents != null;
	}
	
}
