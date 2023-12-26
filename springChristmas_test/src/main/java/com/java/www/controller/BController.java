package com.java.www.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

@Controller
@RequestMapping("board")
public class BController {
	
	@Autowired
	BService bService;
	
	//게시글 전체 가지고 오기
	@GetMapping("bList")
	public String bList(Model model) {
		//db
		ArrayList<BoardDto> list = bService.selectAll();
		//model
		model.addAttribute("list",list);
		
		return "board/bList";
	}//bList
	
	
	//게시글 1개 가져오기
	@GetMapping("bView")
	public String bView(@RequestParam(defaultValue = "1")int bno,Model model) {
		System.out.println("BController bView bno : "+bno);
		Map<String, Object> map =bService.selectOne(bno);
		
		//model
		model.addAttribute("map",map);
		return "board/bView";
	}//bView
	
	//글쓰기 화면보기
	@GetMapping("bInsert")
	public String bInsert(){
		return "board/bInsert";
	}//bInsert-get
	
	//글쓰기 저장 - 오버로딩
	@PostMapping("bInsert")
	public String bInsert(BoardDto bdto,@RequestPart MultipartFile files,Model model) throws Exception {
	if(!files.isEmpty()) {
		String orgName = files.getOriginalFilename();
		System.out.println("controller bInsert orgName"+orgName);
		long time = System.currentTimeMillis();
		String newName =time+"_"+orgName;
		String upload = "c:/upload/";
		File f = new File(upload+newName);
		files.transferTo(f);
		bdto.setBfile(newName);
	}else {//파일첨부가 없으면
		bdto.setBfile("");
		System.out.println("파일첨부가 없습니다.");
		}
		//db
		bService.bInsert(bdto);
		return "board/doBInsert";
	}//bInsert-post
	
	//게시글 삭제
	@PostMapping("bDelete")
	public String bDelete(@RequestParam(defaultValue = "1")int bno,Model model) {
		System.out.println("bcontroller bDelete bno"+bno);
		bService.bDelete(bno);
		return"board/bDelete";
	}//bDelete
	
	//게시글 수정 보기
	@PostMapping("bUpdate")
	public String bUpdate(@RequestParam(defaultValue = "1")int bno,Model model) {
		System.out.println("BController bUpdate bno : "+bno);
		Map<String, Object> map = bService.selectOne(bno);
		model.addAttribute("map",map);
		return "board/bUpdate";
	}//bUpdate-post 게시글 수정 보기
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
