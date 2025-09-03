let ahorcadoContainer = document.getElementById("ahorcado");
let palabraContainer = document.getElementById("palabra");
let intentosDisplay = document.getElementById("intentosRestantes");
let mensaje = document.getElementById("mensaje");
let cronometroDisplay = document.getElementById("cronometro");
let dialogo = document.getElementById("dialogo");
let dialogoCuadro = document.getElementById("dialogoCuadro");
let dialogoTitulo = document.getElementById("dialogoTitulo");
let dialogoMensaje = document.getElementById("dialogoMensaje");
let teclado = document.getElementById("teclado");
let palabras = ["GATO", "PERRO", "CASA", "ARBOL"];
let pistas = [];
let estado = [];
let tiempo = 300;
let intervaloCronometro;
let juegoActivo = false;
let juegoPausado = false;
let intentos = 6;
let palabraSeleccionada = "";

function mezclar(array) {
    let copia = [...array];
    for (let i = copia.length - 1; i > 0; i--) {
        let j = Math.floor(Math.random() * (i + 1));
        [copia[i], copia[j]] = [copia[j], copia[i]];
    }
    return copia;
}

function dibujar() {
    let display = Array(palabraSeleccionada.length).fill("_");
    for (let i = 0; i < palabraSeleccionada.length; i++) {
        if (estado.includes(palabraSeleccionada[i].toUpperCase())) {
            display[i] = palabraSeleccionada[i].toUpperCase();
        }
    }
    if (palabraContainer) {
        palabraContainer.textContent = display.join("");
    }
    intentosDisplay.textContent = `Intentos restantes: ${intentos}`;
}

function mover(letra) {
    if (!juegoActivo || estado.includes(letra)) return;
    estado.push(letra);
    let botones = teclado.getElementsByTagName("button");
    for (let btn of botones) {
        if (btn.textContent === letra) {
            btn.disabled = true;
        }
    }
    if (!palabraSeleccionada.toUpperCase().includes(letra)) {
        intentos--;
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

function iniciarJuego() {
    if (juegoActivo) return;
    tiempo = 300;
    intentos = 6;
    estado = [];
    palabraSeleccionada = mezclar(palabras)[0].toUpperCase();
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
}

function reiniciar() {
    clearInterval(intervaloCronometro);
    juegoActivo = false;
    juegoPausado = false;
    tiempo = 300;
    intentos = 6;
    estado = [];
    cronometroDisplay.innerText = "05:00";
    mensaje.innerText = "";
    palabraSeleccionada = mezclar(palabras)[0].toUpperCase();
    dibujar();
    dialogo.style.display = "none";
    dialogoCuadro.style.display = "none";
    let botones = teclado.getElementsByTagName("button");
    for (let btn of botones) {
        btn.disabled = false;
    }
}

function pausarJuego() {
    if (juegoActivo && !juegoPausado) {
        clearInterval(intervaloCronometro);
        juegoPausado = true;
        teclado.style.pointerEvents = 'none';
        document.querySelector('.boton-P').textContent = 'REANUDAR';
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