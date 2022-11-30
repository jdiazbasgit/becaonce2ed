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
    constructor(chico, chica) {
        this.chico = chico;
        this.chica=chica;
    }
}

class EstadoCivil {
    constructor(descripcion){
        this.descripcion=descripcion;
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
//datosPersonales = new DatosPersonales("3", "Soltero");
//cargo = new Cargo("Becario")
//empresa = new Empresa("11111", "BBVA IT");
//datosLaboral = new DatosLaboral("1.582", Cargo());


var edu = new Empleado("Edu","PC", "5544777B", new Date("1992/07/19").toLocaleDateString(),new Date("2020/02/02").toLocaleDateString(), null,new DatosPersonales(new Hijo(0,0), new EstadoCivil("soltero")),new DatosLaboral(3000,new Cargo("Analista Programador")), new Empresa("111444111","Arelance"));
console.log(edu);
console.log(`EL mejor empleado de la empresa ${edu.empresa.descripcion} se llama ${edu.nombre} y su apellido es ${edu.apellido} su fecha de nacimiento es ${edu.fechaNac} y sigue trabajando como ${edu.datosLabolares.cargo.descripcion} y tiene el sueldo increible ${edu.datosLabolares.salario} €, por ahora no tiene hijos, total hijos ${edu.datosPersonales.hijo.chico}`);
console.log(`Su fecha alta es ${edu.fechaAlta} y todavia no se sabe cual es su baja , por eso se define el ${edu.fechaBaja}`)
console.log(`No tengo mas info, si quereis saberlo mas... llamad al 112 `)