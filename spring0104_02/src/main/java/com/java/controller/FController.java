package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired BService bService;
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	//리스트 불러오기
	@GetMapping("blist")
	public String blist(Model model) {
		List<BoardDto> list = bService.blist();
		System.out.println(list.get(0).getBtitle());
		model.addAttribute("list",list);
		return "blist";
	}
	//게시글 1개 가져오기
	@GetMapping("bview")
	public String bview(@RequestParam(defaultValue = "1")int bno,Model model) {
		BoardDto bdto = bService.selectOne(bno);
		model.addAttribute("bdto",bdto);
		
		System.out.println("bdot :"+bdto);
		return "bview";
	}
	//글쓰기 페이지 열기
	@GetMapping("bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	//파일업로드
	@PostMapping("bwrite")
	public String bwrite(BoardDto bdto,@RequestPart MultipartFile file,Model model) throws Exception {
		System.out.println("FController bdto btitle:"+bdto.getBtitle());
		System.out.println("FController bdto bcontent:"+bdto.getBcontent());
		if(!file.isEmpty()) {
			String oriFName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time+"_"+oriFName;
			String fupload = "c:/upload/";
			
			//파일 서버에 업로드 부분
			File f = new File(fupload+upFName);
			file.transferTo(f);
			//bdto bfile 추가
			bdto.setBfile(upFName);
			
			
			
		}else {
			bdto.setBfile("");
			
		}
			System.out.println("파일첨부 이름 : "+bdto.getBfile());
			//service연결 -파일저장
			bService.write(bdto);
			
			
			model.addAttribute("result","write-s");
			
		
		
		return "doFboard";
	}
	


}
