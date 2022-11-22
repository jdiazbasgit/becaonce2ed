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

cargaPais = pais => {
    fetch("https://restcountries.com/v2/name/" + nombre)
        .then(response => response.json())
        .then(datosgenerales => {
            var datosGeneralesSelect = document.querySelector("#datosgenerales");
            vaciarElemento = (elemento);
            let datosGenerales = document.createElement("option")
            datosGenerales.text = "datosgenerales"
            datosGenerales.forEach(pais => {
                let datosgenerales = ["Pais","Nombre","Capital","Población","Lengua"]

              let option = document.createElement("option")
                option.value = pais.name.capital.population.languages
                option.text=option.value;
                datosGenerales.appendChild(option)
})


        })
}



