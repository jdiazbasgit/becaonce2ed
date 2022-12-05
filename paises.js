
opcionesContinente = continente => {

  var paisesSelect = document.querySelector("#paises");
  paisesSelect.innerHTML = ""

  fetch("https://restcountries.com/v3.1/region/" + continente)
    .then((response) => response.json())
    .then(pais => {
      let seleccionaPais = document.createElement("option")
      seleccionaPais.value = "0"
      seleccionaPais.text = "seleccionarPais"
      paisesSelect.appendChild(seleccionaPais);
      pais.forEach(pais => {

        let option = document.createElement("option");
        option.value = pais.name.common;
        option.text = option.value;
        paisesSelect.appendChild(option)
      });


    })



}
var main = document.querySelector("main")
var div1 = document.createElement("div")
div1.classlist("class") = "row"
var div2 = document.createElement("div")
div2.class ="col megacol"
var ul1 = document.createElement ("ul")
ul1.class = "nav nav-tabs nav-justified mt-5 textocabeceras"
var li1 = document.createElement("li")
li1.class = "nav item"
var a1 = document.createElement("a")
a1.class = "nav-link active"
a1.setAttribute("data-bs-toggle") = "tab"
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

var  li2 = document.createElement(li)
li2.class = "nav-item"
var a2 = document.createElement(a)
a2.class ="nav-link"
a2.setAttribute("data-bs-toggle") ="tab"
a2.href = "#geografia"
var h3b =document.createElement("h3")
h3b.innerHTML= "Geografia"
li2.appendChild("a2")
a2.appendChild("h3b")

//idioma//

var  li3 = document.createElement(li)
li3.class = "nav-item"
var a3 = document.createElement(a)
a3.class ="nav-link"
a3.setAttribute("data-bs-toggle") ="tab"
a3.href = "#idioma"
var h3c =document.createElement("h3")
h3c.innerHTML= "#Idioma"
li3.appendChild("a3")
a3.appendChild("h3c")

// bandera //


var  li4 = document.createElement(li)
li4.class = "nav-item"
var a4 = document.createElement(a)
a4.class ="nav-link"
a4.setAttribute("data-bs-toggle") ="tab"
a4.href = "#Bandera"
var h3d =document.createElement("h3")
h3d.innerHTML= "bandera"
li4.appendChild("a4")
a4.appendChild("h3d")

//////nombre del pais//
var div3 = document.createElement(div)
div3.class = "tab-content"
var div3a = document.createElement(div)
div3a.class = "tab-pane container active textodatos"
var div3b = document.createElement(div)
div3b.class = "row p-2"
var div3c = document.createElement(div)
div3c.class = "col"
var div3d = document.createElement(div)
var h2 = document.createElement(h2)
h2.innerHTML = "nombredelPais"
div3.appendChild(div3a)
div3a.appendChild(div3b)
div3b.appendChild(div3c)
div3c.appendChild(div3d)
div3d.appendChild(h2)

///imagenes gear

var div4= document.createElement(div)
div4.class = ("col")
var div4a = document.createElement(div)
div4a.class = ("celdagears")
var img1 = document.createElement(img)
img1.src = ("imagenes/gear.png")
img1.class= ("gear1")
var  img2 = document.createElement(img)
img2.src = ("imagenes/gearmini.png")
img2.class = ("gear2")
div4.appendChild(div4a)
div4a.createElement(img1)
div4a.createElement(img2)

///nombre capital

var div5 = document.createElement(div)
div5.class = "row ms-5"
var div5a = document.createElement(div)
div5a.class = "col"
var div5b = document.createElement(div)
var h4 = document.createElement(h4)
h4.innerHTML = "Capital"
var span1 = document.createElement(span)
span1.innerHTML = "nombreXCapital"
div5.appendChild(div5a)
div5a.appendChild(div5b)
div5b.appendChild(h4)
h4.appendChild(span1)

