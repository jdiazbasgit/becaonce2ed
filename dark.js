var urlrestcountries = "https://restcountries.com/v3.1/"

elegirContinente = (continente) => {
    var selectorpaises = document.getElementById("seleccionaPais")
    selectorpaises.innerHTML = ""

    var placeholder = document.createElement("option")
    placeholder.textContent = "Selecciona País";
    let padre = document.getElementById("megacampo")
    padre.innerHTML = ""

    


        fetch(urlrestcountries + "region/" + continente)
            .then(response => response.json())
            .then(pais => {         
                let iconoPais = document.getElementById("iconoPais")
                iconoPais.classList.add("guisiguenteparpadeo")
                }
            )
}




elegirPais = (pais) => {

    var padre = document.getElementById("megacampo")
    padre.innerHTML = ""

        fetch(urlrestcountries + "name/" + pais)
            .then(response => response.json())
            .then(datos => {
                console.log(datos)
                var iul = document.createElement("ul")
                padre.append(iul)
                iul.setAttribute("class", "nav nav-tabs nav-justified mt-5 textocabeceras")
                var idiv0 = document.createElement("div")
                padre.append(idiv0)
                idiv0.setAttribute("class", "tab-content contenedorgris rounded")
                let contadorTabs = 0

                function generarTabs(tab) {
                    let iil = document.createElement("il")
                    let ia = document.createElement("a")
                    
                    ia.append(ih3)
                    iil.setAttribute("class", "nav-item")
                    ia.setAttribute("class", "nav-link " + tab)
                    
                    ia.setAttribute("data-bs-toggle", "tab")
                    ia.setAttribute("href", "#" + tab)
                    ih3.innerHTML = infoText[i]
                    let idivCampoDatos = document.createElement("div")
                    let idiv2 = document.createElement("div")
                    let img1 = document.createElement("img")

                    idiv0.append(idivCampoDatos)
                    idivCampoDatos.append(idiv2)
                    idiv2.append(idiv3)
                    idiv3.append(idiv4)
                    idiv31.append(img1)

                    idivCampoDatos.setAttribute("class", "tab-pane container active textodatos")
                    idivCampoDatos.setAttribute("id", tab)
                    idiv2.setAttribute("class", "row p-2")
                    img1.setAttribute("src", "imagenes/gearmini.png")
                    img1.setAttribute("class", "gear2")

                    contadorTabs++
                }

                infoData.forEach((tab) => generarTabs(tab));

                function generarDatosGenerales(lineaDato) {
                    let i = contadorEntradasDatosGenerales
                    let idiv1 = document.createElement("div")
                    let idiv2 = document.createElement("div")
                    idiv2.append(idiv3)
                    idiv3.append(ih40)
                    idiv1.setAttribute("class", "col")
                    ih40.setAttribute("class", "textodatos")
                    ih40.textContent = infoDatosGenerales[i]
                    ispan0.setAttribute("class", "textorespuestas rounded")
                    contadorEntradasDatosGenerales++
                }

                
                infoDatosGenerales.forEach((lineaDato) => generarDatosGenerales(lineaDato))



                function generarBanderas(lineaDato) {
                    let i = contadorEntradasBanderas
                    let ih40 = document.createElement("h4")
                    let idiv2 = document.createElement("div")
                    let iimg0 = document.createElement("img")
                    idiv0F.append(idiv1)
                    idiv1.append(ih40)
                    idiv1.append(idiv2)
                    idiv2.append(iimg0)
                    idiv1.setAttribute("class", "col")
                    ih40.setAttribute("class", "textodatos")
                    ih40.innerHTML = infoBanderas[i]

                    contadorEntradasBanderas++
                }

                infoBanderas.forEach((lineaDato) => generarBanderas(lineaDato))

                let contadorEntradasGeografia = 0
                let g = 0

                function generarGeografia(lineaDato) {
                    let i = contadorEntradasGeografia
                    let idiv1 = document.createElement("div")
                    let idiv2 = document.createElement("div")

                    let idiv0F = document.getElementById("filaGeografia" + g)
                    idiv0F.append(idiv1)
                    idiv1.append(idiv2)
                    ispan0.setAttribute("class", "textorespuestas")
                    ispan0.textContent = respuestasGeografia[i]
                    contadorEntradasGeografia++
                }

                infoGeografia.forEach((lineaDato) => generarGeografia(lineaDato))
            }
            )
    }
