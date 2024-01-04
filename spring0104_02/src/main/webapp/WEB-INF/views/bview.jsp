<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글수정</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<section>
    <h1>게시글</h1>
    <hr>

    <form action="modify.do" name="modify" method="post">
      <table>
      <input type="hidden" name="bId" value="">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
          	${bdto.id}
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            ${bdto.btitle }
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bContent" cols="50" rows="10">
             ${bdto.bcontent }
            </textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file">
            <img src="./upload/${bdto.bfile}">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write button">수정</button>
        <button type="button" class="cancel button" onclick="javascript:location.href='blist'">목록</button>
      </div>
    </form>

  </section>

</body>
</html>