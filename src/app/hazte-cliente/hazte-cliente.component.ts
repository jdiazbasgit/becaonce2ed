import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UrlHandlingStrategy } from '@angular/router';
import { ProfileService } from '../servicios/profile.service';
import ProfileBeans from '../beans/ProfileBeans';
import { IdentificationTypeService } from '../servicios/identification-type.service';
import IdentificationTypeBean from '../beans/IdentificationTypeBean';
import { RolService } from '../servicios/rol.service';
import UserBeans from '../beans/UserBeans';
import { UserService } from '../servicios/user.service';
import ProfileUserDtoStringBean from '../beans/ProfileUserDtoStringBean';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';



@Component({
  selector: 'app-hazte-cliente',
  templateUrl: './hazte-cliente.component.html',
  styleUrls: ['./hazte-cliente.component.css']
 
  
})


export class HazteClienteComponent implements OnInit { 
  standalone: true = true; 
  hide = true;
  name: string;
  secondName: string;
  identification: string;
  phone: string;
  image: Array<number>
  email: string;
  identificationType: number;
  user: string;
  password: string
  identificationTypes: Array<any>
  urlIdentificationTypes = "http://localhost:8080/once/identificationsTypes"
  urlProfile = "http://localhost:8080/once/profiles/save"
  urlRol = "http://localhost:8080/once/roles"
  urlUsers = "http://localhost:8080/once/users"
  urlComprobar="http://localhost:8080/once/profiles/comprobar"
  emailBaseDeDatos: string
  telefonoBaseDatos: string
  usuarioBaseDatos: string
  clave: string
  mensajeEmail: string;
  mensajePhone: string;
  mensajeUser: string;
  mensaje: string
  passwordVisible: boolean = false;



  constructor(private profilServices: ProfileService, private identificationTypeServices: IdentificationTypeService,
    private rolservice: RolService, private userService: UserService) {
    this.name = "";
    this.secondName = "";
    this.identification = "";
    this.phone = "";
    this.email = "";
    this.emailBaseDeDatos = ""
    this.telefonoBaseDatos = ""
    this.usuarioBaseDatos = ""
    this.clave = ""
    this.user = ""
    this.identificationType = 0
    this.image = []
    this.password = ""
    this.identificationTypes = []
    this.mensajeEmail = ""
    this.mensajePhone = ""
    this.mensajeUser = ""
    this.mensaje = ""
    
  }

  ngOnInit() {
    this.identificationTypeServices.getDatos(this.urlIdentificationTypes).subscribe((datos: any) => {
      this.identificationTypes = datos._embedded.identificationTypes
      console.log("identificadores : " + this.identificationTypes)


    })
 
  }


  comprobarDatos() {
    this.usuarioBaseDatos = '';
    this.clave = '';
    this.emailBaseDeDatos = '';
    this.telefonoBaseDatos = '';


    this.rolservice.patch(this.urlComprobar,new ProfileUserDtoStringBean(this.email,this.phone,this.user)).subscribe((datos: any) => {
      if(datos.email)
      this.mensajeEmail = "Email ya Existe"
      if(datos.phone)
      this.mensajePhone = "El Telefono ya Existe"
      if(datos.user)
      this.mensajeUser = "El Usuario ya Existe"
    })
  
  }
  togglePasswordVisibility() {
  
  
    this.passwordVisible = !this.passwordVisible;
  }
  cargarImagen(event: any) {
    const file: File = event.target.files[0];
  
    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        const imageBytes = new Uint8Array(e.target.result);
        this.image = Array.from(imageBytes);
      };
      reader.readAsArrayBuffer(file);
    }
  }



 

  guardaDatos() {


    this.profilServices.patch(this.urlProfile,
      new ProfileBeans(this.name, this.secondName, this.identification, this.phone, this.email, this.identificationType, this.user, this.image, this.password))
      .subscribe((dato: boolean) => {
        if (dato) {
          this.mensaje = "Grabacion realizada correctamente";
        } else {
          this.mensaje = "La grabación no se ha realizado";
        }
      });
  }

}
