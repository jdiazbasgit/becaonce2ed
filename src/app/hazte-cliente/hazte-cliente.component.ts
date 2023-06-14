import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { UrlHandlingStrategy } from '@angular/router';
import { ProfileService } from '../servicios/profile.service';
import { ProyectosService } from '../servicios/proyectos.service';

@Component({
  selector: 'app-hazte-cliente',
  templateUrl: './hazte-cliente.component.html',
  styleUrls: ['./hazte-cliente.component.css']
})


export class HazteClienteComponent {
  nombre: string;
  apellidos: string;
  documentodeidentidad: string;
  telefono: string;
  email: string;
  emailBaseDeDatos:string
  telefonoBaseDatos:string
 


  constructor(private profilServices:ProfileService, private services:ProyectosService) {
    this.nombre = "";
    this.apellidos = "";
    this.documentodeidentidad = "";
    this.telefono = "";
    this.email = "";
    this.emailBaseDeDatos=""
    this.telefonoBaseDatos=""
    

  }

  ngOnInit(){
    this.sacarEmail()
  }
  sacarEmail(){
    this.emailBaseDeDatos=""
    this.telefonoBaseDatos=""
    this.services.getDatos("http://localhost:8080/once/profiles")
    .subscribe((datos:any)=>{
      console.log(datos)
      console.log(datos._embedded.profiles.length)
      for (let index = 0; index < datos._embedded.profiles.length; index++) {
        //console.log(datos._embedded.profiles[index].email)
        console.log(index)
        this.emailBaseDeDatos=datos._embedded.profiles[index].email
        this.telefonoBaseDatos=datos._embedded.profiles[index].phone
        console.log(this.telefonoBaseDatos)
      console.log(this.emailBaseDeDatos + " estoy aqui")
      if (this.emailBaseDeDatos==this.email ) {
        console.log("ya existe") 
      }
      if (this.telefonoBaseDatos==this.telefono) {
        console.log("el numero ya existe")
        
      }
     
      }
      this.guardaDatos()
      
    })

    
  }



  guardaDatos (){
    

    this.profilServices.saveOrUpdate("http://localhost:8080/once/profiles","")
    const clienteGuardado={
    name:this.nombre,
    second_name:this.apellidos,
  identification:this.documentodeidentidad,
  phone:this.telefono,
  email:this.email,


  };
}

}

