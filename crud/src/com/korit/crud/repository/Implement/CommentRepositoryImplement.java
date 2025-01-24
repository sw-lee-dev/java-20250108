package com.korit.crud.repository.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.korit.crud.entity.CommentEntity;
import com.korit.crud.repository.CommentRepository;
import com.korit.crud.vo.CommentListVO;

public class CommentRepositoryImplement implements CommentRepository {
	
	Connection connection;
	
	public CommentRepositoryImplement(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void save(CommentEntity commentEntity) {
		
		final String SQL = "INSERT INTO comment (contents, board_number, writer_id, write_datetime, status, parent_comment) VALUES (?, ?, ?, NOW(), true, null)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, commentEntity.getContets());
			preparedStatement.setInt(2, commentEntity.getBoardNumber());
			preparedStatement.setString(3, commentEntity.getWriterId());
			preparedStatement.setString(4, commentEntity.getWriteDatetime());
			preparedStatement.setBoolean(5, commentEntity.isStatus());
			preparedStatement.setInt(6, commentEntity.getParentComment());
			
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public List<CommentListVO> getListAll() {
		
		List<CommentListVO> commentList = new ArrayList<>();
		
		final String SQL = 
				"SELECT C.contents, U.nickname, C.write_datetime FROM comment C INNER JOIN user U "
				+ "ON C.writer_id = U.id ORDER BY C.comment_number DESC";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String contents = resultSet.getString(1);
				String nickname = resultSet.getString(2);
				String writeDatetime = resultSet.getString(3);
				
				CommentListVO vo = new CommentListVO(contents, nickname, writeDatetime);
				commentList.add(vo);
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return commentList;
	}

	@Override
	public boolean existsById(Integer boardNumber) {
		return false;
	}

	@Override
	public void hideComment(boolean status, Integer commentNumber) {

	}

	@Override
	public void update(String contents, Integer commentNumber) {

	}

	@Override
	public void delete(Integer commentNumber) {

	}

}
