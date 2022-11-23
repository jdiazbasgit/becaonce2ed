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
  var IdPaises = document.getElementById("pais");

  fetch("https://restcountries.com/v3.1/region/" + continente)
    .then((response) => response.json())
    .then((paises) => {

      paises.forEach(pais => {
        //console.log("la capital de "+pais.name.common+" es "+pais.capital+" y tiene "+pais.population+" habitantes")
        //console.log (`la capital de ${pais.name.common} es ${pais.capital} y tiene ${pais.population} habitantes`)
        // template string

        var option = document.createElement("option");
        option.value = pais.name.common;
        option.text = pais.name.common;
        IdPaises.add(option);
      });


      /*for (i = 0; i < datos.length; i++) {
        console.log(datos[i].name.official);
      }*/



    }).catch(error => {
      alert(error);
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
  var cboPais = document.getElementById("pais");
  cboPais.innerHTML = "";

  if (!event.target.value == '') {
    var option = document.createElement("option");
    option.text = "Seleccione un país";
    cboPais.add(option);
    cargarPaises(event.target.value);
  } else {
    alert("Por favor, seleccione un continente");
  }
});



var Pais = document.querySelector('#pais');

Pais.addEventListener('change', (event) => {
  fetch("https://restcountries.com/v3.1/name/" + Pais.value)
    .then((response) => response.json())
    .then((countriesList) => {

      countriesList.forEach(countryData => {
        document.querySelector('#region').innerHTML=countryData.region;
        document.querySelector('#capital').innerHTML=countryData.capital;
        document.querySelector('#area').innerHTML=countryData.area;





        document.querySelector('#nombre').innerHTML=countryData.currencies[0];
        document.querySelector('#simbolo').innerHTML=countryData.currencies[0];




        document.querySelector("#flag-container img").src = countryData.flags.png;
        document.querySelector("#shield-container img").src = countryData.coatOfArms.png;
        document.querySelector('#arabe').innerHTML=countryData.translations.ara.official;
        document.querySelector('#francia').innerHTML=countryData.translations.fra.official;
        document.querySelector('#italia').innerHTML=countryData.translations.ita.official;
      });

    }).catch(error => {
      alert(error);
    });
});

