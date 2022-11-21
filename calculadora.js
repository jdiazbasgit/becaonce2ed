    var resultado = document.getElementById("resultado");
  
    var uno = document.getElementById("uno");
    darEvento(uno)
    var dos = document.getElementById("dos");
    darEvento(dos)
    var tres = document.getElementById("tres");
    darEvento(tres)
    var cuatro = document.getElementById("cuatro");
    darEvento(cuatro)
    var cinco = document.getElementById("cinco");
    darEvento(cinco)
    var seis = document.getElementById("seis");
    darEvento(seis)
    var siete = document.getElementById("siete");
    darEvento(siete)
    var ocho = document.getElementById("ocho");
    darEvento(ocho)
    var nueve = document.getElementById("nueve");
    darEvento(nueve)
    var cero = document.getElementById("cero");
    darEvento(cero)

function darEvento(elemento) {
    elemento.addEventListener("click", function (event) {
        resultado.value = resultado.value + event.target.innerHTML
        });
}
