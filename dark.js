var urlrestcountries = "https://restcountries.com/v3.1/"

elegirContinente = (continente) => {
    var selectorpaises = document.getElementById("seleccionaPais")
    selectorpaises.innerHTML = ""

    var placeholder = document.createElement("option")
    placeholder.textContent = "Selecciona País";
    placeholder.value = null;
    selectorpaises.appendChild(placeholder);

    fetch(urlrestcountries + "region/" + continente)
        .then(response => response.json())
        .then(pais => {
            pais.forEach(pais => {
                console.log("La capital de " + pais.name.common + " es " + pais.capital)
                var nombredepais = pais.name.common;
                var nuevaoption = document.createElement("option")
                nuevaoption.textContent = nombredepais;
                nuevaoption.value = nombredepais;
                selectorpaises.appendChild(nuevaoption);
            }
            )
        })
}



elegirPais = (pais) => {

    var padre = document.getElementById("megacampo")
    padre.innerHTML = ""

    fetch(urlrestcountries + "name/" + pais)
        .then(response => response.json())
        .then(datos => {
            console.log(datos)

            var infoData = ["datos", "geografia", "idioma", "bandera", "historia"]
            var infoText = ["Datos Generales", "Geografía", "Idioma", "Bandera", "Historia"]

            var iul = document.createElement("ul")
            padre.append(iul)
            iul.setAttribute("class", "nav nav-tabs nav-justified mt-5 textocabeceras")
            let contadorTabs = 0

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
                if (i == 0) {
                    ia.classList.add("active")
                }
                ia.setAttribute("data-bs-toggle", "tab")
                ia.setAttribute("href", tab)
                ih3.innerHTML = infoText[i]
                contadorTabs++
            }

            infoData.forEach((tab) => generarTabs(tab));


            var idiv0 = document.createElement("div")
            var idivCampoDatos = document.createElement("div")
            var idiv2 = document.createElement("div")
            var idiv3 = document.createElement("div")
            var idiv4 = document.createElement("div")
            var ih2 = document.createElement("h2")
            var idiv30 = document.createElement("div")
            var idiv31 = document.createElement("div")
            var img0 = document.createElement("img")
            var img1 = document.createElement("img")
            padre.append(idiv0)
            idiv0.append(idivCampoDatos)
            idivCampoDatos.append(idiv2)
            idiv2.append(idiv3)
            idiv3.append(idiv4)
            idiv2.append(idiv30)
            idiv4.append(ih2)
            idiv30.append(idiv31)
            idiv31.append(img0)
            idiv31.append(img1)
            idiv0.setAttribute("class", "tab-content")
            idivCampoDatos.setAttribute("class", "tab-pane container active textodatos")
            idivCampoDatos.setAttribute("id", "datos")
            idiv2.setAttribute("class", "row p-2")
            idiv3.setAttribute("class", "col")
            ih2.setAttribute("class", "nombreDePaisClass")
            ih2.innerHTML = pais
            idiv30.setAttribute("class", "col")
            idiv31.setAttribute("class", "celdagears")
            img0.setAttribute("src", "imagenes/gear.png")
            img0.setAttribute("class", "gear1")
            img1.setAttribute("src", "imagenes/gearmini.png")
            img1.setAttribute("class", "gear2")

            let infoDatosGenerales = ["Capital: ", "Población: ", "Moneda: ", "Dominio: ", "Símbolo Divisa: ", "Superficie: "]

            let moneda = Object.keys(datos[0].currencies)
            let monedas = []
            moneda.forEach(moneda => {
                monedas.push(" " + datos[0].currencies[moneda].name)
            })
            let simbolo = Object.keys(datos[0].currencies)
            let simbolos = []
            simbolo.forEach(simbolo => {
                simbolos.push(" " + datos[0].currencies[simbolo].symbol)
            })

            let respuestasDatosGenerales = [
                datos[0].capital,
                datos[0].population,
                monedas,
                datos[0].tld,
                simbolos,
                datos[0].area
            ]
            
            let contadorEntradasDatosGenerales = 0
            let j = 0

            function generarDatosGenerales(lineaDato) {
                let i = contadorEntradasDatosGenerales
                if (i % 2 == 0) {
                    j++
                }
                if (i % 2 == 0) {
                    let idiv0F = document.createElement("div")
                    idivCampoDatos.append(idiv0F)
                    idiv0F.setAttribute("id", "fila" + j)
                    idiv0F.setAttribute("class", "row ms-5")
                }
                let idiv1 = document.createElement("div")
                let idiv2 = document.createElement("div")
                let idiv3 = document.createElement("div")
                let ih40 = document.createElement("h4")
                let idiv0F = document.getElementById("fila" + j)
                idiv0F.append(idiv1)
                idiv1.append(idiv2)
                idiv2.append(idiv3)
                idiv3.append(ih40)
                idiv1.setAttribute("class", "col")
                ih40.innerHTML = infoDatosGenerales[i] + respuestasDatosGenerales[i]
                contadorEntradasDatosGenerales++
            }

            infoDatosGenerales.forEach((lineaDato) => generarDatosGenerales(lineaDato));

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
        }
        )
}


















/*var selectorpaises = document.getElementById("seleccionaPais")
selectorpaises.childNodes.forEach(hijo =>{
selectorpaises.remove(hijo)
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