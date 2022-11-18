function calcularnumerosprimos() {
    var c = 100;

    var numerosPrimos = [1];
    for (j = 2; j < c; j++) {
        if (soyPrimo(j)) {
            numerosPrimos.push(j);
        }
    }
    console.log(numerosPrimos);
    for (i = 0; i < numerosPrimos.length; i++) {
        tabla = document.getElementById('tabla');
        tr = document.createElement('tr');
        td = document.createElement('td');
        td.innerHTML = numerosPrimos[i]
        tr.appendChild(td);
        tabla.appendChild(tr);
    }
}
function soyPrimo(numero) {
    for (var i = numero - 1; i > 1; i--) {
        if (numero % i === 0) {
            return false;
        }
    }
    return true;
}