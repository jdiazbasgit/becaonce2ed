var urlRestCountries = "https://restcountries.com/v3.1/";
cargarPaises = (continente) => {
  fetch(urlRestCountries + "region/" + continente)
    .then((response) => response.json())
    .then((paises) => {
      var paisesSelect = document.querySelector("#paises");
      paisesSelect.innerHTML = "";
      let seleccionaPais = document.createElement("option");
      seleccionaPais.value = "0";
      seleccionaPais.text = "Selecciona pais";
      paisesSelect.appendChild(seleccionaPais);
      paises.forEach((pais) => {
        let option = document.createElement("option");
        option.value = pais.name.common;
        option.text = option.value;
        paisesSelect.appendChild(option);
        // console.log(pais.name.common)
      });
    });
};
vaciarElemento = (elemento) => {
  elemento.childNodes.forEach((hijo) => {
    elemento.removeChild(hijo);
  });
};
dameDatos = (URL) => fetch(URL);
/*dameNombreDePais= cca3 =>{
    dameDatos("https://restcountries.com/v2/name/" + cca3).then (response =>
    response.json)
    .then (pais => pais.name.common)
}*/
dameDatosGenerales = () => {
  let selectPaises = document.querySelector("#paises");
  dameDatos(urlRestCountries + "/name/" + selectPaises.value)
    .then((response) => response.json())
    .then(pais => {
      pìntaDatosGenerales(pais[0])
    })
}
pintaDatosGenerales = (pais) => {
  var main = document.querySelector("main");
  main.innerHTML = "";
  let table = document.createElement("table");
  table.classList.add("table");
  table.classList.add("table-stripped");
  table.classList.add("text-center");
  let tr1 = document.createElement("tr");
  let th1 = document.createElement("th");
  let th2 = document.createElement("th");
  let th3 = document.createElement("th");
  let th4 = document.createElement("th");
  let th5 = document.createElement("th");
  let tr2 = document.createElement("tr");
  let td1 = document.createElement("td");
  let td2 = document.createElement("td");
  let td3 = document.createElement("td");
  let td4 = document.createElement("td");
  let td5 = document.createElement("td");
  th1.innerHTML = "Capital "
  th2.innerHTML = "Población";
  th3.innerHTML = "Área";
  th4.innerHTML = "Dominio";
  th5.innerHTML = "Moneda";
  td1.innerHTML = pais.capital;
  td2.innerHTML = pais.population;
  td3.innerHTML = pais.area;
  td4.innerHTML = pais.tld;
  td5.innerHTML = pais.currencies;
  main.appendChild(table);
  table.appendChild(tr1);
  tr1.appendChild(th1);
  tr1.appendChild(th2);
  tr1.appendChild(th3);
  tr1.appendChild(th4);
  tr1.appendChild(th5);
  tr2.appendChild(td1);
  tr2.appendChild(td2);
  tr2.appendChild(td3);
  tr2.appendChild(td4);
  tr2.appendChild(td5);
};
