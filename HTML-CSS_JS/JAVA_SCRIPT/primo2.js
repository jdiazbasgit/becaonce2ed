function primo(numero) {
    for (var i = 2; i < numero; i++) {
        if (numero % i === 0) {
            return false;
        }
    }

    return numero !== 1;
}

function crearFilas() {

    var x = 2
    var numprimo = []

    for (x = 2; x < 100; x++) {
        if (primo(x)) {
            numprimo.push(x);
            var tr = document.createElement("tr");
            var td = document.createElement("td");
            td.innerHTML = x;
            tr.appendChild(td);
        }
        tabla.appendChild(tr);
    }
}

function sinprimo() {
    var x = 1
    var num = []

    for (x = 1; x < 100; x++) {

            var tr = document.createElement("tr");
            var td = document.createElement("td");
            td.innerHTML = x;
            tr.appendChild(td);   
            if (primo(x)) {
            num.push(x);
            tr.attributes(style= "background-color-red")
        }
        tabla2.appendChild(tr)
    }
}

