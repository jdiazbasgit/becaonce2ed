function minombreEnMayusculas() {
    texto = "oscarpereaalvarez"
    for (i = 0; i < texto.length; i++) {
        if (i % 2 == 0) {
            document.querySelector("#h1").innerHTML = document.querySelector("#h1").innerHTML + texto.substring(i, i + 1).toLowerCase();
        }
        else {
            document.querySelector("#h1").innerHTML = document.querySelector("#h1").innerHTML + texto.substring(i, i + 1).toUpperCase();
        }
    }

}
