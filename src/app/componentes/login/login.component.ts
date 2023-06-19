import { Component, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import { catchError } from 'rxjs';
import { DocumentTypeService } from 'src/app/servicios/document-type.service';
import { LoginService } from 'src/app/servicios/login.service';
import { ProyectosService } from 'src/app/servicios/proyectos.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})



export class LoginComponent {

  logado: boolean = false;
  inputUsuario: string = "";
  inputPassword: string = "";
  usuario: string = "";
  cladveIncorrecta: boolean = false;//claveErronea
  mensajeClave: String = "";
  contadorTemporizadorDeInactividad: number = 30000;
  sessionTimeoutTimer: any;//temporizadorDeInactividad
  sinActividad: boolean = false;

  constructor(private elementRef: ElementRef, private loginService: LoginService, private documentType: DocumentTypeService, private router: Router) {

  }

  ngDoCheck() {
    if (sessionStorage.getItem('token') && !this.logado) {
      this.logado = true;
      this.usuario = sessionStorage.getItem('user') ?? '';
    }
    if (!this.logado && this.router.url !== "/landing") {
      this.router.navigateByUrl("landing");
    }
    if (!this.sinActividad && this.logado) {
      clearTimeout(this.sessionTimeoutTimer);
      this.sessionTimeoutTimer = setTimeout(() => {
        console.log("Cerrado por inactividad!!");
        this.sinActividad = true;
        this.cerrarSesion();
      }, this.contadorTemporizadorDeInactividad);
    }
  }
  logarse() {
    let body = document.body;
    body.setAttribute("style", "overflow: hidden");
    let modalConectando = this.elementRef.nativeElement.querySelector('#modalConectando');
    modalConectando.classList.remove('oculto');
    setTimeout(() => {
      this.loginService.identificar("http://localhost:8080/login", this.inputUsuario, this.inputPassword)
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
            let userM = this.inputUsuario;
            let passM = this.inputPassword;
            sessionStorage.setItem('user', datos.user);
            console.log(userM + passM);
            sessionStorage.setItem('token', datos.token);
            this.sinActividad = false;
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

  cerrarSesion() {
    sessionStorage.clear()
    this.logado = false
  }
  
  limpiarFormulario() {
    this.inputUsuario = ""
    this.inputPassword = ""
  }

  colorearBotonLoginAlPulsar() {
    this.limpiarFormulario()
    let btnLogin = this.elementRef.nativeElement.querySelector('.btnLogin');
    if (btnLogin.classList.contains('collapsed')) {
      btnLogin.classList.remove('pulsado');
    }
    else {
      btnLogin.classList.add('pulsado');
      this.cladveIncorrecta = false
    }
  }

  mensajeClaveErronea(mensaje: String) {
    this.cladveIncorrecta = true
    this.mensajeClave = mensaje
  }

  getFees() {
    const token = sessionStorage.getItem('token');
    console.log("Sacando Fees con token: " + token);
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
    console.log("token: " + sessionStorage.getItem('token'))
  }

}
