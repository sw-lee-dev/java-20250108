package com.korit.crud.service.Implement;

import java.util.List;

import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.WriteBoardRequestDto;
import com.korit.crud.entity.BoardEntity;
import com.korit.crud.repository.BoardRepository;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.service.BoardService;
import com.korit.crud.vo.BoardListVO;
import com.korit.crud.vo.BoardViewVO;

public class BoardServiceImplement implements BoardService {
	
	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	
	public BoardServiceImplement(BoardRepository boardRepository, UserRepository userRepository) {
		this.boardRepository = boardRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void writeBoard(WriteBoardRequestDto requestDto, String id) {
		// SESSION 에 로그인된 id 로 진행을 하지만 컴퓨터 시스템 또는 저장소 시스템에 예기치못한 문제가 발생하여 데이터가 사라지게 될 경우 SESSION 에 로그인된 id 가 존재하는지 검증할 필요가 있다.
		// 아주 드문 경우이지만 개발자라면 드물게 일어난다할지라도 예외에 대한 처리를 반드시 하고 가야한다.
 		boolean isExistedUser = userRepository.existsById(id);
		if (!isExistedUser) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		BoardEntity boardEntity = new BoardEntity(requestDto, id);
		boardRepository.write(boardEntity);
		System.out.println("작성에 성공했습니다.");
	}

	@Override
	public void getListAll() {
		List<BoardListVO> boardList = boardRepository.findListAll();
		System.out.println("게시물 번호 / 게시물 제목 / 작성자 닉네임 / 작성일");
		// 출력 시 BoardListVO 에서 설정한 toString 메서드가 있다면 그 형태로 출력됨. toString 메서드 없이 그냥 출력하면 주소만 나옴
		for (BoardListVO board : boardList) {
			System.out.println(board);
		}
	}

	@Override
	public void getContents(Integer boardNumber) {
		BoardViewVO vo = boardRepository.showListById(boardNumber);
		if (vo == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return;
		}
		System.out.println(vo);
	}

	@Override
	public boolean checkUpdate(Integer boardNumber, String id) {
		BoardViewVO vo = boardRepository.showListById(boardNumber);
		if (vo == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return false;
		}
		boolean isRightUser = vo.getWriterId().equals(id);
		if (!isRightUser) {
			System.out.println("수정 권한이 없습니다.");
			return false;
		}
		
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("내용 : " + vo.getContents());
		
		return true;
	}
	
	@Override
	public void update(PatchBoardRequestDto requestDto, Integer boardNumber, String id) {
		String title = requestDto.getTitle();
		String contents = requestDto.getContents();
		boardRepository.updateByNumber(boardNumber, title, contents);
		System.out.println("수정에 성공했습니다.");
	}

	@Override
	public void delete(Integer boardNumber, String id) {
		BoardViewVO vo = boardRepository.showListById(boardNumber);
		if (vo == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return;
		}
		boolean isRightUser = vo.getWriterId().equals(id);
		if (!isRightUser) {
			System.out.println("수정 권한이 없습니다.");
			return;
		}
		boardRepository.deleteByNumber(boardNumber);
		System.out.println("삭제에 성공했습니다.");
	}


}
