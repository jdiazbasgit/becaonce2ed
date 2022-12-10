var capital = []
var poblacion
var area
var dominios = []
var fronteras = []
var bandera
var escudo
var monedas
var monedasDatos = []
var traducciones = []
var fronterasNombres = []
var traduccionesDatos = []

const urlPais = "https://restcountries.com/v3.1/name/"
const urlAlpha = "https://restcountries.com/v3.1/alpha/"
const urlRestCountries = "https://restcountries.com/v3.1/"
var main = document.querySelector("main");

inicializar = () => {
  capital = []
  poblacion
  area
  dominios = []
  fronteras = []
  bandera
  escudo
  monedas
  monedasDatos = []
  traducciones = []
  fronterasNombres = []
  traduccionesDatos = []

  main.innerHTML = ""
}







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
var li2 = document.createElement("li")
li2.class = "nav-item"
var a2 = document.createElement("a")
a2.class = "nav-link"
a2.class = "data-bs-toggle"
a2.href = "#geografia"
var h3b = document.createElement("h3")
h3b.innerHTML = "Geografia"
li2.appendChild(a2)
a2.appendChild(h3b)

//idioma//

var li3 = document.createElement("li")
li3.class = "nav-item"
var a3 = document.createElement("a")
a3.class = "nav-link"
a3.class = "data-bs-toggle"
a3.href = "#idioma"
var h3c = document.createElement("h3")
h3c.innerHTML = "Geografia"

li3.appendChild(a3)
a3.appendChild(h3c)

// bandera //


var li4 = document.createElement("li")
li4.class = "nav-item"
var a4 = document.createElement("a")
a4.class = "nav-link"
a4.class = "data-bs-toggle"
a4.href = "#idioma"
var h3d = document.createElement("h3")
h3d.innerHTML = "bandera"
li4.appendChild(a4)
a4.appendChild(h3d)

// xnombres del pais //

var div3 = document.createElement("div")
div3.class = "tab-content"
var div3a = document.createElement("div")
div3a.class = "tab-pane container active textodatos"
div3a.id = "datos"
var div3b = document.createElement("div")
div3b.class = "row p-2"
var div3c = document.createElement("div")
div3c.class = "col"
var h2 = document.createElement("h2")
h2.innerHTML = "XnombredelPais"
h2.appendChild(div3c)
div3c.appendChild(div3b)
div3b.appendChild(div3a)
div3a.appendChild(div3)

//imagenes cerca de continente y paises//

var div4 = document.createElement("div")
div4.class = "col"
var div4a = document.createElement("div")
div4.class = "celdagers"
var img1 = document.createElement("img")
img1.src = ("imagenes/gear.png")
img1.class = ("gear1")
var img2 = document.createElement("img")
img2.src = ("imagenes/gearmini.png")
img2.class = ("gear2")

div4.appendChild(div4a)
div4a.appendChild(img1)
div4a.appendChild(img2)

//por capiital y nombre de la ca pital

var div5 = document.createElement("div")
div5.class = "row ms-5"
var div5a = document.createElement("div")
div5a.class = "col"
var h4 = document.createElement("h4")
h4.innerHTML = "Capital"
var span1 = document.createElement("span")
h4.innerHTML = "nombreXCapital"

div5.appendChild(div5a)
div5a.appendChild(h4)
h4.appendChild(span1)

//por poblacion xpoblacion

var div6 = document.createElement("div")
div6.class = "row ms-5"
var div6a = document.createElement("div")
div6a.class = "col"
var h4a = document.createElement("h4")
h4a.innerHTML = "Poblacion"
var span2 = document.createElement("span")
h4a.innerHTML = "Xpoblacion"

div6.appendChild(div6a)
div6.appendChild(h4a)
h4a.appendChild(span2)

//// por moneda Xmoneda - simbolo de divisa xdivisa

var div7 = document.createElement("div")
div7.class = "row ms-5"
var div7a = document.createElement("div")
div7a.class = "col"
var h4b = document.createElement("h4")
h4b.innerHTML = "Moneda"
var span3 = document.createElement("span")
h4b.innerHTML = "Xmoneda"

div7.appendChild(div7a)
div7a.appendChild(h4b)
h4b.appendChild(span3)

