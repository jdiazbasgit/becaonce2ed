document.body.scrollTop = document.documentElement.scrollTop = 0;
console.log(localStorage.getItem("idiomaWebSpaCk"))
cargarAjustes()
console.log(localStorage.getItem("idiomaWebSpaCk"))

function selectorPestanas(id) {
    document.getElementById("ajustesLabelPestNinguna").classList.remove("active")
    document.getElementById("ajustesLabelPestDatos").classList.remove("active")
    document.getElementById("ajustesLabelPestGeografia").classList.remove("active")
    document.getElementById("ajustesLabelPestTraducciones").classList.remove("active")
    document.getElementById("ajustesLabelPestBandera").classList.remove("active")
    let labelActiva = document.getElementById(id)
    labelActiva.classList.add("active")
}


function cargarAjustes() {
    console.log(localStorage.getItem("labelPestDat"))
    let labelPestNing = document.getElementById("ajustesInputPestNinguna")
    let labelPestDatos = document.getElementById("ajustesInputPestDatos")
    let labelPestGeo = document.getElementById("ajustesInputPestGeo")
    let labelPestTra = document.getElementById("ajustesInputPestTra")
    let labelPestBan = document.getElementById("ajustesInputPestBan")
    if (localStorage.getItem("labelPestDat") === null) {
        localStorage.setItem("labelPestDat", labelPestDatos.checked)
    }
    if (localStorage.getItem("labelPestNin") === "true") {
        document.getElementById("ajustesLabelPestNinguna").classList.add("active")
        labelPestNing.checked = true
    }

    if (localStorage.getItem("labelPestDat") === "true") {
        document.getElementById("ajustesLabelPestDatos").classList.add("active")
        labelPestDatos.checked = true
    }

    if (localStorage.getItem("labelPestGeo") === "true") {
        document.getElementById("ajustesLabelPestGeografia").classList.add("active")
        labelPestGeo.checked = true
    }
    if (localStorage.getItem("labelPestTra") === "true") {
        document.getElementById("ajustesLabelPestTraducciones").classList.add("active")
        labelPestTra.checked = true
    }
    if (localStorage.getItem("labelPestBan") === "true") {
        document.getElementById("ajustesLabelPestBandera").classList.add("active")
        labelPestBan.checked = true
    }
    console.log(localStorage)
    let radioIdioma = document.getElementById("ajustesIdiomaSpa")
    if (localStorage.getItem("idiomaWebSpaCk") === null) {
        localStorage.setItem("idiomaWebSpaCk", radioIdioma.checked)
    }
    let idiomaWeb = document.getElementById("ajustesIdiomaSpa")
    let idiomaWebEn = document.getElementById("ajustesIdiomaEng")
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        idiomaWeb.checked = true
    }
    else {
        idiomaWebEn.checked = true
    }
    let extraPlaneta = document.getElementById("ajustesOcultarPlaneta")
    if (localStorage.getItem("extraPlaneta") === "true") {
        extraPlaneta.checked = true
    }
    else {
        extraPlaneta.checked = false
    }



    let extraNoIntro = document.getElementById("ajustesSaltarIntro")
    if (localStorage.getItem("extraNoIntro") === "true") {
        extraNoIntro.checked = true
    }
    else {
        extraNoIntro.checked = false
    }
    if (localStorage.getItem("extraNoIntro") === "true") {
        let megabody = document.getElementById("megabody")
        megabody.classList.remove("blur")
        let body = document.querySelector("body")
        body.classList.remove("bodyoverflowHide")
        let introDiv = document.getElementById("introdiv")
        introDiv.innerHTML = ""
    }
    let extraTraducionNativa = document.getElementById("ajustesTraduNativa")
    if (localStorage.getItem("extraTraducionNativa") === "true") {
        extraTraducionNativa.checked = true
    }
    else {
        extraTraducionNativa.checked = false
    }

    let extraDelay = document.getElementById("ajustesForzarDelay")
    if (localStorage.getItem("extraDelay") === "true") {
        extraDelay.checked = true
    }
    else {
        extraDelay.checked = false
    }


    generarSelects()


}

function guardarAjustes() {
    let radioIdioma = document.getElementById("ajustesIdiomaSpa")
    localStorage.setItem("idiomaWebSpaCk", radioIdioma.checked)
    console.log(localStorage.getItem("idiomaWebSpaCk"))
    let extraPlaneta = document.getElementById("ajustesOcultarPlaneta")
    localStorage.setItem("extraPlaneta", extraPlaneta.checked)
    let extraNoIntro = document.getElementById("ajustesSaltarIntro")
    localStorage.setItem("extraNoIntro", extraNoIntro.checked)
    let extraTraducionNativa = document.getElementById("ajustesTraduNativa")
    localStorage.setItem("extraTraducionNativa", extraTraducionNativa.checked)
    let extraDelay = document.getElementById("ajustesForzarDelay")
    localStorage.setItem("extraDelay", extraDelay.checked)
    let guardarPestDatos = document.getElementById("ajustesInputPestDatos")
    localStorage.setItem("labelPestDat", guardarPestDatos.checked)
    let guardarPestNin = document.getElementById("ajustesInputPestNinguna")
    localStorage.setItem("labelPestNin", guardarPestNin.checked)
    let guardarPestGeo = document.getElementById("ajustesInputPestGeo")
    localStorage.setItem("labelPestGeo", guardarPestGeo.checked)
    let guardarPestTra = document.getElementById("ajustesInputPestTra")
    localStorage.setItem("labelPestTra", guardarPestTra.checked)
    let guardarPestBan = document.getElementById("ajustesInputPestBan")
    localStorage.setItem("labelPestBan", guardarPestBan.checked)
    console.log(localStorage)
    generarSelects()
}


function entrar() {
    let introDiv = document.getElementById("introdiv")
    introDiv.onclick = ""
    let videoHBu = document.getElementById("videoHB")
    let videoHDe = document.getElementById("videoHD")
    let videoHIz = document.getElementById("videoHI")
    videoHBu.play()
    videoHDe.play()
    videoHIz.play()
    let animPI = document.getElementById("animHangarIzq")
    animPI.classList.add("animPuertaIzq")
    let animPD = document.getElementById("animHangarDer")
    animPD.classList.add("animPuertaDerc")
    let animPT = document.getElementById("animHangarTop")
    animPT.classList.add("animPuertaTop")
    let animPB = document.getElementById("animHangarBot")
    animPB.classList.add("animPuertaBottom")
    let megabody = document.getElementById("megabody")
    megabody.classList.add("quitarblur")
    megabody.classList.remove("blur")
    setTimeout(() => {
        let body = document.querySelector("body")
        body.classList.remove("bodyoverflowHide")
        let introDiv = document.getElementById("introdiv")
        introDiv.innerHTML = ""
    }, 6100);


}

