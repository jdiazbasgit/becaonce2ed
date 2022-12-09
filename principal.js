//1ª vas crear las varaibles las cuales le vamos a dar su caracteristica si es un ,string,array,number y bulean

var capital //string
var poblacion //number
var area // number
var dominios = [] //los corchetes delante de una varible indican un array y ademas un array empieza por [0]
var fronteras = [] //array
var bandera //string
var escudo //string
var monedas = [] //array
var monedasDatos = [] //array
var traducciones = [] //array
var fronterasNombres = [] //array
var traduccionesDatos = [] //array

class Traduccion {
  constructor(traduccionDelNombre, paisesDelIdioma) {
    this.traduccionDelNombre = traduccionDelNombre;
    this.paisesDelIdioma = paisesDelIdioma;
  }
}
//Se crea la Función a la que le damos un nombre y un parametro(pais), pero, si no es necesario queda vacío
function cargarDatos(pais) {
  dameDatos("https://restcountries.com/v3.1/name/" + pais) //Un parámetro url + el parametro de la Función cargaDatos(pais)
    .then(paises => { //.then es el inicio de la promesa para que pueda devolver los parametros 
      let miPais = paises[0] //let=vive la varible en el ambito de esta funcion y esa variable let con un nombre le damos los parametros devueltos de la promesa, comienza por [0]
      capital = miPais.capital //cogemos var capital y le damos el valor de let(miPais), el .(punto=introduccion) y damos el parametro que queremos que nos saque, en este caso "capital"
      poblacion = miPais.population //var poblacion le damos el valor let mas population, que es igual a la poblacion del pais queremos saber ese dato 
      area = miPais.area //var area le damos el valor de let mas l toquen que queremos, que ne este caso es area(area= miPais.area)
      dominios = miPais.tld //dominios es un array, nos damos cuenta porque le pones una ese(s) y esto indica que tenemos varios elementos
      bandera = miPais.flags.svg //en este caso, cuando hacemos la busqueda, vemos que tiene mas de un elemento y hay que expecicar cual queremos y lo hacemos con el "." y el nombre del elemento(bandera= miPais.flags.svg)
      escudo = miPais.coatOfArms.svg //aqui tambien tendríamos que expecificar igual que en el anterior
      monedas = miPais.currencies //var moneda le damos el valor(moneda=miPais.currencies)
      traducciones = miPais.translations
      fronteras = miPais.borders
      fronteras.forEach(frontera => {
        dameDatos("https://restcountries.com/v3.1/alpha/" + frontera)
          .then(paises => {
            let miPais = paises[0]
            fronterasNombres.push(miPais.name.common)
          })
      })
      monedas.forEach(monedas => {
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
}
cargarPaises = (continente) => {
  fetch("https://restcountries.com/v3.1/region/" + continente)
    .then((response) => response.json())
    .then((paises) => {

      var paisesSelect = document.querySelector("#paises");
      paisesSelect.innerHTML = ""
      let seleccionaPaises = document.createElement("option")
      seleccionaPaises.value = "0"
      paisesSelect.appendChild(seleccionaPaises);
      paises.forEach(pais => {
        let option = document.createElement("option")
        option.value = pais.name.common;
        option.text = option.value;
        paisesSelect.appendChild(option);
      })
    })
}
vaciarElementos = (elementos) => {
  paisesSelect.childNodes.forEach(hijo => {
    paisesSelect.removeChild(hijo);
  })
}
class Moneda {
  constructor(name, symbol) {
    this.name = name;
    this.symbol = symbol;
  }
}
dameDatos = (url) => fetch(url)
  .then(response => {
    if (response.status == 200)
      return response.json()
  })


ponerDatosGenerales = (pais) => {
  var main = document.querySelector("main");
  main.innerHTML = ""
  main.classList.add("row")
  main.classList.add("align-middle")
  let div1 = document.createElement("div")
  div1.classList.add("col-sm-6")
  var tabla = document.createElement("table")
  let td1 = document.createElement("td")
  let tr1 = document.createElement("tr")
  let tr11 = document.createElement("tr")
  div1.appendChild(tabla)
  main.appendChild(div1)
  div1.appendChild(td1)
  div1.appendChild(tr1)
  div1.appendChild(tr11)
  tr1.innerHTML = "capital: " + pais.capital
  let td2 = document.createElement("td")
  let tr2 = document.createElement("tr")
  let tr22 = document.createElement("tr")
  div1.appendChild(td2)
  div1.appendChild(tr2)
  div1.appendChild(tr22)
  tr2.innerHTML = "poblacion: " + pais.population
  let td3 = document.createElement("td")
  let tr3 = document.createElement("tr")
  let tr33 = document.createElement("tr")
  div1.appendChild(td3)
  div1.appendChild(tr3)
  div1.appendChild(tr33)
  tr3.innerHTML = "area: " + pais.area
  let div2 = document.createElement("div")
  div2.classList.add("col-sm-6")
  main.appendChild(div2)
  let td4 = document.createElement("td")
  let tr4 = document.createElement("tr")
  let tr44 = document.createElement("tr")
  div2.appendChild(td4)
  div2.appendChild(tr4)
  div2.appendChild(tr44)
  tr4.innerHTML = "dominio: " + pais.tld
  let td5 = document.createElement("td")
  let tr5 = document.createElement("tr")
  let tr55 = document.createElement("tr")
  div2.appendChild(td5)
  div2.appendChild(tr5)
  div2.appendChild(tr55)
  tr5.innerHTML = "moneda: "
  let td6 = document.createElement("td")
  let tr6 = document.createElement("tr")
  let tr66 = document.createElement("tr")
  div2.appendChild(td6)
  div2.appendChild(tr6)
  div2.appendChild(tr66)
  td6.innerHTML = "ㅤㅤㅤnombre: " + pais.moneda.name
  let td7 = document.createElement("td")
  let tr7 = document.createElement("tr")
  let tr77 = document.createElement("tr")
  div2.appendChild(td7)
  div2.appendChild(tr7)
  div2.appendChild(tr77)
  td7.innerHTML = "ㅤㅤㅤsimbolo: "
}
dameDatosGenerales = () => {
  let paisesSelect = document.querySelector("#paises")
  dameDatos("https://restcountries.com/v3.1/" + "name/" + paisesSelect.value)
    .then(response => response.json())
    .then(pais => {
      ponerDatosGenerales(pais[0])
    })
}
dameDatosMoneda = () => {
  let paisesSelect = document.querySelector("#paises")
  dameDatos("https://restcountries.com/v3.1/" + "name/" + paisesSelect.value)
    .then(response => response.json())
    .then(pais => {
      ponerDatosGenerales(pais[0])
    })
}
//https://restcountries.com/v3.1/alpha

//dameDatosGenerales = () => {}
dameDatosGeograficos = () => { }
dameBanderas = () => { }
dameTraducciones = () => { }