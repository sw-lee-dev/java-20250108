package com.korit.crud.service.Implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.service.UserService;

public class UserServiceImplement implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void getSignInUser(String id) {
		// 유저 정보를 저장소에서 불러오기
		UserEntity userEntity = userRepository.findById(id);
		// 이 단락에서의 유효성검사 해줘야함. >> 만에 하나의 예외가 생길 경우를 방지
		if (userEntity == null) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		System.out.println("아이디 : " + userEntity.getId() + "/ 닉네임 : " + userEntity.getNickname());
	}

	@Override
	public void patchSignInUser(PatchSignInUserRequestDto patchRequestDto, String id) {
		// 수정하려는 유저가 있는지 확인
		boolean existedUser = userRepository.existsById(id);
		if (!existedUser) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		// 유저 닉네임 수정
		String nickname = patchRequestDto.getNickname();
		// 유저 정보에서 닉네임값을 입력한 닉네임값으로 변경 >> repository 이용
		userRepository.updateByNickname(id, nickname);
		// 출력 성공했습니다.
		System.out.println("성공했습니다.");
	}

	@Override
	public void deleteSignInUser(DeleteSignInUserRequestDto deleteRequestDto, String id) {
		// 삭제만 할게 아니라서 userEntity 로 사용하는게 맞음
//		boolean existedUser = userRepository.existsById(id);
//		if(!existedUser) {
//			System.out.println("존재하지 않는 아이디입니다.");
//			return;
//		}
		// 수정하려는 유저가 있는지 확인
		UserEntity userEntity = userRepository.findById(id);
		if (userEntity == null) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		// 비밀번호 일치 확인
		String password = deleteRequestDto.getPassword();
		String existPassword = userEntity.getPassword();
		if (!existPassword.equals(password)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
//		userRepository.deleteById(userEntity, password);
		userRepository.deleteById(id);
		// 출력 성공했습니다.
		System.out.println("성공했습니다.");
		// 아이디가 존재하지 않으니 로그아웃
		CrudApplication.SESSION = null;
		System.out.println("로그아웃 되었습니다.");
	}

}
