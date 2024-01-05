package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MServiceImpl implements MService {
	
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	HttpSession session;
	
	@Override
	public String loginCheck(MemberDto mdto) {
		//mapper 연결 
		MemberDto memberDto = memberMapper.loginCheck(mdto);
		String result ="";
		if(memberDto!= null) {
			result="로그인성공";
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
		}
		else result="로그인실패";
			
		
		
		return result;
	}

	@Override //
	public String step03(MemberDto mdto) {
		//db전송
		memberMapper.step03(mdto);
		String result ="가입완료";
		
		return result;
	}




}
