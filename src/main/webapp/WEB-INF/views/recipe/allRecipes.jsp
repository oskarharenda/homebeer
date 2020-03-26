<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="name" items="${recipes}">

    <form:form modelAttribute="recipes" method="get">
    nazwa: ${name.name}
    opis: ${name.description}
    składniki: ${name.ingredients}
    <p><button type="submit" formaction="/opinion/add/${name.id}">dodaj opinie </button> </p>
        <br>
    </form:form>

</c:forEach>
</body>
</html>