function generarSelects() {
    let padre = document.getElementById("megacampo")
    padre.innerHTML = ""
    let madre = document.getElementById("campoSelects")
    madre.innerHTML = ""
    if (localStorage.getItem("extraPlaneta") === "true") {
        console.log("no hay planta")
    }
    else {
        let row0 = document.createElement("div")
        row0.classList.add("row")
        madre.append(row0)
        let col0 = document.createElement("div")
        col0.classList.add("col")
        row0.append(col0)
        let h30 = document.createElement("h3")
        h30.setAttribute("class", "bg-transparent p-2 rounded text-center textocabeceras")
        if (localStorage.getItem("idiomaWebSpaCk") === "true") {
            h30.textContent = "Planeta"
        }
        else {
            h30.textContent = "Planet"
        }
        col0.append(h30)
        let ul0 = document.createElement("ul")
        ul0.setAttribute("class", "list-group list-group-light mb-0")
        col0.append(ul0)
        let li0 = document.createElement("il")
        li0.setAttribute("class", "list-group-item d-flex justify-content-center align-items-center textoselects")
        ul0.append(li0)
        let idivs0 = document.createElement("div")
        idivs0.setAttribute("class", "d-flex align-items-center")
        li0.append(idivs0)
        let iimgs0 = document.createElement("img")
        iimgs0.setAttribute("src", "imagenes/planet.svg")
        iimgs0.setAttribute("width", "45px")
        iimgs0.setAttribute("class", "bg-light rounded-circle guisiguente")
        idivs0.append(iimgs0)
        let idivs1 = document.createElement("div")
        idivs1.setAttribute("class", "ms-3")
        idivs0.append(idivs1)
        let ip0 = document.createElement("p")
        ip0.classList.add("fw-bold")
        ip0.classList.add("mb-1")
        idivs1.append(ip0)
        let iselect0 = document.createElement("select")
        iselect0.setAttribute("name", "#")
        iselect0.classList.add("p-0")
        iselect0.disabled = true
        ip0.append(iselect0)
        let ioption0 = document.createElement("option")
        ioption0.setAttribute("value", "null")
        ioption0.classList.add("#")
        if (localStorage.getItem("idiomaWebSpaCk") === "true") {
            ioption0.textContent = "Planeta Tierra"
        }
        else {
            ioption0.textContent = "Planet Earth"
        }
        iselect0.append(ioption0)
    }


    let row1 = document.createElement("div")
    row1.setAttribute("class", "row mb-2")
    row1.setAttribute("id", "filaContinenteScroll")
    madre.append(row1)
    let idivs2 = document.createElement("div")
    idivs2.classList.add("col")
    row1.append(idivs2)
    let ih31 = document.createElement("h3")
    ih31.setAttribute("class", "bg-transparent p-2 rounded text-center textocabeceras")
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        ih31.textContent = "Continente"
    }
    else {
        ih31.textContent = "Continent"
    }
    idivs2.append(ih31)
    let iul1 = document.createElement("ul")
    iul1.setAttribute("class", "list-group list-group-light mb-0")
    idivs2.append(iul1)
    let ili1 = document.createElement("li")
    ili1.setAttribute("class", "list-group-item d-flex justify-content-center align-items-center textoselects")
    iul1.append(ili1)
    let idivs3 = document.createElement("div")
    idivs3.setAttribute("class", "d-flex align-items-center")
    ili1.append(idivs3)
    let iimgs1 = document.createElement("img")
    iimgs1.setAttribute("src", "imagenes/world.svg")
    iimgs1.setAttribute("width", "45px")
    iimgs1.setAttribute("class", "bg-light rounded-circle guisiguenteparpadeo")
    iimgs1.setAttribute("id", "iconoContinente")
    idivs3.append(iimgs1)
    let idivs4 = document.createElement("div")
    idivs4.classList.add("ms-3")
    idivs3.append(idivs4)
    let ip1 = document.createElement("p")
    ip1.setAttribute("class", "fw-bold mb-1")
    idivs4.append(ip1)
    let iselect1 = document.createElement("select")
    iselect1.setAttribute("name", "continente")
    iselect1.setAttribute("class", "opcionescontinentescasilla p-0")
    iselect1.setAttribute("id", "seleccionaContinente")
    iselect1.setAttribute("onchange", "elegirContinente(value)")
    ip1.append(iselect1)

    let ioption1 = document.createElement("option")
    ioption1.classList.add("opcionescontinentes")
    ioption1.value = "null"
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        ioption1.textContent = "Selecciona Continente"
    }
    else {
        ioption1.textContent = "Select Continent"
    }
    iselect1.append(ioption1)

    let ioption2 = document.createElement("option")
    ioption2.classList.add("opcionescontinentes")
    ioption2.value = "asia"
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        ioption2.textContent = "Asia"
    }
    else {
        ioption2.textContent = "Asia"
    }
    iselect1.append(ioption2)

    let ioption3 = document.createElement("option")
    ioption3.classList.add("opcionescontinentes")
    ioption3.value = "africa"
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        ioption3.textContent = "África"
    }
    else {
        ioption3.textContent = "Africa"
    }
    iselect1.append(ioption3)

    let ioption4 = document.createElement("option")
    ioption4.classList.add("opcionescontinentes")
    ioption4.value = "americas"
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        ioption4.textContent = "América"
    }
    else {
        ioption4.textContent = "America"
    }
    iselect1.append(ioption4)

    let ioption5 = document.createElement("option")
    ioption5.classList.add("opcionescontinentes")
    ioption5.value = "oceania"
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        ioption5.textContent = "Oceanía"
    }
    else {
        ioption5.textContent = "Oceania"
    }
    iselect1.append(ioption5)

    let ioption6 = document.createElement("option")
    ioption6.classList.add("opcionescontinentes")
    ioption6.value = "europe"
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        ioption6.textContent = "Europa"
    }
    else {
        ioption6.textContent = "Europe"
    }
    iselect1.append(ioption6)

    let idivs5 = document.createElement("div")
    idivs5.classList.add("col")
    row1.append(idivs5)
    let ih32 = document.createElement("h3")
    ih32.setAttribute("class", "bg-transparent p-2 rounded text-center textocabeceras")
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        ih32.textContent = "País"
    }
    else {
        ih32.textContent = "Country"
    }
    idivs5.append(ih32)
    let iul2 = document.createElement("ul")
    iul2.setAttribute("class", "list-group list-group-light mb-0")
    idivs5.append(iul2)
    let ili2 = document.createElement("li")
    ili2.setAttribute("class", "list-group-item d-flex justify-content-center align-items-center textoselects")
    iul2.append(ili2)
    let idivs6 = document.createElement("div")
    idivs6.setAttribute("class", "d-flex align-items-center")
    ili2.append(idivs6)
    let iimgs2 = document.createElement("img")
    iimgs2.setAttribute("class", "bg-light rounded-circle guisiguente")
    iimgs2.setAttribute("src", "imagenes/map-search.svg")
    iimgs2.setAttribute("width", "45px")
    iimgs2.setAttribute("id", "iconoPais")
    idivs6.append(iimgs2)
    let idivs7 = document.createElement("div")
    idivs7.classList.add("ms-3")
    idivs6.append(idivs7)
    let ip2 = document.createElement("p")
    ip2.setAttribute("class", "fw-bold mb-1")
    idivs7.append(ip2)
    let iselect2 = document.createElement("select")
    iselect2.name = "pais"
    iselect2.setAttribute("class", "opcionescontinentescasilla p-0")
    iselect2.setAttribute("id", "seleccionaPais")
    iselect2.setAttribute("onchange", "elegirPais(value)")
    ip2.append(iselect2)
    let ioption7 = document.createElement("option")
    ioption7.classList.add("opcionescontinentes")
    ioption7.value = "null"
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        ioption7.textContent = "Selecciona País"
    }
    else {
        ioption7.textContent = "Select Country"
    }
    iselect2.append(ioption7)
    //elegirContinente("null")
}