// por simbolo divisa xdivisa
var div8 = document.createElement("div")
div8.class = "row ms-5"
var div8a = document.createElement("div")
div8a.class = "col"
var div8b = document.createElement("div")
var h4c = document.createElement("h4")
h4c.innerHTML = "Simbolo Divisa"
var span4 = document.createElement("span")
h4c.innerHTML = "Xdivisa"
div8.appendChild(div8a)
div8a.appendChild(div8b)
div8b.appendChild(h4c)
h4c.appendChild(span4)

//// superficie xsuperficie
var div9 = document.createElement("div")
div9.class = "row ms-5"
var div9a = document.createElement("div")
div9a.class = "col"
var h4d = document.createElement("h4")
h4c.innerHTML = "Superficie"
var span5 = document.createElement("span")
h4d.innerHTML = "Xsupeficie"
div9.appendChild(div9a)
div9a.appendChild(h4d)
h4d.appendChild(span5)

//por nombre del pais

var div10 = document.createElement("div")
div10.class = "tab-pane container fade textodatos"
div10.id = "geografria"
var div10a = document.createElement("div")
div10a.class = "row p-2"
var div10b = document.createElement("div")
div10b.class = "col"
var div10c = document.createElement("div")
var h2a = document.createElement("h2")
h2a.innerHTML = "Xnombredelpais"

div10.appendChild(div10a)
div10a.appendChild(div10b)
div10b.appendChild(div10c)
div10c.appendChild(h2a)

//imagenes 216

var div11 = document.createElement("div")
div11.class = "col"
var div11a = document.createElement("div")
div11a.class = "celdagears"
var img3 = document.createElement("img")
img3.src = "imagenes/gear.png"
img3.class = "gear1"
var img4 = document.createElement("img")
img4.src = "imagenes/gearmini.png"
img4.class = "gear2"

div11.appendChild(div11a)
div11a.appendChild(img3)
div11a.appendChild(img4)

////fronteras terrestres

var div12 = document.createElement("div")
div12.class = "row ms-5"
var div12a = document.createElement("div")
div12a.class = "col"
var div12b = document.createElement("div")
var h4e = document.createElement("h4")
h4e.innerHTML = "Fronteras Terrestres:"
var span6 = document.createElement("span")

div12.appendChild(div12a)
div12a.appendChild(div12b)
div12b.appendChild(h4e)
h4e.appendChild(span6)

//xnombredel Pais 238
var div13 = document.createElement("div")
div13.class = "tab-pane container fade textodatos"
div13.id = "idioma"
var div13a = document.createElement("div")
div13a.class = "row p-2"
var div13b = document.createElement("div")
div13b.class = "col"
var div13c = document.createElement("div")
var h2b = document.createElement("h2")
h2b.innerHTML = "XnombredelPais"

div13.appendChild(div13a)
div13a.appendChild(div13b)
div13b.appendChild(div13c)
div13c.appendChild(h2b)

//imagenes 241

var div14 = document.createElement("div")
div14.class = "col"
var div14a = document.createElement("div")
div14a.class = "celdagears"
var img5 = document.createElement("img")
img5.src = "imagenes/gear.png"
img5.class = "gear1"
var img6 = document.createElement("img")
img6.src = "imagenes/gearmini.png"
img6.class = "gear2"

div14.appendChild(div14a)
div14a.appendChild(img5)
div14a.appendChild(img6)

//PAISES-IDIOMA

var div15 = document.createElement("div")
div15.class = "row m5-5"
var div15a = document.createElement("div")
div15a.class = "col"
var h4f = document.createElement("h4")
var button1 = document.createElement("button")
button1.class = "rounded botonidiomas"
button1.class = "data-bs-toggle"
button1.class = "data-bs-target"
button1.addEventListener = ("click")
button1.id = "#idioma1"
button1.innerHTML = "Idioma1"

div15.appendChild(div15a)
div15a.appendChild(h4f)
h4f.appendChild(button1)

//idioma 2

var h4g = document.createElement("h4")
var button2 = document.createElement("button")
button2.class = "rounded botonidiomas"
button2.class = "data-bs-toggle"
button2.class = "data-bs-target"
button2.addEventListener = ("click")
button2.id = "#idioma2"
button2.innerHTML = "Idioma2"
h4g.appendChild(button2)

// idioma 3

