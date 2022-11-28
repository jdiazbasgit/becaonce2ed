//creamos las clases

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

class Empresa {
    constructor(cif, nombre) {
        this.cif = cif;
        this.nombre = nombre;

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

class DatosPersonales {
    constructor(Hijo, EstadoCivil) {
        this.Hijo = Hijo;
        this.EstadoCivil = EstadoCivil
    }

}

class Empleado {
    constructor(nombre,apellidos, dni, fechadenacimiento, fechadealta, fechadebaja, DatosPersonales, DatosLaborales, Empresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechadenacimiento = fechadenacimiento;
        this.fechadealta = fechadealta;
        this.fechadebaja = fechadebaja;
        this.DatosPersonales = DatosPersonales;
        this.DatosLaborales = DatosLaborales;
        this.Empresa = Empresa;
    }
}

estadoCivil = new EstadoCivil("descripcion");
hijo = new Hijo("chicos", "chicas");
empresa = new Empresa("cif", "nombre");
datosLaborales = new DatosLaborales(salario,"cargo");
cargo = new Cargo("descripcion");
datosPersonales = new DatosPersonales("estadocivil", "Hijo");
empleado = new Empleado("nombre","apellidos","dni","DatosPersonales","DatosLaborales","Empresa")new date(dd-mm-yy,"fechadenacimiento","fechadealta","fechadebaja");

