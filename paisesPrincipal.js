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
dameDatos = (url) => fetch(url)

dameDatosGeograficos = () => {
}
dameDatosGenerales = () => {
    var main = document.querySelector("main");
    main.innerHTML=""
    main.classList.add("row")
    main.classList.add("align-middle")
    let div1 = document.createElement("div")
    div1.classList.add("col-s")
    div1.classList.add("")
    let h21 = document.createElement("h2")
    h21.classList.add("text-danger")
    main.appendChild(div1)
    div1.appendChild(h21)
    h21.innerHTML = "Datos"
    let h22= document.createElement("h2")
    div1.appendChild(h22)
    h22.innerHTML="Poblacion"
}




dameBanderas = () => { }
dameCodigodeMoneda = () => { }
traducciones = () => { }

