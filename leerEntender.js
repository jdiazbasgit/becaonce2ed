/*1ª vas crear las varaibles las cuales le vamos a dar su caracteristica si es un ,string,array,number y bulean*/
var capital //string
var poblacion //number
var area // number
var dominios = []// las llaves delante de uba varible tiene es significado de array
var fronteras = [] // array esto tambien quiere decir qeu comenzamos a contar desde el 0 
var bandera //string
var escudo // string
var monedas = [] // array
var monedasDatos = [] // array
var traducciones = [] // array
var fronterasNombres = [] // array
var traduccionesDatos = [] // array

class Traduccion { // aqui emos creado una clase(class)
  constructor(traduccionDelNombre, paisesDelIdioma) {//aqui entre llaves va el constructor con donde va los elementos qeu lleva la clase 
    this.traduccionDelNombre = traduccionDelNombre; // entre corchetes dabas vidas a eso elementos 
    this.paisesDelIdioma = paisesDelIdioma;
  }
}

function cargarDatos(pais) { // el inicio de una function la cual le damos un nombre y entre parentecis le damos un parametro(pais) si es necesario y si no los dejanos vacios()
  dameDatos("https://restcountries.com/v3.1/name/" + pais)//abrimos corchetes,creamos otra function donde le damos un parametro,url, y le pasamos el parametro de cargaPais function anterior 
    .then(paises => { // .then es el inicio de la promesa para que pueda devolver los parametros 
      let miPais = paises[0] // let=vive la varible en el ambito de esta funcion y esa variable letcon un nombre le damos los parametros devueltos de la promesa y al ser un array comienza por [0]
      capital = miPais.capital //aqui escogemos la var= capital y le damos el valor de let=miPais el .(punto=introduccion ) y le damos el parametro que quemos que nos saque en esta casa la capital
      poblacion = miPais.population// var poblacion le damos el valor let mas population   que es igual  a saber la poblacion del pais del queremos saber ese dato 
      area = miPais.area // la var area le damos el valor de let mas l oque queremos que ne este caso es area  area= miPais.area
      dominios = miPais.tld //dominos es un array que tambien nos damos cuenta por le pones una ese(s) y es de varios elementos en caso es dominios=miPais.tld
      bandera = miPais.flags.svg // bandera en este caso cuando hacemos la busqueda tiene mas de un elemento y hay que expecicar cual queremos y se hace con el . y el nombre del elemento bandera= miPais.flags.svg
      escudo = miPais.coatOfArms.svg //escudo tambien tenemos que expecificar lo que queremos por se compone de mas de un elemento en esta caso seria  escudo=miPais.coatOfArms 
      monedas = miPais.currencies // le damos el valor a la var moneda que ne este caso seria moneda=miPais.currencies
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
        monedasDatos.push(Object.entries(moneda)[0])
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