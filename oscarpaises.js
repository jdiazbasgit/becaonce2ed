

var urlRestCountries = "https://restcountries.com/v3.1/";

var capital
var poblacion
var area
var monedas = []
var dominios = []
var fronteras = []
var bandera
var escudo
var monedasDatos = []
var traducciones = []
var fronterasNombres = []
var traduccionesDatos = []


class Traduccion {
    constructor(traduccionDelNombre, paisesDelIdioma) {
        this.traduccionDelNombre = traduccionDelNombre;
        this.paisesDelIdioma = paisesDelIdioma;
    }
}
dameDatos = (url) => fetch(url)
    .then(response => {
        if (response.status == 200)
            return response.json()
    })

function cargarDatos(pais) {
    dameDatos("https://restcountries.com/v3.1/name/" + pais)
        .then(paises => {
            let miPais = paises[0]
            capital = miPais.capital
            poblacion = miPais.population
            area = miPais.area
            dominios = miPais.tld
            bandera = miPais.flags.svg
            escudo = miPais.coatOfArms.svgmonedas
            monedas = miPais.currencies
            traducciones = miPais.translations
            fronteras = miPais.borders
            fronteras.forEach(frontera => {
                dameDatos("https://restcountries.com/v3.1/alpha/" + frontera)
                    .then(paises => {
                        let miPais = paises[0]
                        fronterasNombres.push(miPais.name.common)
                    })
            })
            // monedas.forEach(monedas => {
            // monedasDatos.push(Object.entries(monedas)[0])
            //  })
            Object.entries(traducciones)
                .forEach(traduccion => {
                    miTraduccion = new Traduccion(traduccion[1].common, [])
                    dameDatos("https://restcountries.com/v3.1/lang/" + traduccion[0])
                        .then(paises => {
                            paises.forEach(pais => {
                                miTraduccion.paisesDelIdioma.push(pais.name.common)
                                traduccionesDatos.push(miTraduccion)
                            })
                        })

                })
        })

}







cargarPaises = continente => {
    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then(response => response.json())
        .then(paises => {


            var paisesSelect = document.querySelector("#paises");
            paisesSelect.innerHTML = ""
            let seleccionaPais = document.createElement("option")
            seleccionaPais.value = "0"
            seleccionaPais.text = "Selecciona pais";
            paisesSelect.appendChild(seleccionaPais);

            paises.forEach(pais => {

                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value;
                paisesSelect.appendChild(option)

            });

        })

}

dameDatosGenerales = () => {
    let selectPaises = document.querySelector("#paises");
    dameDatos(urlRestCountries + "/name/" + selectPaises.value)
        .then((response) => response.json)
        .then(pais => {
            pintaDatosGenerales(pais)
        })
}


pillarDatosGeograficos = () => {

    var main = document.querySelector("main");
    var div = document.createElement("div")
    div.id = "#fronteras"
    div.setAttribute("class", "container text-center")
    var h31 = document.createElement("h3")
    var h32 = document.createElement("h3")
    var h33 = document.createElement("h3")
    var h34 = document.createElement("h3")
    var h35 = document.createElement("h3")
    h31.innerHTML = "Frontera 1"
    h32.innerHTML = "Frontera 2"
    h33.innerHTML = "Frontera 3"
    h34.innerHTML = "Frontera 4"
    h35.innerHTML = "Frontera 5"
    main.appendChild(div)
    div.appendChild(h31)
    div.appendChild(h32)
    div.appendChild(h33)
    div.appendChild(h34)
    div.appendChild(h35)

}
datosGeograficos =()



