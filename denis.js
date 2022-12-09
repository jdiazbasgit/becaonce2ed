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

  main.innerHTML = ""
}

class Moneda {
  constructor(name, symbol) {
    this.name = name
    this.symbol = symbol
  }
}

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
     traduccionesEntries= Object.entries(miPais.translations)
     traduccionesEntries.forEach(t=>{
      traducciones.push(t[0])
      traduccionesDatos.push(t[1]) 
     })
  /* for (  i=0 ; i <traducciones.length;i++ ){
    pais23 = i
 console.log(pais23)
   }*/

      fronteras = miPais.borders
      monedasDatos = []
      Object.entries(monedas).forEach(moneda => {
        monedasDatos.push(moneda[1])
      })
      document.querySelectorAll("button").forEach(b => {
        b.disabled = false
      })
      let i = 0

      for (let frontera of fronteras) {

        dameDatos(urlAlpha + frontera).then(response => response.json()).then(paises => {
          i++
          fronterasNombres.push(paises[0].name.common)
          if (i == fronteras.length) {
            document.querySelector("#divspecial").classList.remove("fade")
          }
        })
      }
    })
}
dameBanderas = () => {
  main.innerHTML = ""
  let div = document.createElement("div")
  let h2 = document.createElement("h2")
  let img1 = document.createElement("img")
  let img2 = document.createElement("img")
  div.classList.add("container")
  div.classList.add("mt-3")
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
dameDatosTraducciones=()=>{
   for (  i=0 ; i <traducciones.length;i++ ){
    traducciones[i]
    console.log(tr)
   }
}
verPais = async (valorPais) => {
  let url = `https://restcountries.com/v3.1/name/${valorPais}`;
  pais = await cargaDatos(url);
 

}
verPaisTraducciones = async (valorPais, elemento) => {

  let url = `https://restcountries.com/v3.1/lang/${valorPais}`;
  paisesPorIdioma = await cargaDatos(url);
  try {
      let paisesPori= ""
      paisesPorIdioma.forEach(pais => {
          paisesPori = paisesPori + pais.name.common + "   "

      });
      elemento.setAttribute("title", paisesPori);
  } catch (error) {

  }



}
dameTraducciones = () =>{
  main.innerHTML=""
  let divTraducciones=document.createElement("div")
  divTraducciones.id="divTrad"
  divTraducciones.innerHTML=""
  main.appendChild(divTraducciones)
  traduccionesDatos.forEach(traduccion=>{
    let buttonTradcciones=document.createElement("button")
    buttonTradcciones.classList.add("btn")
    buttonTradcciones.classList.add("btn-primary")
    buttonTradcciones.setAttribute("data-bs-toggle","collapse")
    buttonTradcciones.setAttribute("data-bs-target","#divTRad")
    buttonTradcciones.innerHTML=traduccion.common
    divTraducciones.appendChild(buttonTradcciones)
  })

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
      seleccionaPais.text = "Selecciona pais";
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
  divFronteras.classList.add("text-center")
  main.appendChild(divFronteras)
  let olFronteras=document.createElement("ol")
  divFronteras.appendChild(olFronteras)
  fronterasNombres.forEach(frontera => {
    let liFronteras=document.createElement("li")
    let h3Fronteras = document.createElement("h3")
    h3Fronteras.innerHTML = frontera.toUpperCase()
    olFronteras.appendChild(liFronteras)
    liFronteras.appendChild(h3Fronteras)
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
  td2.innerHTML = pais.population
  td3.innerHTML = pais.area;
  td5.innerHTML = ""
  let ul = document.createElement("ul")
  ul.innerHTML = ""
  monedasDatos.forEach(moneda => {
    li = document.createElement("li")
    li.innerHTML = ` ${moneda.name} - ${moneda.symbol}`
    ul.appendChild(li)
  })
  td5.appendChild(ul)
  ulcapital = document.createElement("ul")
  capital.forEach(capi => {
    li = document.createElement("li")
    li.innerHTML = capi
    ulcapital.appendChild(li)
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


