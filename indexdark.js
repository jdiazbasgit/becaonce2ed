

opcionesContinente = continente => {

    var paisesSelect = document.querySelector("#paises");
    paisesSelect.innerHTML = ""

    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then((response) => response.json())
        .then(pais => {
            let seleccionaPais = document.createElement("option")
            seleccionaPais.value = "0"
            seleccionaPais.text = "seleccionarPais"
            paisesSelect.appendChild(seleccionaPais);
            pais.forEach(pais => {
                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value;
                paisesSelect.appendChild(option)
            });

        })
}

//buscar datosGenerales.


const main = document.querySelector("main")
var capital;
var moneda;
var simbolo;
var poblacion;
var dominio;
var superficie;
var moneda;
var bandera;
var escudo;