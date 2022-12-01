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
            monedas.forEach(moneda => {
                monedasDatos.push(Object.entries(monedas)[0])
            })
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
    //while(capital==undefined && poblacion ==)
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
dameDatos = (url) => fetch(url);
dameNombreDePais= cca3 =>{
    dameDatos(urlRestCountries + cca3).then (response =>
    response.json)
    .then (pais => pais.name.common)
}
 


dameDatosGenerales = () => {
    let selectPaises = document.querySelector("#paises");
    dameDatos( "https://restcountries.com/v3.1/region/" + selectPaises.value)
      .then((response) => response.json())
      .then(pais => {
        pintaDatosGenerales(pais[0])
      })
  }

  intaDatosGenerales = (pais) => {
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
    td2.innerHTML = pais.population;
    td3.innerHTML = pais.area;
    td4.innerHTML = pais.tld;
    td5.innerHTML = moneda.name;
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
  }





vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.removeChild(hijo);
    })
}
























































































dameDatos = (url) => fetch(url)
    .then(response => {
        if (response.status == 200)
            return response.json()
    })