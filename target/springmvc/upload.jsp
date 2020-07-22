<%--
  Created by IntelliJ IDEA.
  User: 公仔aa
  Date: 2020/7/21
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="img"/>
    <input type="submit" value="上传"/>
</form>
<img src="${path}">
</body>
</html>
