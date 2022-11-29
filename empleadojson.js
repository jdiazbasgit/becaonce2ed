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
    constructor(nombre, apellidos, dni, fechadenacimiento, fechadealta, fechadebaja, datosPersonales, datosLaborales, empresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechadenacimiento = fechadenacimiento;
        this.fechadealta = fechadealta;
        this.fechadebaja = fechadebaja;
        this.datosPersonales = datosPersonales;
        this.datosLaborales = datosLaborales;
        this.empresa = empresa;
    }
}

//estadoCivil = new EstadoCivil("descripcion");
//hijo = new Hijo("chicos", "chicas");
//empresa = new Empresa("cif", "nombre");
//datosLaborales = new DatosLaborales(salario,"cargo");
//cargo = new Cargo("descripcion");
//datosPersonales = new DatosPersonales("estadocivil", "Hijo");

juan = new Empleado("Juan", "Rodriguez", "52128521P", new Date("1970/02/15"), new Date("2008/02/08"), null, new DatosPersonales(new Hijo(3, 2), new EstadoCivil("casado")), new DatosLaborales(1500, new Cargo("jefe de sección")), new Empresa("B12345678","Telefonica"));
console.log(`El señor ${juan.nombre} ${juan.apellidos} con documento ${juan.dni} nacido el ${juan.fechadenacimiento} que empezo a trabajar con nosotros el ${juan.fechadealta} y que sigue con nosotros en la ${juan.fechadebaja} con hijos${juan.DatosPersonales} que trabaja de ${juan.datosLaborales} y su nombre es ${juan.empresa.nombre}`)
console.log (juan)

oscar= new Empleado ("Oscar","Perea Alvarez","52125125P", new DatosPersonales(new Hijo(3,2),new EstadoCivil("divorciado")),new DatosLaborales(3000, new Cargo("Analista Programador")),new Empresa("B123456789","Fundación Once"))
console.log (oscar)