class Cargo {
    constructor(descripcion) {
        this.descripcion = descripcion;
    }
}
class Empresa {
    constructor(cif, nombre) {
        this.cif = cif;
        this.nombre = nombre;
    }
}
class EstadoCivil {
    constructor(descripcion) {
        this.descripcion = descripcion;
    }

}
class Hijo {
    constructor(chicos, chicas) {
        this.chicos = chicos;
        this.chicas = chicas;
    }
}
class DatosPersonales {
    constructor(hijo, estadoCivil) {
        this.hijo = hijo;
        this.estadoCivil = estadoCivil;
    }
}
class DatosLaborales {
    constructor(cargo, salario) {
        this.cargo = cargo;
        this.salario = salario;
    }

}
class Empleado {
    constructor(nombre, apellidos, dni, fechaNacimiento, fechaAlta, fechaBaja, datosPersonales, datosLaborales, empresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.datosPersonales = datosPersonales;
        this.datosLaborales = datosLaborales;
        this.empresa = empresa;
    }
}
estadoCivil = new EstadoCivil("divorciado")
cargo = new Cargo("analista Programador")
empresa = new Empresa("12345678A", "fundacion Once")
hijo = new Hijo(3, 1)
datosPersonales = new DatosPersonales(hijo, estadoCivil)
datosLaborales = new DatosLaborales(cargo, "3000")
empleado = new Empleado("Daniel", "Gómez Parra", "00000000A", new Date("2003/01/17").toLocaleDateString(), new Date("2022/09/20").toLocaleDateString(), null, datosPersonales, datosLaborales, empresa)
console.log(empleado)
console.log(cargo)
console.log(empresa)
console.log(estadoCivil)
console.log(hijo)
console.log(datosPersonales)