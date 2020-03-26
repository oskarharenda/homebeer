<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: oskar
  Date: 24.03.2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<security:authorize access="isAuthenticated()">
    tylko dla zalogowanych:

    Witaj:
    ${username1}
    ${username2}
</security:authorize>
<security:authorize access="!isAuthenticated()">
    dla niezalogowanych
</security:authorize>


</body>
</html>
