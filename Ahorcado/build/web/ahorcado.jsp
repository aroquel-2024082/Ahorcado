<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Juego del Ahorcado</title>
    <link rel="stylesheet" href="css/index.css"/>
    <link href='https://cdn.boxicons.com/fonts/basic/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <video autoplay muted loop id="background-video" class="video-fondo">
        <source src="img/VideoFondo3.mp4" type="video/mp4">
        Tu navegador no soporta el video de fondo.
    </video>
    <div class="encabezado">
        <h2>El Ahorcado Loco</h2>
        <img src="img/CabezaPollo.png" alt="Logo Ahorcado" class="logo">
    </div>

    <div class="Primer-Contenedor">
        <div class="container">
            
            <a style="font-size: 25px">PISTA</a>
            <div class="pista-cuadro">
                <p id="pista-texto"></p>
            </div>
            <div class="t-s">
                <div id="cronometro" class="tiempo">05:00</div>
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
                <button class="boton-C" onclick="iniciarJuego()">COMENZAR<i class='bxr  bx-play'></i></button>
                <button class="boton-R" onclick="reiniciar()">REINICIAR<i class='bxr  bx-refresh-cw'></i> </button>
                <button class="boton-P" onclick="pausarJuego()">PAUSAR<i class='bxr  bx-pause'></i> </button>
                <button class="boton-RJ" onclick="reanudarJuego()">REANUDAR<i class='bxr  bx-rewind'></i> </button>
            </div>
        </div>
        <div class="Imagen-De-Referencia" id="imagenJuegoContainer">
            <p id="intentosRestantes">Intentos restantes: 6</p>
            <div class="ahorcado-container">
                <img src="img/Base.png" alt="Base" class="ahorcado-base">
                <div class="ahorcado-partes">
                    <img id="cabeza" src="img/CabezaDos.png" alt="cabeza" class="ahorcado-parte">
                    <img id="torso" src="img/Torzo.png" alt="torso" class="ahorcado-parte">
                    <img id="brazo-izquierdo" src="img/BrazoIzquierdo.png" alt="brazo-izquierdo" class="ahorcado-parte">
                    <img id="brazo-derecho" src="img/BrazoDerecho.png" alt="brazo-derecho" class="ahorcado-parte">
                    <img id="pierna-izquierda" src="img/PiernaIzquierda.png" alt="pierna-izquierda" class="ahorcado-parte">
                    <img id="pierna-derecha" src="img/PiernaDerecha.png" alt="pierna-derecha" class="ahorcado-parte">
                </div>
            </div>
            <div class="palabra-oculta-cuadro">
                <p id="palabra-oculta"></p>
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