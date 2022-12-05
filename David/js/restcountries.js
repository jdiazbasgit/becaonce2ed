/*import restcountries from "Spinners.js";*/
let url = "https://restcountries.com/v3.1/";

const restcountries = {
    Region: url+"region/",
    Name: url+"name/"
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function getRegion(continente) {
    const response = await fetch(restcountries.Region + continente);
    document.getElementById("spinner").style.display = "block";
    await sleep(2000);
    document.getElementById("spinner").style.display = "none";
    return await response.json()
}

async function getName(pais) {
    const response = await fetch(restcountries.Name + pais);
    document.getElementById("spinner").style.display = "block";
    await sleep(2000);
    document.getElementById("spinner").style.display = "none";
    return await response.json();
}

let Continente = document.querySelector('#continent');

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

Pais.addEventListener('change', () => {
    getName(Pais.value).then(function (countriesList) {
        countriesList.forEach(countryData => {
            document.querySelector('#region').innerHTML = countryData.region;
            document.querySelector('#capital').innerHTML = countryData.capital;
            document.querySelector('#area').innerHTML = countryData.area + ' Km<sup>2</sup>';

            document.querySelector("#flag-container img").src = countryData.flags.png;
            document.querySelector("#shield-container img").src = countryData.coatOfArms.png;

            var insAccordion = "";
            var i = 0;

            var translations = Object.keys(countryData['translations']);

            translations.forEach(idioma => {
                var sofficial = countryData.translations[idioma].official;
                var scommon = countryData.translations[idioma].common;

                insAccordion += '<div class="accordion accordion-flush">';
                insAccordion += '<div class="accordion-item">';
                insAccordion += '<h2 class="accordion-header id="flush-heading' + i + '">';
                insAccordion += '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse' + i + '">';
                insAccordion += scommon;
                insAccordion += '</button>';
                insAccordion += '</h2>';
                insAccordion += '<div id="flush-collapse' + i + '" class="accordion-collapse collapse"';
                insAccordion += 'aria-labelledby="flush-heading' + i + '" data-bs-parent="#accordionFlushExample">';
                insAccordion += '<div class="accordion-body">';
                insAccordion += sofficial;
                insAccordion += '</div>';
                insAccordion += '</div>';
                insAccordion += '</div>';
                insAccordion += '</div>';
                i++;
            });

            document.querySelector('#traducir').innerHTML = insAccordion;

            var monedas = Object.keys(countryData['currencies']);

            if (monedas.length > 1) {
                var sname = "";
                var ssymbol = "";
                monedas.forEach(tipo => {
                    sname += '<li class="border-0">' + countryData.currencies[tipo].name + '</li>';
                    ssymbol += '<li class="border-0">' + countryData.currencies[tipo].symbol + '</li>';
                });

                document.querySelector('#nombre').innerHTML = sname;
                document.querySelector('#simbolo').innerHTML = ssymbol;

            } else if (monedas.length == 1) {
                document.querySelector('#nombre').innerHTML = '<li class="border-0">' + countryData.currencies[monedas].name + '</li>';
                document.querySelector('#simbolo').innerHTML = '<li class="border-0">' + countryData.currencies[monedas].symbol + '</li>';
            }
        });

    }).catch(error => {
        alert(error);
    });
});