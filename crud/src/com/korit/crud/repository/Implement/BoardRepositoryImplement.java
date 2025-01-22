package com.korit.crud.repository.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.korit.crud.CrudApplication;
import com.korit.crud.entity.BoardEntity;
import com.korit.crud.repository.BoardRepository;

public class BoardRepositoryImplement implements BoardRepository {

	private final Connection connection;
	
	public BoardRepositoryImplement(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void write(String id, String title, String contents) {
		
		final String SQL = "INSERT INTO board (id, title, contents) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, contents);
			
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public BoardEntity findListBy(int boardNumber) {
		
		BoardEntity boardEntity = null;
		
		final String SQL = 
				"SELECT B.board_number '게시글 번호', B.title '게시글 이름', U.nickname '작성자 닉네임', B.write_date '작성일' "
				+ "FROM board B JOIN user U ON B.id = U.id WHERE boardNumber = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, boardNumber);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int chooseNumber = resultSet.getInt(1);
				String id = resultSet.getString(2);
				String title = resultSet.getString(3);
				String nickname = resultSet.getString(4);
				String writeDate = resultSet.getString(5);
				
				boardEntity = new BoardEntity(chooseNumber, id, title, nickname, writeDate);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return boardEntity;
	}

	@Override
	public BoardEntity showListBy(int boardNumber) {
		
		return null;
	}

	@Override
	public void updateByNumber(int boardNumber, String title, String contents) {

	}

	@Override
	public void deleteByNumber(int boardNumber, String id) {

	}

}
