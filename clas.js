


class Empresa {
    constructor(cif, nombre, ) {
        this.cif = cif;
        this.nombre = nombre;
        
    }
}
class Hijo {
    constructor(chicos, chicas,) {
        this.chicos = chicos;
        this.chicas = chicas;

    }



}
class Cargo {
    constructor(descripcion) {
        this.descripcion = descripcion;
    }



}

class EstadoCivil {
    constructor(descripcion) {
        this.descripcion = descripcion;

    }

}
class DatosPersonales {
    constructor(hijos, estadocivil) {
        this.hijos = hijos;
        this.estadocivil = estadocivil;


    }
}
class DatosLaborales {
    constructor(cargo, salario) {
        this.cargo = cargo;
        this.salario = salario;

    }

}
class Empleado {
    constructor(nombre, apellidos, fechaNacimiento, dni, fechaAlta, fechaBaja, datosLaborales, datosPersonales, empresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.fechaNacimiento = fechaNacimiento;
        this. datosLaborales = datosLaborales;
        this. datosPersonales = datosPersonales;
        this. empresa = empresa;

    }
}
empresa = new Empresa("12345789f", "fundaciononce");
hijo = new Hijo(3,2);
cargo = new Cargo("programador");
estadoCivil = new EstadoCivil("soltero");
datospersonales = new DatosPersonales(hijo, estadoCivil)
datoslaborales = new DatosLaborales(cargo, "3000")
 empleado = new Empleado("Daniel", "Avila", "012345678N", new Date(2001 / 12 / 21).toLocaleDateString(), new Date("2022/8/23").toLocaleDateString(), null, datospersonales, datoslaborales, empresa)


console.log(empleado)
console.log(empresa)
console.log(hijo)
console.log(cargo)
console.log(estadoCivil)
// console.log(datospersonales)
console.log(JSON.stringify(empleado))




















