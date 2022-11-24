<<<<<<< HEAD
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
=======
primos = [1, 2, 3]
function numerosPrimos() {

    //if (100 == 0 || 100 == 1 || 100 == 4) return false;


    for (let i = 4; i < 100; i++) {
        soyPrimo = true

        for (let j = i-1; j > 1; j--) {
            if (i % j == 0) {

                soyPrimo = false;
                break
            }

        }

        if (soyPrimo) {
            primos.push(i)
        }
    }
    console.log(primos)

defea




}
>>>>>>> 51aae0865cd1e1e5ffa7c14157e6e516894c1d49
