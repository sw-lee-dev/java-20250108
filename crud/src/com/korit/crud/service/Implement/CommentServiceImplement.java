package com.korit.crud.service.Implement;

import com.korit.crud.dto.board.CommentRequestDto;
import com.korit.crud.entity.CommentEntity;
import com.korit.crud.repository.CommentRepository;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.service.CommentService;

public class CommentServiceImplement implements CommentService {

	CommentRepository commentRepository;
	UserRepository userRepository;
	
	public CommentServiceImplement(CommentRepository commentRepository, UserRepository userRepository) {
		this.commentRepository = commentRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void saveComment(CommentRequestDto requestDto, String id) {
		boolean isExistUser = userRepository.existsById(id);
		if (!isExistUser) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		CommentEntity commentEntity = new CommentEntity(requestDto, id);
		commentRepository.save(commentEntity);
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
