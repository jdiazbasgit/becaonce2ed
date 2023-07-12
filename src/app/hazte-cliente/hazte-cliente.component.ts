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
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { ActivatedRoute } from '@angular/router';




@Component({
  selector: 'app-hazte-cliente',
  templateUrl: './hazte-cliente.component.html',
  styleUrls: ['./hazte-cliente.component.css']


})


export class HazteClienteComponent implements OnInit {
  previsualizacion: Array<number>
  standalone: true = true;
  hide = true;
  name: string;
  secondName: string;
  identification: string;
  phone: string;
  image: Array<number>
  imageString: string
  email: string;
  identificationType: number;
  user: string;
  password: string
  identificationTypes: Array<any>
  urlIdentificationTypes = "http://localhost:8080/once/identificationsTypes"
  urlProfile = "http://localhost:8080/once/profiles/save"
  urlRol = "http://localhost:8080/once/roles"
  urlUsers = "http://localhost:8080/once/users"
  urlComprobar = "http://localhost:8080/once/profiles/comprobar"
  emailBaseDeDatos: string
  telefonoBaseDatos: string
  usuarioBaseDatos: string
  clave: string
  mensajeEmail: string;
  mensajePhone: string;
  mensajeUser: string;
  mensajeIdentification: string
  mensajeCampos: string
  mensajeImage: string
  mensajeImage2:string
  mensaje: string
  passwordVisible: boolean = false;
  activo: boolean = true
  previsualizacionURL: string = "";




  constructor(private profilServices: ProfileService, private identificationTypeServices: IdentificationTypeService,
    private rolservice: RolService) {
    this.previsualizacion = []
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
    this.imageString = ""
    this.password = ""
    this.identificationTypes = []
    this.mensajeEmail = ""
    this.mensajePhone = ""
    this.mensajeUser = ""
    this.mensajeIdentification = ""
    this.mensajeCampos = ""
    this.mensajeImage = ""
    this.mensajeImage2=""
    this.mensaje = ""

  }

  


  ngOnInit() {

    this.identificationTypeServices.getDatos(this.urlIdentificationTypes).subscribe((datos: any) => {
      this.identificationTypes = datos._embedded.identificationTypes
      console.log("identificadores : " + this.identificationTypes)
    })
    
  }


  cargarImagen(event: any) {
   
    const file: File = event.target.files[0];

    if (file) {
      if (file.size > 95535 ) {
       this.mensajeImage2='El tamaño de la imagen excede los bytes .';
        return;
      }
  
      const reader = new FileReader();
      reader.onload = (e: any) => {
        const imageBytes = new Uint8Array(e.target.result);
        this.image = Array.from(imageBytes);
        this.previsualizacion= this.image;

        const blob = new Blob([imageBytes], { type: file.type });
      this.previsualizacionURL = URL.createObjectURL(blob);
    };
      reader.readAsArrayBuffer(file);
    }
  }

  comprobarDatos(): any {
    this.mensajeEmail = '';
    this.mensajePhone = '';
    this.mensajeUser = '';
    this.mensajeIdentification = '';
    this.mensajeCampos = ""
    this.mensajeImage = ""
    this.mensajeImage2=""
    this.previsualizacion=[]
    this.image=[]
    this.activo = false;

    if (this.imageString === "" || this.identificationType === 0 || this.email === "" || this.phone === "" || this.user === "" || this.identification === "" || this.name === "" || this.secondName === "" || this.password === "") {

      this.activo = true

      this.mensajeCampos = "rellene todos los campos"

      return
    }
    let extension: string = this.imageString.substring(this.imageString.lastIndexOf('.') + 1)
    if (extension !== 'jpg' && extension !== 'jpeg' && extension !== 'gif' && extension !== 'png') {
      this.mensajeImage = "el formato de la imagen no es valido"
      this.activo = true
      return
    }

    this.rolservice.patch(this.urlComprobar, new ProfileUserDtoStringBean(this.email, this.phone, this.user, this.identification)).subscribe((datos: any) => {
      if (datos.email) {
        this.mensajeEmail = "Email ya Existe"
        this.activo = true
      }

      if (datos.phone) {
        this.mensajePhone = "El Telefono ya Existe"
        this.activo = true
      }
      if (datos.user) {
        this.mensajeUser = "El Usuario ya Existe"
        this.activo = true
      }
      if (datos.identification) {
        this.activo = true
        this.mensajeIdentification = "La Identificacion ya Existe"
      }
    })

  }
  togglePasswordVisibility() {


    this.passwordVisible = !this.passwordVisible;
  }

  guardaDatos() {


    this.profilServices.patch(this.urlProfile,
      new ProfileBeans(this.name, this.secondName, this.identification, this.phone, this.email, this.identificationType, this.user, this.image, this.password))
      .subscribe((dato: boolean) => {
        if (dato) {
          this.mensaje = "Grabacion realizada correctamente";
          this.name=""
          this.secondName=""
          this.identification=""
          this.phone=""
          this.email=""
          this.identificationType=0
          this.user=""
          this.image=[0]
          this.previsualizacion=[0]
          this.password=""
        } else {
          this.mensaje = "La grabación no se ha realizado";
      
        }
      });
  }

}
