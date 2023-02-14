var capital;
var poblacion;
var area;
var dominios = [];
var fronteras = [];
var bandera;
var escudo;
var monedas;
var monedasDatos = [];
var traducciones = [];
var fronterasNombres = [];
var traduccionesDatos = [];

cargarPaises = (continente) => {
  let error = document.querySelector("#error");
  let paisesSelect = document.querySelector("#paises");
  paisesSelect.innerHTML = "";
  let option = document.createElement("option");
  option.value = 0;
  option.innerHTML = "Selecciona Pais .....";
  paisesSelect.appendChild(option);
  if (continente == "0") {
    //alert("Debe seleccionar un continente")
    error.innerHTML = "Debe seleccionar un continente";
    paisesSelect.innerHTML = "";
    paisesSelect.appendChild(option);
  } else {
    error.innerHTML = "";

    dameDatos("https://restcountries.com/v3.1/region/" + continente).then(
      (paises) => {
        paises.forEach((pais) => {
          optionPais = document.createElement("option");
          optionPais.value = pais.name.common;
          optionPais.innerHTML = pais.name.common;
          paisesSelect.appendChild(optionPais);
        });
      }
    );
  }
};

async function cargarDatos(pais) {
  if (pais == 0)
    document.querySelector("#error").innerHTML = "Debe seleccionar un pais";
  else {
    document.querySelector("#error").innerHTML = "";
    const paises = await dameDatos(
      "https://restcountries.com/v3.1/name/" + pais
    );
    let miPais = paises[0];
    capital = miPais.capital;
    poblacion = miPais.population;
    area = miPais.area;
    dominios = miPais.tld;
    bandera = miPais.flags.svg;
    escudo = miPais.coatOfArms.svg;
    monedas = miPais.currencies;
    traducciones = miPais.translations;
    fronteras = miPais.borders;
    if (fronteras != undefined)
      fronteras.forEach(async (frontera) => {
       const paises1=await dameDatos("https://restcountries.com/v3.1/alpha/" + frontera)
         
            let miPais = paises1[0]
            fronterasNombres.push(miPais.name.common);
          
       
      });
    Object.entries(monedas).forEach((moneda) => {
      monedasDatos.push(moneda[1]);
    });
    Object.entries(traducciones).forEach(async (traduccion) => {
      let miTraduccion = new Traduccion(traduccion[1].common, []);
      const paises2=await dameDatos("https://restcountries.com/v3.1/lang/" + traduccion[0])
        
          if (paises2 != undefined) {
            paises2.forEach((pais) => {
              miTraduccion.paisesDelIdioma.push(pais.name.common);
              traduccionesDatos.push(miTraduccion);
            });
          }
        }
      );
   
  }
  
  while (true) {
    setTimeout(pinta(), 5000);
    if (
      capital != undefined &&
      poblacion != undefined &&
      area != undefined &&
      dominios != undefined &&
      //fronteras != undefined &&
      bandera != undefined &&
      escudo != undefined &&
      monedas != undefined &&
      monedasDatos.length >0 &&
      traducciones.length >0 &&
      fronterasNombres.length >0 &&
      traduccionesDatos.length >0
    ) {
      pinta();
      break;
    }
  }
  function pinta() {
    console.log(capital);
    console.log(poblacion);
    console.log(area);
    console.log(dominios);
    console.log(fronteras);
    console.log(bandera);
    console.log(escudo);
    console.log(monedas);
    console.log(monedasDatos);
    console.log(traducciones);
    console.log(fronterasNombres);
    console.log(traduccionesDatos);
  }
}

class Traduccion {
  constructor(traduccionDelNombre, paisesDelIdioma) {
    this.traduccionDelNombre = traduccionDelNombre;
    this.paisesDelIdioma = paisesDelIdioma;
  }
}

dameDatos = (url) =>
  fetch(url).then((response) => {
    if (response.status == 200) return response.json();
  });