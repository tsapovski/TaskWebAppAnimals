<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit pet</title>
</head>
<body>
<h3>Edit pet</h3>
<form method="post">
  <input type="hidden" value="${pet.id}" name="id"/><br>
  <label>Type</label><br>
  <input Name="typePet" value="${pet.typePet}"/><br>
  <label>Name</label><br>
  <input name="name" value="${pet.name}" /><br>
  <label>Age</label><br>
  <input name="age" value="${pet.age}" type="number"/><br>
  <label>Color</label><br>
  <input name="color" value="${pet.color}" /><br>
  <label>Owner</label><br>
  <input name="ownerStatus" value="${pet.ownerStatus}" /><br>
  <input type="submit" value="Send" />
</form>
</body>
</html>