
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
    constructor(hijo, estadoCivil) {
        this.hijo = hijo;
        this.estadoCivil = estadoCivil
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

pepe=new Empleado("Denis", "Ilban","Y0314053W", new Date("2001/02/20").toLocaleDateString(),new Date("2019/05/28").toLocaleDateString(),null,new DatosPersonales(new Hijo(3,2),new EstadoCivil("Divorciado")),new DatosLaborales(3000, new Cargo("Analista-programador")),new Empresa("B7583758","ONCE"))
console.log(pepe)

console.log(`El nuevo trabajador se llama ${pepe.nombre} ${pepe.apellidos}.Su DNI es ${pepe.dni} Tiene ${pepe.datosPersonales.hijo.chicos} hijos y ${pepe.datosPersonales.hijo.chicas} hijas. Su estado civil es ${pepe.datosPersonales.estadoCivil.descripcion} Ha nacido el ${pepe.fechaNacimiento} y le hemos contratado el ${pepe.fechaAlta} en la categoría de ${pepe.datosLaborales.cargo.descripcion} con un salario de ${pepe.datosLaborales.salario} en la empresa ${pepe.empresa.nombre} con CIF ${pepe.empresa.cif}`)


tablaDatos=()=>{
var div=document.querySelector("div")
div.innerHTML=""
let table= document.createElement("table")
table.setAttribute("class", "table table-stripped text-center")
let tr1=document.createElement("tr")
let th1=document.createElement("th")
let th2=document.createElement("th")
let th3=document.createElement("th")
let th4=document.createElement("th")
let th5=document.createElement("th")
let th6=document.createElement("th")
let th7=document.createElement("th")
let th8=document.createElement("th")
let th9=document.createElement("th")
let th10=document.createElement("th")
let tr2=document.createElement("tr")
let td1=document.createElement("td")
let td2=document.createElement("td")
let td3=document.createElement("td")
let td4=document.createElement("td")
let td5=document.createElement("td")
let td6=document.createElement("td")
let td7=document.createElement("td")
let td8=document.createElement("td")
let td9=document.createElement("td")
let td10=document.createElement("td")
th1.innerHTML="Nombre"
th2.innerHTML="Apellidos"
th3.innerHTML="DNI/NIE"
th4.innerHTML="Fecha Nacimiento"
th5.innerHTML="Fecha Alta"
th6.innerHTML="Puesto"
th7.innerHTML="Salario"
th8.innerHTML="Empresa"
th9.innerHTML="Hijos"
th10.innerHTML="Estado civil"
td1.innerHTML=pepe.nombre
td2.innerHTML=pepe.apellidos
td3.innerHTML=pepe.dni
td4.innerHTML=pepe.fechaNacimiento
td5.innerHTML=pepe.fechaAlta
td6.innerHTML=pepe.datosLaborales.cargo.descripcion
td7.innerHTML=pepe.datosLaborales.salario
td8.innerHTML=pepe.empresa.nombre
td9.innerHTML=pepe.datosPersonales.hijo.chicos+pepe.datosPersonales.hijo.chicas
td10.innerHTML=pepe.datosPersonales.estadoCivil.descripcion
div.appendChild(table)
table.appendChild(tr1)
table.appendChild(tr2)
tr1.appendChild(th1)
tr1.appendChild(th2)
tr1.appendChild(th3)
tr1.appendChild(th4)
tr1.appendChild(th5)
tr1.appendChild(th6)
tr1.appendChild(th7)
tr1.appendChild(th8)
tr1.appendChild(th9)
tr1.appendChild(th10)
tr2.appendChild(td1)
tr2.appendChild(td2)
tr2.appendChild(td3)
tr2.appendChild(td4)
tr2.appendChild(td5)
tr2.appendChild(td6)
tr2.appendChild(td7)
tr2.appendChild(td8)
tr2.appendChild(td9)
tr2.appendChild(td10)
}
console.log(JSON.stringify(pepeºººººººººººº))



