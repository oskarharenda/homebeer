<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/recipe/all">Zobacz wszystkie przepisy</a><br>
<a href="${pageContext.request.contextPath}/recipe/user">Zobacz swoje przepisy</a><br><br>
dodano przpis: <br>
nazwa: ${recipe.name}
składniki: ${recipe.ingredients}
opis: ${recipe.description}
utworzono: ${recipe.createdDate}

</body>
</html>
