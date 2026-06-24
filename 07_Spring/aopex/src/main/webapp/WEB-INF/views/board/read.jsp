<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>게시글 조회</title>
</head>
<body>

<h2>게시글 조회</h2>

<table border="1">

    <tr>
        <th>번호</th>
        <td>${board.no}</td>
    </tr>

    <tr>
        <th>제목</th>
        <td>${board.title}</td>
    </tr>

    <tr>
        <th>작성자</th>
        <td>${board.writer}</td>
    </tr>

    <tr>
        <th>내용</th>
        <td>${board.content}</td>
    </tr>

    <tr>
        <th>첨부파일</th>
        <td>

            <c:if test="${file != null}">
                <a href="${pageContext.request.contextPath}/board/download/${file.fileId}">
                        ${file.fileName}
                </a>
            </c:if>

            <c:if test="${file == null}">
                첨부파일 없음
            </c:if>

        </td>
    </tr>

</table>

<br>

<a href="${pageContext.request.contextPath}/board/list">
    목록
</a>

</body>
</html>