package com.java.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.Message.RecipientType;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;

@Service

public class EmailServiceInpl implements EmailService {
	
	//이메일발송 객체
		@Autowired JavaMailSender mailSender;
		@Autowired HttpSession session;
		
		//이메일 발송 - html
		@Override
		@Async     //비동기 처리
		public String emailSend2(String name, String email) {
			System.out.println("EmailServiceImpl emailSend email : "+email);
			//인증코드 생성
			String pwcode = getCreateKey();
			
			//이메일 전송
			MimeMessage message = mailSender.createMimeMessage();
			try {
				message.setSubject("[인증번호] 홍길동님 회원가입 이메일 인증코드 발송","utf-8"); //제목
				String htmlData="<table align='center' style='margin:0 0 0 40px;border:1px #D9D9D9 solid;'>\r\n"
						+ "			<tr>\r\n"
						+ "				<td style='width:618px;height:220px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;background:#F9F9F9;'>\r\n"
						+ "					<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;'><img src='https://cfm.kt.com/images/v2/layout/gnb-ktlogo.png' alt='비밀번호 찾기를 요청하셨습니다.'/></p>\r\n"
						+ "					<p style='width:620px;margin:10px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1;'>아래의 인증코드는 회원가입에 필요한 인증코드입니다.</p>\r\n"
						+ "					<p style='width:620px;margin:28px 0 0 0;padding:0;text-align:center;color:#666666;font-size:12px;line-height:1;'><strong>회원가입 인증코드 : <span style='color:#F7703C;line-height:1;'>"+pwcode+"</span></strong></p>\r\n"
						+ "					<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1.4;'>회원가입에 필요한 인증코드를 발송해 드렸습니다.<br/>인증코드를 인증번호 입력에 넣고 인증번호 확인 버튼을 클릭해주세요.</p>\r\n"
						+ "				</td>\r\n"
						+ "			</tr>\r\n"
						+ "			</table>	";
			message.setText(htmlData,"utf-8","html");					 //내용
			message.setFrom(new InternetAddress("fbwogur12@naver.com")); //보내는 사람
			message.addRecipient(RecipientType.TO, new InternetAddress(email)); //받는사람
			mailSender.send(message);
			session.setAttribute("email_pwcode", pwcode);
		
			
			
			
		} catch (MessagingException e) {e.printStackTrace();}
		
		//이메일 전송
		System.out.println("email 발송 완료!!!");
		
	
		return pwcode;
	}
	
	
	@Override//text 이메일 발송
	public String emailSend(String name, String email) {
		System.out.println("EmailServiceInpl email : "+email);
		//인증코드 생성
		String pwcode = getCreateKey();
		
		//이메일 전송
 		SimpleMailMessage message = new SimpleMailMessage();
 		message.setTo(email);
 		message.setFrom("fbwogur12@naver.com"); //네이버 주소입력
 		message.setSubject(name+" 님 회원 인증번호 발송합니다.");
 		message.setText("안녕하세요. 회원가입에 필요한 이메일 인증코드를 \n"
 				+"이메일로 발송합니다. \n"
 				+name+"님의 이메일 발송번호 : "+pwcode
 				);
 		
 		mailSender.send(message);
 		System.out.println("email 발송 완료!!!");
		
		
		return null;
	}
	
	public String getCreateKey() {
		String pwcode="";
		char[] charSet = new char[] {
				'0','1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f','g','h','i','j',
				'k','l','m','n','o','p','q','r','s','t',
				'u','v','w','x','y','z'
				
				
		};
		int idx = 0;
		for(int i=0; i<6; i++) {
			idx = (int)(Math.random()*36);
			if(i>=8) {
				pwcode += "*";
			}else {
				pwcode += charSet[idx];
			}
			
			//darga783**
			
		}
		System.out.println("비밀번호 인증코드 : "+pwcode);
		
		return pwcode;
	}


	
}
