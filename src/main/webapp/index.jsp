<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Examen Extraordinario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

<div class="container  mt-5 centrado align-items-stretch">
    <div class="col-4">
        <div class="card">
            <div class="card-header">
                <h5 > Inicio de sesión </h5>
            </div>
            <div class="card-body">

                <form class="needs-validation" id="loginForm" action="/user/login" novalidate method="post">
                    <tr >
                        <th>
                            <div class="form-outline">
                                <label class="form-label" for="correo">Usuario</label>
                                <input id="correo" name="correo" type="text" class="form-control"  required>
                                <div class="invalid-feedback">
                                    Campo obligatorio
                                </div>
                            </div>

                            <div class="form-outline">
                                <label class="form-label" for="contra">Contraseña</label>
                                <input id="contra" name="contra"  type="password" class="form-control"  required >
                                <div class="invalid-feedback">
                                    Campo obligatorio
                                </div>
                            </div>
                        </th>
                    </tr>
                    <div class="card-footer">
                        <div class="d-grid">
                            <button id="login" type="submit" class="btn btn-primary btn-block" value="login" >
                                <i data-feather="log-in"></i> Iniciar sesión
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<div class="card" style="width: 18rem;">
    <div class="card-header">
        Featured
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item"><a href="/user/view-register"><h2>Registrarte</h2></a></li>
    </ul>
</div>
</body>
</html>