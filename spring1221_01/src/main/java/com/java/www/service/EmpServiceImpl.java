package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmpDto;
import com.java.www.mapper.EmpMapper;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpMapper empMapper;
	
	@Override
	public ArrayList<EmpDto> list() {
		
		ArrayList<EmpDto> list = empMapper.list();
		return list;
	}
	//사원 부서정보 가져오기
	@Override
	public ArrayList<EmpDeptDto> list2() {
		ArrayList<EmpDeptDto> list = empMapper.list2();
		return list;
	}

}