var urlrestcountries = "https://restcountries.com/v3.1/"

elegirContinente = (continente) => {
    var selectorpaises = document.getElementById("seleccionaPais")
    selectorpaises.innerHTML = ""

    var placeholder = document.createElement("option")
    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
        placeholder.textContent = "Selecciona País"
    }
    else {
        placeholder.textContent = "Select Country"
    }
    placeholder.value = null;
    selectorpaises.appendChild(placeholder);

    let padre = document.getElementById("megacampo")
    padre.innerHTML = ""

    if (continente == "null") {
        let iconoContinente = document.getElementById("iconoContinente");
        iconoContinente.classList.remove("guisiguente")
        iconoContinente.classList.add("guisiguenteparpadeo")
        let iconoPais = document.getElementById("iconoPais");
        iconoPais.classList.remove("guisiguenteparpadeo")
        iconoPais.classList.add("guisiguiente")
    }
    else {
        let iconoContinente = document.getElementById("iconoContinente");
        iconoContinente.classList.remove("guisiguenteparpadeo")
        iconoContinente.classList.add("guisiguente")


        fetch(urlrestcountries + "region/" + continente)
            .then(response => response.json())
            .then(pais => {
                if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                    pais.sort((a, b) => {
                        if (a.translations.spa.common > b.translations.spa.common)
                            return 1
                        else
                            return -1
                    }
                    ).forEach((paisOrdenadoSpa) => {
                        let nombredepais = paisOrdenadoSpa.translations.spa.common;
                        let nuevaoption = document.createElement("option")
                        nuevaoption.textContent = nombredepais
                        nuevaoption.value = paisOrdenadoSpa.name.common
                        selectorpaises.appendChild(nuevaoption)
                    })
                }
                else {
                    let paisesOrdenados = []
                    pais.forEach(pais => paisesOrdenados.push(pais.name.common))
                    paisesOrdenados.sort()
                    paisesOrdenados.forEach(paisOrdenado => {
                        let nombredepais = paisOrdenado;
                        let nuevaoption = document.createElement("option")
                        nuevaoption.textContent = nombredepais
                        nuevaoption.value = nombredepais
                        selectorpaises.appendChild(nuevaoption)
                    }
                    )
                }
                let iconoPais = document.getElementById("iconoPais");
                iconoPais.classList.remove("guisiguente")
                iconoPais.classList.add("guisiguenteparpadeo")
            }
            )
    }
}



