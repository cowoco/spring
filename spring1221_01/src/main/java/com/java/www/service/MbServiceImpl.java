package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemBoardDto;
import com.java.www.mapper.MbMapper;

@Service
public class MbServiceImpl implements MbService{

	@Autowired
	MbMapper mbMapper;
	
	
	@Override
	public ArrayList<MemBoardDto> list3() {
		ArrayList<MemBoardDto> list = mbMapper.list3();
		System.out.println(" MbServiceImpl list3"+list);
		return list;
	}


	@Override
	public ArrayList<MemBoardDto> list4() {
		ArrayList<MemBoardDto> list = mbMapper.list4();
		System.out.println(" MbServiceImpl list4"+list);
		return list;
	}

}
