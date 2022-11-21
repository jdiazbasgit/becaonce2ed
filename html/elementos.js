var tabla = document.querySelector("#tabla");
 //crear un Array vacio que se llame primos
 var primos=[];
function numeroPrimos(){
//recorremos los numerops del 1 al 100 en un for
// si es primo lo añadimos al array
primos.push(3);
   // recorro en array de numeros y por cada uno de los numero primos creamos un tr, un td, le damos contenido al td con el valor del numero primo 
   //añadimos el td al tr
   //añadimos el tr a la tabla
    

}


function crearFilas() {
  var tr = document.createElement("tr");
  var td = document.createElement("td");
  td.innerHTML = "celda creada";
  tr.appendChild(td);
  if (contador % 2 === 0) td.classList.add("rojo");
  tabla.appendChild(tr);
  //contador++;
}
