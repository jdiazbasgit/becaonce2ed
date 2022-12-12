var capital = []
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
const urlPais = "https://restcountries.com/v3.1/name/"
const urlAlpha = "https://restcountries.com/v3.1/alpha/"
const urlRestCountries = "https://restcountries.com/v3.1/"
const urllang = "https://restcountries.com/v3.1/lang/spa"
var main = document.querySelector("main");
inicializar = () => {
  capital = []
  poblacion
  area
  dominios = []
  fronteras = []
  bandera
  escudo
  monedas
  monedasDatos = []
  traducciones = []
  fronterasNombres = []
  traduccionesDatos = []


}

class Moneda {
  constructor(name, symbol) {
    this.name = name
    this.symbol = symbol
  }
}
cargarTraducciones = (paises) => {
  inicializar()
  fetch(urlRestCountries + "lang/spa" + paises)
    .then((response) => response.json())
    .then((traducciones) => {
      var traducciones = document.querySelector("#b3");
      traducciones.innerHTML = "";
      let seleccionaTraducciones = document.createElement("button");
      seleccionaTraducciones.text = "traduceAlIdioma"
      traducciones.appendChild(traduceAlIdioma);
      traducciones.sort((a, b) => {
        if (a.lang.spa > b.lang.spa)
          return 1
        else return -1
      }).forEach((traducciones) => {
        let button = document.createElement("button")
        button.value = traducciones.lang.spa;
        button.text = button.value;
        traducciones.appendChild(button);

      });


    });
};

function cargarDatos(pais) {
  fronterasNombres = []
  dameDatos(urlPais + pais)
    .then(response => {
      return response.json()
    })
    .then(paises => {
      let miPais = paises[0]
      capital = []
      miPais.capital.forEach(capi => {
        capital.push(capi)
      })
      poblacion = miPais.population
      area = miPais.area
      dominios = []
      miPais.tld.forEach(domi => {
        dominios.push(domi)
      })
      bandera = miPais.flags.svg
      escudo = miPais.coatOfArms.svg
      monedas = miPais.currencies
      traducciones = miPais.translations
      fronteras = miPais.borders
      monedasDatos = []
      Object.entries(monedas).forEach(moneda => {
        monedasDatos.push(moneda[1])
      })
      document.querySelectorAll("button").forEach(b => {
        b.disabled = false
      })
      
      if (fronteras != undefined) {
        for (let frontera of fronteras) {

          dameDatos(urlAlpha + frontera).then(response => response.json()).then(paises => {
          
            fronterasNombres.push(paises[0].name.common)
            if (i == fronteras.length) {
              document.querySelector("#divspecial")
              console.log(fronteras)

            }
          })
        }
      }
      else main.innerHTML="no tiene fronteras"
    })
}




dameBanderas = () => {
  main.innerHTML = ""
  let div = document.createElement("div")
  let h2 = document.createElement("h2")
  let img1 = document.createElement("img")
  let img2 = document.createElement("img")
  div.classList.add("container")
  div.classList.add("mt-5")
  h2.classList.add("text-center")
  img1.src = bandera
  img1.width = 304
  img1.height = 236
  img2.src = escudo
  img2.width = img1.width
  img2.height = img1.height
  div.appendChild(h2)
  div.appendChild(img1)
  div.appendChild(img2)
  main.appendChild(div)
}
cargarPaises = (continente) => {
  inicializar()
  fetch(urlRestCountries + "region/" + continente)
    .then((response) => response.json())
    .then((paises) => {
      var paisesSelect = document.querySelector("#paises");
      paisesSelect.innerHTML = "";
      let seleccionaPais = document.createElement("option");
      seleccionaPais.value = "0";
      seleccionaPais.text = "SeleccionaPais";
      paisesSelect.appendChild(seleccionaPais);
      paises.sort((a, b) => {
        if (a.name.common > b.name.common)
          return 1
        else return -1
      }).forEach((pais) => {
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

pintaDatosGeograficos = () => {
  main.innerHTML = ""
  let divFronteras = document.createElement("div")
  divFronteras.innerHTML = ""
  divFronteras.classList.add("container")
  divFronteras.classList.add("text")
  main.appendChild(divFronteras)
  fronterasNombres.forEach(frontera => {
    let h3 = document.createElement("h6")
    h3.innerHTML = frontera.toUpperCase()
    divFronteras.appendChild(h3)
    
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

Moneda = new Moneda("name", "symbol")
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
  th1.innerHTML = "CAPITAL "
  th2.innerHTML = "POBLACIÓN";
  th3.innerHTML = "ÁREA";
  th4.innerHTML = "DOMINIO";
  th5.innerHTML = "MONEDA";
  td2.innerHTML = pais.population
  td3.innerHTML = pais.area;
  td5.innerHTML = ""
  let ul = document.createElement("ul")
  ul.innerHTML = ""
  ul.style = "list-style-type:none"
  monedasDatos.forEach(moneda => {
    li = document.createElement("li")
    li.innerHTML = ` ${moneda.name} - ${moneda.symbol}`
    li.style = "list-style-type:none"
    ul.appendChild(li)
  })
  td5.appendChild(ul)
  let ulcapital = document.createElement("ul")
  capital.forEach(capi => {
    li = document.createElement("li")
    li.innerHTML = capi
    li.style = "list-style-type:none"
    ulcapital.appendChild(li)
    ul.style = "list-style-type:none"
  })
  td1.appendChild(ulcapital)
  ultld = document.createElement("ul")
  dominios.forEach(domi => {
    li = document.createElement("li")
    li.innerHTML = domi
    ultld.appendChild(li)
  })
  td4.appendChild(ultld)
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
