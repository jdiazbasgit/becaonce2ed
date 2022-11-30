class Cargo {
    constructor(descripcion) {
        this.descripcion = descripcion
    }
}
class Empresa {
    constructor(cif, nombre) {
        this.cif = cif
        this.nombre = nombre
    }
}
class EstadoCivil {
    constructor(descripcion) {
        this.descripcion = descripcion
    }
}
class Hijo {
    constructor(chicos, chicas) {
        this.chicos = chicos
        this.chicas = chicas
    }
}
class DatosPersonales {
    constructor(hijo, estadoCivil) {
        this.hijo = hijo
        this.estadoCivil = estadoCivil
    }
}
class DatosLaborales {
    constructor(cargo, salario) {
        this.cargo = cargo
        this.salario = salario
    }
}
class Empleado {
    constructor(nombre, apellidos, dni, fechaNacimiento, fechaAlta, fechaBaja, datosPersonales, datosLaborales, empresa) {
        this.nombre = nombre
        this.apellidos = apellidos
        this.dni = dni
        this.fechaNacimiento = fechaNacimiento
        this.fechaAlta = fechaAlta
        this.fechaBaja = fechaBaja
        this.datosPersonales = datosPersonales
        this.datosLaborales = datosLaborales
        this.empresa = empresa
    }
}

var cargo = new Cargo("Jardinero")
var empresa = new Empresa("R1300054B", "CONVENTO LA SAGRADA FAMILIA")
var estadoCivil = new EstadoCivil("Viudo")
var hijo = new Hijo(1, 3)
var datosPersonales = new DatosPersonales(hijo, estadoCivil)
var datosLaborales = new DatosLaborales(cargo, 1800)

var tomasTurbado = new Empleado(
    "Tomas",
    "Turbado Reinoso",
    "00000014Z",
    new Date(1911, 06, 24).toLocaleDateString(),
    new Date(1931, 09, 26).toLocaleDateString(),
    null,
    datosPersonales,
    datosLaborales,
    empresa
)

console.log(JSON.stringify(tomasTurbado))

console.log("Hace muchos años, en el día " + tomasTurbado.fechaNacimiento +
    " nació un pequeño varón, que sin dilación creció entre arbustos fuertes y robustos. Hasta que el "
    + tomasTurbado.fechaAlta + " comenzó su andadura, como empleado de Dios en el " +
    tomasTurbado.empresa.nombre + " donde nuestro querido " + tomasTurbado.nombre +
    " y de apellidos " + tomasTurbado.apellidos + " conoció el amor entre flores, pues era "
    + tomasTurbado.datosLaborales.cargo.descripcion + " del lugar. Prueba de su amor nacieron "
    + tomasTurbado.datosPersonales.hijo.chicas + " hijas y " +
    tomasTurbado.datosPersonales.hijo.chicos + " zagal arrabalero que marchó a recorrer el mundo entero. El tiempo le hizo "
    + tomasTurbado.datosPersonales.estadoCivil.descripcion + " y hasta hoy trabaja sin descanso por "
    + tomasTurbado.datosLaborales.salario + "€ al mes, porque la fe no da de comer...")

    /*   JSON.stringify(obj) // me devuelve un json
    JSON.parse(json) // me devuelve un obj     */
    
datos = JSON.stringify(tomasTurbado)
bodyM = document.getElementById("body")
parra = document.createElement("p")
bodyM.append(parra)    
parra.textContent = datos
    