var h4h = document.createElement("h4")
var button3 = document.createElement("button")
button3.class = "rounded botonidiomas"
button3.class = "data-bs-toggle"
button3.class = "data-bs-target"
button3.addEventListener = ("click")
button3.id = "#idioma3"
button3.innerHTML = "Idioma3"


h4h.appendChild(button3)

// idioma 4

var h4i = document.createElement("h4")
var button4 = document.createElement("button")
button4.class = "rounded botonidiomas"
button4.class = "data-bs-toggle"
button4.class = "data-bs-target"
button4.addEventListener = ("click")
button4.id = "#idioma4"
button4.innerHTML = "Idioma4"


h4i.appendChild(button4)

// idioma 5

var div16 = document.createElement("div")
div16.class = "col"
var div16a = document.createElement("div")
var h4j = document.createElement("h4")
var button5 = document.createElement("button")
button5.class = "rounded botonidiomas"
button5.class = "data-bs-toggle"
button5.class = "data-bs-target"
button5.addEventListener = ("click")
button5.id = "#idioma5"
button5.innerHTML = "Idioma5"
div16.appendChild(div16a)
div16a.appendChild(h4j)
h4j.appendChild(button5)

//idioma 6

var h4k = document.createElement("h4")
var button6 = document.createElement("button")
button6.class = "rounded botonidiomas"
button6.class = "data-bs-toggle"
button6.class = "data-bs-target"
button6.addEventListener = ("click")
button6.id = "#idioma6"
button6.innerHTML = "Idioma6"


h4k.appendChild(button6)

//idioma7

var h4l = document.createElement("h4")
var button7 = document.createElement("button")
button7.class = "rounded botonidiomas"
button7.class = "data-bs-toggle"
button7.class = "data-bs-target"
button7.addEventListener = ("click")
button7.id = "#idioma7"
button7.innerHTML = "Idioma7"


h4l.appendChild(button7)

// idioma 8

var h4m = document.createElement("h4")
var button8 = document.createElement("button")
button8.class = "rounded botonidiomas"
button8.class = "data-bs-toggle"
button8.class = "data-bs-target"
button8.addEventListener = ("click")
button8.id = "#idioma8"
button8.innerHTML = "Idioma8"


h4m.appendChild(button8)

// banderas y escudos con (id bandera)

var div17 = document.createElement("div")
div17.class = "tab-pane container fade textodatos"
div17.id = "bandera"
var div17a = document.createElement("div")
div17a.class = "row p-2"
var div17b = document.createElement("div")
div17b.class = "col"
var div17c = document.createElement("div")
var h2c = document.createElement("h2")
h2c.innerHTML = "XnombreDelPais"
div17.appendChild(div17a)
div17a.appendChild(div17b)
div17b.appendChild(div17c)
div17c.appendChild(h2c)

//imagenes 

var div18 = document.createElement("div")
div18.class = "col"
var div18a = document.createElement("div")
div18a.class = "celdagears"
var img7 = document.createElement("img")
img7.src = "imagenes/gear.png"
img7.class = "gear1"
var img8 = document.createElement("img")
img8.src = "imagenes/gearmini.png"
img8.class = "gear2"

div18.appendChild(div18a)
div18a.appendChild(img7)
div18a.appendChild(img8)

// BANDERAS imagen

var div19 = document.createElement("div")
div19.class = "row ms-5"
var div19a = document.createElement("div")
div19a.class = "col"
var h4l = document.createElement("h4")
h4l.innerHTML = "Bandera "
var div19b = document.createElement("div")
var img9 = document.createElement("img")
img9.class = "img-fluid tarjetabandera rounded"
img9.src = "https://flagcdn.com/w320/es.png"

div19.appendChild(div19a)
div19a.appendChild(div19b)
div19b.appendChild(img9)

// ESCUDO imagen

var div20 = document.createElement("div")
div20.class = "col"
var h4m = document.createElement("h4")
h4m.innerHTML = "Escudo"
var div20a = document.createElement("div")
var img10 = document.createElement("img")
img10.class = "img-fluid tarjetabandera rounded"
img10.src = "https://mainfacts.com/media/images/coats_of_arms/es.png"

div20.appendChild(h4m)
h4m.appendChild(div20a)
div20a.appendChild(img10) 