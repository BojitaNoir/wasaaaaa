

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .custom-form {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      margin-top: 50px;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6 custom-form">
      <h2 class="mb-4">Registro de Usuario</h2>
      <form class="needs-validation" id="registrationForm" action="/user/register" novalidate method="post">
        <div class="mb-3">
          <label for="nombres" class="form-label">Nombre</label>
          <input type="text" class="form-control" id="nombres" name="nombres" required>
          <div class="invalid-feedback">
            Por favor ingresa un nombre válido.
          </div>
        </div>
        <div class="mb-3">
          <label for="apellidos" class="form-label">Apellidos</label>
          <input type="text" class="form-control" id="apellidos" name="apellidos" required>
          <div class="invalid-feedback">
            Por favor ingresa apellidos válidos.
          </div>
        </div>
        <div class="mb-3">
          <label for="curp" class="form-label">CURP</label>
          <input type="text" class="form-control" id="curp" name="curp" required>
          <div class="invalid-feedback">
            Por favor ingresa una CURP válida.
          </div>
        </div>
        <div class="mb-3">
          <label for="fecha" class="form-label">Fecha de Nacimiento</label>
          <input type="date" class="form-control" id="fecha" name="fecha" required>
          <div class="invalid-feedback">
            Por favor ingresa una fecha de nacimiento válida.
          </div>
        </div>
        <div class="mb-3">
          <label for="correo" class="form-label">Correo Electrónico</label>
          <input type="email" class="form-control" id="correo" name="correo" required>
          <div class="invalid-feedback">
            Por favor ingresa un correo electrónico válido.
          </div>
        </div>
        <div class="mb-3">
          <label for="contraseña" class="form-label">Contraseña</label>
          <input type="password" class="form-control" id="contraseña" name="contraseña" required>
          <div class="invalid-feedback">
            Por favor ingresa una contraseña válida.
          </div>
        </div>
        <div class="d-grid">
          <button id="register" type="submit" class="btn btn-primary btn-block">
            <i data-feather="user-plus"></i> Registrarse
          </button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>