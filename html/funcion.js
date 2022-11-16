function ejercicioFor() {

    texto = "edupalomino"
    //alert("longitud: "+int(texto.length))

    for (let i = 0; i <= texto.length; i++) {
        let elementoAmodificar=document.querySelector("#h1")
        if (i % 2 == 0) {
            elementoAmodificar.innerHTML=elementoAmodificar.innerHTML+texto.substr(i, 1).toUpperCase();
        } else {
            elementoAmodificar.innerHTML=elementoAmodificar.innerHTML+texto.substr(i, 1).toLowerCase();

        }
    }
}