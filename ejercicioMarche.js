function sumar() {
    let numero1 = document.querySelector("numero1");
    let numero2 = document.querySelector("numero2");
    letresultado = parseInt(numero1.value) + parseInt(numero2.value);

    var table = document.querySelector("table")
    var tr = document.createElement("tr")
    var td1 = document.createElement("td")
    td1.numero1=numero1
    var br1 = document.createElement("br")
    var br2 = document.createElement("br")
    var td2 = document.createElement("td")
    td2.numero2=numero2
    var td3 = document.createElement("td")
    td3.reultado=reultado

    table.appendChild(tr)
    tr.appendChild(td1)
    tr.appendChild(td2)
    tr.appendChild(td3)


}
