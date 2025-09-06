let intentosDisplay = document.getElementById("intentosRestantes");
let mensaje = document.getElementById("mensaje");
let cronometroDisplay = document.getElementById("cronometro");
let dialogo = document.getElementById("dialogo");
let dialogoCuadro = document.getElementById("dialogoCuadro");
let dialogoTitulo = document.getElementById("dialogoTitulo");
let dialogoMensaje = document.getElementById("dialogoMensaje");
let teclado = document.getElementById("teclado");
let palabraOcultaDisplay = document.getElementById("palabra-oculta");
let ahorcadoContainer = document.querySelector(".ahorcado-container");
let pistaTexto = document.getElementById("pista-texto");

let estado = [];
let tiempo = 300;
let intervaloCronometro;
let juegoActivo = false;
let juegoPausado = false;
let intentos = 6;
let palabraSeleccionada = "";
let errorCount = 0;

async function obtenerPalabra() {
    try {
        const response = await fetch('AhorcadoServlet');
        if (!response.ok) {
            throw new Error('Error al obtener la palabra');
        }
        const data = await response.json();
        if (data.error) {
            throw new Error(data.error);
        }
        return data;
    } catch (error) {
        console.error('Error al obtener la palabra:', error);
        mostrarDialogo("Error", "No se pudo obtener la palabra. Por favor, reinicia el juego.");
        return null;
    }
}

function dibujar() {
    let display = Array(palabraSeleccionada.length).fill("_");
    for (let i = 0; i < palabraSeleccionada.length; i++) {
        if (estado.includes(palabraSeleccionada[i].toUpperCase())) {
            display[i] = palabraSeleccionada[i].toUpperCase();
        }
    }
    palabraOcultaDisplay.textContent = display.join(" ");
    intentosDisplay.textContent = `Intentos restantes: ${intentos}`;
}

function agregarParte() {
    let partes = ["cabeza", "torso", "brazo-izquierdo", "brazo-derecho", "pierna-izquierda", "pierna-derecha"];
    if (errorCount >= 0 && errorCount < partes.length) {
        document.getElementById(partes[errorCount]).classList.add("visible");
    }
}

function mover(letra) {
    if (!juegoActivo || juegoPausado || estado.includes(letra)) return;
    estado.push(letra);
    let botones = teclado.getElementsByTagName("button");
    for (let btn of botones) {
        if (btn.textContent === letra) {
            btn.disabled = true;
        }
    }
    if (!palabraSeleccionada.toUpperCase().includes(letra)) {
        intentos--;
        agregarParte();
        errorCount++;
    }
    dibujar();
    verificar();
}

function verificar() {
    let display = Array(palabraSeleccionada.length).fill("_");
    for (let i = 0; i < palabraSeleccionada.length; i++) {
        if (estado.includes(palabraSeleccionada[i].toUpperCase())) {
            display[i] = palabraSeleccionada[i].toUpperCase();
        }
    }
    if (!display.includes("_")) {
        mensaje.innerText = " 🎉 ¡Felicidades! Adivinaste la palabra.";
        clearInterval(intervaloCronometro);
        juegoActivo = false;
        mostrarDialogo("¡Victoria!", "🎉 ¡Felicidades! Adivinaste la palabra a tiempo. ¡Eres un genio!");
    } else if (intentos === 0) {
        mensaje.innerText = `⏰ ¡Perdiste! La palabra era ${palabraSeleccionada}.`;
        clearInterval(intervaloCronometro);
        juegoActivo = false;
        mostrarDialogo("¡Derrota!", "⏰ ¡Intentos agotados! Perdiste el juego. ¿Quieres intentarlo de nuevo?");
    }
}

async function iniciarJuego() {
    if (juegoActivo) return;
    
    const palabraData = await obtenerPalabra();
    if (!palabraData) {
        return;
    }
    
    palabraSeleccionada = palabraData.palabra;
    pistaTexto.textContent = `${palabraData.pista1} - ${palabraData.pista2}`;

    tiempo = 300;
    intentos = 6;
    estado = [];
    errorCount = 0;
    
    let partes = document.querySelectorAll('.ahorcado-parte');
    partes.forEach(parte => parte.classList.remove('visible'));

    intervaloCronometro = setInterval(() => {
        if (tiempo > 0) {
            tiempo--;
            let min = Math.floor(tiempo / 60);
            let sec = tiempo % 60;
            min = min < 10 ? "0" + min : min;
            sec = sec < 10 ? "0" + sec : sec;
            cronometroDisplay.innerText = min + ":" + sec;
        } else {
            clearInterval(intervaloCronometro);
            juegoActivo = false;
            mensaje.innerText = `⏰ ¡Tiempo agotado! La palabra era ${palabraSeleccionada}.`;
            mostrarDialogo("¡Derrota!", "⏰ ¡Tiempo terminado! Perdiste el juego. ¿Quieres intentarlo de nuevo?");
        }
    }, 1000);

    juegoActivo = true;
    mensaje.innerText = "";
    dibujar();
    let botones = teclado.getElementsByTagName("button");
    for (let btn of botones) {
        btn.disabled = false;
    }
    teclado.addEventListener("click", function(event) {
        if (event.target.classList.contains("btn")) {
            mover(event.target.textContent);
        }
    });
}

function reiniciar() {
    clearInterval(intervaloCronometro);
    juegoActivo = false;
    juegoPausado = false;
    tiempo = 300;
    intentos = 6;
    estado = [];
    errorCount = 0;

    let partes = document.querySelectorAll('.ahorcado-parte');
    partes.forEach(parte => parte.classList.remove('visible'));
    pistaTexto.textContent = "";

    cronometroDisplay.innerText = "05:00";
    mensaje.innerText = "";
    palabraOcultaDisplay.textContent = "";
    dialogo.style.display = "none";
    dialogoCuadro.style.display = "none";
    let botones = teclado.getElementsByTagName("button");
    for (let btn of botones) {
        btn.disabled = false;
    }
    dibujar();
}

function pausarJuego() {
    if (juegoActivo && !juegoPausado) {
        clearInterval(intervaloCronometro);
        juegoPausado = true;
        teclado.style.pointerEvents = 'none';
    }
}

function reanudarJuego() {
    if (juegoActivo && juegoPausado) {
        intervaloCronometro = setInterval(() => {
            if (tiempo > 0) {
                tiempo--;
                let min = Math.floor(tiempo / 60);
                let sec = tiempo % 60;
                min = min < 10 ? "0" + min : min;
                sec = sec < 10 ? "0" + sec : sec;
                cronometroDisplay.innerText = min + ":" + sec;
            } else {
                clearInterval(intervaloCronometro);
                juegoActivo = false;
                mensaje.innerText = '⏰ ¡Tiempo agotado!';
                mostrarDialogo("¡Derrota!", "⏰ ¡Tiempo terminado! Perdiste el juego. ¿Quieres intentarlo de nuevo?");
            }
        }, 1000);
        juegoPausado = false;
        teclado.style.pointerEvents = 'auto';
        document.querySelector('.boton-P').textContent = 'PAUSAR';
    }
}

function mostrarDialogo(titulo, mensaje) {
    dialogoTitulo.innerText = titulo;
    dialogoMensaje.innerText = mensaje;
    dialogo.style.display = "block";
    dialogoCuadro.style.display = "block";
}

function cerrarDialogo() {
    dialogo.style.display = "none";
    dialogoCuadro.style.display = "none";
    reiniciar();
}

function alCargarPagina() {
    reiniciar();
}

function salirJuego () {
    window.close();
}

document.addEventListener("DOMContentLoaded", alCargarPagina);