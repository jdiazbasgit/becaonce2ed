function spinner(visible) {if (visible == true) { document.getElementById("spinner").style.display = "block"; } else { document.getElementById("spinner").style.display = "none"; }}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

let url = "https://restcountries.com/v3.1/";

const restcountries = {
    Region: url + "region/",
    Name: url + "name/",
    Alpha: url + "alpha/",
    Lang: url + "lang/"
}

async function getRegion(continente) {
    const response = await fetch(restcountries.Region + continente);
    spinner(true);
    await sleep(500);
    spinner(false);
    return await response.json();
}

async function getName(pais) {
    const response = await fetch(restcountries.Name + pais);
    spinner(true);
    await sleep(500);
    spinner(false);
    return await response.json();
}

async function getAlpha(pais) {
    const response = await fetch(restcountries.Alpha + pais);
    return await response.json();
}

let Continente = document.querySelector('#continent');

Continente.addEventListener("click", function () {
    document.getElementById("tabs").style.display = "none";
    document.getElementById("tabs-cont").style.display = "none";
});

Continente.addEventListener('change', (event) => {
    var cboPais = document.getElementById("pais");
    cboPais.innerHTML = "";

    if (!event.target.value == '') {
        var option = document.createElement("option");
        option.text = "Seleccione un país";
        cboPais.add(option);

        getRegion(event.target.value).then(function (paises) {
            paises.forEach(pais => {
                var option = document.createElement("option");
                option.value = pais.name.common;
                option.text = pais.name.common;
                cboPais.add(option);
            });
        }).catch(error => {
            alert(error);
        });

    }
});

let Pais = document.querySelector('#pais');

Pais.addEventListener("click", function () {
    document.getElementById("tabs").style.display = "none";
    document.getElementById("tabs-cont").style.display = "none";
});

