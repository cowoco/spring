package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> blist() {
		List<BoardDto> list = boardMapper.blist();
		return list;
	}

	@Override
	public BoardDto selectOne(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		
		return bdto;
	}

	@Override
	public void write(BoardDto bdto) {
		boardMapper.write(bdto);
		
	}

}
