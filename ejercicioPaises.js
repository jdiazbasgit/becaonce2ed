var monedas
var capital
var poblacion
var dominios
var fronteras
var bandera
var escudos
var traducciones 

cargarPaises = continente => {
    fetch("https://restcountries.com/v3.1/region/" + continente)
        .then(response => response.json())
        .then(paises => {


            var paisesSelect = document.querySelector("#paises");
            paisesSelect.innerHTML = ""
            let seleccionaPais = document.createElement("option")
            seleccionaPais.value = "0"
            paisesSelect.appendChild(seleccionaPais);
            paises.forEach(pais => {
                let option = document.createElement("option");
                option.value = pais.name.common;
                option.text = option.value;
                paisesSelect.appendChild(option)

            })

        })
}
vaciarElemento = (elemento) => {
    elemento.childNodes.forEach(hijo => {
        elemento.removeChild(hijo);
    })
}
dameDatos = (url) => fetch(url);
dameNombreDePais = cca3 => {
    dameDatos(urlrescountries + [cca3]).then(response => response.json)
        .then(pais => pais.borders)

    vaciarElemento = (elemento) => {
        elemento.childNodes.forEach(hijo => {
            elemento.removeChild(hijo);
        })
    }
}
class Moneda {
    constructor(name, symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
cargarMonedas = (monedas) => {
    fetch ("https://restcountries.com/v3.1/region/")
    let selectPaises = document.querySelector("#paises");
      .then((response) => response.json())
      .then(pais => {
        pintaDatosGenerales(pais[0])
      })
  }
  
  pintaDatosGenerales = (pais) => {
    var main = document.querySelector("main");
    main.innerHTML = "";
    let table = document.createElement("table");
    table.setAttribute("class", "table table-stripped text-center") 
    let tr1 = document.createElement("tr");
    let th1 = document.createElement("th");
    let th2 = document.createElement("th");
    let th3 = document.createElement("th");
    let th4 = document.createElement("th");
    let th5 = document.createElement("th");
    let tr2 = document.createElement("tr");
    let td1 = document.createElement("td");
    let td2 = document.createElement("td");
    let td3 = document.createElement("td");
    let td4 = document.createElement("td");
    let td5 = document.createElement("td");
    th1.innerHTML = "Capital "
    th2.innerHTML = "Población";
    th3.innerHTML = "Área";
    th4.innerHTML = "Dominio";
    th5.innerHTML = "Moneda";
    td1.innerHTML = pais.capital;
    td2.innerHTML = pais.population;
    td3.innerHTML = pais.area;
    td4.innerHTML = pais.tld;
    td5.innerHTML = pais.moneda;
    main.appendChild(table);
    table.appendChild(tr1,);
    table.appendChild(tr2)
    tr1.appendChild(th1);
    tr1.appendChild(th2);
    tr1.appendChild(th3);
    tr1.appendChild(th4);
    tr1.appendChild(th5);
    tr2.appendChild(td1);
    tr2.appendChild(td2);
    tr2.appendChild(td3);
    tr2.appendChild(td4);
    tr2.appendChild(td5);
  };
  
  datosGeograficos = () => {
      let datosGeograficos = document.querySelector("#fronteras")
    datosGeograficos.innerHTML = ""
    let selectPaises = document.createElement("option")
    selectPaises.value = "0"
}

pintarDatosGeograficos = () => {
    var main = document.querySelector("main")
    var div = document.createElement("div")
    let h31 = document.createElement("h3")
    let h32 = document.createElement("h3")
    let h33 = document.createElement("h3")
    let h34 = document.createElement("h3")
    let h35 = document.createElement("h3")

    h31.innerHTML = "Frontera 1:" + pais.frontera
    h32.innerHTML = "Frontera 2:" + pais.frontera
    h33.innerHTML = "Frontera 3:" + pais.frontera
    h34.innerHTML = "Frontera 4:" + pais.frontera
    h35.innerHTML = "Frontera 5:" + pais.frontera

    
}

banderas = () => { 
    let banderas = document.querySelector("#banderas")
    banderas.innerHTML = ""
    let selectPaises = document.createElement("option")
    selectPaises.value = "0"
}
pintarDatosBandera = () => {
    var main = document.querySelector("main")
    var div = document.createElement("div")
    let h31 = document.createElement("h3")
    let h32 = document.createElement("h3")
    let h33 = document.createElement("h3")
    let h34 = document.createElement("h3")
    let h35 = document.createElement("h3")

    h31.innerHTML = 
    h32.innerHTML = 
    h33.innerHTML = 
    h34.innerHTML = 
    h35.innerHTML =  
}

idioma= () => { 
    let idioma = document.querySelector("#fronteras")
    idioma.innerHTML = ""
    let selectPaises = document.createElement("option")
    selectPaises.value = "0"
}

class Traduccion {
    traducciones = () => {
        let datosGeograficos = document.querySelector("#fronteras")
        datosGeograficos.innerHTML = ""
        let selectPaises = document.createElement("option")
        selectPaises.value = "0"
    }
}
 











































/*bandera https://goo.gl/maps/uDWEUaXNcZTng1fP6
escudo https://mainfacts.com/media/images/coats_of_arms/pe.svg
*/
https: //restcountries.com/v3.1/name/peru

cargarBanderas = () => {
    let selectpaises = documento.querySelector( # país)
    dameDatos(urlrespaises + / nombre / + seleccionarpaises.valor) _ _
        .luego((respuesta) => respuesta.json())
        .entonces(paises => {
        } 
}
pintarBanderas = () => {
    dameDatos(urlrescountries + / alpha / + flags)
        .luego((respuesta) => respuesta.json())
        .entonces(paises => {
        }
        }

pintarescudos = () => {
    dameDatos(urlrescountries + / alpha / + pais.flag.coatOfArmsº)
        .luego((respuesta) => respuesta.json())
        .entonces(paises => {
        }
/ *
            consola _ registro(banderas)
            var principal = documento.querySelector("principal");
            principal _ HTML interno = ""
            principal _ listaclases.añadir _ aplicar("centro de texto")
            sea  ​​h21 = documento.crearElemento("h2");
    let th1 = documento.crearElemento("th");
            principal _ appendChild(principal)
            mesa _ appendChild(tabla)
            tr1 _ agregarNiño(tr)
    th1.agregar niñ



        (th1)

    vaciarElemento = (element



    ) => {
    elemento _ childNodes.p



        raCada(hijo => {
        elemento _ renovar _



            enoveChild(hijo);

        })
    }
}




























































