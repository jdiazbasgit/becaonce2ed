var tabla = Document.querySelector("#tabla");
var primos = [];
function numeroPrimos() {
    primos.push(1, 100)
}
function crearFilas() {
    var tr = document.createElement("tr");
    var td = document.createElement("td");
    td.innerHTML = "";
    tr.appenChild(td);
    for (i = 0) {
        if (i % 2, i % i === 0) {
            tabla.appenChild(tr)
            document.querySelector("#tabla").innerHTML = document.querySelector("#tabla").innerHTML + primos.substring(i, i + 1);
        }
    }



