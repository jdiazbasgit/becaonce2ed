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
cargarNaciones = paises => {
    fetch("https://restcountries.com/v3.1/subregion/{region}" + paises)
        .then(response => response.json())
        .then(paises => {
            paises.forEach(pais => {
                option.value = pais.name.common;
                document.querySelector("#pais").innerHTML = document.querySelector("#pais").innerHTML
               // console.log(pais.name.common)
            });






        })
}


