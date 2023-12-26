<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/read.css">
 
</head>
<body>
<section>
    <h1>NOTICE</h1>
	<form action="" id="bFrm" name="bFrm" method="post">
	<input type="hidden" name="bno" value="${map.bdto.bno}">
    <table>
       <colgroup>
        <col width="15%">
        <col width="50%">
        <col width="15%">
        <col width="20%">
      </colgroup>
       <tr>
      	 <th><strong>글번호</strong></th>
          <th colspan="3">${map.bdto.bno }</th>
      </tr>
      <tr>
      	<td><strong>제목</strong> </td>
        <td colspan="3">${map.bdto.btitle}</td>
      </tr>
      <tr>
        <td><strong>작성자</strong></td>
        <td>${map.bdto.id}</td>
        <td>조회수</td>
        <td>${map.bdto.bhit}</td>
      </tr>
      <tr>
        <td colspan="4" class="article">${map.bdto.bcontent }</td>
      </tr>
      <tr>
      <tr>
      	<td><strong>파일이름</strong> </td>
        <td colspan="4">${map.bdto.bfile }</td>
      </tr>
      <tr>
      	<td><strong>이미지</strong></td>
      	<td colspan="3">
      	<c:if test="${map.bdto.bfile !=null }">
      		<img src="/upload/${map.bdto.bfile}"></td>
      	</c:if>
      	<c:if test="${map.bdo.bfile == null }">
      		첨부된 파일이 없습니다.
      	</c:if>
      </tr>
      <tr>
        <td><strong>다음글</strong></td>
        <td colspan="3">
        <a href="bView?bno=${map.nextdto.bno}">${map.nextdto.btitle }</a>
      </tr>
      <tr>
        <td><strong>이전글</strong></td>
        <td colspan="3">
        <a href="bView?bno=${map.prevdto.bno }">${map.prevdto.btitle }</a>
      </tr>
     
    </table>
     <script>
  	$(function(){
  		$(".updateBtn").click(function(){
  			alert("수정페이지로 이동합니다");
  			$("#bFrm").attr("action","bUpdate").submit();
  		});
  		
  		
  		$(".delBtn").click(function(){
  			if(confirm("게시글을 삭제하시겠습니까?")){
    			$("#bFrm").attr("action","bDelete").submit(); //bDelete 페이지 전송
  			
  			}
  		});
  	});
  
  </script>

     <a href="bList"><div class="list">목록</div></a>
     <div class="list delBtn" style="cursor: pointer;">삭제</div>
	 <div class="list updateBtn">수정</div>
     <div class="list replyBtn">답변달기</div>
    </form>
  </section>
</body>
</html>