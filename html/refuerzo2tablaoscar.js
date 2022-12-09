
function registrar() {
    var usuario, clave, repetirclave, email, repetiremail;
    usuario = document.getElementById("usuario")
    clave = document.getElementById("clave")
    repetirclave = document.getElementById("repetirclave")
    email = document.getElementById("email")
    repetiremail = document.getElementById("repetiremail")

    if (clave.value != repetirclave.value) {
        alert("la contraseña no es igual")
        return false

    }
    if (email.value != repetiremail.value) {
        alert("el email no coincide")
        return false
    }
    if (clave.value == repetirclave.value && email.value != repetiremail.value)
        alert("usuario registrado")
}

