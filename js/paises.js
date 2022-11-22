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
  var strPaises='';
  fetch("https://restcountries.com/v3.1/region/" + continente)
    .then((response) => response.json())
    .then((paises) => {

      paises.forEach(pais => {
        //console.log("la capital de "+pais.name.common+" es "+pais.capital+" y tiene "+pais.population+" habitantes")
        //console.log (`la capital de ${pais.name.common} es ${pais.capital} y tiene ${pais.population} habitantes`)
        // template string
        strPaises += pais.name.common + '<br>';
      });

      document.getElementById("pais").innerHTML =strPaises;

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
}*/

const btn = document.querySelector('#cargarPaises');

btn.addEventListener('click', (event) => {
  cargarPaises('europe');
});