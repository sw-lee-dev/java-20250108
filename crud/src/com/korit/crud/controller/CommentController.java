package com.korit.crud.controller;

import com.korit.crud.dto.board.CommentRequestDto;

public interface CommentController {

	void saveComment(CommentRequestDto requestDto);
	void getListAll();
	boolean checkWriter(Integer boardNumber, String id);
	void hideComment();
	void update();
	void delete();
}
