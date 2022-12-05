function suma(a, b) {
  return a + b;
}
function resta(a, b) {
  return a - b;
}
function division(a, b) {
  return a / b;
}
function multiplicacion(a, b) {
  return a * b;
}
function exponente(a, b){
    return a ** b;
}

function operacion(callback, a, b) {
  let c = a + b;
  return parseInt(callback(a,b));
}

cargar = () => {
  hsuma = document.querySelector("#suma");
  hresta = document.querySelector("#resta");
  hmultiplicacion = document.querySelector("#multiplicacion");
  hdivision = document.querySelector("#division");
  hexponente = document.querySelector("#exponente");
  numero1 = document.querySelector("#n1").value;
  numero2 = document.querySelector("#n2").value;
  hsuma.innerHTML =
    "la suma es:" + operacion(suma, parseInt(numero1), parseInt(numero2));
  hresta.innerHTML =
    "la resta es:" + operacion(resta, parseInt(numero1), parseInt(numero2));
  hmultiplicacion.innerHTML =
    "la multiplicacion es:" +
    operacion(multiplicacion, parseInt(numero1), parseInt(numero2));
  hdivision.innerHTML =
    "la division es:" +
    operacion(division, parseInt(numero1), parseInt(numero2));
  hexponente.innerHTML =
    "el calculo con exponente es:" +
    operacion(exponente, parseInt(numero1), parseInt(numero2));
};
