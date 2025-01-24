package com.korit.crud.service;

import com.korit.crud.dto.board.CommentRequestDto;

public interface CommentService {

	void saveComment(CommentRequestDto requestDto, String id);
	void getListAll();
	boolean checkWriter(Integer boardNumber, String id);
	void hideComment();
	void update();
	void delete();
}
