package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmpDto;
import com.java.www.dto.MemBoardDto;
import com.java.www.service.EmpService;
import com.java.www.service.MbService;

@Controller
public class FController {
	
	@Autowired
	EmpService empService;
	
	@Autowired
	MbService mbService;

	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	//사원정보 가져오기
	@GetMapping("list")
	public String list(Model model) {
		//리스트 불러오기
		ArrayList<EmpDto> list = empService.list();
		model.addAttribute("list",list);
		return "list";
	}
	
	//사원정보 가져오기
	@GetMapping("list2")
	public String list2(Model model) {
		ArrayList<EmpDeptDto> list = empService.list2();
		model.addAttribute("list",list);
		return "list2";
	}//list2
	//사원정보 가져오기
	@GetMapping("list3")
	public String list3(Model model) {
		ArrayList<MemBoardDto> list = mbService.list3();
		
		model.addAttribute("list",list);
		return "list3";
	}//list3
	
	public String list4(Model model) {
		ArrayList<MemBoardDto> list = mbService.list4();
		System.out.println(" FController list4"+list);
		model.addAttribute("list"+list);
		return "list4";
		
	}
	
	
	
}
