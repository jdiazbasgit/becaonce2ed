cargaPaises = continente => {
    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then(response => response.json())
        .then(paises => {

            var paisesSelect = document.querySelector("#paises");
            paisesSelect.innerHTML = ""
            let seleccionePais = document.createElement("option")
            seleccionePais.value = "0"
            seleccionePais.text = "Selecciona país";

            paisesSelect.appendChild(seleccionePais);
            paises.forEach(pais => {

                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value;
                paisesSelect.appendChild(option)

                //console.log(pais.name.common)
            })
        })
}

//vaciarElemento.appendChild(option)

vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.removeChild(hijo);
    })
}


dameDatos = (url) => fetch(url)

//Dame Datos Generales

dameDatosGenerales = (pais) => {
    var main = document.querySelector("main");
    main.innerHTML = ""
    main.classList.add("row")
    main.classList.add("align-middle")
   let div1 = document.createElement("div")
   div1.classList.add("col-sm-6")
    let h21 = document.createElement("h2")
    h21.classList.add("text-danger")

    main.appendChild(div1)
    div1.appendChild(h21)
    h21.innerHTML = "Datos:"
    let h22 = document.createElement("h2")
    div1.appendChild(h22)
    h22.innerHTML = "Población:"
    let h23 = document.createElement("h2")
    div1.appendChild(h23)
    h23.innerHTML = "Área:"
    let div2 = document.createElement("div")
    div2.classList.add("col-sm-6")

    main.appendChild(div2)
    let h24 = document.createElement("h2")
    div2.appendChild(h24)
    h24.innerHTML = "Domicilio:"
    let h25 = document.createElement("h2")
    div2.appendChild(h25)
    h25.innerHTML = "Moneda:"

    let ul = document.createElement("ul")
    ul.classList.add("list-group")
    main.appendChild(ul)
    let il1 = document.createElement("il")
    il1.classList.add("list-group-item")
    il1.innerHTML = "Nombre:"
    ul:appendChild(il1)
    let il2 = document.createElement("il")
    il2.classList.add("list-group-item")
    il2.innerHTML = "Símbolo:"
    ul.appendChild(il2)

    // console.log(pais)
}

//Dame Datos Geográficos

dameDatosGeograficos = () => {
    var div1 = document.querySelector("#div");
    let div1 = document.createElement("div")
    let h21 = document.createElement("h2")
    div1.appendChild(div2)
    div2.appendChild(h21)
    h21.innerHTML = "Datos"

    formulario.appendChild(div)
    div.appendChild(h21)
    h21.innerHTML = "Datos"


}

dameBanderas = () => { }
dameCodigoDeMoneda = () => { }
traducciones = () => { }