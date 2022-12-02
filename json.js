class Hijos {
    constructor(chicos, chicas) {
        this.chicos = chicos;
        this.chicas = chicas;
    }
}
class DatosPersonales {
    constructor(estadoCivil, hijos) {
        this.estadoCivil = estadoCivil;
        this.hijos = hijos;
    }
}
class EstadoCivil {
    constructor(descripcion) {
        this.descripcion = descripcion;
    }

}
class DatosLaborales {
    constructor(salario, cargo) {
        this.salario = salario;
        this.cargo = cargo;
    }
}
class Cargo {
    constructor(descripcion) {
        this.descripcion = descripcion;
    }
}

class Empresa {

    constructor(cif, descripcion) {
        this.cif = cif;
        this.descripcion = descripcion;
    }
}
class Empleado {
    constructor(nombre, apellido, dni, fechaNacimiento, fechaAlta, fechaBaja, datosPersonales, datosLaborales, empresa) {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.dni = dni;
        this.fechaNaciemiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.datosPersonales = datosPersonales;
        this.datosLaborales = datosLaborales;
        this.empresa = empresa;
    }
}


empresa = new Empresa("50505055Q", "Fundacion ONCE")
cargo = new Cargo("Analista Programador")
estadoCivil = new EstadoCivil("Divorciado")
hijo = new Hijos(3, 1)
datosPersonales = new DatosPersonales(estadoCivil, hijo)
datosLaborales = new DatosLaborales(3000, cargo)
empleado = new Empleado("Emilio", "Cuadros Rolon", "55555555S",
    new Date("1975 / 01 / 19").toLocaleDateString(),
    new Date("2022 / 10 / 13").toLocaleDateString(),
    null,
    datosPersonales, datosLaborales, empresa)
console.log(empleado)
console.log(empresa)
console.log(cargo)
console.log(estadoCivil)
console.log(hijo)
console.log(datosLaborales)

console.log(JSON.stringify(empleado))

