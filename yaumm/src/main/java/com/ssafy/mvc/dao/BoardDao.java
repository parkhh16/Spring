package com.ssafy.mvc.dao;

import java.util.List;

import com.ssafy.mvc.dto.BoardDto;
import com.ssafy.mvc.dto.SearchCondition;



public interface BoardDao {
	// 전체 게시글을 조회
	public List<BoardDto> selectAll();

	// 게시글 조회
	public BoardDto selectOne(int id);

	// 게시글 등록
	public void insertBoard(BoardDto board);

	// 게시글 삭제
	public int deleteBoard(int id);

	// 게시글 수정
	public void updateBoard(BoardDto board);

	// 조회수 증가
	public void updateViewCnt(int id);

	public List<BoardDto> search(SearchCondition condition);

}
