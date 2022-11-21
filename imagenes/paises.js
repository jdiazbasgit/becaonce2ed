cargarPaises= (continente)=>{
    fetch("https://restcountries.com/v3.1/region/" + continente)
    .then((response) => response.json(continente))
    .then((paises)=>{
        

        paises.forEach(pais=> {
            paises.querySelector("#continente").value= paises.querySelector("#continente").value + value
           
            

            
        });
    }) 

}