package com.korit.crud.service.Implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.dto.board.WriteBoardRequestDto;
import com.korit.crud.entity.BoardEntity;
import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.BoardRepository;
import com.korit.crud.service.BoardService;

public class BoardServiceImplement implements BoardService {
	
	private BoardRepository boardRepository;
	
	public BoardServiceImplement(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public void write(WriteBoardRequestDto requestDto) {
		String id = CrudApplication.SESSION;
		String title = requestDto.getTitle();
		String contents = requestDto.getContents();
		boardRepository.write(id, title, contents);
		System.out.println("작성에 성공했습니다.");
	}

	@Override
	public void getListAll() {

	}

	@Override
	public void getContents() {

	}

	@Override
	public void update() {

	}

	@Override
	public void delete() {

	}

}
