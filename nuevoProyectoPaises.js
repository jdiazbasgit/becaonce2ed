var capital
var poblacion
var area
var dominios = []
var fronteras = []
var bandera
var escudo
var monedas
var monedasDatos = []
var traducciones = []
var fronterasNombres = []
var traduccionesDatos = []
var urlPais = "https://restcountries.com/v3.1/name/"
var urlRestCountries = "https://restcountries.com/v3.1/";
const main = document.querySelector("main");
class Moneda {
    constructor(name, symbol) {
        this.name = name
        this.symbol = symbol
    }
}
function cargarDatos(pais) {
    dameDatos("https://restcountries.com/v3.1/name/" + pais)
        .then(response => response.json())
        .then(paises => {
            let miPais = paises[0]
            capital = miPais.capital
            poblacion = miPais.population
            area = miPais.area
            dominios = miPais.tld
            bandera = miPais.flags.svg
            escudo = miPais.coatOfArms.svg
            monedas = miPais.currencies
            traducciones = miPais.translations
            fronteras = miPais.borders
            monedasDatos = []
            Object.entries(monedas).forEach(moneda => {
                monedasDatos.push(moneda[1])
            })
            /*document.querySelector("#b1").disabled = false
            document.querySelector("#b2").disabled = false
            document.querySelector("#b3").disabled = false
            document.querySelector("#b4").disabled = false*/
            /*document.querySelectorAll("button").forEach(b=>{
              b.disabled=false
            })*/
            document.querySelector("#divspecial").classList.remove("fade")
            /*fronteras.forEach(frontera => {
                dameDatos("https://restcountries.com/v3.1/alpha/" + frontera)
                  .then(response => response.json())
                  .then(paises => {
                    let miPais = paises[0]
                    fronterasNombres.push(miPais.name.common)
                    document.querySelector("#b1").disabled = false
                  })
              })
        
              Object.entries(traducciones)
                .forEach(traduccion => {
                  miTraduccion = traduccion[0]
                  dameDatos("https://restcountries.com/v3.1/lang/" + traduccion[0])
                    .then(response => {
                      if (response.status == 200) {
                        return response.json()
                      } else
                        return []
                    })
                    .then(paises => {
                      paises.forEach(pais => {
                        traduccionesDatos.push(traduccion[1])
                      })
                    })
                })*/
        })
}
cargarPaises = (continente) => {
    fetch(urlRestCountries + "region/" + continente)
        .then((response) => response.json())
        .then((paises) => {
            var paisesSelect = document.querySelector("#paises");
            paisesSelect.innerHTML = "";
            let seleccionaPais = document.createElement("option");
            seleccionaPais.value = "0";
            seleccionaPais.text = "Selecciona pais";
            paisesSelect.appendChild(seleccionaPais);
            paises.forEach((pais) => {
                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value;
                paisesSelect.appendChild(option);

            });
        });
};
dameDatos = (URL) => fetch(URL);
dameNombreDePais = cca3 => {
    dameDatos(urlRestCountries + cca3).then(response =>
        response.json)
        .then(pais => pais.name.common)
}



dameDatosGenerales = () => {
    let selectPaises = document.querySelector("#paises");
    dameDatos(urlRestCountries + "/name/" + selectPaises.value)
        .then((response) => response.json())
        .then(pais => {
            pintaDatosGenerales(pais[0])
        })
}

moneda = new Moneda("name", "symbol")
pintaDatosGenerales = (pais) => {
    var main = document.querySelector("main");
    main.innerHTML = "";
    let table = document.createElement("table");
    table.setAttribute("class", "table table-stripped text-center")
    let tr1 = document.createElement("tr");
    let th1 = document.createElement("th");
    let th2 = document.createElement("th");
    let th3 = document.createElement("th");
    let th4 = document.createElement("th");
    let th5 = document.createElement("th");
    let tr2 = document.createElement("tr");
    let td1 = document.createElement("td");
    let td2 = document.createElement("td");
    let td3 = document.createElement("td");
    let td4 = document.createElement("td");
    let td5 = document.createElement("td");
    th1.innerHTML = "Capital "
    th2.innerHTML = "Población";
    th3.innerHTML = "Área";
    th4.innerHTML = "Dominio";
    th5.innerHTML = "Moneda";
    td1.innerHTML = pais.capital;
    td2.innerHTML = pais.population
    td3.innerHTML = pais.area;
    td4.innerHTML = pais.tld;
    td5.innerHTML = ""
    let ul = document.createElement("ul")
    ul.innerHTML = ""
    monedasDatos.forEach(moneda => {
        li = document.createElement("li")
        li.innerHTML = ` ${moneda.name} - ${moneda.symbol}`
        ul.appendChild(li)
    })
    td5.appendChild(ul)
    main.appendChild(table);
    table.appendChild(tr1,);
    table.appendChild(tr2)
    tr1.appendChild(th1);
    tr1.appendChild(th2);
    tr1.appendChild(th3);
    tr1.appendChild(th4);
    tr1.appendChild(th5);
    tr2.appendChild(td1);
    tr2.appendChild(td2);
    tr2.appendChild(td3);
    tr2.appendChild(td4);
    tr2.appendChild(td5);
};
class Traduccion {
    constructor(traduccionDelNombre, paisesDelIdioma) {
        this.traduccionDelNombre = traduccionDelNombre;
        this.paisesDelIdioma = paisesDelIdioma;
    }
}

cargaBandera = () => {
    let selectPaises = document.querySelector("#paises");
    dameDatos(urlRestCountries + "/name/" + miPais.flags.svg)
        .then((response) => response.json())
        .then(pais => {
            pintaDatosGenerales(pais[0])
        })
}

cargaEscudo = () => {
    let selectPaises = document.querySelector("#paises");
    dameDatos(urlRestCountries + "/name/" + miPais.coatOfArms.svg)
        .then((response) => response.json())
        .then(pais => {
            pintaDatosGenerales(pais[0])
        })
}


cargaTraduccionesDatos = () => {
    let selectPaises = document.querySelector("#paises");
    dameDatos(urlRestCountries + "/name/" + offcial.common)
        .then((response) => response.json())
        .then(pais => {
            pintaDatosGenerales(pais[0])
        })
}














































































dameDatos = (url) => fetch(url)
    .then(response => {
        if (response.status == 200)
            return response.json()
    })