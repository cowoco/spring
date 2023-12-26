package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemBoardDto;
@Mapper
public interface MbMapper {

	ArrayList<MemBoardDto> list3();

	ArrayList<MemBoardDto> list4();

	

}
