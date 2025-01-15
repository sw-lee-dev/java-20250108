package com.korit.crud.controller.implement;

import com.korit.crud.controller.AuthController;
import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;
import com.korit.crud.service.AuthService;

public class AuthControllerImplement implements AuthController {

	private final AuthService authService; // 구현체가 AuthService 라는 인터페이스에 의존성을 가짐 - 추상화에 의존한것
	
	public AuthControllerImplement(AuthService authService) { // 생성자를 통해서 값을 외부에서 주입하게 만듦
		this.authService = authService;
	}
	
	@Override
	public void signUp(SignUpRequestDto requestDto) {
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;
		
		authService.signUp(requestDto);
	}
	
	@Override
	public void signIn(SignInRequestDto requestDto) {
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;
		
		authService.signIn(requestDto);
	}
	
}
