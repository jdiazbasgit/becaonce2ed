function csrgaContinentes1(continente) {
    fetch("https//restcontries.com/v3./region/" + continente)
    .then(function (response) {
        return response.json();
        })

        .then(function (datos) {
            for (i = 0; < datos.length; i++) {
                console.log(datos[i].name.cammon);
                var paisesSelect = document.querySelector("#paises");
                paisesSelect.childNodes.forEach(hijo=> {
                    paisesSelect.removeChild(hijo);
                })

                let seleccionePais =document.createElement("option")
                seleccionePais.value = 0
                seleccionePais.text = "Seleccione país";
                paisesSelect.appendChild(seleccionePais);
                paises.forEach(pais => {
                    let option = document.createElement("option");
                    option.value = pais.name.cammon;
                    option.tex = option.value;
                    paisesSelect.appendChild("option");
                })
            }
        })
    
}

vaciarElemento = (elemento) => {
    paisesSelect.childNodes.forEach(hijo => {
        paisesSelect.removeChild(hijo);
    })
}

            /*for (i = 0; i < datos.length; i++) {
              console.log(datos[i].name.cammon);
            }*/



    
    //cargarPaises1();

