
//cargaInicial= pais =>{

    //fetch("https://restcountries.com/v3.1/name")
    //.then(response => response.json())
    //.then(paises =>{})
   
//}
var urlrescountries = "https://restcountries.com/v3.1";


var capital;//STRING
var poblacion;//number
var area;//number
var moneda;// Moneda[]
var domino;//string
var fronteras;// string[]
var bandera;//string
var escudo;//string
var traducciones;//Traduccion[]

class Moneda {
    constructor(name,symbol){
this.name=name
this.symbol=symbol

    }
}

class Traduccion {

    constructor(common, official, paises) {
        this.common = common
        this.paises = paises
        this.official = official
    }
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
cargaFronteras = paises => {
fetch ("https://restcountries.com/v3.1/name/borders" + paises)
.then(response => response.json())

}

//vaciarElemento = (elemento) => {
  //  elemento.childNodes.forEach(hijo => {
    //    elemento.removeChild(hijo);
   // })
//}

//dameDatos = (url) => fetch(url);


dameNombreDePais = cca3=>{
dameDatos(urlrescountries + [cca3]).then (response => response.json)
.then(pais=>pais.borders)

}

//datosgenerales= (pais) =>{
// datosGenerales = document.querySelector("#datosgenerales");
//datosGenerales.innerHTML = ""


//var main=document.querySelector("main");
//main.innerHTML=""
//let table=document.createElement("table")




//      }




pillarDatosGeograficos = () => {

    var main = document.querySelector("main")
    var div = document.createElement("div")
    let h31 = document.createElement("h3")
    let h32 = document.createElement("h3")
    let h33 = document.createElement("h3")
    let h34 = document.createElement("h3")
    let h35 = document.createElement("h3")

    h31.innerHTML = "Frontera 1" + pais.frontera   
    h32.innerHTML = "Frontera 2" + pais.frontera
    h33.innerHTML = "Frontera 3" + pais.frontera
    h34.innerHTML = "Frontera 4" + pais.frontera
    h35.innerHTML = "Frontera 5" + pais.frontera


}




datosGeograficos = () => {
    let datosGeograficos = document.querySelector("#fronteras")
    datosGeograficos.innerHTML = ""
    let selectPaises = document.createElement("option")
    selectPaises.value = "0"

   

dameDatos(`${urlrescountries} /pais/borders/` + selectPaises.value)

        .then((response) => response.json())
        .then(pais => {
            pillarDatosGeograficos(pais[0])
        })

}
traducciones = () => { }
banderas = () => { }

 //var capital = pais[0].capital
 //console.log(capital)