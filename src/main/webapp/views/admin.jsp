<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .custom-card {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }
        .custom-list {
            list-style-type: none;
            padding: 0;
        }
        .custom-list-item {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8 custom-card">
            <div class="d-flex justify-content-between mb-3">
                <div class="h4">Bienvenido</div>
                <a href="/user/logut">Cerrar Sesión</a>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="card custom-list-item">
                        <div class="card-body">
                            <h5 class="card-title">Registrar Instructor</h5>
                            <a href="/user/view-createI" class="btn btn-primary">Ir</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card custom-list-item">
                        <div class="card-body">
                            <h5 class="card-title">Registrar Clase</h5>
                            <a href="/user/view-createC" class="btn btn-primary">Ir</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mt-4">
                <h3>Listado de Usuarios</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Rol</th>
                        <th>Correo</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${users}" varStatus="s">
                        <tr>
                            <td><c:out value="${user.firstName}"/></td>
                            <td><c:out value="${user.lastName}"/></td>
                            <td><c:out value="${user.roleId}"/></td>
                            <td><c:out value="${user.email}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="mt-4">
                <h3>Listado de Clases</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Estatus</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="clas" items="${classes}" varStatus="a">
                        <tr>
                            <td><c:out value="${clas.className}"/></td>
                            <td><c:out value="${clas.description}"/></td>
                            <td><c:out value="${clas.status}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>

