function sumar() {
    let numero1 = document.querySelector("#numero1");
    let numero2 = document.querySelector("#numero2");
    let resultado = parseInt(numero1.value) + parseInt(numero2.value);





    var table = document.querySelector("table")
    var tr = document.createElement("tr")
    var td1 = document.createElement("td")
    var td2 = document.createElement("td")
    var td3 = document.createElement("td")

    table.appendChild(tr)
    tr.appendChild(td1)
    tr.appendChild(td2)
    tr.appendChild(td3)
    td1.align="center"
    td2.align="center"
    td3.align="center"
    td1.innerHTML = numero1.value
    td2.innerHTML = numero2.value
    td3.innerHTML = resultado
    numero1.value=""
    numero2.value=""

}



