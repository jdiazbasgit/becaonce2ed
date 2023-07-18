import { Component, ElementRef, EventEmitter, Output, isStandalone } from '@angular/core';
import { FormControl, FormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router } from '@angular/router';
import { catchError } from 'rxjs';
import { DocumentTypeService } from 'src/app/servicios/document-type.service';
import { LoginService } from 'src/app/servicios/login.service';
import { ModalLoginComponent } from '../modal-login/modal-login.component';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import LoginBean from 'src/app/beans/LoginBean';

export interface DialogData {
  name: string;
  animal: string;
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',

})

export class LoginComponent {

  
  logado: boolean = false;
  inputUser: string = "";
  inputPassword: string = "";
  user: string = "";
  incorrectKey: boolean = false;//claveErronea
  keyMessage: String = "";//mensajeClave
  isLoading = false;
  sinActividad: boolean = false;
  InactivityTimer: any;
  timeout: number = 6000000;
  isBlurred : boolean = false;
  notActive: boolean = false;
  hide = true;
  registerclicked: string = "";

  constructor(
    private dialog: MatDialog,
    private elementRef: ElementRef,
    private loginService: LoginService,
    private documentType: DocumentTypeService,
    private router: Router
  ) { }

  ngDoCheck() {
    if (sessionStorage.getItem('token') != null && !this.logado == false) {
      this.logado = true;
      this.user = sessionStorage.getItem('user') ?? '';
    }
    if (!this.logado && this.router.url !== "/home") {
      this.router.navigateByUrl("home");
    }
    if (!this.sinActividad && this.logado) {
      clearTimeout(this.InactivityTimer)
      this.InactivityTimer = setTimeout(() => {
        console.log("salida de sesion por inactividad")
        this.sinActividad = true;
        this.closeSession()
      }, this.timeout);
    }
  }

  handleLogin() {
    const user = this.inputUser;
    const pwd = this.inputPassword;
    const loginData = new LoginBean(user, pwd);
    this.isLoading = true;
    setTimeout(() => {
      this.loginService.identificar("http://localhost:8080/login",
        loginData.usuario, loginData.clave)
        .pipe(
          catchError(error => {
            console.log(error);
            if (error.status === 0 || error.status === 404) {
              this.mensajeClaveErronea("No ha sido posible establecer la conexión. Intentelo más tarde");
            }
            return "";
          })
        )
        .subscribe((datos: any) => {
          console.log(datos)
          if (datos.token == null) {
            this.inputUser = "";
            this.inputPassword = "";
            this.isBlurred = true;
            this.mensajeClaveErronea("El Usuario o la Clave introducidos no son correctos");
            return;
          }
          else {
           // if(datos.rol[0].rol === "ROLE_ADMIN"){
              sessionStorage.setItem("rol",datos.roles[0].rol);
            //} else {

           // }
            
            
            console.log("inicio de sesion correcto con rol:"+sessionStorage.getItem("rol"))
            let userM = this.inputUser;
            let passM = this.inputPassword;
            sessionStorage.setItem('user', datos.user);
            console.log(userM + passM);
            sessionStorage.setItem('token', datos.token);
           // sessionStorage.setItem('rol', datos.roles[0].rol)
            this.notActive = false;
            console.log(datos.token);
            this.isLoading = false;
            //this.closeDialog();
          }
        })
    }, 1000);
  }

  mensajeClaveErronea(mensaje: String) {
    this.incorrectKey = true;
    this.keyMessage = mensaje;
  }

  // openDialog() {
  //   this.dialog.open(ModalLoginComponent);
  // }

  closeSession() {
    sessionStorage.removeItem('user');
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('rol');
    this.logado = false;
  }
  handlerRegisterClick(): void{
    this.registerclicked;
  }
}
