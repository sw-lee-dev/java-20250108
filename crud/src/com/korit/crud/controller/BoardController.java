package com.korit.crud.controller;

import com.korit.crud.dto.board.WriteBoardRequestDto;

public interface BoardController {
	
	void write(WriteBoardRequestDto requestDto);
	void getListAll();
	void getContents();
	void update();
	void delete();

}
