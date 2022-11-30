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
class Cargo {
    constructor(descripcion) {
        this.descripcion = descripcion;

    }
}

class DatosLaborales {
    constructor(salario, cargo) {
        this.salario = salario;
        this.cargo = cargo;

    }
}

class DatosPersonales {
    constructor(hijo, estadoCivil) {
        this.hijo = hijo;
        this.estadoCivil = estadoCivil;
    }

}

class Empleado {
    constructor(nombre, apellidos, dni, fechaDeNacimiento, fechaDeAlta, fechaDeBaja, datosPersonales, datosLaborales, empresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeAlta = fechaDeAlta;
        this.fechaDeBaja = fechaDeBaja;
        this.datosPersonales = datosPersonales;
        this.datosLaborales = datosLaborales;
        this.empresa = empresa;
    }
   
}




juan = new Empleado("Juan", "Rodriguez", "52128521P", new Date("1970/02/15").toLocaleDateString(), new Date("2008/02/08").toLocaleDateString(), null, new DatosPersonales(new Hijo(3, 2), new EstadoCivil("casado")), new DatosLaborales(1500, new Cargo("jefe de sección")), new Empresa("B12345678", "Telefonica"));
console.log(`El señor ${juan.nombre} ${juan.apellidos} con documento ${juan.dni} nacido el ${juan.fechadenacimiento} que empezo a trabajar con nosotros el ${juan.fechadealta} y que sigue con nosotros en la ${juan.fechadebaja} con ${juan.datosPersonales.hijo.chicos} hijos, que trabaja de ${juan.datosLaborales.cargo.descripcion} en la empresa ${juan.empresa.nombre}`)
console.log(juan)

oscar = new Empleado("Oscar", "Perea Alvarez", "52125125P",null,null,null, new DatosPersonales(new Hijo(3, 2), new EstadoCivil("divorciado")), new DatosLaborales(3000, new Cargo("Analista Programador")), new Empresa("B123456789", "Fundación Once"))
console.log(`El señor ${oscar.nombre} ${oscar.apellidos} con documento ${oscar.dni} tiene ${oscar.datosPersonales.hijo.chicos} hijos y ${oscar.datosPersonales.hijo.chicas} hijas y estado civil de ${oscar.datosPersonales.estadoCivil.descripcion} ocupa el cargo de ${oscar.datosLaborales.cargo.descripcion} y tiene un sueldo de ${oscar.datosLaborales.salario} € trabaja en la empresa ${oscar.empresa.nombre} con un CIF ${oscar.empresa.cif}`)
console.log(oscar)