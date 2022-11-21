cargarPaises = continente => {
    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then(response => response.json())
        .then(paises => {
            // for (i = 0; i < paises.lenght; i++) {
            paises.forEach(pais => {
                console.log(pais.name.common)
            });






        })
}

