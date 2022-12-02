const continentes = [

    { value: "europe", texto: "Europa" },
    { value: "asia", texto: "Asia" },
    { value: "africa", texto: "Africa" },
    { value: "americas", texto: "America" },
    { value: "oceania", texto: "Oceania" }
];
gestionarElemento = (nombre, tipo = 2) => {
    if (tipo == 1) {
        return document.createElement(nombre);

    }
    else {
        return document.querySelector(nombre);
    }
};
var pais;
var paisesPorIdioma;
cargaPaisesDeCotinente = async (value) => {
    //let selectContinente = document.querySelector("#continentes");
    let url = `https://restcountries.com/v3.1/region/${value}`;
    let paises = await cargaDatos(url);
    let selectPaises = gestionarElemento("#paises");
    selectPaises.innerHTML = "";
    let optionInicio = gestionarElemento("option", 1);

    optionInicio.value = 0;
    optionInicio.innerHTML = "Selecciona pais...";
    selectPaises.appendChild(optionInicio);

    paises.forEach(pais => {
        paises.sort(compare);
        //console.log(paises);
        let option = gestionarElemento("option", 1);
        option.value = pais.name.common;
        option.innerHTML = pais.translations.spa.common;

        selectPaises.appendChild(option);
        //console.log( pais[0].sort(translations.spa.common));
    });



};
compare = (a, b) => {
    if (a.last_nom < b.last_nom) {
        return -1;
    }
    if (a.last_nom > b.last_nom) {
        return 1;
    }
    return 0;
}



cargaDatos = (url) => {
    return new Promise((resolve, reject) => {
        fetch(url).then((response => {

            resolve(response.json());

        })).catch(error => {
            reject(error);
        });
    });
}
cargaSelectContinentes = () => {
    let selectContinentes = gestionarElemento("#continentes");
    continentes.forEach(continente => {
        let option = gestionarElemento("option", 1);

        option.value = continente.value;
        option.innerHTML = continente.texto;
        selectContinentes.appendChild(option);
    });
};

/*cargaPais = async (nombrePais) => {
    let url = `https://restcountries.com/v3.1/name/${nombrePais}`;
    pais = await cargaDatos(url);
    let bandera = gestionarElemento("#bandera");
    let escudo = gestionarElemento("#escudo");
    let paisSeleccionado = gestionarElemento("#pais");
    let paisSeleccionado2 = gestionarElemento("#paisSelect");
    paisSeleccionado.innerHTML = "Pais: " + pais[0].translations.spa.common;
    paisSeleccionado2.innerHTML = pais[0].translations.spa.common;
    bandera.src = pais[0].flags.png;
    escudo.src = pais[0].coatOfArms.png;

}*/
cargaDatosGeograficos = async () => {
    let titulogeografico = gestionarElemento("#titulogeografico");
    let latLng = gestionarElemento("#latlng");
    let mapa = gestionarElemento("#mapa2");
    let subregion = gestionarElemento("#subregion");
    let region = gestionarElemento("#region");
    let area = gestionarElemento("#area");
    titulogeografico.innerHTML = "Datos Geograficos de: " + pais[0].translations.spa.common;
    mapa.href = pais[0].maps.openStreetMaps;
    mapa.target = "_blank";
    latLng.innerHTML = "Latitud-Longitud:" + pais[0].latlng;
    mapa.innerHTML = "Enlace Mapa: " + pais[0].maps.openStreetMaps;
    subregion.innerHTML = "Subregion: " + pais[0].subregion;
    region.innerHTML = "Continente: " + pais[0].region;
    area.innerHTML = "Area: " + pais[0].area + " km2";
    //console.log(subregion);


}

