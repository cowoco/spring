package com.java.www.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

@Controller
@RequestMapping("board")
public class BController {
	
	@Autowired
	BService bService;
	
	@RequestMapping("bList")
	public String bList(Model model) {
		//db에서 가져오기 
		ArrayList<BoardDto> list = bService.selectAll();
		model.addAttribute("list",list);

		return "board/bList";
	}
	
	@GetMapping("bView")
	public String bView(@RequestParam(defaultValue = "1")int bno,Model model){
		System.out.println("BController bno : "+bno);
		
		Map<String, Object> map = bService.selectOne(bno);
		
		model.addAttribute("map",map);

		
		return "board/bView";
	}
	
	
	

}
