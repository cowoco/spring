package com.java.www.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BoardMapper boardMapper;
	
	
	// 공지사항 전체 가져오기
	@Override
	public List<BoardDto> selectAll() {
		
		List<BoardDto> list = boardMapper.selectAll();
		return list;
	}

   //게시글 1개 가져오기
	@Override
	public Map<String, Object> selectOne(int bno) {
		System.out.println("BServiceImpl selectOne bno: "+bno);
		BoardDto bdto = boardMapper.selectOne(bno);
		
		//map - 게시글,댓글 전체 가져오기
		Map<String, Object> map = new HashMap<>();
		List<BCommentDto> list = boardMapper.BCommentSelectAll(bno);
		map.put("bdto", bdto);
		map.put("list", list);
		
		return map;
	}

	@Override //db에 저장된 댓글 1개 가져오기
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		boardMapper.BCommentInsert(cdto);
		System.out.println("BServiceImpl BCommentInsert cno "+cdto.getCno());
		System.out.println("BServiceImpl BCommentInsert cdate "+cdto.getCdate());
		
		
		BCommentDto bCommentDto = new BCommentDto();
		bCommentDto = boardMapper.BCommentSelectOne(cdto.getCno());
		System.out.println("BServiceImpl bCommentDto ccontent "+bCommentDto.getCcontent());
		return bCommentDto;
	}

}
