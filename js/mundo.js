/*cargarPaises = () => {
  fetch("https://restcountries.com/v3.1/region/europe")
    .then((response) => response.json())
    .then((datos) => {
      for (i = 0; i < datos.length; i++) {
        console.log(datos[i].name.official);
      }
    });
  cargarPaises1();
};*/



cargarPaises = (continente) => {
    var strPaises = document.getElementById("pais");
    
    fetch("https://restcountries.com/v3.1/region/" + continente)
      .then((response) => response.json())
      .then((paises) => {
  
        paises.forEach(pais => {
          //console.log("la capital de "+pais.name.common+" es "+pais.capital+" y tiene "+pais.population+" habitantes")
          //console.log (`la capital de ${pais.name.common} es ${pais.capital} y tiene ${pais.population} habitantes`)
          // template string

          var option = document.createElement("option");
          option.text=pais.name.common;
          strPaises.add(option);
        });

        
        /*for (i = 0; i < datos.length; i++) {
          console.log(datos[i].name.official);
        }*/
  
  
  
      }).catch(error => {
  
  
      });
    //cargarPaises1();
  };
  
  /*function cargarPaises1() {
    fetch("https://restcountries.com/v3.1/region/europe")
      .then(function (response) {
        return response.json();
      })
      .then(function (datos) {
        for (i = 0; i < datos.length; i++) {
          console.log(datos[i].name.common);
        }
      });
  }
  
  const btn = document.querySelector('#continente');
  
  btn.addEventListener('click', (event) => {
    cargarPaises('europe');
  });*/


var Continente = document.querySelector('#continent');

Continente.addEventListener('change', (event) => {
    var cboPais= document.getElementById("pais");

    for (var i=0;i<cboPais.length;i++){
        cboPais.remove(i);
    }

    if(!event.target.value==''){
        alert(event.target.value);

        var option = document.createElement("option");
        option.text="Seleccione un país";
        cboPais.add(option);

        document.querySelector('#continent').remove;
        cargarPaises(event.target.value);
    } else{
        alert("Por favor, seleccione un continente");
    }
});

  