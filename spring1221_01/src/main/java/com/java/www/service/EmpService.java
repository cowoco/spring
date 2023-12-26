package com.java.www.service;

import java.util.ArrayList;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmpDto;

public interface EmpService {
	
	//사원정보 가져오기
	ArrayList<EmpDto> list();
	
	//사원, 부서정보 가져오기
	ArrayList<EmpDeptDto> list2();

}
