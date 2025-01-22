package com.korit.crud.repository;

import com.korit.crud.entity.BoardEntity;

public interface BoardRepository {
	
	// 작성
	// 리스트보기 게시물의 리스트를 반환
	// 상세보기 해당 게시물의 내용을 반환(제목, 작성자 닉네임, 작성일, 내용)
	// 수정
	// 삭제
	void write(String id, String title, String contents);
	BoardEntity findListBy(int boardNumber);
	BoardEntity showListBy(int boardNumber);
	void updateByNumber(int boardNumber, String title, String contents);
	void deleteByNumber(int boardNumber, String id);

}
