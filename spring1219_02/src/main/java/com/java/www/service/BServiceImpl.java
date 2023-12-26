package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService{
	
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public ArrayList<BoardDto> selectAll() {
		//게시글 전체 가져오기
		ArrayList<BoardDto> list =  boardMapper.selectAll();
		
		return list;
	}//selectAll

	@Override
	public Map<String, Object> selectOne(int bno) {
		System.out.println("BService bno : "+bno);
		BoardDto bdto = boardMapper.selectOne(bno);
		Map<String, Object> map = new HashMap<>();
		map.put("bdto", bdto);
		
		
		return map;
	}

}
