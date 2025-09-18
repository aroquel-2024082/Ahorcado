<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Juego del Ahorcado</title>
    <link rel="stylesheet" href="css/ahorcado.css">
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
</head>
<body>
    
    <div class="login">
        <form action="Validar" method="POST" class="formulario">
            <h1>Iniciar Sesion</h1>
            <div class="sesion">
                <input type="text" name="txtUsuario" placeholder="Usuario" required>
                <i class="bx bxs-user"></i>
            </div>
            <div class="sesion">
                <input type="password" name="txtContrasena" placeholder="Contraseña" required>
                <i class="bx bxs-lock-alt"></i>
            </div>
            <div class="recordar">
                <label><input type="checkbox">Recordarme</label>
                <a href="#">¿Olvidaste la Contraseña?</a>
            </div>
            <button type="submit" name="btnIngresar" value="Ingresar" class="btn">Ingresar</button>
        </form>
    </div>
    
</body>
</html>