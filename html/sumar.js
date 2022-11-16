function sumar(){
    let numero1= document.querySelector("#numero1");
    let numero2= document.querySelector("#numero2");
    let resultado=parseInt(numero1.value)+parseInt(numero2.value);
    document.querySelector("#resultado").innerHTML=resultado

}