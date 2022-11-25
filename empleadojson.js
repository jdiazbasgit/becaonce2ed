//creamos las clases

class Empleado {
    constructor(nombre, apellidos, dni, fechadenacimiento, fechadealta, fechadebaja) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechadenacimiento = fechadenacimiento;
        this.fechadealta = fechadealta;
        this.fechadebaja = fechadebaja;

    }
}
class EstadoCivil {
    constructor(soltero, casado, parejadehecho, viudo, viuda){
this.soltero=soltero;
this.casado=casado;
this.parejadehecho=parejadehecho;
this.viudo=viudo;
this.viuda=viuda;
}
}
class Hijo {
    constructor(hijos, hijas) {
        this.hijos = hijos;
        this.hijas = hijas;

    }
}

class Empresa {
    constructor(cif, descripcion) {
        this.cif=cif;
        this.descripcion=descripcion;

    }
}
class DatosLaborales {
    constructor(salario, cargo) {
        this.salario=salario;
        this.cargo=cargo;

    }

}
class Cargo {
    constructor(directivo, mandointermedio, operario) {
        this.directivo=directivo;
        this.mandointermedio=mandointermedio;
        this.

    }
}
class DatosPersonales {
    constructor(nombre, apellidos, dni, fechadenacimiento, estadocivil, hijo) {

    }

}
