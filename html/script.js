document.querySelector("#h1").innerHTML = "pepe";
function sumar(a, b) {
  return a + b;
}

function pintarSuma() {
  resultado = sumar(5, 10);
  console.log(resultado);
  document.querySelector("#h1").innerHTML = resultado;
  //alert("has pulsado el boton sumar");
  //console.log(confirm(5, fdgfd, dfg));
  a = 7;
  b = a++;
  console.log("b--> " + b);
  console.log("a--> " + a);

  a = 7;
  b = ++a;
  console.log("b en ++ : " + b);
  console.log("a en ++ : " + a);
}

function ejemploFor() {
nombre="federico";


  for (let i = 1; i <= 10; i++) {
    let elementoAModificar=document.querySelector("#h1");
    if (i % 2 == 0) {
      elementoAModificar.innerHTML =
        elementoAModificar.innerHTML + "-" + i;
    }
  }
var elemento=document.querySelector("#h1");
  for (var i = 10; i >= 1; i--) {
    if (i % 2 > 0) {
      document.querySelector("#h1").innerHTML =
        document.querySelector("#h1").innerHTML + "-" + i;
    }
  }
  var ventana=window.open();
  ventana.close();
}

function letVar(){

    var a=10
    if(a===10){
        let b=5
        console.log("a en if:"+b)
    }
    console.log("a fuera de if:"+a)
    console.log(b);
}
