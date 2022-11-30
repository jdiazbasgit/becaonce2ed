
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

class Empresa {
    constructor(nombre, cif,) {
        this.nombre = nombre;
        this.cif = cif;

    }
}

class Cargo {
    constructor(descripcion) {
        this.descripcion = descripcion;

    }

}
class Datospersonale {
    constructor(hijos, estadocivil,) {
        this.hijos = hijos;
        this.estadocivil = estadocivil;

    }
}

class DatosLaborables {
    constructor(salario, cargo) {
        this.salario = salario;
        this.cargo = cargo;

    }
}

class Empleado {
    constructor(nombre, apellido, dni, fechadenacimiento, fechaalta, fechabaja, datospersonales, datoslaborales, empresa,) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechadenacimiento = fechadenacimiento;
        this.fechaalta = fechaalta;
        this.fechabaja = fechabaja;
        this.datospersonales = datospersonales;
        this.datoslaborales = datoslaborales;
        this.empresa = empresa;
    
    }
}

estadocivil = new EstadoCivil("casado")
cargo = new Cargo("analista programador")
empresa = new Empresa("12457896B","Fundacion Once")
hijo = new Hijos("3","2")
datospersonales = new Datospersonale(hijo, estadocivil)
datoslaborales = new DatosLaborables(cargo, "3000")
empleado = new Empleado("luis", "villagran", "99999999A", new Date(1992/02/17).toLocaleString(), new Date(2022/11/30).toLocaleString(), "null", datospersonales, datoslaborales, empresa)
console.log