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

class Cargo {
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
    constructor(nombre, apellidos, dni, fechaDeNacimiento, fechaDeAlta, fechaDeBaja, datosPersonales, datosLaborales, empresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeAlta = fechaDeAlta;
        this.fechaDeBaja = null;
        this.datosPersonales = datosPersonales
        this.datosLaborales = datosLaborales
        this.empresa = empresa
    }
}
