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
    constructor(nombre, apellido, dni, fechadeNacimiento, fechadeAlta, fechadeBaja, datosPersonales, datosLaborables, empresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechadeNacimiento = fechadeNacimiento;
        this.fechadeAlta = fechadeAlta;
        this.fechadeBaja = fechadeBaja;
        this.datosPersonales = datosPersonales;
        this.datosLaborables = datosLaborables;
        this.empresa = empresa;


    }
}

cargo = new Cargo ("Analista Datos");
empresa = new Empresa ("Fundacion la ONCE","87654321D")
estadocivil = new EstadoCivil ("Soltero");
hijos = new Hijos (3,2);
datosPersonales = new Datospersonales (estadocivil,hijos);
datosLaborables = new DatosLaborables (3000,cargo)
empleado = new Empleado ("Luis Carlos","Patiño Ocampo","432118765T",new Date ("1990/10/10").toLocaleString(), new Date("2022/10/10").toLocaleString(),null,datosPersonales,datosLaborables,empresa)
/*console.log(empleado)
console.log(cargo)
console.log(empresa)
console.log(estadocivil)
console.log(hijos)
console.log(datosLaborables)
console.log(datosPersonales)*/
console.log(JSON.stringify(empleado))
console.log(`elnombre es: ${empleado.nombre} con apellido: ${empleado.apellido} y con numero de panchiespañol: ${empleado.dni} y nacio por puto milagro el dia:${empleado.fechadeNacimiento} y ${empleado.fechadeAlta} y no al despedido por que no quieren y cobran algo${empleado.fechadeBaja} con ${empleado.datosPersonales.estadocivil}` )