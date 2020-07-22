<%--
  Created by IntelliJ IDEA.
  User: 公仔aa
  Date: 2020/7/13
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/data/map" method="post">
    用户1编号：<input type="text" name="users['a'].id"/><br/>
    用户1名称：<input type="text" name="users['a'].name"/><br/>
    用户2编号：<input type="text" name="users['b'].id"/><br/>
    用户2名称：<input type="text" name="users['b'].name"/><br/>
    用户3编号：<input type="text" name="users['c'].id"/><br/>
    用户3名称：<input type="text" name="users['c'].name"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
