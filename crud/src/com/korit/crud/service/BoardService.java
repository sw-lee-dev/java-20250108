package com.korit.crud.service;

import com.korit.crud.dto.board.WriteBoardRequestDto;

public interface BoardService {
	
	void write(WriteBoardRequestDto requestDto);
	void getListAll();
	void getContents();
	void update();
	void delete();
	
}
