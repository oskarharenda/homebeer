<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">strona startowa</a><br>
<a href="${pageContext.request.contextPath}/recipe/all">Zobacz wszystkie przepisy</a><br>
<a href="${pageContext.request.contextPath}/recipe/user">Zobacz swoje przepisy</a><br><br>
Edytujesz przpis:${recipe.name}<br>
aktualne składniki: ${recipe.ingredients}<br>
aktualny opis:${recipe.description}<br><br>

<form:form modelAttribute="userRecipe" method="post" action="/recipe/edit/${userId}">
    <p>Nowa nazwa przepisu: <form:input path="name"/></p>
    <p>Nowe składniki: <form:input path="ingredients"/></p>
    <p>Nowy opis: <form:input path="description"/></p>
    <p><button type="submit">edytuj</button> </p>
</form:form>
</body>
</html>
