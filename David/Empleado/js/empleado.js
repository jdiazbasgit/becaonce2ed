class Empleado {
    constructor(nombre, dni, fechanacimiento, fechaalta, fechabaja) {
        this.nombre=nombre;
        this.dni=dni;
        this.fechanacimiento=fechanacimiento;
        this.fechaalta=fechaalta;
        this.fechabaja=fechabaja;
    }
}

class Empresa {
    constructor(cif, descripcion) {
        this.cif = cif;
        this.descripcion = descripcion;
    }
}

class DatosLaborales{
    constructor(salario){
        this.salario = salario;
    }
}

class Cargo{
    constructor(descripcion){
        this.descripcion = descripcion;
    }
}

class DatosPersonales {
    constructor(hijo, estadoCivil){
        this.hijo = hijo;
        this.estadoCivil = estadoCivil;
    }
}

class TotalHijo{
    constructor(chico, chica){
        this.chico = chico;
        this.chica = chica;
    }
}

class estadocivil{
    constructor(descripcion){
        this.descripcion = descripcion;
    }
}




var empleado = new Empleado("David", "50094297L", "23/03/1974", "01/11/2022", "28/11/2022");
var chico = new TotalHijo("2", "0");

var Dni = empleado.dni;
empleado.dni ="50094297LLLLL"
Dni = empleado.dni;
document.querySelector("#xx").innerHTML = "Mi dni es " + Dni;
//alert(chico.chico);