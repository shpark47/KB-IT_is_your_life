<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>getParameterValues 실습</h1>
    <fieldset>
        <legend>좋아하는 운동 및 성별</legend>
        <form action="sports" method="post">
            <label>
                야구 <input type="checkbox" name="sports" value="야구"/>
            </label>
            <label>
                축구 <input type="checkbox" name="sports" value="축구"/>
            </label>
            <label>
                농구 <input type="checkbox" name="sports" value="농구"/>
            </label>
            <br/>
            <label>
                남 <input type="radio" name="sex" value="남자"/>
            </label>
            <label>
                여 <input type="radio" name="sex" value="여자"/>
            </label>
            <input type="submit" value="전송"/>
        </form>
    </fieldset>
</body>
</html>
