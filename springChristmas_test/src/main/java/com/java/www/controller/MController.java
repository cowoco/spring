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
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	}
	@RequestMapping("doLogin")
	public String doLogin(MemberDto mdto,Model model) {
		int result=0;
		//확인
		System.out.println("MController id :"+mdto.getId());
		//db연결
		MemberDto memberDto = mService.loginSelect(mdto);
		if(memberDto !=null) {
			session.setAttribute("session_id", memberDto.getId());
			session.setAttribute("session_name", memberDto.getName());
			result =1;
		}else {
			System.out.println("MController doLogin : null");
		}
		
		model.addAttribute("result",result);
		return "member/doLogin";
	}

}
