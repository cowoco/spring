<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<title>1221 01</title>
	</head>
	<body>
	<h1>1221 01index 페이지 입니다</h1>
		<ul>
			<c:if test="${session_id==null }">
				<li><strong style="font-size: 20px">로그인을 해주세요.</strong></li>
				<a href="member/login"><li>로그인</li></a>
			</c:if>
			<c:if test="${session_id!=null }">
				<li><strong style="font-size: 20px">${session_name }님 환영합니다.</strong></li>
				<a href="member/logout"><li>로그아웃</li></a>
			</c:if>
			<a href="list"><li>사원 리스트(List)</li><a>
			<a href="list2"><li>사원 부서리스트(List2)</li><a>
			<a href="list3"><li>멤버 보드 리스트(List3)</li><a>
			<a href="list4"><li>멤버 보드 리스트(List4)</li><a>
			<br>
			<a href="mInsert"><li>회원가입</li><a>
			<a href="boardBno"><li>글번호</li><a>
			<a href="bInsert"><li>공지사항글쓰기(Insert)</li><a>
			<a href="bView"><li>공지사항보기(View)</li><a>
			<br>
			<a href="board/bInsert2"><li>다중 업로드</li><a>
			<a href="board/bList2"><li>다중 업로드 리스트(List)</li><a>
		</ul>
	</body>
</html>