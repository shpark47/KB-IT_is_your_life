<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2026-06-24
  Time: 오후 4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/board/register"
      method="post"
      enctype="multipart/form-data">

    제목 :
    <input type="text" name="title">

    작성자 :
    <input type="text" name="writer">

    내용 :
    <textarea name="content"></textarea>

    파일 :
    <input type="file"
           name="uploadFile">

    <button type="submit">
        등록
    </button>

</form>
</body>
</html>
