package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService mService;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	@RequestMapping("doLogin")
	public String doLogin(MemberDto mdto,Model model) {
		int result = 0;
		System.out.println("MController id : "+mdto.getId());
		System.out.println("MController pw : "+mdto.getPw());
		//db연결 - 리턴값:dto dto가있는지 확인.
		MemberDto memberDto = mService.loginSelect(mdto); //id,pw
		
		  if(memberDto!=null) { //session.setAttribute("session", mdto.getId());
		  System.out.println("MController id 있음 : "+memberDto.getId());
		  result = 1;
		  }else { System.out.println("MController memberDto :null "); }
		 
		
		
		model.addAttribute("result",result);
		
		return "member/doLogin";
	}

}
