package com.java.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	
	@Autowired BService bService;
	@Autowired HttpSession session;
	
	@RequestMapping({"/","main"})
	public String main() {
		
		return "main";
	}
	@GetMapping("map")
	public String map() {
		
		return "map";
	}
	@PostMapping("screenInfo")
	@ResponseBody
	public String screenInfo(String movie) throws Exception {
		System.out.println("test data: "+movie);
		// 영화 정보 api 가져오기
		String key = "c9508ba53d5c0c1147679398a58e954f";
		//오늘 날짜 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(System.currentTimeMillis());
		System.out.println("오늘 날짜 : "+today);
		
	  //-----
	   StringBuilder urlBuilder = new StringBuilder("https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"); /*URL*/
       urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "="+key); /*Service Key*/
       urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") + "=" + URLEncoder.encode("20240104", "UTF-8")); /*이부분 주석처리 : 공공데이터포털에서 받은 인증키*/
       //주석처리해야 함.
       urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
       urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
       urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*요청자료형식(XML/JSON)*/
       urlBuilder.append("&" + URLEncoder.encode("CURRENT_DATE","UTF-8") + "=" + URLEncoder.encode("2019122010", "UTF-8")); /*2016-12-01 01시부터 조회*/
       urlBuilder.append("&" + URLEncoder.encode("HOUR","UTF-8") + "=" + URLEncoder.encode("24", "UTF-8")); /*CURRENT_DATE부터 24시간 후까지의 자료 호출*/
       urlBuilder.append("&" + URLEncoder.encode("COURSE_ID","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*관광 코스ID*/
       URL url = new URL(urlBuilder.toString());
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       conn.setRequestMethod("GET");
       conn.setRequestProperty("Content-type", "application/json");
       System.out.println("Response code: " + conn.getResponseCode());
       BufferedReader rd;
       if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
           rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
       } else {
           rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
       }
       StringBuilder sb = new StringBuilder();
       String line;
       while ((line = rd.readLine()) != null) {
           sb.append(line);
       }
       rd.close();
       conn.disconnect();
       System.out.println(sb.toString());
       return sb.toString();
		
		
       //-----
	}
	
	@PostMapping("movieAPI")
	@ResponseBody
	public String movieAPI(String txt) throws Exception {
		String key="c9508ba53d5c0c1147679398a58e954f";
		
		
		StringBuilder urlBuilder = new StringBuilder("https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json");
        urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "="+key);
        urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") + "=" + URLEncoder.encode("20240104", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        //URL url = new URL("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=918RE13GA7OY7ZEmUzApgbOeAcQoZ%2FaHsXWcqPAKQ9YNNPj83KOstRMRIUrCFIAcm9qj2R6b7NFZjp%2FYsYzJLg%3D%3D&numOfRows=10&pageNo=2&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();  //String 을 계속 더하면 String변수를 계속 새롭게 만듬.
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line); //json데이터를 sb에 1줄씩 저장
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
		
		
		return sb.toString();
	}
	
	
	
	@GetMapping("bview")
	public String bview(@RequestParam(defaultValue = "1")int bno, Model model) {
		BoardDto bdto = bService.selectOne(bno);
		model.addAttribute("bdto",bdto);
		
		return "bview";
	}
	
	@GetMapping("bwrite")
	public String bwrite() {
		
		return "bwrite";
	}
	
	
	@PostMapping("uploadImage") //summernote 에서 ajax이미지 전송
	@ResponseBody
	public String uploadImage(@RequestPart MultipartFile file) throws Exception {
		String urlName ="";
		//파일서버로 전
		if(!file.isEmpty()) {
			String oriFileName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = time+"_"+oriFileName;
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+uploadFileName); //파일등록
			file.transferTo(f); //파일서버로 전송
			urlName = "/upload/"+uploadFileName;
			System.out.println("FController ajax 링크 전송"+urlName);
		}
		return urlName;
	}//uploadImage
	
	
	
	
	
	
	@PostMapping("bwrite") //글쓰기 저장
	public String bwrite(BoardDto bdto,@RequestPart MultipartFile file,Model model) throws Exception {
		System.out.println("controller bwrite btitle : "+bdto.getBtitle());
		
		if(!file.isEmpty()) {
			String oriFileName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = time+"_"+oriFileName;
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+uploadFileName); //파일등록
			file.transferTo(f); //파일서버로 전송
			
			bdto.setBfile(uploadFileName); //dtp bfile 이름저장
		}else {
			bdto.setBfile("");//dto bfile 이름저장
		}
		
		System.out.println("controller bwrite bfile : "+bdto.getBfile());
		
		//service연결 -글쓰기 저장
		bService.bwrite(bdto);
		
		model.addAttribute("result","success-bwrite");
		return "result";
	}//bwrite
	
	
	@RequestMapping("blist") //게시글 전체 가져오기
	public String blist(Model model) {
		List<BoardDto> list = bService.selectAll();
		model.addAttribute("list",list);
		return "blist";
	}
	

	

}
