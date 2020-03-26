<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="recipes" method="post" action="/opinion/add">
<c:forEach var="name" items="${recipes}">

    nazwa: ${name.name}
    opis: ${name.description}
    składniki: ${name.ingredients}
    <p><button type="submit">dodaj opinie </button> </p>
    <br>

</c:forEach>
</form:form>
</body>
</html>
