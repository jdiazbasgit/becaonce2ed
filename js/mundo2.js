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

var linear = (t) => {
    return t * t;
  }
  
  let x = -200;
  let incrementBy = .01;
  let idanimation = null;
  
  function animate() {
    var w = window.innerWidth + 200;
  
    incrementBy += 0.3;
    x = linear(incrementBy);
    document.querySelector("#car").style.display="block";
    document.querySelector("#car").style.left = x + "px";
  
    if (x >= w) {
        /*x = -200;
        incrementBy = .01;*/
         window.cancelAnimationFrame(idanimation);
         document.querySelector("#car").style.display="none";
    }
  
    idanimation =window.requestAnimationFrame(animate);
  }
  
  coche = () => {
    x = -200;
    incrementBy = .01;
    animate();
  }
  
  cargarPaises = (continente) => {
    var IdPaises = document.getElementById("pais");

    fetch("https://restcountries.com/v3.1/region/" + continente)
      .then((response) => response.json())
      .then((paises) => {
        
        coche();
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
    }
  });
  
  
  
  var Pais = document.querySelector('#pais');
  
  Pais.addEventListener('change', (event) => {
    fetch("https://restcountries.com/v3.1/name/" + Pais.value)
      .then((response) => response.json())
      .then((countriesList) => {
  
        countriesList.forEach(countryData => {
          document.querySelector('#region').innerHTML = countryData.region;
          document.querySelector('#capital').innerHTML = countryData.capital;
          document.querySelector('#area').innerHTML = countryData.area + ' Km<sup>2</sup>';
  
          document.querySelector("#flag-container img").src = countryData.flags.png;
          document.querySelector("#shield-container img").src = countryData.coatOfArms.png;
  
          var insAccordion = "";
          var i = 0;
  
          var translations = Object.keys(countryData['translations']);
  
          translations.forEach(idioma => {
            var sofficial = countryData.translations[idioma].official;
            var scommon = countryData.translations[idioma].common;
  
            insAccordion += '<div class="accordion accordion-flush">';
            insAccordion += '<div class="accordion-item">';
            insAccordion += '<h2 class="accordion-header id="flush-heading' + i + '">';
            insAccordion += '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse' + i + '">';
            insAccordion += scommon;
            insAccordion += '</button>';
            insAccordion += '</h2>';
            insAccordion += '<div id="flush-collapse' + i + '" class="accordion-collapse collapse"';
            insAccordion += 'aria-labelledby="flush-heading' + i + '" data-bs-parent="#accordionFlushExample">';
            insAccordion += '<div class="accordion-body">';
            insAccordion += sofficial;
            insAccordion += '</div>';
            insAccordion += '</div>';
            insAccordion += '</div>';
            insAccordion += '</div>';
            i++;
          });
  
          document.querySelector('#traducir').innerHTML = insAccordion;
  
          var monedas = Object.keys(countryData['currencies']);
  
  
  
          if (monedas.length > 1) {
            var sname = "";
            var ssymbol = "";
            monedas.forEach(tipo => {
              /*sname += countryData.currencies[tipo].name + ', ';
              ssymbol += countryData.currencies[tipo].symbol + ', ';*/
              sname += '<li class="border-0">'+countryData.currencies[tipo].name+'</li>';
              ssymbol += '<li class="border-0">'+countryData.currencies[tipo].symbol+'</li>';
            });
  
            /*document.querySelector('#nombre').innerHTML = sname.slice(0, -2);
            document.querySelector('#simbolo').innerHTML = ssymbol.slice(0, -2);*/
            document.querySelector('#nombre').innerHTML = sname;
            document.querySelector('#simbolo').innerHTML = ssymbol;
            
          } else if (monedas.length == 1) {
            document.querySelector('#nombre').innerHTML = '<li class="border-0">'+countryData.currencies[monedas].name+'</li>';
            document.querySelector('#simbolo').innerHTML = '<li class="border-0">'+countryData.currencies[monedas].symbol+'</li>';
          }
        });
  
      }).catch(error => {
        alert("Hello world!");
      });
  });