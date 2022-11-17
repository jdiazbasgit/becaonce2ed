function minombreenmayuscula() {
    nombre = "danielgomez";
    alert(nombre.toUpperCase())
    for (let i = 0; i < nombre.length; i++) {

        if (i % 2 == 0) {
            
            document.querySelector("#h1").innerHTML = document.querySelector("#h1").innerHTML + nombre.substring(i,i+1).toUpperCase();
        } else {
            document.querySelector("#h1").innerHTML = document.querySelector("#h1").innerHTML + nombre.substring(i,i+1).toLowerCase();
        }
    }
}
