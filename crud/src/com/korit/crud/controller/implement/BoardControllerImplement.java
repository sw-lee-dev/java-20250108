package com.korit.crud.controller.implement;

import com.korit.crud.controller.BoardController;
import com.korit.crud.dto.board.WriteBoardRequestDto;
import com.korit.crud.service.BoardService;

public class BoardControllerImplement implements BoardController {
	
	private BoardService boardService;
	
	public BoardControllerImplement(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public void write(WriteBoardRequestDto requestDto) {
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;
		
		boardService.write(requestDto);
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
