<%--
  Created by IntelliJ IDEA.
  User: oskar
  Date: 27.03.2020
  Time: 08:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Dodano opinię do przepisu: ${recipe.name}<br><br>
<a href="${pageContext.request.contextPath}/recipe/all">Zobacz wszystkie przepisy</a><br>
<a href="${pageContext.request.contextPath}/recipe/user">Zobacz swoje przepisy</a><br><br>
</body>
</html>
