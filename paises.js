cargarPaises=()=>{
    fetch("https://restcountries.com/v3.1/region/europe/").then(response=>response.json())
    .then(datos=>{
        for(i=0;datos.length;i++){
            console.log(datos[i].name.common)
        
        }
    })
};

cargarPaises=(continente)=>{
    fetch("https://restcountries.com/v3.1/region/"+continente)
    .then((response)=>response.json())
    .then((paises)=>{
        paises.forEach(pais => {
            console.log("La capital de"+pais.name.common+" es "+pais.capital+" y tiene "+pais.population+" habitantes")
            //console.log(`La capital de ${pais.name.common} es ${pais.capital} y tiene ${pais.population} habitantes`)
            //template string
        });
    })
}