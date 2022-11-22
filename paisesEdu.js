cargarPaises = (continente) => {
    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then((response) => response.json())
        .then(paises => {

            var paisesSelect = document.querySelector("#paises");
            paisesSelect.innerHTML = ""
            let selecionaPais = document.createElement("option")
            selecionaPais.value = "0"
            selecionaPais.text = "Selecciona pais";
            paisesSelect.appendChild(selecionaPais);
            paises.forEach(pais => {

                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value
                paisesSelect.appendChild(option)
                // console.log(paises[i].name.common);

            })

        })
    }
vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.renove.renoveChild(hijo);

    })

}









































