<%--
  Created by IntelliJ IDEA.
  User: 公仔aa
  Date: 2020/7/15
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${requestScope.user}
${sessionScope.user}
${applicationScope.user}
</body>
</html>
