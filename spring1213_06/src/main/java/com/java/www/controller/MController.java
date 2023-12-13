package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;

@Controller
@RequestMapping("member")
public class MController {
	
	@GetMapping("mInsert")
	public String mInsert(Model model) {
		
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		MemberDto mdto
		= new MemberDto("tara", "1111", "마라", "010-2222-2222", "Female", "book", mdate);
		
		model.addAttribute("mdto",mdto);
		System.out.println("MController name"+mdto.getName());
		
		
		return "member/mInsert";
	}

}
