
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

dameDatos = (url) => fetch(url)

ponerDatosGenerales = (pais) =>{
var main = document.querySelector("main");
main.innerHTML=""
main.classList.add("row")
main.classList.add("align-middle")
let div1 = document.createElement("div")
div1.classList.add("col-sm-6")
var tabla = document.createElement("table")
let td1 = document.createElement("td")
let tr1 = document.createElement("tr")
let tr11 = document.createElement("tr")
main. appendChild(div1)
div1.appendchild(td1)
div1.appendchild(tr1)
div1.appendchild(tr11)
tr1.innerHTML = "capital" + pais.capital
let td2 = document.createElement("td")
let tr2 = document.createElement("tr")
let tr22 = document.createElement("tr")
div1.appendchild(td2)
div1.appendchild(tr2)
div1.appendchild(tr22)
tr2.innerHTML = "poblacion" + pais.population
let td3 = document.createElement("td")
let tr3 = document.createElement("tr")
let tr33 = document.createElement("tr")
div1.appendchild(td3)
div1.appendchild(tr3)
div1.appendchild(tr33)
tr3.innerHTML = "area" + pais.area
let div2 = document.createElement("div")
div2.classList.add(col-sm-6)
main.appendChild(div2)
let td4 = document.createElement("td")
let tr4 = document.createElement("tr")
let tr44 = document.createElement("tr")
div2.appendchild(td4)
div2.appendchild(tr4)
div2.appendchild(tr44)
div1.appendChild(tabla)
tr4.innerHTML= "dominio" + pais.domain

}
dameDatosGenerales = () => { 
  let paisesSelect = document.querySelector("#paises")
  dameDatos("https://restcountries.com/v3.1/alpha/" + "/name/" + selectpaises.value)
  .then(response => response.json())
  .then(pais=>{
    ponerDatosGenerales(pais[0])
  })
}


//https://restcountries.com/v3.1/alpha




dameDatosGenerales = () => {}
dameDatosGeograficos = () => {}
dameBanderas = () => {}
dameCodigodeMoneda = () => {}
traducciones = () => {}