cargaDatosTecnicos = () => {
    let titulotecnico = gestionarElemento("#titulotecnico");
    let dominio = gestionarElemento("#dominio");
    let aplhaCode2 = gestionarElemento("#alpha2");
    let aplhaCode3 = gestionarElemento("#alpha3");
    let fronteras = gestionarElemento("#fronteras");
    let demonymsvalor = gestionarElemento("#demonyms");
    let demonyms = Object.values(pais[0].demonyms);
    let gini = gestionarElemento("#gini");

    let zonaHoraria = gestionarElemento("#zona");
    titulotecnico.innerHTML = "Datos Tecnicos de: " + pais[0].translations.spa.common;

    demonyms.forEach(prop => {
        demonymsvalor.innerHTML = "Gentilicios: " + prop.f + "," + prop.m;
    });

    dominio.innerHTML = "Dominio TLD: " + pais[0].tld;
    aplhaCode2.innerHTML = "Codigo Alfa 2: " + pais[0].cca2;
    aplhaCode3.innerHTML = "Codigo Alfa 3: " + pais[0].cca3;
    fronteras.innerHTML = "Fronteras: " + pais[0].borders;
    let gini1;
    try {
        gini1 = Object.values(pais[0]?.gini);
    } catch (e) {
        gini1 = "No tiene";
    }


    gini.innerHTML = "Gini 2018: " + gini1;


    zonaHoraria.innerHTML = "Zonas horarias: " + pais[0].timezones;


    //demonyms.innerHTML = "Demonyms " + pais[0].demonyms;

}


cargaBanderas = () => {
    let bandera = gestionarElemento("#bandera");
    let escudo = gestionarElemento("#escudo");
    bandera.classList.add("bandera");
    escudo.classList.add("escudo");
    //pais = await cargaDatos(url);
    //document.querySelector("posicion-menu").innerHTML=pais.name.common;
    bandera.src = pais[0].flags.png;
    escudo.src = pais[0].coatOfArms.png;


}
cargaDatosGenerales = () => {
    //moneda
    //let moneda = document.querySelector("#moneda");

    //moneda.innerHTML = "Moneda: " + Object.getOwnPropertyNames(pais[0].currencies);
    let titulogenerales = gestionarElemento("#titulogenerales");
    let nombrePais = gestionarElemento("#nombrePais");
    let capital = gestionarElemento("#capital");
    let monedas = Object.values(pais[0].currencies);
    let poblacion = gestionarElemento("#poblacion");
    let idiomas = gestionarElemento("#idiomas");
    let traduccion = gestionarElemento("#traducciones");



    titulogenerales.innerHTML = "Datos Generales de: " + pais[0].translations.spa.common;
    //let traducciones = Object.values(pais[0].translations);


    let nombres = Object.getOwnPropertyNames(pais[0].translations);
    let valor = Object.values(pais[0].translations);
    let traducciones = gestionarElemento("#traducciones");
    let parrafo = gestionarElemento("p", 1);
    let valorTraduccion = gestionarElemento("#valortraduccion");
    traducciones.title = "";
    parrafo.innerHTML ="";

    //para sacar el idioma de cada pais
    /*forEach(idioma => {
        fetch("https://restcountries.com/v3.1/lang/{$idioma}"+ idioma);
    });*/
    let textos = "";
    for (let i = 0; i < valor.length; i++) {
        let h5 = gestionarElemento("h5", 1);
        let a = gestionarElemento("a", 1);
        a.setAttribute("data-toggle", "tooltip");
        a.setAttribute("data-placement", "auto");
        a.href = "#";
        
        verPaisTraducciones(nombres[i], a);
        

        a.innerHTML = valor[i].official + " - " + valor[i].common;
        h5.appendChild(a);
        parrafo.appendChild(h5);
        //textos = textos + " - " + nombres[i] + " : " + valor[i].official + "," + valor[i].common;
        //console.log(traducciones.title);

        //nombreTraduccion.innerHTML = nombres[i];

        //console.log(nombres[i]);
        //console.log(valor[i]);


    }
    traducciones.title = textos;
    traducciones.appendChild(parrafo);

    //llenar los arrays de los dos valores y nombres 



    buscaPais = () => {
        //poner cca3
        //pais[0].cca3
    }

    nombrePais.innerHTML = "Pais: " + pais[0].name.common;
    capital.innerHTML = "Capital: " + pais[0].capital;
    poblacion.innerHTML = "Poblacion: " + pais[0].population;
    idiomas.innerHTML = "Idiomas: " + Object.values(pais[0].languages);

    console.log(traduccion);
    // idiomas.forEach(prop=>{
    //  idiomas.innerHTML = prop;
    //});
    /*monedas.forEach(prop => {
        monedas.innerHTML = prop.name;
        monedas.innerHTML = prop.symbol;
        let tabla = gestionarElemento("#monedas");
        tabla.innerHTML = "";
        let trCabecera = gestionarElemento("tr", 1);
        let thCabeceraNombre = gestionarElemento("th", 1);
        let thCabeceraSimbolo = gestionarElemento("th", 1);
        thCabeceraNombre.innerHTML = "Nombre de la moneda";
        thCabeceraSimbolo.innerHTML = "simbolo";
        trCabecera.appendChild(thCabeceraNombre);
        trCabecera.appendChild(thCabeceraSimbolo);
        tabla.appendChild(trCabecera);

        let tr = gestionarElemento("tr", 1);
        let td = gestionarElemento("td", 1);
        let td1 = gestionarElemento("td1", 1);
        td.innerHTML = prop.name;
        td1.innerHTML = prop.symbol;
        tr.appendChild(td);
        tr.appendChild(td1);
        tabla.appendChild(tr);

    });*/


}

