package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@GetMapping("logout") //로그아웃
	public String logout() {
		session.invalidate();
		return "member/logout";
	}
	@PostMapping("login") //로그인 확인
	public String login(String id,String pw,Model model) {
		int result = mService.login(id,pw);
		
		System.out.println("MController id : "+id);
		System.out.println("MController result : "+result);
		model.addAttribute("result",result);
		return "member/doLogin";
	}//로그인 확인-login
	
	@GetMapping("mInsert") //회원가입 보기
	public String mInsert() {
	
		return "member/mInsert";
	}//mInsert
	@PostMapping("mInsert") //회원가입 저장
	@ResponseBody
	public String mInsert(MemberDto mdto) {
		System.out.println(" savebtn mdto id: "+mdto.getId());
		System.out.println(" savebtn mdto Gender: "+mdto.getGender());
		//db전송 
		String result = mService.mInsert(mdto);
		System.out.println("MController result"+result);
		
		return result;
	}//mInsert
	
	
	
	@PostMapping("idCheck") //ajax 로그인 아이디 체크
	@ResponseBody            //리턴을 jsp페이지가 아니라 data로 넘겨줌.
	public String idCheck(String id) {
		System.out.println("MController mdto id : "+id);
		//db전송
		String result = mService.idCheck(id);
		System.out.println("MController result : "+result);
	
		return result;
	}//

}
