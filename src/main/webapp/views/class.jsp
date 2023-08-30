
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>

<br>
<div class="card">
  <div class="card-header" >
    <div class="row">
      <div class="col" >Listado de usuarios en tu Clase</div>
    </div>
  </div>
  <table class="table table-stripped" id="userTable">
    <thead>
    <tr>
      <th>Nombre </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}" varStatus="s">
      <tr>
        <td>
          <c:out value="${user.firstName}"/>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">


</body>
</html>
