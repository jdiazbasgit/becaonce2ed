

opcionesContinente = continente => {

    var paisesSelect = document.querySelector("#paises");
    paisesSelect.innerHTML = ""

    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then((response) => response.json())
        .then(pais => {
            let seleccionaPaises = document.createElement("option")
            seleccionaPais.value = "0"
            seleccionaPais.text = "seleccionaPais"
            paisesSelect.appendChild(seleccionaPaises);
            pais.forEach(pais => {
                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value;
                paisesSelect.appendChild(option)
            });

        })
}

//buscar datosGenerales.



var capital;
var moneda;
var simbolo;
var poblacion;
var dominio;
var superficie;
var moneda;
var bandera;
var escudo;
//datos generales
var main = document.querySelector("main")
var div1 = document.createElement("div")
div1.class=("row") 
var div2 = document.createElement("div")
div2.class = "col megacol"
var ul1 = document.createElement("ul")
ul1.class = "nav nav-tabs nav-justified mt-5 textocabeceras"
var li1 = document.createElement("li")
li1.class = "nav item"
var a1 = document.createElement("a")
a1.class = "nav-link active"
a1.("data-bs-toggle") = "tab"
a1.href = "#datos"
var h3a = documento.createElement("h3")
h3a.innerHTML = "Datos Generales"
a1.appendChild("h3a")
li1.appendChild("a1")
ul1.appendChild("il1")
div2.appendChild("ul1")
div1.appendChild("div2")
main.appendChild("div1")

//datos geografia//

var li2 = document.createElement("li")
li2.class = "nav-item"
var a2 = document.createElement("a")
a2.class = "nav-link"
a2.class("data-bs-toggle") = "tab"
a2.href = "#geografia"
var h3b = document.createElement("h3")
h3b.innerHTML = "Geografia"
li2.appendChild("a2")
a2.appendChild("h3b")

//idioma//

var li3 = document.createElement("li")
li3.class = "nav-item"
var a3 = document.createElement("a")
a3.class = "nav-link"
a3.setAttribute("data-bs-toggle") = "tab"
a3.href = "#idioma"
var h3c = document.createElement("h3")
h3c.innerHTML = "Geografia"
li3.appendChild("a3")
a3.appendChild("h3c")

// bandera //


var li4 = document.createElement("li")
li4.class = "nav-item"
var a4 = document.createElement("a")
a4.class = "nav-link"
a4.setAttribute("data-bs-toggle") = "tab"
a4.href = "#idioma"
var h3d = document.createElement("h3")
h3d.innerHTML = "bandera"
li4.appendChild("a4")
a4.appendChild("h3d")

// xnombres del pais //

var div3 = documento.createElement("div")
div3.class = "tab-content"
var div3a = document.createElement("div")
div3a.setAttribute("class") = "tab-pane container active textodatos"
div3a.id = "datos"
var div3b = document.createElement("div")
div3b.setAttribute("class") = "row p-2"
var div3c = document.createElement("div")
div3c.setAttribute("class") = "col"
var h2 = document.createElement("h2")
h2.innerHTML = "XnombredelPais"
h2.appendChild("div3c")
div3c.appendChild("div3b")
div3b.appendChild("div3a")
div3a.appendChild("div3")

//imagenes cerca de continente y paises//

var div4 = document.createElement("var")
div4.setAttribute("class") = "col"
var div4a = documento.createElement("div")
div4.setAttribute("class") = "celdagers"
var img1 = document.createElement("img")
div4.appendChild("img1")








































































































