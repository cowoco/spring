package com.java.dto;

import lombok.Data;

public class kakaoDto {
	
	public Long id;
	public String connected_at;
	public Properties properties;
	public Kakao_account kakao_account;
	
	public class Properties{
		public String nickname;
		public String profile_image;
		public String thumbnail_image;
		
	}
	
	
	public class Kakao_account{
		public boolean profile_nickname_needs_agreement;
		public boolean profile_image_needs_agreement;
		public boolean profile;
		//설정안함으로 되어 있음 - 생략가능 
		
		
		
	}
	
	
	

	

}
