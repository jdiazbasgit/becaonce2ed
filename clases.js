
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
class Cargo{
    constructor(descripcion){
        this.descripcion=descripcion
    }
}
class DatosLaborales {
    constructor(salario, cargo) {
        this.salario = salario;
        this.cargo = cargo;

    }
}

class DatosPersonales {
    constructor(Hijo, EstadoCivil) {
        this.Hijo = Hijo;
        this.EstadoCivil = EstadoCivil
    }

}
class Empleado{
    constructor(nombre,apellidos,dni,fechaNacimiento,fechaAlta,fechaBaja,datosPersonales,datosLaborales,empresa){
        this.empresa=empresa
        this.nombre=nombre
        this.apellidos=apellidos
        this.dni=dni
        this.fechaNacimiento=fechaNacimiento
        this.fechaAlta=fechaAlta
        this,fechaBaja=fechaBaja
        this.datosPersonales=datosPersonales
        this.datosLaborales=datosLaborales
    }
}

pepe=new Empleado("Denis", "Ilban","Y0314053W", new Date("2001/02/20"),new Date("2019/05/28"),null,new DatosPersonales(new Hijo(3,2),new EstadoCivil("Divorciado")),new DatosLaborales(3000, new Cargo("Analista-programador")),new Empresa("B7583758","ONCE"))
console.log(pepe)

console.log(`El nuevo trabajador se llama ${pepe.nombre}. Tiene ${pepe.datosPersonales.Hijo.chicos+pepe.datosPersonales.Hijo.chicas} hijos y sus apellidos son ${pepe.apellidos}`)