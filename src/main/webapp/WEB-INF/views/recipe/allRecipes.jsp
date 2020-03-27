<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">strona startowa</a><br>
<a href="${pageContext.request.contextPath}/recipe/user">Zobacz swoje przepisy</a><br><br>
<c:forEach var="name" items="${recipes}">



</c:forEach>

<c:forEach items="${recipes2}" var="recipe">

    <form:form modelAttribute="recipes" method="get">
        nazwa: ${recipe.key.name}<br>
        opis: ${recipe.key.description}<br>
        składniki: ${recipe.key.ingredients}<br>
        <br>
        Średnia ocena: ${recipe.value}<br>
        <p><button type="submit" formaction="/opinion/add/${recipe.key.id}">opinie </button> </p>
        <br>
    </form:form>
</c:forEach>
</body>
</html>
