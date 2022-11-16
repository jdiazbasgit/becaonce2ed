//var tabla = document.querySelector("#tabla");
 //crear un Array vacio que se llame primos
 //var primos=[];
//function numeroPrimos(){
    //recorremos los numerops del 1 al 100 en un for
    // si es primo lo añadimos al array
//primos.push(3);
   // recorro en array de numeros y por cada uno de los numero primos creamos un tr, un td, le damos contenido al td con el valor del numero primo 
   //añadimos el td al tr
   //añadimos el tr a la tabla
var tabla= document.querySelector("#tabla");
var cadena = 100;
var j = 2;
var primos = [];

for (j=2; j < cadena; j++) {

  if (primo(j)) {
    primos.push(j);
  }
  
}



function primo(numero) {

  for (var i = 2; i < numero; i++) {

    if (numero % i === 0) {
      return false;
    }

  }

  return numero !== 1;
}

