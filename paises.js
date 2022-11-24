

opcionescontinente = continente => {

    var paisesSelect = document.querySelector("#paises");
    paisesSelect.innerHTML = ""

    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then((response) => response.json())
        .then(pais => {
            let seleccionaPais = document.createElement("option")
            seleccionaPais.value = "0"
            seleccionaPais.text = "selecciona pais"
            paisesSelect.appendChild(seleccionaPais);
            pais.forEach(pais => {

                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value;
                paisesSelect.appendChild(option)
            });


        })



}

//buscar datosGenerales..

vaciarElementos = (elementos) => {
    paisesSelect.childNodes.forEach(hijo => {
        paisesSelect.removechild(hijo);
    })
}
damedatos = (URL) => fetch(URL){
}
datosGenerales => {
    var main = document.querySelectorAll("main");
    main.innerHTML
    main.classlist.add("row");
    main.classlist.add("col megacol");
    let div1 = document.createElement("div");
    div1.classList.add("");
    let h3 = document.createElement("h3");
    h31.classlist.add("text-success")
}




