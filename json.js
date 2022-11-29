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
class Salario {
    constructor(descripcion) {
        this.descripcion = descripcion;
    }
}


class Empleado {
    constructor(nombre, apellido, dni, fechaNacimiento, fechaAlta, fechaBaja, datosLaborales, empresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNaciemiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.datosPersonales = datosPersonales;
        this.datosLaborales = datosLaborales;
        this.empresa = empresa;
    }
}

class Empresa {

    constructor(cif, descripcion) {
        this.cif = cif;
        this.descripcion = descripcion;
    }
}
class DatosLaborales {
    constructor(salario, cargo) {
        this.salario = salario;
        this.cargo = cargo;
    }
}
empleado = new Empleado("nombre", "dni", "fechaNacimiento", "fechaAlta", "fechaBaja", "datosPersonales", "empresa");

empresa = new Empresa("cif", "descripcion");
datosLaborales = new ("cargo", "salario");
cargo = new Cargo(descripcion);
datosPersonales = new DatosPersonales ("hijo", "estadoCivil");

