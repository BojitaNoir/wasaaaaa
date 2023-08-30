
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
<div>
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
                    <th>Acciones</th>
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
                        <td>
                            <form method="get" action="/user/view-class">
                            <input hidden value="${clas.classId}" name="id">
                            <button type="submit" class="btn btn-outline-warning btn-sm">
                                Inscribirse
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


</body>
</html>
