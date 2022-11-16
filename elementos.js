var tabla= document.querySelector("#tabla");
var contador=0;
function crearFilas(){

    var tr=document.createElement("tr");
    var td=document.createElement("td");
    td.innerHTML="celda creada" ;
    tr.appendChild(td);
    //tabla.appendChild(tr);

    if(contador%2==0) td.classList.add("rojo");
    tabla.appendChild(tr);
    contador++;
}