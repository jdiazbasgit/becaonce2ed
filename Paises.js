
var urlrescountries = "https://restcountries.com/v3.1";


var capital;//STRING
var poblacion;//number
var area;//number
var moneda;// Moneda[]
var domino;//string
var fronteras;// string[]
var bandera;//string
var escudo;//string
var traducciones;//Traduccion[]

cargarPaises = continente => {
    fetch("https://restcountries.com/v3.1/region/" + continente)
    .then(response => response.json())
    .then(paises => {
        
        
        var paisesSelect = document.querySelector("#paises");
        paisesSelect.innerHTML = ""
        let seleccionaPais = document.createElement("option")
        seleccionaPais.value = "0"
        seleccionaPais.text = "Selecciona pais";
        paisesSelect.appendChild(seleccionaPais);
        
        paises.forEach(pais => {
            
            let option = document.createElement("option");
            option.value = pais.name.common;
            option.text = option.value;
            paisesSelect.appendChild(option)
            
        });
        
    })
    
    
    
}

dameDatos = (URL) => fetch(URL);
dameNombreDePais = cca3 => {
    dameDatos(urlrescountries + [cca3]).then(response => response.json)
    .then(pais => alpha.pais.borders)
    
}
































/*
CargaPais = (pais) => {
    var urlrescountries = "https://restcountries.com/v3.1/";
    const main= document.querySelector ("main");
    var capital:// (string);
    var poblacion: // (number)
var area://  (number)
va rmoneda:// Moneda [])
var frontera:// string  
var bandera:// string
var escudo:// string
var traducciones:// traduccion[]
cargaInicialPais = (pais) => {
    fetch("https://restcountries.com/v3.1/".name.alpha.leng + continente)
        .then((response) => response.json())
        .then(paises => {

        })
}

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
    
    dameDatos =(URL) => fetch (URL)
    dameDatos = (URL) cc3 =>{ 
        dameDatos = (URL) (urlrescountries + cc3) (then response => response json)
        .then (pais => pais.border)
    }
    cargarDatosGenrasles= () => {
        
    }
 
    cargarDatosGenrasles= () => {
 
    }
pintarBanderaEscudo = () => {
    cargarBanderaEscudo(urlrescountries + /alpha/ + pais.flag.coatOfArms)
        .then((response) => response.json())
        .then(paises => {
        }
        
        )}  
        console.log (banderas)
        var main = document.querySelector("main");
        main.innerHTML =""
        main.classList.add.apply("text-center")
        let h21 = document.createElement("h2");
        let th1 = document.createElement("th");
    main.appendChild(main)
    
    
    vaciarElemento = (elemento) => {
        elemento.childNodes.forEach(hijo => {
            elemento.renove.renoveChild(hijo);
        })
    }
    
    
    /*bandera https://goo.gl/maps/uDWEUaXNcZTng1fP6
    escudo https://mainfacts.com/media/images/coats_of_arms/pe.svg
*/
/*https://restcountries.com/v3.1/name/peru




})
} 
}
