package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemberDto2;
import com.java.www.dto.MemberDto;

@Mapper
public interface MemberMapper {
	
	
	//로그인 확인 
	MemberDto2 login(MemberDto2 mdto2);
	
	//아이디 찾기
	MemberDto2 idsearch(MemberDto2 mdto2);
	

	//비밀번호 찾기 -아이디 이메일 검색
	MemberDto2 pwsearch(String id, String email);
	
	//패스워드 변경 -update
	void update_pw(String id, String pwcode);
	//아이디 찾기
	MemberDto2 idsearch(String name, String email);
	
	//아이디 중복확인
	MemberDto2 IdCheck(MemberDto2 mdto2);
	


}
