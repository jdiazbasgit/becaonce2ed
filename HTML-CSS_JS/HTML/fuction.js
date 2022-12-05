// pepe, 4 letras pero cuenta como 3 ya que cuenta el 0. seria asi 0123=pepe https://es.javascript.info/string
// '.lenght es aplico a . antes, seria hacer.aplico

function ejercicioFor() {
    let letramodificar = document.querySelector("#h1");
    let texto = 'adansanchez';
    let lnom = texto.length;

    for (let i = 0; i <= lnom; i++) {
        if (i % 2 == 0) {
            letramodificar.innerHTML = letramodificar.innerHTML + texto.substr(i, 1).toUpperCase();
        } else {
            letramodificar.innerHTML = letramodificar.innerHTML + texto.substr(i, 1).toLowerCase();
        }

    }
}



