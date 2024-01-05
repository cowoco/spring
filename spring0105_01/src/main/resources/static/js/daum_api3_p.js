/**
 * 
 */
$(function(){
	//daum_api();
	//함수호출
	screen_data();
	//버튼 클릭시 가져오기
	/*	$("#daumMapBtn").click(()=>{
		alert("영화정보를 가져옵니다.");
			$.ajax({
				url:"../screenInfo",
				type:"post",
				dataType:"json",
				data:{"movie":"1"},
				success:function(data){
					alert("영화정보를 가져왔습니다.");
					console.log("영화정보 : "+data);
					console.log("영화정보 순위 : "+data.boxOfficeResult.dailyBoxOfficeList[0].rank);
					for(let i=0;i<5;i++){
						console.log("영화명 : "+data.boxOfficeResult.dailyBoxOfficeList[i].movieNm );
						
					}
				},
				error:function(){
					alert("실패");
				}
				
			});
		});
		
		*/
});//jq



//ajax으로 영화정보 가져오기 함수
function screen_data(){
		alert("영화정보와 다음지도를 가지고 옵니다.");
			
		$.ajax({
			url:"../screenInfo",
			type:"post",
			dataType:"json",
			data:{"movie":"1"},
			success:function(data){
				let m_data = data.boxOfficeResult.dailyBoxOfficeList;
				console.log("영화제목 1 : "+m_data[0].movieNm);
				
				//------- 다음지도 api
				
				
				
				
				
				
				//---------
				
				
			},
			error:function(){
				alert("실패");
			}
		});//aj
	
	
}

