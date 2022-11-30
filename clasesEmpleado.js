class Cargo {
  constructor (descrpcion){
    this.descripcion = descrpcion;
  }
}

class Empresa {
  constructor (nombre, cif){
    this.nombre = nombre;
    this.cif = cif;
  }
}

class EstadoCivil {
constructor (descripcion) {
  this.descripcion = descripcion;
}
}

class Hijos {
  constructor (chicos, chicas){
    this.chicos = chicos;
    this.chicas = chicas;
  }
}

class DatosPersonales {
  constructor (estadoCivil, Hijos){
    this.estadoCivil = estadoCivil;
    this.Hijos = Hijos;
  }
}

class DatosLaborales {
  constructor (sueldo, Cargo){
    this.sueldo = sueldo;
    this.Cargo = Cargo;
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
      this.datosPersonales = datosPersonales
      this.datosLaborales = datosLaborales
      this.empresa = empresa
  }
}

estadoCivil = new EstadoCivil ("casado")
cargo = new Cargo ("analista programador")
empresa = new Empresa ("Fundación ONCE", "12345678M")
hijo = new Hijos (3, 2)
datosPersonales = new DatosPersonales (hijo, estadoCivil)
datosLaborales = new DatosLaborales ("300", cargo)
empleado = new Empleado ("Marcheline", "Rosero Guerra", "12345678X", new Date("1996/05/05").toLocaleString(), new Date("2000/05/05"), null, datosPersonales, datosLaborales, empresa)


console.log(empleado)


//formato JSON

console.log(JSON.stringify(empleado))


