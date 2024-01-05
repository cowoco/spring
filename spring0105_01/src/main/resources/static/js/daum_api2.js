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
				let movie = data.boxOfficeResult.dailyBoxOfficeList;
				alert("영화정보를 가져왔습니다.");
				console.log("영화정보 : "+data);
				console.log("영화정보 1순위 : "+movie[0].movieNm);
				console.log("영화정보 2순위 : "+movie[1].movieNm);
				console.log("영화정보 3순위 : "+movie[2].movieNm);
				console.log("영화정보 4순위 : "+movie[3].movieNm);
				console.log("영화정보 5순위 : "+movie[4].movieNm);
				// 커스텀 오버레이에 표시할 내용입니다     
				// HTML 문자열 또는 Dom Element 입니다 
				content = '<div class="overlaybox">' +
				    '    <div class="boxtitle">금주 영화순위</div>' +
				    '    <div class="first">' +
				    '        <div class="triangle text">1</div>' +
				    '        <div class="movietitle text">'+movie[0].movieNm+'</div>' +
				    '    </div>' +
				    '    <ul>' +
				    '        <li class="up">' +
				    '            <span class="number">2</span>' +
				    '            <span class="title">'+movie[1].movieNm+'</span>' +
				    '            <span class="arrow up"></span>' +
				    '            <span class="count">2</span>' +
				    '        </li>' +
				    '        <li>' +
				    '            <span class="number">3</span>' +
				    '            <span class="title">'+movie[2].movieNm+'</span>' +
				    '            <span class="arrow up"></span>' +
				    '            <span class="count">6</span>' +
				    '        </li>' +
				    '        <li>' +
				    '            <span class="number">4</span>' +
				    '            <span class="title">'+movie[3].movieNm+'</span>' +
				    '            <span class="arrow up"></span>' +
				    '            <span class="count">3</span>' +
				    '        </li>' +
				    '        <li>' +
				    '            <span class="number">5</span>' +
				    '            <span class="title">'+movie[4].movieNm+'</span>' +
				    '            <span class="arrow down"></span>' +
				    '            <span class="count">1</span>' +
				    '        </li>' +
				    '    </ul>' +
				    '</div>';
					
					 //jquery = $("#map") = document.getElementById('map');
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = { 
			        center: new kakao.maps.LatLng(37.502, 127.026581), // 지도의 중심좌표
			        level: 4 // 지도의 확대 레벨
			    };
			
			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			

			
			// 커스텀 오버레이가 표시될 위치입니다 
			var position = new kakao.maps.LatLng(37.49887, 127.026581);  
			
			
			console.log("오버레이 정보를 생성합니다.");
			// 커스텀 오버레이를 생성합니다
			var customOverlay = new kakao.maps.CustomOverlay({
			    position: position,
			    //content: screen_data(),
			    content: content,
			    xAnchor: 0.3,
			    yAnchor: 0.91
			});
			
			// 커스텀 오버레이를 지도에 표시합니다
			customOverlay.setMap(map);
				
			},
			error:function(){
				alert("실패");
			}
		});//aj
	
	
}

