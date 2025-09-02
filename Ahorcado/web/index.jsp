<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Juego del Ahorcado</title>
    <link rel="stylesheet" href="css/index.css"/>
</head>
<body>
    <video autoplay muted loop id="background-video" class="video-fondo">
        <source src="img/VideoFondo.mp4" type="video/mp4">
        Tu navegador no soporta el video de fondo.
    </video>
    <div class="encabezado">
        <h2>El Ahorcado Loco</h2>
        <img src="img/CabezaPollo.png" alt="Logo Ahorcado" class="logo">
    </div>
    
    <div id="cronometro" class="tiempo">05:00</div>
    
    <div class="Primer-Contenedor">
        <div class="container">
            <div id="palabra" class="palabra"></div>
            <p id="intentosRestantes">Intentos restantes: 6</p>
            <p id="mensaje"></p>
            <div id="teclado" class="teclado"></div>
            <div class="botones">
                <button onclick="iniciarJuego()">Comenzar</button>
                <button onclick="reiniciar()">Reiniciar</button>
            </div>
        </div>
        <div class="Imagen-De-Referencia">
            <h2>LA HORCA</h2>
            <img src="img/Base.png" alt="Base" class="Base">
        </div>
    </div>
    <div id="dialogoCuadro"></div>
    <div id="dialogo" class="dialogo">
        <h3 id="dialogoTitulo"></h3>
        <p id="dialogoMensaje"></p>
        <button onclick="cerrarDialogo()">Cerrar</button>
    </div>
    <script src="js/index.js"></script>
</body>
</html>