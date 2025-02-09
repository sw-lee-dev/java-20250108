package com.korit.crud.controller.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.controller.CommentController;
import com.korit.crud.dto.board.CommentRequestDto;
import com.korit.crud.service.CommentService;

public class CommentControllerImplement implements CommentController {

	CommentService commentService;
	
	public CommentControllerImplement(CommentService commentService) {
		this.commentService = commentService;
	}

	@Override
	public void saveComment(CommentRequestDto requestDto) {
		String id = CrudApplication.SESSION;
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;

		commentService.saveComment(requestDto, id);
	}

	@Override
	public void getListAll() {

	}

	@Override
	public boolean checkWriter(Integer boardNumber, String id) {
		return false;
	}

	@Override
	public void hideComment() {

	}

	@Override
	public void update() {

	}

	@Override
	public void delete() {

	}

}
