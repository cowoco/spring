package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		ArrayList<BoardDto> list =bService.bList();
	
		model.addAttribute("list",list);
		return "board/bList";
	}
	
	@RequestMapping("bView")
	public String bView (@RequestParam(defaultValue = "1")int bno,Model model) {
		System.out.println("BController bno"+bno);
		
		BoardDto boardDto = bService.selectOne(bno);
		
		
		model.addAttribute("bdto",boardDto);
		return "board/bView";
	}
	
	

}
