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
let piezas = ["GATO", "PERRO", "CASA", "ARBOL"];
let estado = [];
let tiempo = 300;
let intervaloCronometro;
let juegoActivo = false;
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
    palabraContainer.textContent = display.join(" ");
    ahorcadoContainer.querySelector("img").src = `img/ahorcado${6 - intentos}.png`;
    intentosDisplay.textContent = `Intentos restantes: ${intentos}`;
}

function crearTeclado() {
    teclado.innerHTML = "";
    for (let i = 65; i <= 90; i++) {
        let letra = String.fromCharCode(i);
        let boton = document.createElement("button");
        boton.textContent = letra;
        boton.addEventListener("click", () => mover(letra));
        teclado.appendChild(boton);
    }
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
    palabraSeleccionada = mezclar(piezas)[0].toUpperCase();
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
    tiempo = 300;
    intentos = 6;
    estado = [];
    cronometroDisplay.innerText = "05:00";
    mensaje.innerText = "";
    palabraSeleccionada = mezclar(piezas)[0].toUpperCase();
    dibujar();
    dialogo.style.display = "none";
    dialogoCuadro.style.display = "none";
    let botones = teclado.getElementsByTagName("button");
    for (let btn of botones) {
        btn.disabled = false;
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
    crearTeclado();
    reiniciar();
}

document.addEventListener("DOMContentLoaded", alCargarPagina);