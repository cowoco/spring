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
	
	
	
	@Override //로그인
	public int login(String id, String pw) {
		int result=0;
		//db
		MemberDto mdto = memberMapper.login(id,pw);
		if(mdto!=null) {
			result =1;
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
			System.out.println("mdto.getId()"+mdto.getId());
		}
		return result;
	}



	@Override //id check
	public String idCheck(String id) {
		String result ="사용불가";
		//db
		MemberDto mdto = memberMapper.idCheck(id);
		if(mdto ==null) result ="사용가능";
		return result;
	}



	@Override
	public String mInsert(MemberDto mdto) {
		String result= "가입완료";
		//db
		memberMapper.mInsert(mdto);
		if(mdto!=null) result="가입불가";
		
		System.out.println("MServiceImpl result : "+result);
		
		return result;
	}
	

}
