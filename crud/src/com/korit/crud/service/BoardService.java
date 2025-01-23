package com.korit.crud.service;

import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.WriteBoardRequestDto;

public interface BoardService {
	
	void writeBoard(WriteBoardRequestDto requestDto, String id);
	void getListAll();
	void getContents(Integer boardNumber);
	boolean checkUpdate(Integer boardNumber, String id);
	void update(PatchBoardRequestDto requestDto, Integer boardNumber, String id);
	void delete(Integer boardNumber, String id);
	
}
