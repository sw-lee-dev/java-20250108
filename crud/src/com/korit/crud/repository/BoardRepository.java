package com.korit.crud.repository;

import java.util.List;

import com.korit.crud.entity.BoardEntity;
import com.korit.crud.vo.BoardListVO;
import com.korit.crud.vo.BoardViewVO;

public interface BoardRepository {
	
	// 작성
	// 리스트보기 게시물의 리스트를 반환
	// 상세보기 해당 게시물의 내용을 반환(제목, 작성자 닉네임, 작성일, 내용)
	// 수정 >> 권한이 해당 사용자에게 있음
	// 삭제 >> 권한이 해당 사용자에게 있음
	void write(BoardEntity boardEntity);
	List<BoardListVO> findListAll();
	BoardViewVO showListById(Integer boardNumber);
	
	boolean existInUser(Integer boardNumber); // 아이디에 맞는 사용자가 존재하는지 여부
	boolean rightInUserIdAndBoardNumber(String writerId, Integer boardNumber); // 사용자가 존재한다면 그 게시물이 해당 사용자의 게시물인지, 사용자의 수정, 삭제 권한 확인
	
	boolean updateByNumber(Integer boardNumber, String title, String contents);
	boolean deleteByNumber(Integer boardNumber);

}
