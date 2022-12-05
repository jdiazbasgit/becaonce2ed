

var urlRestCountries = "https://restcountries.com/v3.1/";
var urlPais = "https://restcountries.com/v3.1/name/"
var capital = []
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
    dameDatos(urlPais + pais)
        .then(response => response.json())
        .then(paises => {
            var miPais = paises[0]
            miPais.capital.forEach(capi => {
                capital.push(capi)
            })
            poblacion = miPais.population
            area = miPais.area
            miPais.tld.forEach(domi => {
                dominios.push(domi)
            })
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
            /*document.querySelector ("#b1").disabled=false
            document.querySelector ("#b2").disabled=false
            document.querySelector ("#b3").disabled=false
            document.querySelector ("#b4").disabled=false
            document.querySelectorAll("button").forEach(b=>{
                b.disabled=false
            })*/
            Object.entries(traducciones)
                .forEach(traduccion => {
                    traduccion = new Traduccion(traduccion[1].common, [])
                    dameDatos("https://restcountries.com/v3.1/lang/" + traduccion[0])
                        .then(paises => {
                            paises.forEach(pais => {
                                traduccion.paisesDelIdioma.push(pais.name.common)
                                traduccionesDatos.push(traduccion)
                            })

                        })


                })


        })
    // document.querySelector("#divspecial").classList.remove("fade")
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
            paises.sort()
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
        .then((response) => response.json())
        .then(pais => {
            pintaDatosGenerales(pais[0])
        })
}



pillarDatosGeograficos = () => {

    var main = document.querySelector("main");
    var div = document.createElement("div")
    div.id = "#fronteras"
    div.setAttribute("class", "container text-center")
    var ul1 = document.createElement("ul")
    ul1.innerHTML = ""
    var li1 = document.createElement("li")
    var h31 = document.createElement("h3")

    main.appendChild(div)
    div.appendChild(ul1)
    ul1.appendChild(li1)
    li1.appendChild(h31)
    li1.innerHTML = fronteras



}
datosGeograficos = (frontera) => {
    let selectPaises = document.querySelector("#paises");
    dameDatos(urlRestCountries + "/alpha/" + selectPaises.value)

        .then(pais => {
            pillarDatosGeograficos(pais)
        })
}



