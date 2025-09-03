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
    
    <div class="Primer-Contenedor">
        <div class="container">
            <div class="t-s">
                <div id="cronometro" class="tiempo">05:00</div>
                <button class="boton-S" onclick="salirJuego()">SALIR</button>
            </div>
            <p id="mensaje"></p>
            <div id="teclado" class="teclado">
                <div class="primeraFila">
                    <button class="btn">A</button>
                    <button class="btn">B</button>
                    <button class="btn">C</button>
                    <button class="btn">D</button>
                    <button class="btn">E</button>
                    <button class="btn">F</button>
                    <button class="btn">G</button>
                    <button class="btn">H</button>
                    <button class="btn">I</button>
                    <button class="btn">J</button>
                </div>
                <div class="segundaFila">
                    <button class="btn">K</button>
                    <button class="btn">L</button>
                    <button class="btn">M</button>
                    <button class="btn">N</button>
                    <button class="btn">Ñ</button>
                    <button class="btn">O</button>
                    <button class="btn">P</button>
                    <button class="btn">Q</button>
                    <button class="btn">R</button>
                    <button class="btn">S</button>
                </div>
                <div class="terceraFila">
                    <button class="btn">T</button>
                    <button class="btn">U</button>
                    <button class="btn">V</button>
                    <button class="btn">W</button>
                    <button class="btn">X</button>
                    <button class="btn">Y</button>
                    <button class="btn">Z</button>
                </div>
            </div>
            <div class="botones">
                <button class="boton-C" onclick="iniciarJuego()">COMENZAR</button>
                <button class="boton-R" onclick="reiniciar()">REINICIAR</button>
                <button class="boton-P" onclick="pausarJuego()">PAUSAR</button>
                <button class="boton-RJ" onclick="reanudarJuego()">REANUDAR</button>
            </div>
            <div class="pistas-j">
                <p id="pistas"></p>
            </div>
        </div>
        <div class="Imagen-De-Referencia">
            <p id="intentosRestantes">Intentos restantes: 6</p>
            <img src="img/Base.png" alt="Base" class="Base">
            <div class="palabra-oculta">
                <p id="oculta"></p>
            </div>
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