package com.java.www.service;

import java.util.ArrayList;

import com.java.www.dto.BoardDto;

public interface BService {
	
	//게시글 전체
	ArrayList<BoardDto> bList();
	
	//게시글 1개 가져오기
	BoardDto selectOne(int bno);

}
