package com.korit.crud.entity;

import com.korit.crud.dto.auth.SignUpRequestDto;

// Entity : 저장소 객체
public class UserEntity {
	private String id;
	private String password;
	private String nickname;
	
	public UserEntity(String id, String password, String nickname) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}
	
	// 오버로드해서 유저정보를 저장할때 생성자의 매개변수를 일일이 찾지 않도록 만들수 있음
	public UserEntity(SignUpRequestDto dto) {
		this.id = dto.getId();
		this.password = dto.getPassword();
		this.nickname = dto.getNickname();
	}

	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getNickname() {
		return nickname;
	}
	// 정보수정을 위해 set 메서드 생성
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
