function minombrEnMayusculas() {
    texto = "luiscarlospatiñoocampo";
    alert("longitud:" + texto.length)
    alert(texto.substring().toUpperCase());

    for (let i = 0; i < texto.length; i++) {

        if (i % 2 == 0) {
            document.querySelector("#h1").innerHTML = document.querySelector("#h1").innerHTML + texto.substring(i,i+1).toUpperCase();
        }
        else 
            document.querySelector("#h1").innerHTML = document.querySelector("#h1").innerHTML + texto.substring(i, i+1).toLowerCase();
        }

    }
