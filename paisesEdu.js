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
/*cargarDatosGenerales = () => { 
    var main = document.querySelector("main");
    main.innerHTML = ""
    main.classList.add.apply("text-center")
    let tr1 = document.createElement("tr");
    let th1 = document.createElement("th");
    th1.classList.add("text -danger")
    main.appendChild("th1")
    tr1.innerHTML = "Datos" 
}

cargarDatosGeograficos = () => {

vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.renove.renoveChild(hijo);

    })

}

cargarTraducciones = () => {
    
 vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.renove.renoveChild(hijo);

    })

}   

cargarBanderas = () => { 

 vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.renove.renoveChild(hijo);

    })

}   
    



























































 

 











