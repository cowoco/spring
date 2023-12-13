package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("notice")
public class NController {
	
	@RequestMapping("noInsert")
	public String noInsert() {
		return "notice/noInsert";
	}
	
	@RequestMapping("noList")
	public String noList() {
		return "notice/noList";
	}
	@RequestMapping("noView")
	public String noView() {
		return "notice/noView";
	}

}
