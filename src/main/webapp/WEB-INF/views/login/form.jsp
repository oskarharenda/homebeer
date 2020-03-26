<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<c:if test="${not empty param.logout}">
    <p>Zostałeś wylogowany</p>
</c:if>
<c:if test="${param.error != null}">
    Błędne dane logowania
</c:if>
    <form method="post" action="/login">
        <p>Nazwa urzytkownika: <input type="text" name="username"/></p>
        <p>Hasło: <input type="password" name="password"></p>
        <p><button type="submit">zaloguj</button> </p>
<security:csrfInput/>
    </form>

</body>
</html>
