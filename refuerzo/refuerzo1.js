function sumar() {
    var numero1 = document.querySelector("#n1");
    var numero2 = document.querySelector("#n2");

    var sumar = parseInt(numero1.value) + parseInt(numero2.value)

    var table = document.querySelector("table")
    var tr1 = document.createElement("tr")
    var td1 = document.createElement("td")
    var td2 = document.createElement("td")
    var td3 = document.createElement("td")
    td1.align = "center"
    td2.align = "center"
    td3.align = "center"
    table.appendChild(tr1)
    tr1.appendChild(td1)
    tr1.appendChild(td2)
    tr1.appendChild(td3)
    td1.innerHTML = numero1.value
    td2.innerHTML = numero2.value
    td3.innerHTML = sumar
    numero1.value = ""
    numero2.value = ""


}

/*var main= document.querySelector("main")
 var label = document.createElement("label")
var form = document.createElement("form")
form.action="#"
form.method="post"
var input1 = document.createElement("input")
input1.type="number"
input1.innerHTML="numero1"
var input2 = document.createElement("input")
input2.type="number"
input2.innerHTML="numero2"
var button = document.createElement('button'); 
button.type = "button"; 
button.innerText = "sumar"; 
main.appendChild(label)
label.appendChild(form)
form.appendChild(input1)
form.appendChild(input2)
form.appendChild(button); 
var table= document.createElement("table")
table.border="1"
var tr1 =document.createElement("tr")
var td1 =document.createElement("td")
td1.innerHTML="numero1"
var td2 =document.createElement("td")
td2.innerHTML="numero2"
var td3 =document.createElement("td")
td3.innerHTML="resultado"
main.appendChild(table)
table.appendChild(tr1)
tr1.appendChild(td1)
tr1.appendChild(td2)
tr1.appendChild(td3)*/

