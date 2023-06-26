import { Component, ElementRef, isStandalone } from '@angular/core';
import { FormControl, FormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router } from '@angular/router';
import { catchError } from 'rxjs';
import { DocumentTypeService } from 'src/app/servicios/document-type.service';
import { LoginService } from 'src/app/servicios/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  
})

export class LoginComponent {

  passwordFormControl = new FormControl('',[Validators.required, Validators.required])//verificar
  logado: boolean = false;
  inputUser: string = "";
  inputPassword: string = "";
  user: string = "";
  incorrectKey: boolean = false;//claveErronea
  keyMessage: String = "";//mensajeClave
  counterAfkTimer: number = 30000;//contadortemporizador de inactividad
  afkTimer: any;//temporizadorDeInactividad notActive incorrectKey keyMessage
  notActive: boolean = false;//sin actividad

  constructor(private elementRef: ElementRef, private loginService: LoginService, private documentType: DocumentTypeService, private router: Router) {

  }


  ngDoCheck() {
    if (sessionStorage.getItem('token') && !this.logado) {
      this.logado = true;
      this.user = sessionStorage.getItem('user') ?? '';
    }
    if (!this.logado && this.router.url !== "/home") {
      this.router.navigateByUrl("home");
    }
    if (!this.notActive && this.logado) {
      clearTimeout(this.afkTimer);
      this.afkTimer = setTimeout(() => {
        console.log("Cerrado por inactividad!!");
        this.notActive = true;
        this.closeSession();
      }, this.counterAfkTimer);
    }
  }
  logarse() {
    let body = document.body;
    body.setAttribute("style", "overflow: hidden");
    let modalConectando = this.elementRef.nativeElement.querySelector('#modalConectando');
    modalConectando.classList.remove('oculto');
    setTimeout(() => {
      this.loginService.identificar("http://localhost:8080/login", this.inputUser, this.inputPassword)
        .pipe(
          catchError(error => {
            console.log(error);
            if (error.status === 0 || error.status === 404) {
              this.mensajeClaveErronea("No ha sido posible establecer la conexión. Intentelo más tarde");
            }
            modalConectando.classList.add('oculto');
            body.removeAttribute("style");
            return "";
          })
        )
        .subscribe((datos: any) => {
          console.log(datos)
          if (datos.token == null) {
            this.limpiarFormulario();
            this.elementRef.nativeElement.querySelector('#inputP').blur();
            this.elementRef.nativeElement.querySelector('#inputU').blur();
            this.mensajeClaveErronea("El Usuario o la Clave introducidos no son correctos");
          }
          if (datos.token != null) {
            console.log("acceso correcto");
            let userM = this.inputUser;
            let passM = this.inputPassword;
            sessionStorage.setItem('user', datos.user);
            console.log(userM + passM);
            sessionStorage.setItem('token', datos.token);
            this.notActive = false;
            let cont = this.elementRef.nativeElement.querySelector('.contenido');
            cont.innerHTML = "Bienvenido";
            cont.classList.add('bg-success');
            console.log(datos.token);
          }
          modalConectando.classList.add('oculto');
          body.removeAttribute("style");

        }
        )

    }, 1000)
  }

  closeSession() {
    sessionStorage.clear();
    this.logado = false;
  }

  limpiarFormulario() {
    this.inputUser = "";
    this.inputPassword = "";
  }

  onPress() {//colorearBotonLoginAlPulsar
    this.limpiarFormulario();
    let btnLogin = this.elementRef.nativeElement.querySelector('.btnLogin');
    if (btnLogin.classList.contains('collapsed')) {
      btnLogin.classList.remove('pulsado');
    }
    else {
      btnLogin.classList.add('pulsado');
      this.incorrectKey = false;
    }
  }

  mensajeClaveErronea(mensaje: String) {
    this.incorrectKey = true;
    this.keyMessage = mensaje;
  }

  getDocumentsTypes() {
    const token = sessionStorage.getItem('token');
    console.log("Sacando documents types con token: " + token);
    this.documentType.getDatos("http://localhost:8080/once/documentsTypes")
      .subscribe({
        next: (response: any) => {
          console.log("status ok:" + response.status);
          console.log(response);
          response._embedded.fees.forEach((element: any) => {
            console.log(element.current);
          });
        },
        error: (error: any) => {
          console.log("status ko:" + error.status);
        }
      });
  }

  errorDeToken() {
    sessionStorage.setItem('token', 'error de token');
    console.log("token: " + sessionStorage.getItem('token'));
  }

}
