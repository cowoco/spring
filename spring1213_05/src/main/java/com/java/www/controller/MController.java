package com.java.www.controller;




import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("member")
public class MController {
	
	
	@GetMapping("memberInsert")
	public String memberInsert(Model model) {
		//id를 전달
		String id ="admin";
		//request.setAttribute("id", id);
		//MemberDto mdto = new MemberDto();
		//현재 날씨와 시간을Timestamp파일에 저장
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		MemberDto mdto 
		= new MemberDto("aaa", "1111", "홍길동", "010-1111-1111", "Male", "game,golf", mdate);
		
		//mdto.setMdate(null);
		//model.addAttribute("id",id);
		model.addAttribute("mdto",mdto);

		System.out.println("MemberDto id : "+mdto.getId());
		return "member/memberInsert";
	}// memberInsert

}
