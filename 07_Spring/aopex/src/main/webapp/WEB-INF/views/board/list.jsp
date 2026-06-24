<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>게시글 목록</title>
</head>
<body>

<h2>게시글 목록</h2>

<a href="${pageContext.request.contextPath}/board/register">
    글쓰기
</a>

<table border="1">

    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
    </tr>

    <c:forEach items="${list}" var="board">

        <tr>

            <td>${board.no}</td>

            <td>
                <a href="${pageContext.request.contextPath}/board/read?no=${board.no}">
                        ${board.title}
                </a>
            </td>

            <td>${board.writer}</td>

        </tr>

    </c:forEach>

</table>

</body>
</html>