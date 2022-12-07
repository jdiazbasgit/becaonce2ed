function registrar() {
    var usuario, clave, repetirclave, email, repetiremail;
    usuario = document.getElementById("usuario").value
    clave = document.getElementById("clave").value
    repetirclave = document.getElementById("repetirclave").value
    email = document.getElementById("email").value
    repetiremail = document.getElementById("repetiremail").value

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

