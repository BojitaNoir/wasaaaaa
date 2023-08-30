<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>

<div class="position-absolute top-0 start-50 translate-middle">
<div class="card">
    <div class="card-body">
        <a href="/user/vista-crear-instructor" class="card-link">Registrar Instructor</a>
    </div>
</div>
<div class="card">
    <div class="card-body">
        <a href="/user/vista-crear-clase" class="card-link">Registrar Clase</a>
    </div>
</div>
</div>

<div class="col-10">
    <div class="card">
        <div class="card-header" >
            <div class="row">
                <div class="col" >Listado de usuarios</div>
            </div>
        </div>
        <table class="table table-stripped" id="userTable">
            <thead>
            <tr>
                <th>Nombre </th>
                <th>Apellidos</th>
                <th>Rol</th>
                <th>Correo</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}" varStatus="s">
                <tr>
                    <td>
                        <c:out value="${user.firstName}"/>
                    </td>
                    <td>
                        <c:out value="${user.lastName}"/>
                    </td>
                    <td>
                        <c:out value="${user.roleId}"/>
                    </td>
                    <td>
                        <c:out value="${user.email}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="col-10">
    <div class="card">
        <div class="card-header" >
            <div class="row">
                <div class="col" >Listado de Clases</div>
            </div>
        </div>
        <table class="table table-stripped" id="clasesTable">
            <thead>
            <tr>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Estatus</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="clas" items="${classes}" varStatus="a">
                <tr>
                    <td>
                        <c:out value="${clas.className}"/>
                    </td>
                    <td>
                        <c:out value="${clas.description}"/>
                    </td>
                    <td>
                        <c:out value="${clas.status}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<div class="card" style="width: 18rem;">
    <div class="card-header">
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item"><a href="/user/logut"><h2>Cerrar Sesion</h2></a></li>
        <li class="list-group-item"><a href="/user/view-createI"><h2>Crear Instructor</h2></a></li>
        <li class="list-group-item"><a href="/user/view-createC"><h2>Crear Clase</h2></a></li>
    </ul>
</div>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</body>
</html>
