package com.java.www.controller;


import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.BoardDto;
import com.java.www.dto.MemberDto;

import jakarta.security.auth.message.callback.SecretKeyCallback.Request;

@Controller
@RequestMapping("member")
public class MemberController {
	

	
	@RequestMapping("mInsert")
	public String mInsert() {
		return"member/memberInsert";
	}
	@RequestMapping("doMUpdate")
	public String doMUpdate(MemberDto mdto
			,Model model) {
		
	
		model.addAttribute("mdto",mdto);
		return"member/memberUpdate";
	}
	
	
	@RequestMapping("doMInsert")
	public String doMInsert(MemberDto memberDto
			,Model model) {
	System.out.println(memberDto.getId());
	
	String id = memberDto.getId();
	String pw = memberDto.getPw();
	String name = memberDto.getName();
	String phone = memberDto.getPhone();
	String gender = memberDto.getGender();
	String hobby = memberDto.getHobby();
	Timestamp mdate = new Timestamp(System.currentTimeMillis());

		
	MemberDto mdto = new MemberDto( id, pw, name, phone, gender, hobby, mdate);	
	
	model.addAttribute("mdto",mdto);
		return"member/memberView";
	}//doMInsert
	

	
	@RequestMapping("login")
	public String login() {
		return"member/login";
	}
	@PostMapping("doLogin")
	public String doLogin(MemberDto memberDto
			,BoardDto boardDto
			,Model model) {
		
		System.out.println("controller id : "+memberDto.getId());
		System.out.println("controller pw : "+memberDto.getPw());
		System.out.println("controller bno : "+boardDto.getBno()); 
		
		String id = memberDto.getId();
		String pw = memberDto.getPw();
		int bno = boardDto.getBno();
		
		
		MemberDto mdto = new MemberDto();
		mdto.setId(id);
		System.out.println("mdto.getId :"+mdto.getId());
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		//전체생성자
		MemberDto mdto2 = new MemberDto(id, pw, "타마라", "010-1111-1111",
				"Female", "golf,book", mdate);
		//부분생성자
		MemberDto mdto3 = MemberDto.builder().id(id).pw(pw)
				.name("유관순").gender("female").build();
		
		System.out.println("FController  mdto3 name : "+mdto3.getName());
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("bno",bno);
		model.addAttribute("mdto",memberDto);
		
		
		return"member/doLogin";
		
		
		
	}

}
