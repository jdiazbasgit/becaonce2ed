class Cargo {
    constructor(descripcion) {
        this.descripcion = descripcion;


    }
}

class Empresa {
    constructor(nombre, cif,) {
        this.nombre = nombre;
        this.cif = cif;

    }
}

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



class Datospersonales {
    constructor(estadocivil, hijos) {
        this.estadocivil = estadocivil;
        this.hijos = hijos;
    }
}

class DatosLaborables {
    constructor(sueldo, cargo) {
        this.sueldo = sueldo;
        this.cargo = cargo;

    }
}

class Empleado {
    constructor(nombre, apellido, dni, fechadenacimiento, fechadealta, fechadebaja, datosPersonales, datosLaborables, empresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechadenacimiento = fechadenacimiento;
        this.fechadealta = fechadealta;
        this.fechadebaja = fechadebaja;
        this.datosPersonales = datosPersonales;
        this.datosLaborables = datosLaborables;
        this.empresa = empresa;


    }
}

