package com.java.www.controller;



import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.www.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller

public class MController {
	
	//
	@GetMapping("member/memberInsert")
	public String memberInsert(Model model) {
		return "member/memberInsert";
	}// memberInsert
	@GetMapping("member/login")
	public String login(Model model) {
		return "member/login";
	}// memberInsert
	@PostMapping("member/doLogin")
	public String doLogin(@RequestParam("id") String id,
			String pw,
			@RequestParam(defaultValue = "1") int bno,Model model) {
		System.out.println("controller id "+id);
		System.out.println("controller pw "+pw);
		System.out.println("controller pw "+bno);
		return "/index";
	}// memberInsert
	
	
	
	
	
	
	@PostMapping("doMemberInsert")
	public String memberInsert(HttpServletRequest request,Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		System.out.printf("%s,%s,%s,%s,%s,%s",id,pw,name,phone,gender,
				Arrays.toString(hobbys));
		return "member/memberView";
	}// memberInsert
	
	
	
	@GetMapping("memberUpdate")
	public String memberUpdate(Model model) {
		//id를 전달
		//request.setAttribute("id", id);
		//MemberDto mdto = new MemberDto();
		//현재 날씨와 시간을Timestamp파일에 저장
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		MemberDto mdto 
		= new MemberDto("ta", "1111", "타마라", "010-1111-1111", "Female", "golf,book", mdate);
		System.out.println("MemberDto id : "+mdto.getId());
		
		//mdto.setMdate(null);
		//model.addAttribute("id",id);
		model.addAttribute("mdto",mdto);
		return "member/memberUpdate";
	}// memberInsert
	
//	//ModelAndView 사용
//	@GetMapping("memberInsert")
//	public ModelAndView memberInsert() {
//		ModelAndView mv = new ModelAndView();
//		//id를 전달
//		String id ="admin";
//		//request.setAttribute("id", id);
//		//MemberDto mdto = new MemberDto();
//		//현재 날씨와 시간을Timestamp파일에 저장
//		Timestamp mdate = new Timestamp(System.currentTimeMillis());
//		MemberDto mdto 
//		= new MemberDto("ta", "1111", "타마라", "010-1111-1111", "Female", "game,golf", mdate);
//		System.out.println("MemberDto id : "+mdto.getId());
//		
//		//mdto.setMdate(null);
//		//model.addAttribute("id",id);
//		mv.addObject("mdto",mdto);
//		mv.setViewName("member/memberInsert");
//		return mv;
//	}// memberInsert

}
