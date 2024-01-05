package com.java.www.service;

import com.java.www.dto.MemberDto2;
import com.java.www.dto.MemberDto;

public interface MService {
	
	//로그인 확인
	int login(MemberDto2 mdto2);
	
	
	//아이디 찾기
	int idsearch(MemberDto2 mdto2);

	//비밀번호 찾기
	String pwsearch(String id, String email);

	//에이젝으로 아이디찾기 -name,email
	MemberDto2 idsearch(String name, String email);

	//아이디 중복확인
	String IdCheck(MemberDto2 mdto2);

}
