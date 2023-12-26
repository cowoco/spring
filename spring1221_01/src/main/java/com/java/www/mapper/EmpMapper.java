package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmpDto;

@Mapper
public interface EmpMapper {

	ArrayList<EmpDto> list();

	ArrayList<EmpDeptDto> list2();
	

}
