elegirContinente=(continente)=>{
    fetch("https://restcountries.com/v3.1/region/"+continente)
    .then(response=>response.json())
    .then(pais=>{
        pais.forEach(pais => {
            console.log("La capital de "+pais.name.common+" es "+pais.capital)
            document.querySelector("#seleccionaPais")
        document.createElement("option").innerHTML = pais.name.common
            /*<option class="opcionescontinentes" value="null">SeleccionaPaís</option>
            
        });
        /*for(i=0; i<datos.length; i++){
            console.log(datos[i].name.official)*/ //con forEach es más facil
        
        }
    ).catch(error=>{
        //este catch como forma de tipificar un fallo
    })
})}

/*

document.getElementById("seleccionaContinente").addEventListener("change", myFunction);

function rellenar() {
  console.log("La capital de")

}
seleccionContinente=(continente)=>{
    fetch("https://restcountries.com/v3.1/region/"+continente)
    .then(response=>response.json())
    .then(pais=>{
        pais.forEach(pais => {
            console.log("La capital de "+pais.name.common+" es "+pais.capital)
            
        });
        /*for(i=0; i<datos.length; i++){
            console.log(datos[i].name.official)*/ //con forEach es más facil
            /*
        }
    ).catch(error=>{
        //este catch como forma de tipificar un fallo
    })
}

var selectContinente = document.querySelector('.continente');

selectContinente.addEventListener('change', (event) => {
    fetch("https://restcountries.com/v3.1/region/europe")
    .then(response=>response.json())
    .then(pais=>{
        pais.forEach(pais => {
            console.log("La capital de "+pais.name.common+" es "+pais.capital)
            
        });
        /*for(i=0; i<datos.length; i++){
            console.log(datos[i].name.official)*/ //con forEach es más facil
            /*
        }
    ).catch(error=>{
        //este catch como forma de tipificar un fallo
    })
}); */