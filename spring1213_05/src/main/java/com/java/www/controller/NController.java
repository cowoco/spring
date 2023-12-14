package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.www.dto.MemberDto;
import com.java.www.dto.boardDto;

import jakarta.security.auth.message.callback.SecretKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("notice")
public class NController {

	@RequestMapping(method = RequestMethod.GET, value = "noticeList")
	public String noticeList() {
		return "notice/noticeList";
	}

	@GetMapping("noticeInsert")
	public String noticeInsert(Model model) {
		return "notice/noticeInsert";
	}
	/*
	 * @PostMapping("doNoticeInsert") public String
	 * doNoticeInsert(HttpServletRequest request, Model model){
	 * 
	 * String btitle = request.getParameter("btitle"); String bcontent =
	 * request.getParameter("bcontent"); String bfile =
	 * request.getParameter("bfile");
	 * System.out.printf("NController %s,%s,%s,",btitle,bcontent,bfile); return
	 * "notice/noticeView"; }
	 */

	@RequestMapping("doNoticeInsert") // GetMapping,PostMapping 둘다가능
	public String noticeView(HttpServletRequest request, Model model) {

		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		Timestamp bdate = new Timestamp(System.currentTimeMillis());
		String bfile = request.getParameter("bfile");
		boardDto bdto = boardDto.builder().btitle(btitle).bcontent(bcontent).bdate(bdate).bfile(bfile).build();

		model.addAttribute("bdto", bdto);
		return "notice/noticeView";
	}

	@RequestMapping("noticeView")
	public String noticeView(Model model) {
		return "notice/noticeView";

	}

}
