<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 19.09.2017
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/load">
    <input type="file" name="file"/>
    <input type="submit" value="ok">
</form>
</body>
</html>
