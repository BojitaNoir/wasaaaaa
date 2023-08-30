
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
<form class="needs-validation" action="/user/save-C" novalidate method="post">
    <div class="mb-3">
        <label for="nombreClase" class="form-label">Nombre de la Clase</label>
        <input type="text" class="form-control" id="nombreClase" name="nombreClase" required>
    </div>
    <div class="mb-3">
        <label for="descripcion" class="form-label">Descripción</label>
        <textarea class="form-control" id="descripcion" name="descripcion" required></textarea>
    </div>
    <div class="mb-3">
        <label for="instructor_id" class="form-label">ID del Instructor</label>
        <select class="form-select" id="instructor_id" name="instructorID">
            <c:forEach var="instructor" items="${instructors}" varStatus="s">
                <option value="<c:out value='${instructor.personId}'/>"><c:out value='${instructor.firstName}'/></option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Guardar Clase</button>
</form>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</body>
</html>
