package com.korit.crud.repository;

import java.util.ArrayList;
import java.util.List;
import com.korit.crud.entity.UserEntity;

// Repository : 데이터베이스 작업을 위한 모듈(레이어)
// 데이터베이스에 삽입, 조회, 수정, 삭제 작업을 처리
public interface UserRepository {
	List<UserEntity> DATABASE_LIST = new ArrayList<>();
	
	void save(UserEntity userEntity); 		// 객체 저장
	boolean existsById(String id);	  		// 회원가입 시 아이디 중복 검사
	UserEntity findById(String id);	  		// 로그인 시 아이디 존재여부 검사
	void updateByNickname(String id, String nickname);	// 정보확인 후 정보수정-닉네임
//	void deleteById(UserEntity userEntity, String password); // 비밀번호 확인 후 정보삭제
	void deleteById(String id);
	void deleteOne(UserEntity userEntity);
}
