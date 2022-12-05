/*
cargarpaises = () => {

    fetch("https://restcountries.com/v3.1/region/europe")
        .then((response) => response.json())
        .then((datos) => {
            for (i = 0; i < datos.length; i++) {
                console.log(datos[i].name.official);
            }
        });
    

}*/

cargarpaises1 = (continente) => {
    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then((response) => response.json())
        .then((paises) => {

            paises.forEach(pais => {
                console.log(`la capital de ${pais.name.common} es ${pais.capital}, tiene ${pais.population} habitantes`)
            });
        })
};