verPais = async (valorPais) => {
    let url = `https://restcountries.com/v3.1/name/${valorPais}`;
    pais = await cargaDatos(url);
    //document.querySelector("posicion-menu").innerHTML = "Capital: "+ pais[0].capital;

}
verPaisTraducciones = async (valorPais, elemento) => {

    let url = `https://restcountries.com/v3.1/lang/${valorPais}`;
    paisesPorIdioma = await cargaDatos(url);
    try {
        let paisesPori= ""
        paisesPorIdioma.forEach(pais => {
            paisesPori = paisesPori + pais.name.common + "   "

        });
        elemento.setAttribute("title", paisesPori);
    } catch (error) {

    }


    //document.querySelector("posicion-menu").innerHTML = "Capital: "+ pais[0].capital;

}
//para sacar varias cosas del json
//object.value(pais[0].currencies);
//forEach()
/*{name:="cuban peso",
  symbol:="$"
}
{name:="cuban",
 symbol:="$"}
*/


//document.createElement("td");
//document.querySelector("#loquesea");
/*crearElemento = (nombre) =>{
    return document.createElement(nombre);
}
dameElemento = (nombre) =>{
    return document.querySelector(nombre);

}
let a = dameElemento("#bandera");*/

/*var visibleGenerales = gestionarElemento("#general")
var visibleTecnicos = gestionarElemento("#tecnicos");
var visibleBanderas = gestionarElemento("#banderas");
var visibleGeograficos = gestionarElemento("#geograficos");
botonGenerales=()=>{
    visibleGenerales.hidden=false;
    visibleTecnicos.hidden=true;
    visibleBanderas.hidden=true;
    visibleGeograficos.hidden=true;
    }
    botonGeograficos=()=>{
      visibleGenerales.hidden=true;
      visibleTecnicos.hidden=true;
      visibleBanderas.hidden=true;
      visibleGeograficos.hidden=false;
    }
    botonTecnicos=()=>{
      visibleGenerales.hidden=true;
      visibleTecnicos.hidden=false;
      visibleBanderas.hidden=true;
      visibleGeograficos.hidden=true;
    }
    botonBanderas=()=>{
      visibleGenerales.hidden=true;
      visibleTecnicos.hidden=true;
      visibleBanderas.hidden=false;
      visibleGeograficos.hidden=true;
    }*/