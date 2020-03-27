<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addOpinion</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">strona startowa</a><br>
<a href="${pageContext.request.contextPath}/recipe/all">Zobacz wszystkie przepisy</a><br>
<a href="${pageContext.request.contextPath}/recipe/user">Zobacz swoje przepisy</a><br><br>
Przpis ${recipe.name}
<br>
Opis: ${recipe.description}
<br><br>

<c:forEach items="${opinions}" var="op">
    opinia: ${op.description}<br>
    ocena: ${op.note}<br>
    <br><br>
</c:forEach>
<br><br><br>
Dodaj opinie do przepisu:
<form:form modelAttribute="opinion" method="post"  action="/opinion/add/${recipe.id}">

    <p>opis: <form:input path="description"/></p>
    <p>ocena: <form:select path="note">
        <c:forEach var="i" begin="1" end="10">
        <form:option value="${i}"/>
        </c:forEach>
    </form:select>
    </p>
<%--    <p>opis: <form:input path="note"/></p>--%>
    <p><button type="submit">dodaj opinie</button> </p>
</form:form>
</body>
</html>
