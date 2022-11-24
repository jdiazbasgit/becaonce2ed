cargarPaises = (continente) => {
    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then((response) => response.json())
        .then(paises => {

            var paisesSelect = document.querySelector("#paises");
            paisesSelect.innerHTML = ""
            let selecionaPais = document.createElement("option")
            selecionaPais.value = "0"
            selecionaPais.text = "Selecciona pais";
            paisesSelect.appendChild(selecionaPais);
            paises.forEach(pais => {

                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value
                paisesSelect.appendChild(option)
                // console.log(paises[i].name.common);

            })

        })
}
vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.renove.renoveChild(hijo);
    })
  }
 /*bandera https://goo.gl/maps/uDWEUaXNcZTng1fP6
 escudo https://mainfacts.com/media/images/coats_of_arms/pe.svg
 */
 https://restcountries.com/v3.1/name/peru
cargarBanderas = () => {
    let selectpaises = document.querySelector(#pais)
    dameDatos(urlrescountries + /name/+ selectpaises.value)
    .then((response) => response.json())
    .then(paises => {
    }}
        pintarBanderas= () => {
            dameDatos(urlrescountries + /alpha/+ flags)
            .then((response) => response.json())
            .then(paises => {
            }
        }

            pintarEscudos= () => {
                dameDatos(urlrescountries + /alpha/+ pais.flag.coatOfArmsº)
                .then((response) => response.json())
                .then(paises => {
                }

            console.log (banderas)
            var main = document.querySelector("main");
            main.innerHTML =""
            main.classList.add.apply("text-center")
            let h21 = document.createElement("h2");
            let th1 = document.createElement("th");
            main.appendChild(main)
            table.appendChild(table)
            tr1.appendChild(tr)
            th1.appendChild(th1)

 vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.renove.renoveChild(hijo);
   
    })
 } 
}
    



























































 

 











