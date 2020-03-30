<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allByRate</title>
</head>
<body>
<c:forEach items="${sorted}" var="recipe">
    nazwa: ${recipe.name} <br>
    średnia: ${recipe.avgNotes}<br><br>
</c:forEach>
</body>
</html>
