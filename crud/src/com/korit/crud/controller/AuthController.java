package com.korit.crud.controller;

import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;

// Controller : 클라이언트와 서버간의 접점에 해당하는 모듈(레이어)
// 요청(입력)에 대한 검증 처리, 응답(출력)에 대한 분기 처리

// 인증, 인가 작업 (회원가입, 로그인)
// DIP 에 의해 의존성을 추상화에 의존하기 위해서 인터페이스로 먼저 정의를 함
public interface AuthController {
	// 회원가입에 대한 기능
	void signUp(SignUpRequestDto requestDto);
	// 로그인에 대한 기능
	void signIn(SignInRequestDto requestDto);
}
