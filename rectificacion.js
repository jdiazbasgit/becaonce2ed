var capital
var poblacion
var area
var monedas = []
var dominios = []
var fronteras = []
var bandera
var escudo
var monedasDatos = []
var traducciones = []
var fronterasNombres = []
var traduccionesNombres = []

function cargarDatos(pais) {
    dameDatos("https://restcountries.com/v3.1/name/" + pais)
        .then(paises => {
            let miPais = paises[0]
            capital = miPais.capital
            poblacion = miPais.population
            area = miPais.area
            dominios = miPais.tld
            bandera = miPais.flags.svg
            escudo = miPais.coatOfArms.svgmonedas
            monedas = miPais.currencies
            traducciones = miPais.translations
            fronteras = miPais.borders
            fronteras.forEach(frontera => {
                dameDatos("https://restcountries.com/v3.1/alpha/" + frontera)
                    .then(paises => {
                        let miPais = paises[0]
                        fronterasNombres.push(miPais.name.common)
                    })
            })
            monedas.forEach(moneda => {
                monedasDatos.push(Object.entries(monedas)[0])
            })
            Object.entries(traducciones)
            .forEach(traduccion =>{
                
            })
        })
}