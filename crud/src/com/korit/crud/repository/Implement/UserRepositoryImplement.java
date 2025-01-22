package com.korit.crud.repository.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;	

public class UserRepositoryImplement implements UserRepository {

	private final Connection connection;
	
	public UserRepositoryImplement(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean existsById(String id) {
		
		final String SQL = "SELECT * FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery(); // 결과물이 있을때
			while (resultSet.next()/*SQL 테이블의 커서를 다음값으로 이동시키는 것*/) {
				// String userId = resultSet.getString(1);
				String userId = resultSet.getString("id"); // 컬럼명을 직접 지정
				if (userId.equals(id)) return true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
		
//		for (UserEntity entity : DATABASE_LIST) {
//			if (entity.getId().equals(id)) return true;
//		}
//		return false;
	}

	@Override
	public void save(UserEntity userEntity) {
		
		final String SQL = "INSERT INTO user VALUES (?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, userEntity.getId());
			preparedStatement.setString(2, userEntity.getPassword());
			preparedStatement.setString(3, userEntity.getNickname());
			
			preparedStatement.executeUpdate(); // INSERT, UPDATE, DELETE 의 경우 실행할때
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		// DATABASE_LIST.add(userEntity);
	}

	@Override
	public UserEntity findById(String id) {
		
		UserEntity userEntity = null;
		
		final String SQL = "SELECT * FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String userId = resultSet.getString(1);
				String password = resultSet.getString(2);
				String nickname = resultSet.getString(3);
				
				userEntity = new UserEntity(userId, password, nickname);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return userEntity;
		
//		for (UserEntity entity : DATABASE_LIST) {
//			if (entity.getId().equals(id)) return entity;
//		}
//		return null;
	}

	@Override
	public void updateByNickname(String id, String nickname) {
		
		final String SQL = "UPDATE user SET nickname = ? WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, nickname);
			preparedStatement.setString(2, id);
			
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		// 주소를 변경하는것이 아니라 주소에 있는 값을 변경하는 용도로는 사용가능
//		for (UserEntity entity : DATABASE_LIST) {
//			if (entity.getId().equals(id)) entity.setNickname(nickname);
//		}
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
		
		final String SQL = "DELETE FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
//		UserEntity userEntity = null;
//		for (UserEntity entity : DATABASE_LIST) {
//			if (entity.getId().equals(id)) userEntity = entity;
//		}
//		DATABASE_LIST.remove(userEntity);
	}

	@Override
	public void deleteOne(UserEntity userEntity) {
		
		String id = userEntity.getId();
		this.deleteById(id);
		
//		DATABASE_LIST.remove(userEntity);
	}
}
