elegirContinente = (continente) => {
    var selectorpaises = document.getElementById("seleccionaPais")
    selectorpaises.innerHTML = ""

    var placeholder = document.createElement("option")
    placeholder.textContent = "Selecciona País";
    placeholder.value = null;
    selectorpaises.appendChild(placeholder);

    fetch("https://restcountries.com/v3.1/region/" + continente)
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
    fetch("https://restcountries.com/v3.1/name/" + pais)
        .then(response => response.json())
        .then(datos => {
            console.log(datos)
            var padre = document.getElementById("megacampo")
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
            

            /*document.getElementById("nombreDePais").innerHTML = pais
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
}); */