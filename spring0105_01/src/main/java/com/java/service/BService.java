package com.java.service;

import java.util.List;

import com.java.dto.BoardDto;

public interface BService {
	
	//게시글 전체 가져오기
	List<BoardDto> selectAll();
	
	//글쓰기 저장
	void bwrite(BoardDto bdto);

	BoardDto selectOne(int bno);

}
