package com.java.www.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class BController {
	
	@Autowired BService bService;
	@Autowired HttpSession session;
	

	@GetMapping("notice")//공지사항 전체가져오기
	public String notice(Model model) {
		//page 가지고 와야 함 
		//service연결 - list 
		List<BoardDto> list = bService.selectAll();
		//model
		model.addAttribute("list",list);
		return "customer/notice";
	}
	
	
	@GetMapping("notice_view")//1개 게시글 가져오기
	public String notice_view(@RequestParam(defaultValue = "1") int bno,Model model) {
		//service연결
		Map<String, Object> map = bService.selectOne(bno);
		System.out.println("BController notice_view bno : "+bno);
		
		//model전송
		model.addAttribute("map",map);
		
		return "customer/notice_view";
	}
	
	@PostMapping("BCommentInsert")//댓글1 개 저장
	@ResponseBody
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		System.out.println("BController BCommentInsert bno : "+cdto.getBno());
		//service연결 - 저장시간,cno
		BCommentDto bCommentDto = bService.bCommentInsert(cdto);
	
		return bCommentDto;
	}
	@PostMapping("BCommentDelete")//댓글 삭제
	@ResponseBody
	public String BCommentDelete(int cno) {
		System.out.println("BController BCommentDelete cno : "+cno);
		//service연결 - 댓글삭제
		String result  = bService.BCommentDelete(cno);
		return "삭제처리";
	}
	@PostMapping("BCommentUpdate")//댓글 수정 저장
	@ResponseBody
	public BCommentDto BCommentUpdate(BCommentDto cdto) {
		System.out.println("BController BCommentUpdate cno : "+cdto.getCno());
		//service연결 - 댓글수정 저장
		BCommentDto bCommentDto = bService.BCommentUpdate(cdto);
		return bCommentDto;
	}
	

}
