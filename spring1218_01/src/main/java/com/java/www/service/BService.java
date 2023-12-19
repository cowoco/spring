package com.java.www.service;

import java.util.ArrayList;

import com.java.www.dto.BoardDto;

public interface BService {
	//게시글 전체 가지고 오기
	ArrayList<BoardDto> bList();
	
	//게시글 1개 
	BoardDto selectOne(int bno);
	
	//게시글 저장
	void bInsert(BoardDto bdto);

}