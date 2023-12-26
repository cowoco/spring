/**
 * mInsert 회원가입 관련
 */
$(function(){
	//-------------------------------------------------------------------------------
	let chkKeyUp=0;
	//회원가입버튼 
	$("#savebtn").click(function(){
		if(chkKeyUp !=1){
			alert("아이디 중복확인을 하셔야 다음으로 진행가능합니다.");
			 return false;
		}
		//ajax  시작
		$.ajax({
			url:"/member/mInsert",
			type:"post",
			data:$("#memberFrm").serialize(), // from 데이터 한번에 전송  20개 id:aaa,pw:1111,name:홍길동,phone:010-1111-1111
			
			dataType:"text", //받는파일 형태 -text,json.xml
			success:function(data){
				alert("성공");
				console.log("data : "+data);
				if(data=="가입완료"){
					alert("회원가입이 완료 되었습니다.");
					location.href="/";
				}
			},
			error:function(){
				alert("실패")
			}
		});
		//ajax 끝
		
		
	});//savebtn
	
	
	//아이디 확인 버튼 클릭후 아이디가 수정되었는지 확인
	$("#id").keyup(function(){
		console.log("key up 발생");
		$("#chkTxt").text("아이디 중복체크를 하셔야 합니다.");
		$("#chkTxt").css({"color":"black","font-weight":"800"});
		chkKeyUp = 0;
	});
	
	
	
	
	$("#idCheckBtn").click(function(){
		//아이디 중복 체크 
		alert("아이디 중복 체크를 합니다.");
		console.log($("#id").val());
		//id가 있는지 체크
		if($("#id").val().length<1){
			alert("아이디를 입력하셔야 체크 가능합니다.");
			$("#id").focus();
			return false;
			
		}
		
		//ajax
		$.ajax({
			url:"/member/idCheck",
			type:"post",
			//data:$("memberFrm").serialize(), // from 데이터 한번에 전송  20개 id:aaa,pw:1111,name:홍길동,phone:010-1111-1111
			data:{"id":$("#id").val()}, //데이터를 개별적으로 보냄
			//contentType:"json", // 내가 보내는 파일 형태
			dataType:"text", //받는파일 형태 -text,json.xml
			success:function(data){
				alert("성공");
				if(data=="사용가능"){
					alert("아이디를 사용할 수 있습니다");
					$("#chkTxt").text("아이디 사용가능");
					$("#chkTxt").css({"color":"blue","font-weight":"800"});
				}else{
					alert("아이디를 사용할 수 없습니다");
					$("#chkTxt").text("아이디 사용불가");
					$("#chkTxt").css({"color":"red","font-weight":"800"});
				}
				
				console.log("data : "+data);
				chkKeyUp=1;
				
			},
			error:function(){
				alert("실패")
			}
			
			
		});
		//ajax 끝
		
	});
});