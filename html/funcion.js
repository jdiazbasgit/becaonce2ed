function ejercicioFor() {

    texto = "edupalomino"
    //alert("longitud: "+int(texto.length))

    for (let i = 0; i <= texto.length; i++) {
        if (i % 2 == 0) {
            document.querySelector("#h1").innerHTML=document.querySelector("#h1").innerHTML+texto.substr(i, 1).toUpperCase();
        } else {
            document.querySelector("#h1").innerHTML=document.querySelector("#h1").innerHTML+texto.substr(i, 1).toLowerCase();
            
        }
    }
}