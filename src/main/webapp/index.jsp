<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pets</title>
</head>
<body>
<h2>Pets List</h2>
<p><a href='<c:url value="/create" />'>Add new pet</a></p><br>
<table>
    <tr>
        <th>Type</th>
        <th>name</th>
        <th>age</th>
        <th>color</th>
        <th>owner</th>
    </tr>
    <c:forEach var="pet" items="${pets}">
        <tr>
            <td>${pet.typePet}</td>
            <td>${pet.name}</td>
            <td>${pet.age}</td>
            <td>${pet.color}</td>
            <td>${pet.ownerStatus}</td>
            <td>
                <a href='<c:url value="/edit?id=${pet.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${pet.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>