elegirPais = (pais) => {

    var padre = document.getElementById("megacampo")
    padre.innerHTML = ""

    if (pais == "null") {
        let iconoPais = document.getElementById("iconoPais");
        iconoPais.classList.remove("guisiguente")
        iconoPais.classList.add("guisiguenteparpadeo")

    }
    else {
        let iconoPais = document.getElementById("iconoPais");
        iconoPais.classList.remove("guisiguenteparpadeo")
        iconoPais.classList.add("guisiguiente")
        var scroll = document.querySelector("#filaContinenteScroll");
        scroll.scrollIntoView({ behavior: 'smooth' });
        let videocargandoDiv = document.createElement("div")
        let zonadatosDiv = document.createElement("div")
        let videocargando = document.createElement("video")
        padre.append(videocargandoDiv)
        padre.append(zonadatosDiv)
        videocargandoDiv.append(videocargando)
        videocargandoDiv.classList.add("row")
        zonadatosDiv.classList.add("row")
        videocargando.src = "imagenes/hangarAlien_VP9.webm"
        videocargando.autoplay = true
        videocargando.loop = true
        videocargando.muted = true
        videocargando.classList.add("videocargandoclass")
        videocargando.classList.add("aparecer")
        let delay
        if (localStorage.getItem("extraDelay") === "true") {
            delay = 5000
        }
        else {
            delay = 0
        }
        setTimeout(() => {

            fetch(urlrestcountries + "name/" + pais)
                .then(response => response.json())
                .then(datos => {
                    zonadatosDiv.classList.add("oculto")
                    //var padre = document.getElementById("megacampo")
                    //padre.innerHTML = ""
                    //console.log(datos)

                    var infoData = ["datos", "geografia", "traducciones", "bandera"]
                    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                        var infoText = ["Datos Generales", "Geografía", "Traducciones", "Bandera"]
                    }
                    else {
                        var infoText = ["General Data", "Geography", "Translations", "Flag"]
                    }


                    var iul = document.createElement("ul")
                    zonadatosDiv.append(iul)
                    iul.setAttribute("class", "nav nav-tabs nav-justified mt-5 textocabeceras aparecer")
                    var idiv0 = document.createElement("div")
                    zonadatosDiv.append(idiv0)
                    idiv0.setAttribute("class", "tab-content contenedorgris rounded aparecer")
                    let contadorTabs = 0
                    let lab
                    if (localStorage.getItem("labelPestDat") === "true") {
                        lab = 0
                    }
                    if (localStorage.getItem("labelPestGeo") === "true") {
                        lab = 1
                    }
                    if (localStorage.getItem("labelPestTra") === "true") {
                        lab = 2
                    }
                    if (localStorage.getItem("labelPestBan") === "true") {
                        lab = 3
                    }
                    if (localStorage.getItem("labelPestNin") === "true") {
                        lab = null
                    }
                    function generarTabs(tab) {
                        let iil = document.createElement("il")
                        let ia = document.createElement("a")
                        let ih3 = document.createElement("h3")
                        let i = contadorTabs
                        iul.append(iil)
                        iil.append(ia)
                        ia.append(ih3)
                        iil.setAttribute("class", "nav-item")
                        ia.setAttribute("class", "nav-link " + tab)
                        if (i == lab) {
                            ia.classList.add("active")
                        }
                        ia.setAttribute("data-bs-toggle", "tab")
                        ia.setAttribute("href", "#" + tab)
                        ih3.innerHTML = infoText[i]

                        let idivCampoDatos = document.createElement("div")
                        let idiv2 = document.createElement("div")
                        let idiv3 = document.createElement("div")
                        let idiv4 = document.createElement("div")
                        let ih2 = document.createElement("h2")
                        let idiv30 = document.createElement("div")
                        let idiv31 = document.createElement("div")
                        let img0 = document.createElement("img")
                        let img1 = document.createElement("img")

                        idiv0.append(idivCampoDatos)
                        idivCampoDatos.append(idiv2)
                        idiv2.append(idiv3)
                        idiv3.append(idiv4)
                        idiv2.append(idiv30)
                        idiv4.append(ih2)
                        idiv30.append(idiv31)
                        idiv31.append(img0)
                        idiv31.append(img1)

                        idivCampoDatos.setAttribute("class", "tab-pane container active textodatos")
                        if (i !== lab) {
                            idivCampoDatos.classList.remove("active")
                            idivCampoDatos.classList.add("fade")
                        }
                        idivCampoDatos.setAttribute("id", tab)
                        idiv2.setAttribute("class", "row p-2")
                        idiv3.setAttribute("class", "col")
                        ih2.setAttribute("class", "nombreDePaisClass")
                        if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                            ih2.textContent = datos[0].translations.spa.common
                        }
                        else {
                            ih2.textContent = datos[0].name.common
                        }
                        idiv30.setAttribute("class", "col")
                        idiv31.setAttribute("class", "celdagears")
                        img0.setAttribute("src", "imagenes/gear.png")
                        img0.setAttribute("class", "gear1")
                        img1.setAttribute("src", "imagenes/gearmini.png")
                        img1.setAttribute("class", "gear2")

                        contadorTabs++
                    }

                    infoData.forEach((tab) => generarTabs(tab));

                    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                        var infoDatosGenerales = ["Capital: ", "Población: ", "Moneda: ", "Dominio: ", "Símbolo Divisa: ", "Superficie: "]
                    }
                    else {
                        var infoDatosGenerales = ["Capital: ", "Population: ", "Currency: ", "Domain: ", "Symbol Currency: ", "Surface: "]
                    }
                    let respuestasDatosGenerales = [datos[0].capital, datos[0].population.toLocaleString(), obtenerMonedas(), datos[0].tld, obtenerSimbolo(), datos[0].area.toLocaleString() + " km²"]

                    let contadorEntradasDatosGenerales = 0
                    let j = 0

                    function generarDatosGenerales(lineaDato) {
                        let i = contadorEntradasDatosGenerales
                        if (i % 2 == 0) {
                            j++
                        }
                        if (i % 2 == 0) {
                            let idiv0F = document.createElement("div")
                            let idivCampoDatosDatos = document.getElementById("datos")
                            idivCampoDatosDatos.append(idiv0F)
                            idiv0F.setAttribute("id", "filaDato" + j)
                            idiv0F.setAttribute("class", "row ms-5")
                        }
                        let idiv1 = document.createElement("div")
                        let idiv2 = document.createElement("div")
                        let idiv3 = document.createElement("div")
                        let ih40 = document.createElement("h4")
                        let idiv0F = document.getElementById("filaDato" + j)
                        idiv0F.append(idiv1)
                        idiv1.append(idiv2)
                        idiv2.append(idiv3)
                        idiv3.append(ih40)
                        idiv1.setAttribute("class", "col botonidiomasfondo rounded botonidiomastexto")
                        ih40.setAttribute("class", "textodatos")
                        ih40.textContent = infoDatosGenerales[i]
                        let ispan0 = document.createElement("span")
                        ih40.append(ispan0)
                        ispan0.setAttribute("class", "textorespuestas rounded")
                        ispan0.textContent = respuestasDatosGenerales[i]
                        contadorEntradasDatosGenerales++
                    }

                    function obtenerMonedas() {
                        let moneda = Object.keys(datos[0].currencies)
                        let monedas = []
                        moneda.forEach(moneda => {
                            monedas.push(" " + datos[0].currencies[moneda].name)
                        })
                        return monedas
                    }
                    function obtenerSimbolo() {
                        let simbolo = Object.keys(datos[0].currencies)
                        let simbolos = []
                        simbolo.forEach(simbolo => {
                            simbolos.push(" " + datos[0].currencies[simbolo].symbol)
                        })
                        return simbolos
                    }

                    //lo de antes funciona obtenerMonedas() y obtenerSimbolo()
                    //pero no consigo agruparlo en una funcion???:     

                    // function obtenerCurrencies(currencie) {
                    //     let curencieData = Object.keys(datos[0].currencies)
                    //     let curencieDataArray = []
                    //     curencieData.forEach(currencie => {
                    //         curencieDataArray.push(" " + datos[0].currencies[curencieData].currencie)
                    //     })
                    //     return curencieDataArray
                    // }

                    //obtenerCurrencies(name)
                    //obtenerCurrencies(symbol)

                    infoDatosGenerales.forEach((lineaDato) => generarDatosGenerales(lineaDato))





                    let paisesFronterizos = []

                    generarGeoNombresFronteras()
                    async function generarGeoNombresFronteras() {
                        if (datos[0].borders !== undefined) {
                            for (frontera of datos[0].borders) {

                                await fetch(urlrestcountries + "alpha/" + frontera)
                                    .then(response => response.json())
                                    .then(paisFronterizo => {
                                        if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                                            paisesFronterizos.push(" " + paisFronterizo[0].translations.spa.common)
                                        }
                                        else {
                                            paisesFronterizos.push(" " + paisFronterizo[0].name.common)
                                        }
                                    })
                            }
                        }
                        else {
                            if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                                paisesFronterizos.push(" No tiene fronteras terrestres")
                            }
                            else {
                                paisesFronterizos.push(" It has no land borders")
                            }
                        }
                        await escribirGeoNombresFronteras()
                    }

                    async function escribirGeoNombresFronteras() {

                        //console.log(paisesFronterizos)
                        if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                            var infoGeografia = ["Paises fronterizos: ", "Latitud, Longitud: "]
                        }
                        else {
                            var infoGeografia = ["Border Countries: ", "Latitude, Longitude: "]
                        }

                        let respuestasGeografia = [paisesFronterizos, datos[0].latlng]

                        let contadorEntradasGeografia = 0
                        let g = 0

                        infoGeografia.forEach((lineaDato) => generarGeografia(lineaDato))

                        function generarGeografia(lineaDato) {
                            let i = contadorEntradasGeografia
                            if (i % 2 == 0) {
                                g++
                            }
                            if (i % 2 == 0) {
                                let idiv0F = document.createElement("div")
                                let idivCampoDatosDatos = document.getElementById("geografia")
                                idivCampoDatosDatos.append(idiv0F)
                                idiv0F.setAttribute("id", "filaGeografia" + g)
                                idiv0F.setAttribute("class", "row ms-5")
                            }
                            let idiv1 = document.createElement("div")
                            let idiv2 = document.createElement("div")
                            let idiv3 = document.createElement("div")
                            let ih40 = document.createElement("h4")

                            let idiv0F = document.getElementById("filaGeografia" + g)
                            idiv0F.append(idiv1)
                            idiv1.append(idiv2)
                            idiv2.append(idiv3)
                            idiv3.append(ih40)
                            idiv1.setAttribute("class", "col botonidiomasfondo rounded botonidiomastexto")
                            ih40.setAttribute("class", "textodatos")
                            ih40.textContent = infoGeografia[i]
                            let ispan0 = document.createElement("span")
                            ih40.append(ispan0)
                            ispan0.setAttribute("class", "textorespuestas")
                            ispan0.textContent = respuestasGeografia[i]
                            contadorEntradasGeografia++
                        }
                    }



                    class ContenedorIdioma {
                        constructor(acronimoRestCountries, botonIdiomaTraduccido, paisesHablanIdioma, paisesHablanIdiomaTraducido, paisesHablanIdiomaTraducidoPaisSeleccionado, paisesHablanIdiomaTraducidoSpa) {
                            this.acronimoRestCountries = acronimoRestCountries
                            this.botonIdiomaTraduccido = botonIdiomaTraduccido
                            this.paisesHablanIdioma = paisesHablanIdioma
                            this.paisesHablanIdiomaTraducido = paisesHablanIdiomaTraducido
                            this.paisesHablanIdiomaTraducidoPaisSeleccionado = paisesHablanIdiomaTraducidoPaisSeleccionado
                            this.paisesHablanIdiomaTraducidoSpa = paisesHablanIdiomaTraducidoSpa
                        }
                    }

                    let contadorEntradasTraduccion = 0
                    let w = 0
                    let traduccionesGrupoObjetos = []
                    let acronimosGroup = []
                    obtenerAcronsTrans()
                    function obtenerAcronsTrans() {
                        let acronTrans = Object.keys(datos[0].translations)
                        acronTrans.push("eng")
                        acronTrans.forEach(acronTrans => {
                            if (acronTrans == "eng") {
                                var idiomaTraducido = new ContenedorIdioma(acronTrans, datos[0].name.common, "", "", "", "")
                            }
                            else {
                                var idiomaTraducido = new ContenedorIdioma(acronTrans, datos[0].translations[acronTrans].common, "", "", "", "")
                            }
                            traduccionesGrupoObjetos.push(idiomaTraducido)
                            acronimosGroup.push(acronTrans)
                        })
                    }



                    generarPaisesDelIdioma()


                    async function generarPaisesDelIdioma() {
                        f = 0
                        m = 0
                        for (idiomaAcronimo of acronimosGroup) {
                            await fetchPorAcronimos(idiomaAcronimo, f)

                        }
                        await escribirBotonesIdiomas()
                    }



                    async function fetchPorAcronimos(idiomaAcronimo, f) {
                        await fetch(urlrestcountries + "lang/" + idiomaAcronimo)
                            .then(response => response.json())
                            .then(paisesDelIdioma => {
                                if (paisesDelIdioma.status !== 404) {
                                    rellenarListaDePaises(paisesDelIdioma)
                                }
                                else {
                                    devolverF(f)
                                }
                            })
                        return f
                    }
                    async function rellenarListaDePaises(paisesDelIdioma) {
                        let listaDePaises = []
                        let listaDePaisesTraducidos = []
                        let listaDePaisesTraducidosSpa = []
                        let listaDePaisesTraducidosPaisSeleccionado = []
                        let t = 0
                        //let idiomaPaisSeleccionado = Object.keys(datos[0].languages)
                        paisesDelIdioma.forEach(() => {
                            listaDePaises.push(" " + paisesDelIdioma[t].name.common)
                            if (idiomaAcronimo !== "zho" && !"eng") {
                                listaDePaisesTraducidos.push(" " + paisesDelIdioma[t].translations[idiomaAcronimo].common)
                            }
                            else {
                                console.log(paisesDelIdioma[t])
                                if (idiomaAcronimo == "eng") {
                                    listaDePaisesTraducidos.push(" " + paisesDelIdioma[t].name.common)
                                }
                                else {
                                    listaDePaisesTraducidos.push(" " + paisesDelIdioma[t].name.nativeName[idiomaAcronimo].common)

                                }
                            }
                            //listaDePaisesTraducidosPaisSeleccionado.push(" " + paisesDelIdioma[t].translations[idiomaPaisSeleccionado[0]].common)
                            //arroja multiples errores por infinidad de idiomas no listados con traducción
                            listaDePaisesTraducidosSpa.push(" " + paisesDelIdioma[t].translations.spa.common)

                            t++
                            if (t == paisesDelIdioma.length) {
                                traduccionesGrupoObjetos[f].paisesHablanIdioma += listaDePaises
                                traduccionesGrupoObjetos[f].paisesHablanIdiomaTraducido += listaDePaisesTraducidos
                                traduccionesGrupoObjetos[f].paisesHablanIdiomaTraducidoPaisSeleccionado += listaDePaisesTraducidosPaisSeleccionado
                                traduccionesGrupoObjetos[f].paisesHablanIdiomaTraducidoSpa += listaDePaisesTraducidosSpa
                                f++
                                console.log(listaDePaises)
                                console.log(listaDePaisesTraducidos)
                                console.log(listaDePaisesTraducidosPaisSeleccionado)
                                console.log(listaDePaisesTraducidosSpa)

                            }
                        })


                        //traduccionesGrupoObjetos[f].paisesHablanIdioma += listaDePaises                    
                        return f
                    }
                    async function devolverF() {
                        f++
                    }

                    async function escribirBotonesIdiomas() {
                        traduccionesGrupoObjetos.forEach((objetoContenedor) => generarBotonesTraduccion(objetoContenedor))
                    }

                    function generarBotonesTraduccion(objetoContenedor) {
                        let acronimoRC = objetoContenedor.acronimoRestCountries
                        if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                            var traduccionISO = listadoISO.listadoISO639_3[acronimoRC].traducido
                        }
                        else {
                            var traduccionISO = listadoISO.listadoISO639_3[acronimoRC].completo
                        }
                        let i = contadorEntradasTraduccion
                        if (i % 2 == 0) {
                            w++
                        }
                        if (i % 2 == 0) {
                            let idiv0F = document.createElement("div")
                            let idivCampoDatosDatos = document.getElementById("traducciones")
                            idivCampoDatosDatos.append(idiv0F)
                            idiv0F.setAttribute("id", "filaTraducciones" + w)
                            idiv0F.setAttribute("class", "row ms-5")
                        }
                        let idiv1 = document.createElement("div")
                        let ih50 = document.createElement("h5")
                        let idiv2 = document.createElement("div")
                        let ih51 = document.createElement("h5")
                        let idiv3 = document.createElement("div")
                        let ispan1 = document.createElement("span")
                        let ispan2 = document.createElement("span")
                        let idiv0F = document.getElementById("filaTraducciones" + w)
                        idiv0F.append(idiv1)
                        idiv1.append(idiv2)
                        idiv2.append(ih51)
                        idiv2.append(ih50)
                        idiv2.append(idiv3)
                        idiv3.append(ispan1)
                        idiv3.append(ispan2)
                        idiv1.setAttribute("class", "col")
                        idiv2.setAttribute("class", "textodatos botonidiomastexto botonidiomasfondo rounded")
                        idiv2.setAttribute("data-bs-toggle", "collapse")
                        idiv2.setAttribute("data-bs-target", "#idioma" + i)
                        ih50.textContent = traduccionISO
                        ih51.setAttribute("class", "botonidiomas")
                        ispan1.setAttribute("class", "botonidiomapaisesh")
                        ih51.textContent = objetoContenedor.botonIdiomaTraduccido
                        idiv3.setAttribute("id", "idioma" + i)
                        idiv3.setAttribute("class", "collapse rounded botonidiomasdesplegado")
                        if (objetoContenedor.paisesHablanIdiomaTraducido == "") {
                            if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                                ispan1.textContent = "No hay registro como lengua oficial de ningún país"
                            }
                            else {
                                ispan1.textContent = "There is no record as an official language of any country"
                            }

                        }
                        else {
                            if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                                ispan1.textContent = "Lengua oficial de:  "
                            }
                            else {
                                ispan1.textContent = "Official language of: "
                            }

                        }
                        if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                            ispan2.textContent = objetoContenedor.paisesHablanIdiomaTraducidoSpa
                        }
                        else {
                            ispan2.textContent = objetoContenedor.paisesHablanIdioma
                        }
                        if (localStorage.getItem("extraTraducionNativa") === "true") {
                            ispan2.textContent = objetoContenedor.paisesHablanIdiomaTraducido
                        }


                        //ispan2.textContent = objetoContenedor.paisesHablanIdiomaTraducidoPaisSeleccionado


                        contadorEntradasTraduccion++
                        if (contadorEntradasTraduccion == traduccionesGrupoObjetos.length) {
                            videocargandoDiv.innerHTML = ""
                            zonadatosDiv.classList.remove("oculto")
                            zonadatosDiv.classList.add("aparecer")

                        }

                    }





                    if (localStorage.getItem("idiomaWebSpaCk") === "true") {
                        var infoBanderas = ["Bandera:", "Escudo:"]
                    }
                    else {
                        var infoBanderas = ["Flag:", "Coat of Arms:"]
                    }
                    let respuestasBanderas = [datos[0].flags.png, datos[0].coatOfArms.png]

                    let contadorEntradasBanderas = 0
                    let b = 0

                    function generarBanderas(lineaDato) {
                        let i = contadorEntradasBanderas
                        if (i % 2 == 0) {
                            b++
                        }
                        if (i % 2 == 0) {
                            let idiv0F = document.createElement("div")
                            let idivCampoDatosDatos = document.getElementById("bandera")
                            idivCampoDatosDatos.append(idiv0F)
                            idiv0F.setAttribute("id", "filaBandera" + b)
                            idiv0F.setAttribute("class", "row ms-5")
                        }
                        let idiv1 = document.createElement("div")
                        let ih40 = document.createElement("h4")
                        let idiv2 = document.createElement("div")
                        let iimg0 = document.createElement("img")
                        let idiv0F = document.getElementById("filaBandera" + b)
                        idiv0F.append(idiv1)
                        idiv1.append(ih40)
                        idiv1.append(idiv2)
                        idiv2.append(iimg0)
                        idiv1.setAttribute("class", "col text-center botonidiomasfondo rounded botonidiomastexto")
                        ih40.setAttribute("class", "textodatos")
                        ih40.innerHTML = infoBanderas[i]
                        iimg0.setAttribute("class", "img-fluid tarjetabandera rounded botonidiomastexto")
                        iimg0.setAttribute("src", respuestasBanderas[i])

                        contadorEntradasBanderas++
                    }

                    infoBanderas.forEach((lineaDato) => generarBanderas(lineaDato))


                }
                )
        }, delay);
    }
}






