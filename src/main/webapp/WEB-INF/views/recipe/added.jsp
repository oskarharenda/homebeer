<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
dodano przpis: <br>
nazwa: ${recipe.name}
składniki: ${recipe.ingredients}
opis: ${recipe.description}
utworzono: ${recipe.createdDate}

</body>
</html>
