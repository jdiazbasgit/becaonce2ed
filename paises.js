opcionescontinente = continente => {

    var paisesSelect = document.querySelector("#paises");
    paisesSelect.innerHTML = ""

    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then((response) => response.json())
        .then(pais => {
            let seleccionaPais = document.createElement("option")
            seleccionaPais.value = "0"
            seleccionaPais.text = "selecciona pais"
            paisesSelect.appendChild(seleccionaPais);
            pais.forEach(pais => {

                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value;
                paisesSelect.appendChild(option)
            });


        })



}

//buscar datos generales..










