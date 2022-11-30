cargarPaises = (continente) => {
  
 
  paisesSelect = document.querySelector("#paises");
  paisesSelect.innerHTML = "";
  option = document.createElement("option");
  option.value = 0;
  option.innerHTML = "Selecciona Pais ....."; 
  paisesSelect.appendChild(option)
  fetch("https://restcountries.com/v3.1/region/" + continente)
    .then((response) => response.json())
    .then((paises) => {
      paises.forEach((pais) => {
        option = document.createElement("option");
        option.value = pais.name.common;
        option.innerHTML = pais.name.common;
        paisesSelect.appendChild(option)
      });

      /*for (i = 0; i < datos.length; i++) {
          console.log(datos[i].name.official);
        }*/
    })
    .catch((error) => {});
  //cargarPaises1();
};

cargarDatos=(pais)=>{
  if(pais==0)
  document.querySelector("#error").innerHTML="Debe seleccionar un pais";
  else{
    document.querySelector("#error").innerHTML="";
  }
}