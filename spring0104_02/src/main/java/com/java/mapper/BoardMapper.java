package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {
	//전체 게시글 저장
	List<BoardDto> blist();
   //게시글 1개 가져오기 	
	BoardDto selectOne(int bno);
	//
	void write(BoardDto bdto);

}
