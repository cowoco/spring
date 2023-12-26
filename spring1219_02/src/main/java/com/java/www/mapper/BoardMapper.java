package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BoardDto;
@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> selectAll();
	
	
	//게시글 1개 가져오기 - 현재글 
	BoardDto selectOne(int bno);

}
