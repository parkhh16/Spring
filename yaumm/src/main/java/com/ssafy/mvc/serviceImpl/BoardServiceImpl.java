package com.ssafy.mvc.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.dao.BoardDao;
import com.ssafy.mvc.dto.BoardDto;
import com.ssafy.mvc.model.dto.SearchCondition;
@Service
public class BoardServiceImpl {
	
	private final BoardDao boardDao;
	public BoardServiceImpl(BoardDao boardDao) {
		// TODO Auto-generated constructor stub
		this.boardDao=boardDao;
	}
	public List<BoardDto> getBoardList() {
		// TODO Auto-generated method stub
		System.out.println("전체 게시글");
		return boardDao.selectAll();
	}

	public BoardDto readBoard(int id) {
		// TODO Auto-generated method stub
		boardDao.updateViewCnt(id);
		System.out.println("게시글 상세 조회");
		return boardDao.selectOne(id);
	}
	@Transactional
	public void writeBoard(BoardDto board) {
		// TODO Auto-generated method stub
		System.out.println("게시글 작성");
		boardDao.insertBoard(board);
	}
	@Transactional
	public boolean removeBoard(int id) {
		System.out.println("게시글 삭제");
		int result=boardDao.deleteBoard(id);
		return result==1;
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public void modifyBoard(BoardDto board) {
		// TODO Auto-generated method stub
		boardDao.updateBoard(board);
	}
	public BoardDto getBoard(int id) {
		// TODO Auto-generated method stub
		return boardDao.selectOne(id);
	}
	public List<BoardDto> search(SearchCondition condition) {
		// TODO Auto-generated method stub
		return boardDao.search(condition);
	}

}
