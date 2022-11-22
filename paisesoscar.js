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
                // console.log(pais.name.common)
            });






        })
}
vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.removeChild(hijo);
    })
}
dameDatos = (URL) => fetch( URL )
dameNombreDePais= cca3 =>{
    dameDatos("https://restcountries.com/v2/name/" + cca3).then (response =>
    response.json)
    .then (pais => pais.name.common)
}

function generales(){
datosGenerales=document.querySelector("#datosgenerales");
datosGenerales.innerHTML=""


}

function geograficos()

function banderas()

function traducciones()

