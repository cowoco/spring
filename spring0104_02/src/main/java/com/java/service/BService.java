package com.java.service;

import java.util.List;

import com.java.dto.BoardDto;

public interface BService {
   //게시글 전체가져오기 	
	List<BoardDto> blist();
	//게시글 1개 보기 
	BoardDto selectOne(int bno);
	void write(BoardDto bdto);

}
