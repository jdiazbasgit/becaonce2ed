import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { UrlHandlingStrategy } from '@angular/router';
import { ProfileService } from '../servicios/profile.service';

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
  emailBaseDeDatos:Array<any>
  services: any;
 


  constructor(private profilServices:ProfileService) {
    this.nombre = "";
    this.apellidos = "";
    this.documentodeidentidad = "";
    this.telefono = "";
    this.email = "";
    this.emailBaseDeDatos=[]
    

  }
  sacarEmail(){
    this.emailBaseDeDatos=[]
    this.services.getDatos("http://localhost:8080/once/profiles")
    .subscribe((datos:any)=>{
      console.log(datos)
      for (let index = 0; index < datos.length; index++) {
        console.log(datos[index]._embedded.profiles.email)
        
      }
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

