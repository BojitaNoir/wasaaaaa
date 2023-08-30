
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
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8 custom-card">
            <h2 class="mb-4">Listado de Clases</h2>
            <table class="table table-striped" id="clasesTable">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Estatus</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="clas" items="${classes}" varStatus="a">
                    <tr>
                        <td><c:out value="${clas.className}"/></td>
                        <td><c:out value="${clas.description}"/></td>
                        <td><c:out value="${clas.status}"/></td>
                        <td>
                            <form method="get" action="/user/view-class">
                                <input hidden value="${clas.classId}" name="id">
                                <button type="submit" class="btn btn-outline-warning btn-sm">
                                    Informacion
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="fixed-bottom text-center p-3">
    <a href="/user/logut" class="btn btn-secondary me-2">Cerrar Sesión</a>
</div>
</body>
</html>