package com.java.www.service;

import com.java.www.dto.MemberDto;

public interface MService {

	//로그인 확인
	String loginCheck(MemberDto mdto);
	//회원가입 정보 저장
	String step03(MemberDto mdto);

}
