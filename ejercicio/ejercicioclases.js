
class Dni {
    constructor(numero, letra) {
        this.numero = numero
        this.letra = letra
    }
}
class EstadoCivil {
    constructor(soltero, casado, separado, viudo) {
        this.soltero = soltero
        this.separado = separado
        this.casado = casado
        this.viudo = viudo

    }
}

class Hijos {
    constructor(chicos, chicas) {
        this.chicos = chicos
        this.chicas = chicas
    }
}

class Empresa {
    constructor(nombre, cif,) {
        this.nombre = nombre
        this.cif = cif

    }
}

class Cargo {
    constructor(puesto, sueldo) {
        this.puesto = puesto
        this.sueldo = sueldo
    }

}
class Datospersonale {
    constructor(nombre, apellido, fechadenaciemto, dni, hijos) {
        this.nombre = nombre
        this.apellido = apellido
        this.fechadenaciemto = fechadenaciemto
        this.dni = dni
        this.hijos = hijos
    }
}

class DatosLaborables {
    constructor(empresa, cargo, altaempresa, bajaempresa) {
        this.empresa = empresa
        this.cargo = cargo
        this.altaempresa = altaempresa
        this.bajaempresa = bajaempresa

    }
}