package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService mService;
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	//-----로그인 확인부분
	//-------ajax형태
	
	
	@PostMapping("loginCheck")
	@ResponseBody
	public String loginCheck(MemberDto mdto) {
		System.out.println("MController loginCheck id : "+mdto.getId());
		
		//service연결 -로그인 확인
		String result =mService.loginCheck(mdto);
		
		return result;
	}
	//회원가입 폼 페이지 열기
	@GetMapping("step03")
	public String step03() {
		return "member/step03";
	}
	//회원가입 저장
	@PostMapping("step03")
	@ResponseBody
	public String step03(MemberDto mdto) {
		System.out.println("MController step03  id"+mdto.getId());
		//db전송
		String result = mService.step03(mdto);
		
		
		return result;
	}

	

}
