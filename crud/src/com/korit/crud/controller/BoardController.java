package com.korit.crud.controller;

import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.WriteBoardRequestDto;

public interface BoardController {
	
	void writeBoard(WriteBoardRequestDto requestDto);
	void getListAll();
	void getContents(Integer boardNumber);
	boolean checkWriter(Integer boardNumber);	
	void update(PatchBoardRequestDto requestDto, Integer boardNumber);
	void delete(Integer boardNumber);

}
