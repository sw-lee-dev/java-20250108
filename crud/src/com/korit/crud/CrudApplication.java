package com.korit.crud;

import java.sql.Connection;
import java.util.Scanner;

import com.korit.crud.controller.AuthController;
import com.korit.crud.controller.BoardController;
import com.korit.crud.controller.UserController;
import com.korit.crud.controller.implement.AuthControllerImplement;
import com.korit.crud.controller.implement.BoardControllerImplement;
import com.korit.crud.controller.implement.UserControllerImplement;
import com.korit.crud.db.MySQLConnector;
import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;
import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.WriteBoardRequestDto;
import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.repository.BoardRepository;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.repository.Implement.BoardRepositoryImplement;
import com.korit.crud.repository.Implement.UserRepositoryImplement;
import com.korit.crud.service.AuthService;
import com.korit.crud.service.BoardService;
import com.korit.crud.service.UserService;
import com.korit.crud.service.Implement.AuthServiceImplement;
import com.korit.crud.service.Implement.BoardServiceImplement;
import com.korit.crud.service.Implement.UserServiceImplement;

public class CrudApplication {
	// 로그인 상태를 확인하기 위한 static 변수 설정(null 이면 로그인 X, null 이 아니고 id 값이 있으면 로그인 O)
	public static String SESSION = null;

	public static void main(String[] args) {
		
		Connection connection = MySQLConnector.getInstance().getConnection();
		// interface		참조변수명				 구조체 클래스			>> 추상화에 의존하게 한것
		UserRepository userRepository = new UserRepositoryImplement(connection);
		AuthService authService = new AuthServiceImplement(userRepository);
		UserService userService = new UserServiceImplement(userRepository);
		AuthController authController = new AuthControllerImplement(authService);
		UserController userController = new UserControllerImplement(userService);
		
		BoardRepository boardrepository = new BoardRepositoryImplement(connection);
		BoardService boardService = new BoardServiceImplement(boardrepository, userRepository);
		BoardController boardController = new BoardControllerImplement(boardService);
		
		// 프로그램을 원할때 종료시키기
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String job = SESSION == null ? "(로그인, 회원가입)" : "(정보보기, 정보수정, 정보삭제, 게시판)";
			System.out.print("작업 " + job + " : ");
			String request = scanner.nextLine();
			
			if (request.equals("나가기")) break;
			
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
			if (request.equals("게시판")) {
				System.out.print("게시판 작업 (작성, 리스트보기, 상세보기, 수정, 삭제, 댓글, 좋아요) : ");
				request = scanner.nextLine();
				if (request.equals("작성")) {
					WriteBoardRequestDto writeBoardRequestDto = new WriteBoardRequestDto();
					boardController.writeBoard(writeBoardRequestDto);
				}
				if (request.equals("리스트보기")) {
					boardController.getListAll();
				}
				if (request.equals("상세보기")) {
					// 최종 사용자로부터 숫자형태로 입력받고자 할땐 입력한 값이 진짜 숫자인지 검증을 해줄 필요가 있다. >> 문자가 올 경우도 대비해서 nextLine()으로 예외처리
					try {
						System.out.print("게시물 번호 : ");
						Integer boardNumber = Integer.parseInt(scanner.nextLine());
						
						boardController.getContents(boardNumber);
					} catch (Exception exception) {
						System.out.println("존재하지 않는 게시물입니다.");
					}
				}
				if (request.equals("수정")) {
					try {
						System.out.print("게시물 번호 : ");
						Integer boardNumber = Integer.parseInt(scanner.nextLine());
						
						boolean isRightUser = boardController.checkWriter(boardNumber);
						if (!isRightUser) continue;
						
						PatchBoardRequestDto patchBoardRequestDto = new PatchBoardRequestDto();
						boardController.update(patchBoardRequestDto, boardNumber);
					} catch (Exception exception) {
						System.out.println("존재하지 않는 게시물입니다.");
					}
				}
				if (request.equals("삭제")) {
					try {
						System.out.print("게시물 번호 : ");
						Integer boardNumber = Integer.parseInt(scanner.nextLine());
						
						boardController.delete(boardNumber);
					} catch (Exception exception) {
						System.out.println("존재하지 않는 게시물입니다.");
					}
				}
				if (request.equals("댓글")) {
					System.out.print("댓글 작업 (작성, 리스트보기, 가리기, 수정, 삭제) : ");
					request = scanner.nextLine();
					if (request.equals("작성")) {
						
					}
					if (request.equals("리스트보기")) {
						
					}
					if (request.equals("가리기")) {
						
					}
					if (request.equals("수정")) {
						
					}
					if (request.equals("삭제")) {
						
					}
				}
				if (request.equals("좋아요")) {
					
				}
			}
		}
		scanner.close();
	}

}
