<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
    <th>nazwa</th>
    <th>składniki</th>
    <th>opis</th>
    </tr>
        <c:forEach var="recipe" items="${userRecipes}">
            <tr>
            <td>${recipe.name}</td>
            <td>${recipe.ingredients}</td>
            <td>${recipe.description}</td>
            </tr>
        </c:forEach>
</table>

</body>
</html>
