<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/recipe/all">Zobacz wszystkie przepisy</a><br>
<a href="${pageContext.request.contextPath}/recipe/add">Dodaj przepis</a><br>
<a href="${pageContext.request.contextPath}/">strona startowa</a><br>
<table>
    <tr>
    <th>nazwa</th>
    <th>składniki</th>
    <th>opis</th>
    </tr>
        <c:forEach var="recipe" items="${userRecipes}">
            <form:form modelAttribute="userRecipe" method="get">
                <tr>
                    <td>${recipe.name}</td>
                    <td>${recipe.ingredients}</td>
                    <td>${recipe.description}</td>
                    <td><p><button type="submit" formaction="/recipe/edit/${recipe.id}">edytuj przepis </button> </p></td>
                </tr>
            </form:form>

        </c:forEach>
</table>

</body>
</html>
