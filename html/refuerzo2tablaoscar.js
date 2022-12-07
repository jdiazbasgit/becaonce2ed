function registrar() {
    var usuario, clave, repetirclave, email, repetiremail;
    usuario = document.getElementById("usuario").value
    clave = document.getElementById("clave").value
    repetirclave = document.getElementById("repetirclave").value
    email = document.getElementById("email").value
    repetiremail = document.getElementById("repetiremail").value

    if (clave != repetirclave) {
        alert("la contraseña no es igual")
        return false

    }
  
       if (email != repetiremail){
        alert ("el email no coincide")
        return false
    }
    else {
        return true
    }
}
console.log(registrar())
