<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="data" method="post" action="/register">
    <p>Nazwa Urzytkownika: <form:input path="username"/></p>
    <p>Email:<form:input path="email"/></p>
    <p>Hasło: <form:password path="password"/></p>
    <p>Imię: <form:input path="firstName"/></p>
    <p>Nazwisko: <form:input path="lastName"/></p>
    <p><button type="submit">Zarejestruj</button> </p>
    <security:csrfInput/>
</form:form>
</body>
</html>
