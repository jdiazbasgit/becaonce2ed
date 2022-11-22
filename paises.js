cargarPaises = (continente) => {
  fetch("https://restcountries.com/v3.1/region/" + continente)
    .then((response) => response.json())
    .then((paises) => {

      var paisesSelect = document.querySelector("#paises");
      paisesSelect.innerHTML = ""
      let seleccionaPaises = document.createElement("option")
      seleccionaPaises.value = "0"
      paisesSelect.appendChild(seleccionaPaises);
      paises.forEach(pais => {
        let option = document.createElement("option")
        option.value = pais.name.common;
        option.text = option.value;
        paisesSelect.appendChild(option);
      })
    })
}
vaciarElementos = (elementos) => {
  paisesSelect.childNodes.forEach(hijo => {
    paisesSelect.removeChild(hijo);
  })
}
dameDatos = (url) => fetch(url) {
.then((response) => response.json())
    .then((datos) => {

      var datosCapital = document.querySelector("#capital");
      datosCapital.innerHTML = ""
      let seleccionaCapital = document.createElement("td")
      seleccionaCapital.value = "0"
      datosCapital.appendChild(seleccioneCapital);
      capital.forEach(capital => {
        option.value = capital.name.common;
        option.text = option.value;
        datosCapital.appendChild(td);

      })
    })
}








