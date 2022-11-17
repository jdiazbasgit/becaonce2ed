function minombreEnMayusculas() {

    texto = "marchelinerosero";

    /*alert("longitud:" + int(texto.length));
    alert(texto.substring(1).toupperCase(1));*/

    for (let i = 0; i <= texto.length; i++) {

        if (i % 2 == 0) {
            document.getElementsByTagName("h1").innerHTML=gente;
            else{
                document.getElementsByTagName("h1").innerHTML=document.getElementsByTagName("h1").innerHTML+texto+substr(i, 1).tolowerCase();

            }

            document.querySelector("#h1").innerHTML =
                document.querySelector("#h1").innerHTML + "" + i;
        }
    }


}

}