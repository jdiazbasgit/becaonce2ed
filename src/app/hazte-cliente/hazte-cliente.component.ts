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



@Component({
  selector: 'app-hazte-cliente',
  templateUrl: './hazte-cliente.component.html',
  styleUrls: ['./hazte-cliente.component.css']
})


export class HazteClienteComponent  implements OnInit{
  name: string;
  secondName: string;
  identification: string;
  phone: string;
  image:Array<number>
  email: string;
  identificationType: string;
  user: string;
  password:string
  identificationTypes:Array<any>
   urlIdentificationTypes="http://localhost:8080/once/identificationsTypes"
   urlProfile="http://localhost:8080/once/profiles"
   urlRol="http://localhost:8080/once/roles"
  emailBaseDeDatos: string
  telefonoBaseDatos: string
  usuarioBaseDatos: string
  clave: string
  

  constructor(private profilServices: ProfileService,private identificationTypeServices: IdentificationTypeService,
    private rolservice : RolService, private userService:UserService ) {
    this.name = "";
    this.secondName = "";
    this.identification = "";
    this.phone = "";
    this.email = "";
    this.emailBaseDeDatos = ""
    this.telefonoBaseDatos = ""
    this.usuarioBaseDatos = ""
    this.clave = ""
    this.user=""
    this.identificationType=""
    this.image=[]
    this.password=""
    this.identificationTypes=[]

  }

  ngOnInit() {
    this.identificationTypeServices.getDatos(this.urlIdentificationTypes).subscribe((datos:any)=>{
      this.identificationTypes=datos._embedded.identificationTypes
      console.log("identificadores : "+ this.identificationTypes)

    
    })
    this.comprobarDatos();
  }
  

  comprobarDatos() {
    this.usuarioBaseDatos = '';
    this.clave = '';
    this.emailBaseDeDatos = '';
    this.telefonoBaseDatos = '';

    this.rolservice.getDatos(this.urlRol).subscribe((datos: any)=>{
      console.log(datos);
      console.log(datos._embedded.rols);
      

    })

    

    this.profilServices.getDatos( this.urlProfile)
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
          if (this.telefonoBaseDatos == this.phone) {
            console.log("El número ya existe");
          }
        });
      });

    this.profilServices.getDatos(this.urlRol)
      .subscribe((datos: any) => {
        console.log(datos);
        console.log(datos._embedded.users);

        datos._embedded.users.forEach((users: any) => {
          this.usuarioBaseDatos = users.user;
          console.log(this.usuarioBaseDatos +" este es el cliente");
          this.clave = users.password;

          if (this.usuarioBaseDatos === this.user) {
            
          }
        });
      });

      
    
  }

  guardaDatos() {


    this.profilServices.saveOrUpdate(this.urlProfile,
    new ProfileBeans(this.name,this.secondName,this.identification,this.phone,this.email,this.identificationType,this.user,this.image,this.password))
    .subscribe((dato: boolean) => {
      if (dato) {
        console.log( "Grabacion realizada correctamente");
      } else {
        console.log("La grabación no se ha realizado");
      }
    });
  }

}
