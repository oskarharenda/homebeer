<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<security:authorize access="isAuthenticated()">
    Witaj: ${username1}
    <br>
    <a href="${pageContext.request.contextPath}/recipe/all">Zobacz wszystkie przepisy</a><br>
    <a href="${pageContext.request.contextPath}/recipe/user">Zobacz swoje przepisy</a><br>
    <a href="${pageContext.request.contextPath}/recipe/add">Dodaj przepis</a><br>


</security:authorize>

<security:authorize access="!isAuthenticated()">
    Witaj:<br>
    <a href="${pageContext.request.contextPath}/login">zaloguj</a><br>
    <a href="${pageContext.request.contextPath}/register">zarejestruj</a><br>
    <a href="${pageContext.request.contextPath}/recipe/all">Zobacz przepisy</a><br>
</security:authorize>

<br><br>



</body>
</html>
