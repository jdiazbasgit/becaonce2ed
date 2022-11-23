dameDatos = dameNombreDePais => {
fetch (https://restcountries.com/v3.1/name/peru + dameNombreDePais) 
.then(response => response.json())
.then(paises => {

    var paisesSelect = document.querySelector("#paises");
    paisesSelect.innerHTML = ""
    let seleccionePais = document.createElement("option")
    seleccionePais.value = "0"
    seleccionePais.text = "Selecciona país";
    paisesSelect.appendChild(seleccionePais);
    paises.forEach (pais => {

        let option = document.createElement("option");
        option.value = pais.name.common;
        option.text = option.value;
        paisesSelect.appendChild(option)

        //console.log(pais.name.common)
    })
})
}

vaciarElemento = (elemento) => {
elemento.childNodes.forEach(hijo => {
    elemento.removeChild(hijo);
})
}