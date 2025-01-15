package com.korit.crud.repository.Implement;

import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;

public class UserRepositoryImplement implements UserRepository {

	@Override
	public boolean existsById(String id) {
		for (UserEntity entity : DATABASE_LIST) {
			if (entity.getId().equals(id)) return true;
		}
		return false;
	}

	@Override
	public void save(UserEntity userEntity) {
		DATABASE_LIST.add(userEntity);
	}

	@Override
	public UserEntity findById(String id) {
		for (UserEntity entity : DATABASE_LIST) {
			if (entity.getId().equals(id)) return entity;
		}
		return null;
	}

	@Override
	public void updateByNickname(String id, String nickname) {
		// 주소를 변경하는것이 아니라 주소에 있는 값을 변경하는 용도로는 사용가능
		for (UserEntity entity : DATABASE_LIST) {
			if (entity.getId().equals(id)) entity.setNickname(nickname);
		}
	}

//	@Override
//	public void deleteById(UserEntity userEntity, String password) {
//		for (int i = 0; i < DATABASE_LIST.size(); i++) {
//			if (userEntity.getPassword().equals(password)) {
//				DATABASE_LIST.remove(i);
//			}
//		}
//	}
	
	@Override
	public void deleteById(String id) {
		UserEntity userEntity = null;
		for (UserEntity entity : DATABASE_LIST) {
			if (entity.getId().equals(id)) userEntity = entity;
		}
		DATABASE_LIST.remove(userEntity);
	}

	@Override
	public void deleteOne(UserEntity userEntity) {
		DATABASE_LIST.remove(userEntity);
	}

	
}