Pais.addEventListener('change', () => {
    let abreviaturaspais = [];
    document.querySelector('#tradlist').innerHTML ="";

    getName(Pais.value).then(function (countriesList) {
        document.getElementById("tabs").style.display = "block";
        document.getElementById("tabs-cont").style.display = "block";
        countriesList.forEach(countryData => {

            document.querySelector("#flag-container img").src = countryData.flags.png;
            document.querySelector("#shield-container img").src = countryData.coatOfArms.png;

            var nativeName = Object.keys(countryData.name['nativeName']);
            let nofficial = ""
            let ncommon = ""
            nativeName.forEach(nNative => {
                nofficial = countryData.name['nativeName'][nNative].official;
                ncommon = countryData.name['nativeName'][nNative].common;
            });

            /* title */
            document.querySelector("#nompaisg").innerHTML = ncommon;
            document.querySelector("#nompaisx").innerHTML = ncommon;
            document.querySelector("#nompaisb").innerHTML = ncommon;
            /* ## title */

            /* Generales */

            document.querySelector("#nombrepais").innerHTML = ncommon;
            document.querySelector("#flag").innerHTML = `<img src='${countryData.flags.png}' class="img-fluid rounded-0" style="height:240px; width:100%;" alt=''>`;

            infgen = `<li class="border-0 pl-2"><strong>Nombre nativo:</strong> ${nofficial}</li>`;
            infgen += `<li class="border-0 pl-2"><strong>Población total:</strong> ${countryData.population} habitantes</li>`;
            infgen += `<li class="border-0 pl-2"><strong>Región:</strong> ${countryData.region}</li>`;
            infgen += `<li class="border-0 pl-2"><strong>Sub-Región:</strong> ${countryData.subregion}</li>`;
            infgen += `<li class="border-0 pl-2"><strong>Capital:</strong> ${countryData.capital}</li>`;
            infgen += `<li class="border-0 pl-2"><strong>Area:</strong> ${countryData.area} Km<sup>2</sup></li>`;

            let idioma = Object.keys(countryData['languages']);
            let idiomas = "";

            idioma.forEach(idiom => {
                idiomas += countryData['languages'][idiom] + '  ';
            });

            infgen += `<li class="border-0 pl-2"><strong>Idiomas:</strong> ${idiomas}</li>`;
            document.querySelector("#infgen").innerHTML = infgen;
            /* ## Generales */


            /* Geograficos */
            document.querySelector("#geoflag").innerHTML = `<img src='${countryData.flags.png}' class="img-fluid rounded-0" style="height:140px;" alt=''>`;

            //let coordinates = countryData.latlng;

            var geoMaps = '';
            geoMaps += `<li class="list-group-item p-1"><a href="${countryData.maps.googleMaps}" target="_blank" class="text-decoration-none">Ver el mapa de google maps</a></br>`;
            geoMaps += `<a href="${countryData.maps.googleMaps}" target="_blank" class="text-decoration-none">Ver el mapa de ver openStreetMaps</a></li>`;

            document.querySelector("#geoMaps").innerHTML = geoMaps;
            document.querySelector("#geoMaps").style.textAlign = "center";
            /* ## Geograficos */

            /* Traduccion */

            abreviaturaspais = Object.keys(countryData['translations']); /* Sacar todos los traductores en la web de name */

            let abpais = [];
            let languagesArr = [];

            for (let a = 0; a < abreviaturaspais.length; a++) {
                var vab = abreviaturaspais[a];
                abpais.push({pais: vab});
            }

            let langitems = Object.keys(countryData['languages']);
            for (var l = 0; l < langitems.length; l++) {
                let lang = langitems[l];
                languagesArr.push({language: lang});
            }

            var getJSON = function (surl, callback) {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', surl, true);
                xhr.responseType = 'json';

                xhr.onload = function () {
                    var status = xhr.status;
                    if (status == 200) {
                        callback(null, xhr.response);
                    } else {
                        callback(status);
                    }
                };

                xhr.send();
            };

            for (let ix = 0; ix < abpais.length; ix++) {
                getJSON(restcountries.Lang + abpais[ix].pais, function (err, langs) {

                    if (err != null) {
                        console.log(err);
                    } else {
                        //console.log(langs);
                        var addli ="";

                        for (let slg = 0; slg < languagesArr.length; slg++) {
                            var lang = languagesArr[slg].language;
                            var LItems="";
                            var LName ="";
                            for (let m = 0; m < langs.length; m++) {
                                LName = langs[m].languages[abpais[ix].pais];
                                if (langs[m]?.translations[lang]?.common){LItems += langs[m].translations[lang].common + ' ';}
                            }

                            if (slg == (languagesArr.length-1)){
                                //console.log(LItems);
                                addli =`<li class="p-0 border-0"><strong>${lang.toUpperCase()}</strong> : ${LItems}</li>`;
                                var insAccordion = "";
                                insAccordion += '<div class="accordion accordion-flush">';
                                insAccordion += '<div class="accordion-item">';
                                insAccordion += '<h2 class="accordion-header id="flush-heading' + ix + '">';
                                insAccordion += '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse' + ix + '">';
                                insAccordion += `<span class="text-right"><strong>${LName}</strong>  (${abpais[ix].pais.toUpperCase()})</span`;
                                insAccordion += '</button>';
                                insAccordion += '</h2>';
                                insAccordion += '<div id="flush-collapse' + ix + '" class="accordion-collapse collapse"';
                                insAccordion += 'aria-labelledby="flush-heading' + ix + '" data-bs-parent="#accordionFlushExample">';
                                insAccordion += '<div class="accordion-body">';
                                insAccordion += `<ul>${addli}</ul>`;
                                insAccordion += '</div>';
                                insAccordion += '</div>';
                                insAccordion += '</div>';
                                insAccordion += '</div>';

                                document.querySelector('#tradlist').innerHTML = document.querySelector('#tradlist').innerHTML + insAccordion;
                            } else {
                                addli+=`<li class="p-0 border-0"><strong>${lang.toUpperCase()}</strong> : ${LItems}</li>`;
                            }
                           
                        }
                    }
                });
            }

            /* Traduccion */

            /* Monedas */
            var monedas = Object.keys(countryData['currencies']);
            var infgencur = "";
            if (monedas.length > 1) {
                var sname = '';
                var ssymbol = '';

                monedas.forEach(tipo => {
                    sname += countryData.currencies[tipo].name + '  ,  ';
                    ssymbol += countryData.currencies[tipo].symbol + '  , ';
                });

                infgencur = '<strong>Monedas:</strong><li class="border-0">' + sname.slice(0, -4) + '</li>' + '<li class="border-0"><strong>Simbolo:</strong>' + ssymbol.slice(0, -4) + '</li>';

            } else if (monedas.length == 1) {
                infgencur = (`<li class="border-0"><strong>Monedas:</strong> ${countryData.currencies[monedas].name}</li>`);
                infgencur += (`<li class="border-0"><strong>Simbolo:</strong> ${countryData.currencies[monedas].symbol}</li>`);
            }
            /* ## Monedas */



            /* Fronteras y geografica */

            if (typeof (countryData['borders']) !== "undefined") {
                let fronteras = Object.keys(countryData['borders']);
                infgencur += '<li class="border-0 text-center font-size:15px;"><strong>Fronteras</strong>';
                var geoTerrVec = "";
                var geoLonFron = "";
                for (var f = 0; f < fronteras.length; f++) {
                    let Abrev = countryData['borders'][f];

                    getAlpha(countryData['borders'][f]).then(function (bordersList) {
                        bordersList.forEach(bordersData => {
                            let borders = bordersData.name.common;
                            infgencur += `<li class="border-0 text-center bg-dark text-white border-bottom">${borders} (${Abrev})</li>`;
                            geoTerrVec += `<li class="border-0 text-left">${borders}</li>`
                            geoLonFron += `<li class="border-0 text-left">-</li>`
                        });
                        document.querySelector('#infgencur').innerHTML = infgencur;
                        document.querySelector('#geoTerrVec').innerHTML = geoTerrVec;
                        document.querySelector('#geoCantVec').innerHTML = f;
                        document.querySelector('#geoLonFron').innerHTML = geoLonFron;
                    }).catch(error => {
                        alert(error);
                    });
                }
            }
            /* ## Fronteras y geografica */
        });

    }).catch(error => {
        alert(error);
    });



});