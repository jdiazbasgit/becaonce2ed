class Empleado {
    constructor(nombre, dni, fechaAlta, fechaBaja) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

}

class Hijo {
    constructor(hijo, estadoCivil) {
        this.hijo = hijo;
        this.esstadoCivil = estadoCivil;
    }
}

class EstadoCivil {
    constructor(descripcion) {
        this.descripcion = descripcion;
    }
}
class DatosPersonales {
    constructor(hijo, estadoCivil) {
        this.hijo = hijo;
        this.estadoCivil = estadoCivil;
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
class DatosLaboral {
    constructor(salario, cargo) {
        this.cargo = cargo;
        this.salario = salario;
    }
}
var Empleado = new Empleado("Pepe Calvo", "5544777B", "19/01/2020", null);
DatosPersonales = new DatosPersonales("3", "Soltero");
Cargo = new Cargo("Becario")
Empresa = new Empresa("11111", "BBVA IT");
DatosLaboral = new DatosLaboral("1.582", Cargo());


//alert(Empleado.)