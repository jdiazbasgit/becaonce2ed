// creamos class para json

class Empleado {
    constructor(nombre, apellidos, dni, fechaNacimiento, sexo, fechaAlta, fechaBaja) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }
}
class Domicilio {
    constructor(calle, numero, piso, portal, distrito, codigoPostal){ 
      this.calle = calle
      this.numero = numero
      this.piso = piso
      this.portal = portal
     his.distrito = distrito
     his.codigoPostal = codigoPostal
}
}
class Empresa {
    constructor(cif, nombreEmpresa) {
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
    }
}

class DatoLaborales {
    constructor(salario) {
        this.salario = salario;

    }
}

class cargo {
    constructor(cargos) {
        this.cargos = cargos;

    }
}

class DatosPersonales {
    constructor(hijo) {
        this.hijo = hijo;
    }
}

class Hijo {
    constructor(hijos, hijas) {
        this.chicos = chicos;
        this.chicasa = chicas;
    }
}

class EstadoCivil {
    constructor(descripcion) {
        this.estadoCivil = this.estadoCivil;

    }
}
// creo los New datos de las clases como segundo paso
//nombre, dni, fechaNacimiento, fechaAlta, fechaBaja.....
// Empleado "name":"eduardo"
empleado = new empleado("nombre", "apellidos","dni", "fechaNacimiento", "sexo", "fecnaAlta", "fechadeBaja")

//domicilio calle, numero, piso, portal, distrito, codigoPostal
domicilio = domicilio("nombre: calle, numero, piso, portal, distrito, codigoPostal")

//Empresa
cif = new cif("B45147632")
descrpicion = new descripcion("Arelance")

//Datos Laborales
salario = new salario()
cargos = new cargos("Alumno")

//Datos Personales
chicos = new chicos("0")
chicas = new chicas("2")

// Estado Civil
estadoCivil = new  estadoCivil("Soltero", "Casado", "Viudo", "Divorciado")




