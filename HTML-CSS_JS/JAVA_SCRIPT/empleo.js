class hijos{
    constructor(chicos,chicas){
        this.chicos=chicos;
        this.chicas=chicas;
    }
    
}

class EstadoCivil{
    constructor(descripcion){
        this.descripcion=descripcion;
    }
}

class DatoPersonal{
    constructor(hijo,estadocivil){
        this.hijo=hijo;
        this.estadocivil=estadocivil;
    }
}

class Cargo{
    constructor(area){
        this.area=area;
    }
}

class Empresa{
    constructor(cif,nombre){
        this.cif=cif;
        this.nombre=nombre;
    }
    
}

class DatoLaboral{
    constructor(cargo,salario){
        this.cargo=cargo;
        this.salario=salario;
    }
    
}
class Empleado{
    constructor(nombre,apellidos,DNI,fechaAlta,fechaBaja,fechaNacimiento,DatoLaboral,DatoPersonal,Empresa){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.DNI=DNI;
        this.fechaAlta=fechaAlta;
        this.fechaBaja=fechaBaja;
        this.fechaNacimiento=fechaNacimiento;
        this.DatoLaboral=DatoLaboral;
        this.DatoPersonal=DatoPersonal;
        this.Empresa=Empresa
    }
    
}

var fechaAlta= new Date()
var fechaBaja= new Date(null)
var fechaNacimiento= new Date("yyyy/mm/dd")

var tb = new Empleado("Adan ","Sanchez ", "77777777d" , "666", "0", "7777", lb, );
alert(tb.fechaAlta);

var lb = new DatoLaboral("programador","1500");
//document.write(`Mi trabajo es ${lb.cargo} y cobro  ${lb.salario}`)
Laboral = document.querySelector('#Laboral').innerHTML= "Mi trabajo es " + lb.cargo + " y cobro " + lb.salario;



/*lb.salario=2000;*/

