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
  emailBaseDeDatos: string
  telefonoBaseDatos: string
  usuarioBaseDatos: string
  clave: string
  usuario: string
  tipoDeDocumento:string



  constructor(private profilServices: ProfileService, private services: ProyectosService) {
    this.nombre = "";
    this.apellidos = "";
    this.documentodeidentidad = "";
    this.telefono = "";
    this.email = "";
    this.emailBaseDeDatos = ""
    this.telefonoBaseDatos = ""
    this.usuarioBaseDatos = ""
    this.clave = ""
    this.usuario=""
    this.tipoDeDocumento=""

  }

  ngOnInit() {
    this.comprobarDatos();
  }

  comprobarDatos() {
    this.usuarioBaseDatos = '';
    this.clave = '';
    this.emailBaseDeDatos = '';
    this.telefonoBaseDatos = '';

    this.services.getDatos("http://localhost:8080/once/profiles")
      .subscribe((datos: any) => {
        console.log(datos);
        console.log(datos._embedded.profiles.length);

        datos._embedded.profiles.forEach((profile: any) => {
          console.log(profile.email);
          console.log(profile);
          this.emailBaseDeDatos = profile.email;
          this.telefonoBaseDatos = profile.phone;
          console.log(this.telefonoBaseDatos);

          if (this.emailBaseDeDatos == this.email) {
            console.log("El email ya existe");
          }
          if (this.telefonoBaseDatos == this.telefono) {
            console.log("El número ya existe");
          }
        });
      });

    this.services.getDatos("http://localhost:8080/once/users")
      .subscribe((datos: any) => {
        console.log(datos);
        console.log(datos._embedded.users);

        datos._embedded.users.forEach((users: any) => {
          this.usuarioBaseDatos = users.user;
          console.log(`${this.usuarioBaseDatos} este es el cliente`);

          if (this.usuarioBaseDatos == this.usuario) {
            
          }
        });
      });
  }

  guardaDatos() {


    this.profilServices.saveOrUpdate("http://localhost:8080/once/profiles",
    new ProfileBeans(this.nombre,this.apellidos,this.documentodeidentidad,this.telefono,this.email,this.tipoDeDocumento,this.usuario))
    const clienteGuardado = {
      name: this.nombre,
      second_name: this.apellidos,
     identification: this.documentodeidentidad,
      phone: this.telefono,
      email: this.email,
      identificationType:this.tipoDeDocumento
      ,user:this.usuario
      



    };
  }

}

