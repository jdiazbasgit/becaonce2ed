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
    var x;
    var num = [];


    for (x = 0; x < 100; x++) {

        var tr = document.createElement("tr");
        var td = document.createElement("td");

        td.innerHTML = x;

        if (primo(x)) {
            num.push(x);
            
            td.setAttribute("style", "background-color: green; color: white; font-size:18px");
            
        } else {
            td.setAttribute('bgcolor', 'red');
        }
        tr.appendChild(td);
        tabla2.appendChild(tr)
    }
}

