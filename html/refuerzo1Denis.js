crearFormulario=()=>{
var div1=document.querySelector("div")
div1.innerHTML=""
var form1=document.createElement("form")
form1.action="http://localhost:8080/prueba/Ejemplo"
form1.method="post"
var input1=document.createElement("input")
input1.type="text"
input1.innerHTML="texto"
button1=document.createElement("button")
button1.innerHTML="Enviar"
button1.type="button"
div1.appendChild(form1)
form1.appendChild(input1)
form1.appendChild(button1)
}
