

fetch("https://restcountries.com/v3.1/name/palestine")
.then(response=>response.json())
.then(pais=>{
    let traducciones=Object.entries(pais[0].translations);
    console.log(traducciones)
    traducciones.forEach(element => {
        let objeto=Object.entries(element[1]);
        console.log(element[0]+" - "+objeto[1][1])
        
    });

    let monedas=Object.entries(pais[0].currencies);
    monedas.forEach(moneda=>{
        console.log(moneda[1].name)
    })
})