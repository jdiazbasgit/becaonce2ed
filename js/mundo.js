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
function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

async function getRegion(continente) {
  const response = await fetch(restcountries.Region + continente);
  document.getElementById("spinner").style.display = "block";
  await sleep(2000);
  document.getElementById("spinner").style.display = "none";
  return await response.json()
}

async function getName(pais) {
  const response = await fetch(restcountries.Name + pais);
  document.getElementById("spinner").style.display = "block";
  await sleep(2000);
  document.getElementById("spinner").style.display = "none";
  return await response.json();
}


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
//Registra un evento a un objeto en especifico
Pais.addEventListener('change', (event) => {
  fetch("https://restcountries.com/v3.1/name/" + Pais.value)
    .then((response) => response.json())
    .then((countriesList) => {

      countriesList.forEach(countryData => {
        document.querySelector('#region').innerHTML = countryData.region;
        document.querySelector('#capital').innerHTML = countryData.capital;
        document.querySelector('#population').innerHTML = countryData.population;
        document.querySelector('#area').innerHTML = countryData.area;
        document.querySelector("#flag-container img").src = countryData.flags.png;
        document.querySelector("#shield-container img").src = countryData.coatOfArms.png;
        document.querySelector('#arabe').innerHTML = countryData.translations.ara.official;
        document.querySelector('#francia').innerHTML = countryData.translations.fra.official;
        document.querySelector('#italia').innerHTML = countryData.translations.ita.official;
        //document.querySelector('#portugal').innerHTML=countryData.translations.por.official;
        document.querySelector('#fronteras').innerHTML = countryData.borders;

        var fronteras = Object.keys(countryData.borders);

        if (fronteras.length > 1) {
          var front = "";
          fronteras.forEach(nombre => {
            front += countryData.borders[nombre] + ' | ';
          });

          document.querySelector("#fronteras").innerHTML = front;
        } else if (fronteras.length != 1) {
          document.querySelector("#fronteras").innerHTML = "No hay fronteras";
        }

        var monedas = Object.keys(countryData['currencies']);
        if (monedas.length > 1) {
          var sname = "";
          var ssymbol = "";
          monedas.forEach(tipo => {
            sname += countryData.currencies[tipo].name + ' | ';
            ssymbol += countryData.currencies[tipo].symbol + ' | ';
          });

          document.querySelector('#nombre').innerHTML = sname.slice(0, -2);
          document.querySelector('#simbolo').innerHTML = ssymbol.slice(0, -2);
        } else if (monedas.length == 1) {
          document.querySelector('#nombre').innerHTML = countryData.currencies[monedas].name;
          document.querySelector('#simbolo').innerHTML = countryData.currencies[monedas].symbol;
        }

      });

    }).catch(error => {
      alert(error);
    });
});

