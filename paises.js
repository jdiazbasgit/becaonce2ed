cargarPaises = (continente) => {
    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then((response) => response.json())
        .then((paises) => {


            var paisesSelect = document.querySelector("#paises");
            paisesSelect.innerHTML = ""
            let seleccionaPaises = document.createElement("option")
            seleccionaPaises.value = "0"
            seleccionaPaises.text = "Selecciona pais";
            paisesSelect.appendChild(seleccionaPaises);
            paises.forEach(pais => {
                let option = document.createElement("option")
                option.value = pais.name.common;
                option.text = option.value;
                paisesSelect.appendChild(option);
               // varciarElementos.appendChild(option)
            })
        })
}

varciarElementos = (elementos) => {
    paisesSelect.childNodes.forEach(hijo => {
        paisesSelect.removeChild(hijo);
    })
}
  dameDatos = (url)=> fetch(url)
   var tabla = document.querySelector("#nav");
   let columna = document.createElement ("div")
   let ul = document.createElement("ul")
   columna.appendChild(ul)

  dameDatosGenerales =()=>{}
  dameDatosGeograficos =()=>{}
  dameBanderas =()=>{} 
  dameCodigodeMoneda =() =>{}
  traducciones =() =>{}

