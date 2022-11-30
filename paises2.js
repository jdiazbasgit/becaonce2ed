elegirContinente = (continente) => {
  var selectorpaises = document.getElementById("seleccionaPais")
  selectorpaises.innerHTML = ""

  var placeholder = document.createElement("option")
  placeholder.textContent = "Selecciona Pais";
  placeholder.value = null;
  selectorpaises.appenChild(placeholder);

  fetch("https://restcountries.com/v3.1/region/" + continente)
    .then(responsse => responsse.json())
    .then(pais => {
      pais.forEach(pais => {
        console.log("La capital de " + pais.name.common + " es " + pais.capital)

        var nombredepais = pais.name.common;
        var nuevaoption.value = nombredepais;
        selectorpaises.appendChild(nuevaoption);
      }
      )



    })
}

elegirPais = (pais) => 


  selectorpaises.innerHTML = ""
  var placeholder = document.createElement("option")
  placeholder.textContent = "Selecciona Pais";
  placeholder.value = null;
  selectorpaises.appendChild(placeholder)

  fetch("https://restcountries.com/v3.1/name/" + pais)
    .then(response => response.json())
    .then(datos => {

      document.querySelectorAll(".nombreDePaisClass").innerHTML = pais
      pais.forEach(pais => {

        console.log("La capital de " + pais.name.common + " es " + pais.capital)
        var selectorpaises = document.getElementById("seleccionaPais")
        var nombreDePais = pais.name.common;
        var nuevaoption = document.createElement("option")
        nuevaoption.textContent = nombreDePais;
        nuevaoption.value = nombredepais;
        selectorpaises.appendChild(nuevaoption);
 ).catch(error => {

        })
    })

