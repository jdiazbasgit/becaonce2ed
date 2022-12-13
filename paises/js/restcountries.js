spinner = (visible) => {if (visible == true) { document.getElementById("spinner").style.display = "block"; } else { document.getElementById("spinner").style.display = "none"; }}
sleep = (ms) => {return new Promise(resolve => setTimeout(resolve, ms));}

const rsURL = {
    url: "https://restcountries.com/v3.1/",
    Region: "region/",
    Name: "name/",
    Alpha: "alpha/",
    Lang: "lang/",
    getRCURL(page, search) {
        var dirURL;
        switch (page) {
            case "Region":dirURL=this.url + this.Region + search;break;
            case "Name":dirURL=this.url + this.Name + search;break;
            case "Alpha":dirURL=this.url + this.Alpha + search;break;
            case "Lang":dirURL=this.url + this.Lang + search;break;
        }
      return dirURL;
    }
};

const getRegion = async (continente) => {
    const response = await fetch(rsURL.getRCURL("Region",continente));
    spinner(true);await sleep(500);spinner(false);
    return await response.json();
}

const getName = async (pais) => {
    const response = await fetch(rsURL.getRCURL("Name", pais));
    spinner(true);await sleep(500);spinner(false);
    return await response.json();
}

const getAlpha = async(pais) => {
    const response = await fetch(rsURL.getRCURL("Alpha", pais));
    return await response.json();
}

const Continente = document.querySelector('#continent');

Continente.addEventListener("click", () => {
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

        getRegion(event.target.value).then((paises) => {
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

const Pais = document.querySelector('#pais');

Pais.addEventListener("click", () => {
    document.getElementById("tabs").style.display = "none";
    document.getElementById("tabs-cont").style.display = "none";
});

Pais.addEventListener('change', () => {
    let abreviaturaspais = [];
    document.querySelector('#tradlist').innerHTML ="";

    getName(Pais.value).then((countriesList)=>{
        document.getElementById("tabs").style.display = "block";
        document.getElementById("tabs-cont").style.display = "block";
        countriesList.forEach(countryData => {

            document.querySelector("#flag-container").innerHTML = (countryData.flags.png?`<img class="border" src="${countryData.flags.png}" width="250px">`:null);

            document.querySelector("#shield-container").innerHTML = (countryData.coatOfArms.png?`<img src="${countryData.coatOfArms.png}" width="150px">`:null);

            const nativeName = Object.keys(countryData.name['nativeName']);
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

            const idioma = Object.keys(countryData['languages']);
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

            abreviaturaspais = Object.keys(countryData['translations']); /* Sacar todos los traductores de la web de name */

            let abpais = [];
            let languagesArr = [];

            for (let a = 0; a < abreviaturaspais.length; a++) {
                var vab = abreviaturaspais[a];
                abpais.push({pais: vab});
            }

            const langitems = Object.keys(countryData['languages']);
            
            for (var l = 0; l < langitems.length; l++) {
                let lang = langitems[l];
                languagesArr.push({language: lang});
            }

            var getJSON = (surl, callback) => {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', surl, true);
                xhr.responseType = 'json';

                xhr.onload = () => {
                    const status = xhr.status;
                    if (status == 200) {
                        callback(null, xhr.response);
                    } else {
                        callback(status);
                    }
                };

                xhr.send();
            };

            for (let ix = 0; ix < abpais.length; ix++) {
                getJSON(rsURL.getRCURL("Lang", abpais[ix].pais), (err, langs) => {
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
            const monedas = Object.keys(countryData['currencies']);
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
                const fronteras = Object.keys(countryData['borders']);
                infgencur += '<li class="border-0 text-center font-size:15px;"><strong>Fronteras</strong>';
                var geoTerrVec = "";
                var geoLonFron = "";
                for (var f = 0; f < fronteras.length; f++) {
                    let Abrev = countryData['borders'][f];

                    getAlpha(countryData['borders'][f]).then((bordersList)=>{
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