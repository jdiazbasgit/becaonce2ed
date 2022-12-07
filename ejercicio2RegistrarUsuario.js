function registrarUsuario() {
    let clave1 = document.querySelector("#clave1")
    let clave2 = document.querySelector("#clave2")
    let email1 = document.querySelector("#email1")
    let email2 = document.querySelector("#email2")

    if (clave1.value != clave2.value)
        alert("las claves no coinciden")
    if (email1.value != email2.value)
        alert("el email no coincide")

    if (clave1.value == clave2.value && email1.value == email2.value)
        alert("Usuario Registrado Correctamente")
}