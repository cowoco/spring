<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>map</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	f6b278f5c975f9a60b956c6a7f757ebc"></script>
		<script src="/js/daum_api.js"></script>
		<style type="text/css">
			*{margin:0; padding: 0;  }
			#map{border: 3px solid black;}
			#header{width: 100%; height: 80px; text-align:center; margin-top: 50px;}
			.overlaybox {position:relative;width:360px;height:350px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/box_movie.png') no-repeat;padding:15px 10px;}
			.overlaybox div, ul {overflow:hidden;margin:0;padding:0;}
			.overlaybox li {list-style: none;}
			.overlaybox .boxtitle {color:#fff;font-size:16px;font-weight:bold;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png') no-repeat right 120px center;margin-bottom:8px;}
			.overlaybox .first {position:relative;width:247px;height:136px;background: url('https://scontent-ssn1-1.xx.fbcdn.net/v/t39.30808-6/347266646_7005354156160887_2968602653533950769_n.png?stp=dst-png_s320x320&_nc_cat=110&ccb=1-7&_nc_sid=16e3db&_nc_ohc=hOr-JNValxEAX-GUYEy&_nc_ht=scontent-ssn1-1.xx&oh=00_AfCEQXiC04DblpdmcSfWX62MUUIRg3vOTaql2gDxJ8GZYg&oe=659C0C8A') no-repeat;margin-bottom:8px;}
			.first .text {color:#fff;font-weight:bold;}
			.first .triangle {position:absolute;width:48px;height:48px;top:0;left:0;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/triangle.png') no-repeat; padding:6px;font-size:18px;}
			.first .movietitle {position:absolute;width:100%;bottom:0;background:rgba(0,0,0,0.4);padding:7px 15px;font-size:14px;}
			.overlaybox ul {width:247px;}
			.overlaybox li {position:relative;margin-bottom:2px;background:#2b2d36;padding:5px 10px;color:#aaabaf;line-height: 1;}
			.overlaybox li span {display:inline-block;}
			.overlaybox li .number {font-size:16px;font-weight:bold;}
			.overlaybox li .title {font-size:13px;}
			.overlaybox ul .arrow {position:absolute;margin-top:8px;right:25px;width:5px;height:3px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/updown.png') no-repeat;} 
			.overlaybox li .up {background-position:0 -40px;}
			.overlaybox li .down {background-position:0 -60px;}
			.overlaybox li .count {position:absolute;margin-top:5px;right:15px;font-size:10px;}
			.overlaybox li:hover {color:#fff;background:#d24545;}
			.overlaybox li:hover .up {background-position:0 0px;}
			.overlaybox li:hover .down {background-position:0 -20px;}   
		</style>
		<script type="text/javascript">
		
		</script>
		
		
	</head>
	<body>
		<div id="header" ><h1>다음지도 api</h1>
		<button id="daumMapBtn">버튼</button></div>
		<div id="map" style="width:100%;height:700px;"></div>
		
	</body>
</html>