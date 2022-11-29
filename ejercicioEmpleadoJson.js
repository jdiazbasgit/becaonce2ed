class Empresa {
    constructor(cif, nombreEmpresa) {
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
    }
}

class DatoLaborales {
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

class Hijo {
    constructor(Hijos, Hijas) {
        this.Hijos = Hijos;
        this.Hijas = Hijas;
    }
}
class Empleado {
    constructor(nombre, apellidos, dni, fechaNacimiento, sexo, fechaAlta, fechaBaja) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }
}
Eduardo = new Empleado("Eduardo Antonio", "Rodriguez Macassi ", "M2345679l", new Date("08/12/1960"),  new Date("31/06/2006"), null, new DatosPersonales(new Hijo(3, 2), new EstadoCivil("divorciado")), new DatoLaborales(new salario(3000, new Cargo("Analista deProgramacion")), new Empreesa("B3245678", "ONCE")));
console.log(`El empleado ${this.nombre} con documento${this.Eduardo.dni} nacido el${this.Eduardo.fechaNacimiento} con fecha de alta ${this.Eduardo.fechaAlta} fecha de baja ${this.Eduardo.fechaBaja} con hijos ${Eduardo.DatosPersonales} que trabaja en ${Eduardo.DatosPersonales}  de nombre  de empresa ${Eduardo.cif.nombreEmpresa}`)
console.log(Eduardo)