class PaisQuiz {
    constructor(pais, capital, index) {
        this.pais = pais
        this.capital = capital
        this.index = index
    }
}

function sacarRandoms(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

let qListaPaises = []
let valorAComprobar
let oportunidades
function generarPaisesQuiz() {

    fetch(urlrestcountries + "all")
        .then(response => response.json())
        .then(qPais => {
            console.log(qPais)
            qPais.forEach(pais => {
                if (pais.capital == undefined) {
                    console.log(pais)
                    delete qPais[pais]
                }
            })
            console.log(qPais)
            let qListaPaises = []
            oportunidades = 0

            let q1 = sacarRandoms(1, qPais.length)
            let qPaisA = qPais[q1].name.common
            let qPaisACapital = qPais[q1].capital
            let paisA = new PaisQuiz(qPaisA, qPaisACapital, q1)

            let q2 = sacarRandoms(1, qPais.length)
            let qPaisB = qPais[q2].name.common
            let qPaisBCapital = qPais[q2].capital
            let paisB = new PaisQuiz(qPaisB, qPaisBCapital, q2)


            let q3 = sacarRandoms(1, qPais.length)
            let qPaisC = qPais[q3].name.common
            let qPaisCCapital = qPais[q3].capital
            let paisC = new PaisQuiz(qPaisC, qPaisCCapital, q3)

            qListaPaises.push(paisA, paisB, paisC)

            console.log(qListaPaises)

            let padre = document.getElementById("megacampo")
            padre.innerHTML = ""
            padre.classList.remove("exito")
            padre.classList.remove("fracaso")
            padre.classList.add("fondoquiz")
            let row1 = document.createElement("div")
            row1.classList.add("row")
            padre.append(row1)
            let col00 = document.createElement("col")
            col00.classList.add("text-center")
            row1.append(col00)
            let but0 = document.createElement("button")
            but0.setAttribute("class", "btn btn-dark rounded text-center botonesQuiz")
            but0.type = "button"
            but0.textContent = qListaPaises[1].pais
            but0.value = qListaPaises[1].pais
            col00.append(but0)
            valorAComprobar = qListaPaises[1].capital
            qListaPaises.sort((a, b) => {
                if (a.pais > b.pais)
                    return 1
                else
                    return -1
            })

            let row2 = document.createElement("div")
            row2.classList.add("row")
            padre.append(row2)
            let col2 = document.createElement("div")
            col2.classList.add("col")
            col2.classList.add("text-center")
            row2.append(col2)
            let but1 = document.createElement("button")
            but1.setAttribute("class", "btn btn-dark rounded text-center botonesQuiz")
            but1.type = "button"
            but1.value = qListaPaises[0].capital
            but1.textContent = qListaPaises[0].capital
            but1.setAttribute("onclick", "comprobar(value)")
            col2.append(but1)
            let but2 = document.createElement("button")
            but2.setAttribute("class", "btn btn-dark rounded text-center botonesQuiz")
            but2.type = "button"
            but2.value = qListaPaises[1].capital
            but2.textContent = qListaPaises[1].capital
            but2.setAttribute("onclick", "comprobar(value)")
            col2.append(but2)
            let but3 = document.createElement("button")
            but3.setAttribute("class", "btn btn-dark rounded text-center botonesQuiz")
            but3.type = "button"
            but3.value = qListaPaises[2].capital
            but3.textContent = qListaPaises[2].capital
            but3.setAttribute("onclick", "comprobar(value)")
            col2.append(but3)
        })
}


function comprobar(value) {
    console.log(value)
    console.log(valorAComprobar[0])
    if (oportunidades == 0) {
        let padre = document.getElementById("megacampo")
        if (value == valorAComprobar[0]) {
            console.log("Exito")
            padre.classList.add("exito")
        }
        else {
            console.log("fracaso")
            padre.classList.add("fracaso")
        }
    }
    oportunidades++
    setTimeout(() => {
        generarPaisesQuiz()
    }, 5000)


}

function generarWebQuiz(qListaPaises) {
    let madre = document.getElementById("campoSelects")
    madre.innerHTML = ""
    let row0 = document.createElement("div")
    row0.classList.add("row")
    madre.append(row0)
    let col0 = document.createElement("div")
    col0.classList.add("col")
    col0.setAttribute("id", "cabeceraQuiz")
    row0.append(col0)
    let imgq = document.createElement("img")
    imgq.setAttribute("src", "imagenes/quiz.png")
    imgq.setAttribute("class", "cabeceraquiz")
    imgq.setAttribute("onclick", "generarPaisesQuiz()")
    col0.append(imgq)
    var scroll = document.querySelector("#cabeceraQuiz");
    scroll.scrollIntoView({ behavior: 'smooth' });

}







/*

                    for (let t = 0; t <= paisesDelIdioma.length; t++) {
                        listaDePaises.push(" " + paisesDelIdioma[t].name.common)
                        if (t = paisesDelIdioma.length) {
                            traduccionesGrupoObjetos[f].paisesHablanIdioma += listaDePaises
                            f++
                        }
                    }
                    traduccionesGrupoObjetos[f].paisesHablanIdioma += listaDePaises
                    f++
                    return f
                }

                let traduccionesNombresCommon = []
                obtenerTradNombresCommon()
                function obtenerTradNombresCommon() {
                    let translation = Object.keys(datos[0].translations)
                    translation.forEach(translation => {
                       let idiomaTraducido = new ContenedorIdioma(datos[0].translations[translation].common, generarTradNombresLang(translation))
                       botonIdiomaColeccion.push(idiomaTraducido)
                    })
                    return traduccionesNombresCommon
                }
                */
/*
generarGeoNombresFronteras()
 
async function generarGeoNombresFronteras() {
    for (frontera of datos[0].borders) {
        await fetch(urlrestcountries + "alpha/" + frontera)
            .then(response => response.json())
            .then(paisFronterizo => {
                paisesFronterizos.push(" " + paisFronterizo[0].name.common)
            })
    }
    await escribirGeoNombresFronteras()
}
 
async function escribirGeoNombresFronteras(){
 
}
*/
/*
//console.log(traduccionesAcron)
let botonIdiomaColeccion = []                
//console.log(botonIdiomaColeccion)
let paisesDelIdiomaColeccion = []
async function generarTradNombresLang(translation) {            
    let i = 0        
        await fetch(urlrestcountries + "lang/" + translation)
            .then(response => response.json())
            .then(paisesDelIdioma => {
                //console.log(paisesDelIdioma)
                ku = JSON.stringify(paisesDelIdioma)
                //console.log(ku)
                for (j of ku[i]) {
                    paisesDelIdiomaColeccion.push(ku.i.name.common)
                    i++ 
                    return ku.i.name.common    
                                                   
                }
            })         
}
 
*/
/*
 let paisesFronterizos = []
 
generarGeoNombresFronteras()
async function generarGeoNombresFronteras() {
    for (frontera of datos[0].borders) {
        await fetch(urlrestcountries + "alpha/" + frontera)
            .then(response => response.json())
            .then(paisFronterizo => {
                paisesFronterizos.push(" " + paisFronterizo[0].name.common)
            })
    }
    await escribirGeoNombresFronteras()
}
*/

/*
async function escribirGeoNombresFronteras() {
 
 
    //console.log(paisesDelIdiomaColeccion)
    let infoGeografia = ["Paises fronterizos: ", "Latitud, Longitud: "]
    let respuestasGeografia = [paisesFronterizos, datos[0].latlng]
 
    let contadorEntradasGeografia = 0
    let g = 0
 
    function generarGeografia(lineaDato) {
        let i = contadorEntradasGeografia
        if (i % 2 == 0) {
            g++
        }
        if (i % 2 == 0) {
            let idiv0F = document.createElement("div")
            let idivCampoDatosDatos = document.getElementById("geografia")
            idivCampoDatosDatos.append(idiv0F)
            idiv0F.setAttribute("id", "filaGeografia" + g)
            idiv0F.setAttribute("class", "row ms-5")
        }
        let idiv1 = document.createElement("div")
        let idiv2 = document.createElement("div")
        let idiv3 = document.createElement("div")
        let ih40 = document.createElement("h4")
 
        let idiv0F = document.getElementById("filaGeografia" + g)
        idiv0F.append(idiv1)
        idiv1.append(idiv2)
        idiv2.append(idiv3)
        idiv3.append(ih40)
        idiv1.setAttribute("class", "col")
        ih40.setAttribute("class", "textodatos")
        ih40.textContent = infoGeografia[i]
        let ispan0 = document.createElement("span")
        ih40.append(ispan0)
        ispan0.setAttribute("class", "textorespuestas")
        ispan0.textContent = respuestasGeografia[i]
        contadorEntradasGeografia++
    }
 
    infoGeografia.forEach((lineaDato) => generarGeografia(lineaDato))
}
 
*/
/*
var idiv20 = document.createElement("div")
idiv1.append(idiv20)
idiv20.setAttribute("class", "row ms-5")
var idiv21 = document.createElement("div")
idiv20.append(idiv21)
idiv21.setAttribute("class", "col")
var idiv22 = document.createElement("div")
idiv21.append(idiv22)
idiv22.setAttribute("class", "col")
var idiv23 = document.createElement("div")
idiv22.append(idiv23)
var ih4 = document.createElement("h4")
idiv23.append(ih4)
ih4.innerHTML = "Capital: " + datos[0].capital
 
var idiv220 = document.createElement("div")
idiv20.append(idiv220)
idiv220.setAttribute("class", "col")
var idiv221 = document.createElement("div")
idiv220.append(idiv221)
idiv221.setAttribute("class", "col")
var idiv222 = document.createElement("div")
idiv221.append(idiv222)
var ih4 = document.createElement("h4")
idiv222.append(ih4)
ih4.innerHTML = "Población: " + datos[0].population
 
var idiv200 = document.createElement("div")
idiv1.append(idiv200)
idiv200.setAttribute("class", "row ms-5")
var idiv230 = document.createElement("div")
idiv200.append(idiv230)
idiv230.setAttribute("class", "col")
var idiv231 = document.createElement("div")
idiv230.append(idiv231)
idiv231.setAttribute("class", "col")
var idiv232 = document.createElement("div")
idiv231.append(idiv232)
var ih4 = document.createElement("h4")
idiv232.append(ih4)
var moneda = Object.keys(datos[0].currencies)
console.log(moneda)
ih4.innerHTML = "Moneda: " +datos[0].currencies[moneda].name
 
 
 
 
 
 
 
 
 
/*var padre = document.getElementById("megacampo")
var iul = document.createElement("ul")
var iil = document.createElement("il")
var ia = document.createElement("a")
var ih3 = document.createElement("h3")
padre.append(iul)
iul.append(iil)
iil.append(ia)
ia.append(ih3)
iul.setAttribute("class", "nav nav-tabs nav-justified mt-5 textocabeceras")
iil.setAttribute("class", "nav-item")
ia.setAttribute("class", "nav-link active")
ia.setAttribute("data-bs-toggle", "tab")
ia.setAttribute("href", "#datos")
ih3.innerHTML = "Datos Generales"
 
var iil = document.createElement("il")
var ia = document.createElement("a")
var ih3 = document.createElement("h3")
padre.append(iul)
iul.append(iil)
iil.append(ia)
ia.append(ih3)
iul.setAttribute("class", "nav nav-tabs nav-justified mt-5 textocabeceras")
iil.setAttribute("class", "nav-item")
ia.setAttribute("class", "nav-link")
ia.setAttribute("data-bs-toggle", "tab")
ia.setAttribute("href", "#geografia")
ih3.innerHTML = "Geografía"
 
var iil = document.createElement("il")
var ia = document.createElement("a")
var ih3 = document.createElement("h3")
padre.append(iul)
iul.append(iil)
iil.append(ia)
ia.append(ih3)
iul.setAttribute("class", "nav nav-tabs nav-justified mt-5 textocabeceras")
iil.setAttribute("class", "nav-item")
ia.setAttribute("class", "nav-link")
ia.setAttribute("data-bs-toggle", "tab")
ia.setAttribute("href", "#idioma")
ih3.innerHTML = "Idioma"
 
var iil = document.createElement("il")
var ia = document.createElement("a")
var ih3 = document.createElement("h3")
padre.append(iul)
iul.append(iil)
iil.append(ia)
ia.append(ih3)
iul.setAttribute("class", "nav nav-tabs nav-justified mt-5 textocabeceras")
iil.setAttribute("class", "nav-item")
ia.setAttribute("class", "nav-link")
ia.setAttribute("data-bs-toggle", "tab")
ia.setAttribute("href", "#bandera")
ih3.innerHTML = "Bandera"
 
 
document.getElementById("nombreDePais").innerHTML = pais
document.getElementById("nombreCapital").innerHTML = datos[0].capital
document.getElementById("nombreMoneda").innerHTML = datos[0].currencies.EUR.name
document.getElementById("nombrePoblacion").innerHTML = datos[0].population*/



















/*var selectorpaises = document.getElementById("seleccionaPais")
selectorpaises.childNodes.forEach(hijo =>{
selectorpaises.remove(hijo)
})*/
/*let moneda = Object.keys(datos[0].currencies)
            let monedas = []
            moneda.forEach(moneda => {
                monedas.push(" " + datos[0].currencies[moneda].name)
            })
            let simbolo = Object.keys(datos[0].currencies)
            let simbolos = []
            simbolo.forEach(simbolo => {
                simbolos.push(" " + datos[0].currencies[simbolo].symbol)
            })*/
/*<option class="opcionescontinentes" value="null">SeleccionaPaís</option>
        
    });
    /*for(i=0; i<datos.length; i++){
        console.log(datos[i].name.official)*/ //con forEach es más facil
/*

document.getElementById("seleccionaContinente").addEventListener("change", myFunction);

function rellenar() {
console.log("La capital de")

}
seleccionContinente=(continente)=>{
fetch("https://restcountries.com/v3.1/region/"+continente)
.then(response=>response.json())
.then(pais=>{
pais.forEach(pais => {
    console.log("La capital de "+pais.name.common+" es "+pais.capital)
    
});
/*for(i=0; i<datos.length; i++){
    console.log(datos[i].name.official)*/ //con forEach es más facil
/*
}
).catch(error=>{
//este catch como forma de tipificar un fallo
})
}

var selectContinente = document.querySelector('.continente');

selectContinente.addEventListener('change', (event) => {
fetch("https://restcountries.com/v3.1/region/europe")
.then(response=>response.json())
.then(pais=>{
pais.forEach(pais => {
console.log("La capital de "+pais.name.common+" es "+pais.capital)
 
});
/*for(i=0; i<datos.length; i++){
console.log(datos[i].name.official)*/ //con forEach es más facil
/*
}
).catch(error=>{
//este catch como forma de tipificar un fallo
})
});



/* let monedas = Object.keys(datos[0].currencies);
            monedas.forEach(moneda => {
                console.log(moneda[0].name)
                
            // ih4.innerHTML = "Moneda: " +datos[0].currencies[moneda].name
            //console.log(datos[0].currencies[moneda[0]].name)
            })*/