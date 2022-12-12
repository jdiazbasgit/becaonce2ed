function comprobarDatosUsuario() {

    let clave01 = document.querySelector("#clave01")
    let clave02 = document.querySelector("#clave02")
    let email01 = document.querySelector("#email01")
    let email02 = document.querySelector("#email02")

    if (clave01.value != clave02.value)
        alert("la clave no coincide")
    if (email01.value != email02.value)
        alert("el email no coinciden")

    if (clave01.value == clave02.value && email01.value == email02.value)
        alert("el Usuario a sido registrado correctamente")
}