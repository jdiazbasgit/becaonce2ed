var main= document.querySelector("main")
var form1=document.createElement("form")
form1.action="#"
form1.method="post"
var table=document.createElement("table")
table.border="1"
var tr1=document.createElement("tr")
var td1= document.createElement("td")
var label1= document.createElement("label")
label1.for="usuario"
label1.innerHTML="USUARIO"
var td2= document.createElement("td")
var input1= document.createElement("input");
input1.type="text"
input1.name="usuario"
td2.appendChild(input1)
td1.appendChild(label1)
tr1.appendChild(td1)
tr1.appendChild(td2)

form1.appendChild(table)
main.appendChild(form1)
var tr2= document.createElement("tr")
var td3=document.createElement("td")
var label2=document.createElement("label")
label2.for="clave"
label2.innerHTML="CLAVE"
td3.appendChild(label2)
tr2.appendChild(td3)
var td4=document.createElement("td")
var input2=document.createElement("input")
input2.type="password"
input2.name="clave"
td4.appendChild(input2)
tr2.appendChild(td4)
var tr3= document.createElement("tr");
var td5=document.createElement("td")
td5.colSpan="2"
var button1= document.createElement("button")
button1.type="button"
//button1.onclick="alert('he pulsado el boton')"

button1.addEventListener("click",(event)=>{
    alert('he pulsado el boton')
})
button1.innerHTML="ENVIAR"
var button2=document.createElement("button")
button2.type="reset"
button2.innerHTML="BORRAR"
tr3.appendChild(td5)
td5.appendChild(button1)
td5.appendChild(button2)
tr3.appendChild(td5)

table.appendChild(tr1)
table.appendChild(tr2)
table.appendChild(tr3)

