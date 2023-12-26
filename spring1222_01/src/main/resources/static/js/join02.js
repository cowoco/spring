/**
 * 
 */
$(function(){
		$("#addressBtn").click(function(){
			  new daum.Postcode({
		        oncomplete: function(data) {
		            $("#f_postal").val(data.zonecode);
		            $("#address1").val(data.address);
		        }
		    }).open();
		});//addressBtn
	//-----------------------------------------------------
		$("#saveBtn").click(function(){
			if($("#name").val().length<2){
				alert("이름을 입력해주세요");
				$("#name").focus();
				return false;
			}
			
		});//saveBtn 회원가입시 이름을 입력해야만 넘어가게 하는거
	//------------------------------------------------------
	
		
		
		
	//-------------------------------------------------------

		$("#idChekBtn").click(function(){
			alert($("#id").val());
			//ajax  시작
			$.ajax({
				url:"/member/idCheck",
				type:"post",
				//data:{"id":$("#id").val()}, // from 데이터 한번에 전송  20개 id:aaa,pw:1111,name:홍길동,phone:010-1111-1111
				data:$("#agreeFrm").serialize(),								
				dataType:"text", //text,json.xml
				success:function(data){
					alert("성공");
					console.log("data : "+data);
				},
				error:function(){
					alert("실패")
				}
			});
			//ajax 끝
		});
		//$("#idChekBtn").click(()=>{ //익명함수,화살함구 6.0버전});
     //----------------------------------------------------------------------	
	
		
	});//end