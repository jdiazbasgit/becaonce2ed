class Empleado{
    constructor()
}

class datosPersonales{
    constructor(hijo, estadoCivil){
        this.hijo=hijo;
        this.esstadoCivil=estadoCivil;
    }
}

class EstadoCivil{
    constructor(descripcion){
        this.descripcion=descripcion;
    }
}
class Cargo{
    constructor(descripcion){
        this.descripcion=descripcion;

    }
}
class Empresa{
    constructor(cif,descripcion){
        this.cif=cif;
        this.descripcion=descripcion;
    }
}
class DatosPersonales{
    constructor(estadoCivil, hijo){
        this.estadoCivil=estadoCivil;
        this.hijo=hijo;
    }
}
class DatosLaboral{
    constructor(salario,cargo){
        this.cargo=cargo;
        this.salario=salario;
    }
}
