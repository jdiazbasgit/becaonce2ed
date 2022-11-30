
class EstadoCivil {
    constructor(descripcion) {
        this.descripcion = descripcion;

    }
}

class Hijos {
    constructor(chicos, chicas) {
        this.chicos = chicos;
        this.chicas = chicas;
    }
}

class Empresa {
    constructor(nombre, cif,) {
        this.nombre = nombre;
        this.cif = cif;

    }
}

class Cargo {
    constructor(descripcion) {
        this.descripcion = descripcion;

    }

}
class Datospersonale {
    constructor(hijos, estadocivil,) {
        this.hijos = hijos;
        this.estadocivil = estadocivil;

    }
}

class DatosLaborables {
    constructor(salario, cargo) {
        this.salario = salario;
        this.cargo = cargo;

    }
}

class Empleado {
    constructor(nombre, apellido, dni, fechadeNacimiento, fechaAlta, fechaBaja, datosPersonales, datosLaborales, empresa,) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechadeNacimiento = fechadeNacimiento;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.datosPersonales = datosPersonales;
        this.datosLaborales = datosLaborales;
        this.empresa = empresa;
    
    }
}

estadocivil = new EstadoCivil("casado")
cargo = new Cargo("analista programador")
empresa = new Empresa("Fundacion Once","12345678B")
hijo = new Hijos(3,2)
datosPersonales = new Datospersonale(hijo, estadocivil)
datosLaborales = new DatosLaborables(3000, cargo)
empleado = new Empleado("luis", "villagran", "99999999A", new Date("1992/02/17").toLocaleString(), new Date("2022/11/30").toLocaleString(), null, datosPersonales, datosLaborales, empresa)
console.log(empleado)
console.log(cargo)
console.log(empresa)
console.log(estadocivil)
console.log(hijo)
console.log(datosPersonales)
console.log(datosLaborales)
console.log(JSON.stringify(empleado))
