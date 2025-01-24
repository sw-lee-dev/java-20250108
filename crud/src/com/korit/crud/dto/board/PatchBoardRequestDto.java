package com.korit.crud.dto.board;

import java.util.Scanner;

public class PatchBoardRequestDto {
	private String title;
	private String contents;
	
	public PatchBoardRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("제목 : ");
		this.title = scanner.nextLine();
		System.out.print("내용 : ");
		this.contents = scanner.nextLine();
	}

	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	
	public boolean validate() {
//		if (!isNotNull()) {
//			System.out.println("내용을 입력해주세요.");
//			return false;
//		}
//		if (!titleCheck()) {
//			System.out.println("제목은 비어있거나 공백으로만 이루어질수 업습니다.");
//			return false;
//		}
//		if (!contentsCheck()) {
//			System.out.println("내용은 비어있거나 공백으로만 이루어질수 없습니다.");
//			return false;
//		}
		if (!isNotNull() || !titleCheck() || !contentsCheck()) {
			System.out.println("내용을 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull()	{
		return title != null && contents != null;
	}
	
	private boolean titleCheck() {
		return !title.isBlank();
	}
	
	private boolean contentsCheck() {
		return !contents.isBlank();
	}
	
}
