class Empleado {
    constructor(nombre, apellido, dni, fechaNac, fechaAlta, fechaBaja, datosPersonales, datosLabolares, empresa ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.datosPersonales= datosPersonales;
        this.datosLabolares=datosLabolares;
        this.empresa=empresa;
    }

}
class DatosPersonales {
    constructor(hijo, estadoCivil) {
        this.hijo = hijo;
        this.estadoCivil = estadoCivil;
    }
}

class Hijo {
    constructor(hijos) {
        this.hijos = hijos;
    }
}

class EstadoCivil {
    constructor(descripcion){
        this.descripcion = descripcion;
    }
}
class DatosLaboral {
    constructor(salario, cargo) {
        this.cargo = cargo;
        this.salario = salario;
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

var Empleado = new Empleado("Pepe Calvo", "5544777B", "19/01/2020", null);
DatosPersonales = new DatosPersonales("3", "Soltero");
Cargo = new Cargo("Becario")
Empresa = new Empresa("11111", "BBVA IT");
DatosLaboral = new DatosLaboral("1.582", Cargo());


//alert(Empleado.)