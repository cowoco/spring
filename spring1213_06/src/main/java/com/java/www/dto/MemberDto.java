package com.java.www.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //전체 
@NoArgsConstructor //기본

public class MemberDto {
	
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;
	private Timestamp mdate;
	
	
	

}
