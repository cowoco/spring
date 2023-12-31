package com.java.www.service;

import java.util.List;
import java.util.Map;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

public interface BService {
	
	
	//공지사항 전체가져오기
	List<BoardDto> selectAll();
	//db에 저장된 댓글 1개 가져오기 
	Map<String, Object> selectOne(int bno);
	//ajax 댓글 입력
	BCommentDto BCommentInsert(BCommentDto cdto);

}
