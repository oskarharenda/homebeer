<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
dodawanie przpisu:
<form:form modelAttribute="data" method="post" action="/recipe/add">
    <p>nazwa przepisu: <form:input path="name"/></p>
    <p>składniki: <form:input path="ingredients"/></p>
    <p>opis: <form:input path="description"/></p>
    <p><button type="submit">dodaj przepis</button> </p>
</form:form>
</body>
</html>
