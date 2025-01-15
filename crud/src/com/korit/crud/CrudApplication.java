package com.korit.crud;

import java.util.Scanner;

import com.korit.crud.controller.AuthController;
import com.korit.crud.controller.UserController;
import com.korit.crud.controller.implement.AuthControllerImplement;
import com.korit.crud.controller.implement.UserControllerImplement;
import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;
import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.repository.Implement.UserRepositoryImplement;
import com.korit.crud.service.AuthService;
import com.korit.crud.service.UserService;
import com.korit.crud.service.Implement.AuthServiceImplement;
import com.korit.crud.service.Implement.UserServiceImplement;

public class CrudApplication {
	// 로그인 상태를 확인하기 위한 static 변수 설정(null 이면 로그인 X, null 이 아니고 id 값이 있으면 로그인 O)
	public static String SESSION = null;

	public static void main(String[] args) {
		// interface		참조변수명				 구조체 클래스			>> 추상화에 의존하게 한것
		UserRepository userRepository = new UserRepositoryImplement();
		AuthService authService = new AuthServiceImplement(userRepository);
		UserService userService = new UserServiceImplement(userRepository);
		AuthController authController = new AuthControllerImplement(authService);
		UserController userController = new UserControllerImplement(userService);
		
		// 프로그램을 원할때 종료시키기
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String job = SESSION == null ? "(로그인, 회원가입)" : "(정보보기, 정보수정, 정보삭제)";
			System.out.print("작업 " + job + " : ");
			String request = scanner.nextLine();
			
			if (request.equals("exit")) break;
			
			if (request.equals("회원가입")) {
				SignUpRequestDto requestDto = new SignUpRequestDto();
				authController.signUp(requestDto);
			}
			if (request.equals("로그인")) {
				SignInRequestDto requestDto = new SignInRequestDto();
				authController.signIn(requestDto);
			}
			if (request.equals("정보보기")) {
				userController.getSignInUser();
			}
			if (request.equals("정보수정")) {
				PatchSignInUserRequestDto patchRequestDto = new PatchSignInUserRequestDto();
				userController.patchSigbInUser(patchRequestDto);
			}
			if (request.equals("정보삭제")) {
				DeleteSignInUserRequestDto deleteRequestDto = new DeleteSignInUserRequestDto();
				userController.deleteSignInUser(deleteRequestDto);
			}
		}
		scanner.close();
	}

}
