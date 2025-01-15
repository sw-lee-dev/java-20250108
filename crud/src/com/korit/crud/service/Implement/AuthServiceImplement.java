package com.korit.crud.service.Implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;
import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.service.AuthService;

public class AuthServiceImplement implements AuthService {
	
	private final UserRepository userRepository; // 구현체가 UserRepository 라는 인터페이스에 의존성을 가짐 - 추상화에 의존한것
	
	public AuthServiceImplement(UserRepository userRepository) { // 생성자를 통해서 값을 외부에서 주입하게 만듦
		this.userRepository = userRepository;
	}
	
	@Override
	public void signUp(SignUpRequestDto requestDto) {
		// 아이디가 중복됐는지 저장소에서 확인하는 작업 >> 저장소가 먼저 있어야함
		String id = requestDto.getId();
		boolean existedId = userRepository.existsById(id);
		// - 중복된 아이디라면 '중복된 아이디입니다.' 출력 후 메서드 종료
		if (existedId) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		// 해당 유저 정보를 저장소(데이터베이스)에 저장 후 '성공했습니다.' 출력
//		String password = requestDto.getPassword();
//		String nickname = requestDto.getNickname();
//		UserEntity userEntity = new UserEntity(id, password, nickname);
		// 오버로드된 생성자의 매개변수로 정보를 저장하면 매개변수를 일일이 나열하지 않아도 된다
		UserEntity userEntity = new UserEntity(requestDto);
		userRepository.save(userEntity);
		System.out.println("성공했습니다.");
	}

	@Override
	public void signIn(SignInRequestDto requestDto) {
		// 아이디에 해당하는 정보가 있는지 확인 (인스턴스를 찾는것-가지고 오는것 >> 인스턴스가 필요함)
		String id = requestDto.getId();
		UserEntity userEntity = userRepository.findById(id);
		// - 존재하지 않는다면 '로그인에 실패했습니다.' 출력 후 메서드 종료
		if (userEntity == null) {
			System.out.println("로그인에 실패했습니다.");
			return;
		}
		// 찾은 정보의 비밀번호와 입력한 비밀번호가 같은지 확인
		String password = requestDto.getPassword();
		String existPasswoed = userEntity.getPassword();
		// - 같지 않다면 '로그인에 실패했습니다.' 출력 후 메서드 종료
		if (!existPasswoed.equals(password)) {
			System.out.println("로그인에 실패했습니다.");
			return;
		}
		// 로그인 정보 저장
		CrudApplication.SESSION = id;
		// '로그인 성공' 출력
		System.out.println("로그인 성공");
	}
	
}
