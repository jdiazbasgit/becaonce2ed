var urlrestcountries = "https://restcountries.com/v3.1/"
const main= document.querySelector("main")

cargarPaises = (continente) => {
    fetch(urlrestcountries + "region/" + continente)
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
dameDatos = (url) => fetch(url)

dameDatosGeograficos = () => {
}
pintaDatosGenerales = (pais) => {
    console.log(pais)
    
    main.innerHTML = ""
    main.classList.add("row")
    main.classList.add("align-middle")
    let div1 = document.createElement("div")
    div1.classList.add("col-sm-6")
    let h21 = document.createElement("h2")
    main.appendChild(div1)
    div1.appendChild(h21)
    h21.innerHTML = "Capital:" + pais.capital
    let h22 = document.createElement("h2")
    div1.appendChild(h22)
    h22.innerHTML = "Poblacion:" + pais.population
    let h23 = document.createElement("h2")
    div1.appendChild(h23)
    h23.innerHTML = "Área:" + pais.area
    let div2 = document.createElement("div")
    div2.classList.add("col-sm-6")

    main.appendChild(div2)
    let h24 = document.createElement("h2")
    div2.appendChild(h24)
    h24.innerHTML = "Dominio:" + pais.tld
    let h25 = document.createElement("h2")
    div2.appendChild(h25)
    h25.innerHTML = "Moneda:"

    let ul = document.createElement("ul")
    ul.classList.add("list-group")
    main.appendChild(ul)
    let il1 = document.createElement("il")
    il1.classList.add("list-group-item")
    il1.innerHTML = "Nombre:"
    ul.appendChild(il1)
    let il2 = document.createElement("il")
    il2.classList.add("list-group-item")
    il2.innerHTML = "Simbol:"
    ul.appendChild(il2)


}
dameDatosGenerales = () => {
    let selectpaises = document.querySelector("#paises")
    dameDatos(urlrestcountries + "/name/" + selectpaises.value)
        .then(response => response.json())
        .then(pais => {
            pintaDatosGenerales(pais[0])
        })
}
  dameNombrePaisporCodigo = (codigo) => {
   dameDatos(urlrestcountries + "/alpha/" + codigo)
        .then(response => response.json())
        .then(pais => {
            return pais[0].name.common
        })

}



dameBanderas = () => {
    let h2=document.createElement("h2")
    main.appendChild(h2)
    h2.innerHTML="Banderas"

}
dameCodigodeMoneda = () => { }
traducciones = () => { 
    
    let div= document.createElement("div")
    div.classList.add("btn-group")
    main.appendChild(div)
    let button1=document.createElement("button")
    div.appendChild(button1)

}

