<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addOpinion</title>
</head>
<body>
Dodaj opinie do przepisu: ${recipe.name}

<form:form modelAttribute="opinion" method="post"  action="/opinion/add">

    <p>opis: <form:input path="description"/></p>
    <p>opis: <form:input path="note"/></p>
    <p><button type="submit">dodaj opinie</button> </p>
</form:form>
</body>
</html>
