package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	public ArrayList<BoardDto> selectAll() {
		//게시글 전체 가져오기 
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override
	public Map<String, Object> selectOne(int bno) {
		// 게시글1개 가져오기
		BoardDto bdto = boardMapper.selectOne(bno);
		BoardDto prevdto = boardMapper.selectOnePrev(bno);
		BoardDto nextdto = boardMapper.selectOneNext(bno);
		
		Map<String, Object> map = new HashMap<>();
		map.put("bdto", bdto);
		map.put("prevdto", prevdto);
		map.put("nextdto", nextdto);
		return map;
	}//selectOne

	@Override
	public void bInsert(BoardDto bdto) {
		//글쓰기 저장
		int result = boardMapper.bInsert(bdto);
		System.out.println("BServiceImpl result"+result);
		
		
	}
	
	//게시글 삭제
	@Override
	public void bDelete(int bno) {
		int result = boardMapper.bDelete(bno);
		System.out.println("BServiceImpl bDelete result"+result);
		
	}
	
	

}
