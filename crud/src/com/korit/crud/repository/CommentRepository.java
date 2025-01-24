package com.korit.crud.repository;

import java.util.List;

import com.korit.crud.entity.CommentEntity;
import com.korit.crud.vo.CommentListVO;

public interface CommentRepository {

	// 댓글 작성
	// 댓글 리스트보기 >> ListVO 필요
	// 댓글 가리기 >> 게시물 관리자만
	// 댓글 수정 >> 댓글 작성자만
	// 댓글 삭제 >> 댓글 작성자만
	void save(CommentEntity commentEntity);
	List<CommentListVO> getListAll();
	
	boolean existsById(Integer boardNumber);
	void hideComment(boolean status, Integer commentNumber);
	
	void update(String contents, Integer commentNumber);
	void delete(Integer commentNumber);
	
}
