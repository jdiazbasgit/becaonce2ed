class Cargo {
    constructor(descripcion) {
        this.descripcion = descripcion;
    }

}
class Empresa {
    constructor(cif, nombreEmpresa) {
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
    }
}
class EstadoCivil {
    constructor(descripcion) {
        this.descripcion = descripcion;
    }
}
class DatoLaborales {
    constructor(salario, cargo) {
        this.salario = salario;
        this.cargo = cargo;
    }
}


class DatosPersonales {
    constructor(hijo, estadoCivil) {
        this.hijo = hijo;
        this.estadoCivil = estadoCivil;

    }
}

class Hijo {
    constructor(chicos, chicas) {
        this.chicos = chicos;
        this.chicas = chicas;
    }
}
class Empleado {
    constructor(nombre, apellidos, dni, fechaNacimiento, fechaAlta, fechaBaja, datosPersonales, datoLaborales, empresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.datosPersonales = datosPersonales
        this.datoLaborales = datoLaborales
        this.empresa = empresa
    }
}
eduardo = new Empleado("Eduardo Antonio", "Rodriguez Macassi ", "M2345679l", new Date("1966/12/19").toLocaleDateString(), new Date("2022/10/20").toLocaleDateString(), null, new DatosPersonales(new Hijo(3, 2), new EstadoCivil("divorciado")), new DatoLaborales(3000, new Cargo("Analista de Sistemas")), new Empresa("B3245678", "ONCE"));
console.log(`El empleado ${eduardo.nombre + eduardo.apellidos} con documento ${eduardo.dni} nacido el ${eduardo.fechaNacimiento} con fecha de alta ${eduardo.fechaAlta} fecha de baja ${eduardo.fechaBaja} con hijos ${eduardo.datosPersonales.hijo.chicos + eduardo.datosPersonales.hijo.chicas} estado civil ${eduardo.datosPersonales.estadoCivil}  que trabaja en la empresa ${eduardo.empresa.nombreEmpresa} como ${eduardo.datoLaborales.cargo.descripcion}`);
console.log(eduardo)

console.log(JSON.stringify(eduardo))