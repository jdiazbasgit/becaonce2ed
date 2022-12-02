var main = document.querySelector("main")
var form1 = document.createElement("form")
form1.action = "#"
form1.method = "post"
var table = document.createElement("table")
table.border = "1"
var tr1 = document.createElement("tr")
var td1 = document.createElement("td")
var label1 = document.createElement("label")
label1.for = "usuario"
label1.innerHTML = "USUARIO"
var td2 = document.createElement("td")
var input1 = document.createElement("input")
input1.type = "text"
input1.name = "usuario"
td2.appendChild(input1)
td1.appendChild(label1)
tr1.appendChild(td1)
tr1.appendChild(td2)
form1.appendChild(table)
main.appendChild(form1)
// primero

var tr2 = document.createElement("tr")
var td3 = document.createElement("td")
var label2 = document.createElement("label")
label2.for ="clave"
label2.innerHTML="CLAVE"
td3.appendChild(label2)
tr2.appendChild(td3)
//segundo

var td4 = document.createElement(td)
var input2 = document.createElement("input")
input2.type = "password"
input2.name = "clave"
td4.appendChild(input2)
tr2.appendChild(td4)

//tercero

var tr3 = document.createElement("tr")
var td5 = document.createElement("td")
td4.colspan = "2"
var button1 = document.createElement("button")
button1.type = "button"
button1.onclick = "alert"
//button1.onclick="alert('he pulsado el boton')"

button1.addEventListener("click",(event)=>{
    alert('he pulsado el  boton')
})
button1.innerHTML="ENVIAR"

var button2 = document.createElement("button")
button2.type = "reset"
button2.innerHTML = BORRAR
tr3.appendChild(td5)
td5.appendChild(button1)
td5.appendChild(button2)
 
//cerramos los tr1, tr2. tr3..
table.appendChild(tr1)
table.appendChild(tr2)
table.appendChild(tr3)

//ejercicio
var main = document.querySelector("main")
var form2 = document.createElement("form")
form2.action = "http://localhost:8080/prueba/Ejemplo"
form2.method = "get"
var label3 = document.createElement("label")
label3.for = "texto"
label3.innerHTML = texto
var input3 = document.createElement("input")
input3.type = "text"
input3.name = "texto"
var button3 = document.createElement("button")
button3.type = "submit"
button3.innerHTML = enviar
main.appendChild(form2)
form2.appendChild(label3)
input3.appendChild(form2)
button3.appendChild(form2)
//////*/

function suma() {
var num1 = parseInt(document.getElementById('num1').value);
var num2 = parseInt(document.getElementById('num2').value);
var resultado;
Result= Number1+Number2,
alert("+resultado");


console.log(suma +resultado);

}




