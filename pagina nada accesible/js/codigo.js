window.onload = () => {
    //Recuperamos todos los botones y enlaces de la página
    var botones = document.getElementsByTagName("button");
    var enlaces = document.getElementsByTagName("a");

    //Le asignamos a todos los botones un evento onclick
    for (let boton of botones) {
        boton.onclick = () => {
            alert("Click en botón " + boton.innerHTML);
        };
    }

    //Lo mismo, pero con los enlaces
    for (let enlace of enlaces){
        enlace.onclick = () => {
            alert("Click en el enlace " + enlace.innerHTML);
        };
    }


};