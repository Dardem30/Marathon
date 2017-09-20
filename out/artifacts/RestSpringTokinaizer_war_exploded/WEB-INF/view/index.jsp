<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 18.09.2017
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/check">
    <input type="file" name="file"/>
    <input type="submit" name="words" value="words">
    <input type="submit" name="brackets" value="brackets">
</form>
<h3>${s}</h3>
<table>
    <tr>
        <td>word</td>
    </tr>
    <c:forEach items="${list}" var="word">
        <tr>
            <td>${word}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
