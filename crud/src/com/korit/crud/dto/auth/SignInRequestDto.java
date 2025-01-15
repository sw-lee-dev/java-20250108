package com.korit.crud.dto.auth;

import java.util.Scanner;

//DTO (Data Transfer Object) : 모듈간 데이터 전송을 위한 객체
public class SignInRequestDto {
	private String id;
	private String password;
	
	@SuppressWarnings("resource")
	public SignInRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아이디 : ");
		this.id = scanner.nextLine();
		System.out.print("비밀번호 : ");
		this.password = scanner.nextLine();
	}

	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	
	public boolean validate() {
		if(!isNotNull()) {
			System.out.println("모두 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return id != null && password != null; 
	}
	
}
