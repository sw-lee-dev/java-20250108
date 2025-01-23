package com.korit.crud.controller.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.controller.BoardController;
import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.WriteBoardRequestDto;
import com.korit.crud.service.BoardService;

public class BoardControllerImplement implements BoardController {
	
	private BoardService boardService;
	
	public BoardControllerImplement(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public void writeBoard(WriteBoardRequestDto requestDto) {
		String id = CrudApplication.SESSION;
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;
		
		boardService.writeBoard(requestDto, id);
	}

	@Override
	public void getListAll() {
		boardService.getListAll();
	}

	@Override
	public void getContents(Integer boardNumber) {
		boardService.getContents(boardNumber);
	}

	@Override
	public boolean checkWriter(Integer boardNumber) {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인된 사용자가 없습니다.");
			return false;
		}
		return boardService.checkUpdate(boardNumber, id);
	}
	
	@Override
	public void update(PatchBoardRequestDto requestDto, Integer boardNumber) {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인된 사용자가 없습니다.");
			return;
		}
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;
		
		boardService.update(requestDto,boardNumber, id);
	}

	@Override
	public void delete(Integer boardNumber) {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인된 사용자가 없습니다.");
			return;
		}
		boardService.delete(boardNumber, id);
	}


}
