import { Component, ElementRef } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import { LoginService } from '../servicios/login.service';
import { FeeService } from '../servicios/fee.service';
import { Router } from '@angular/router';
import { catchError } from 'rxjs';
import { Time } from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  logado: boolean = false
  inputUsuario: string = ""
  inputPassword: string = ""
  usuario: string = ""
  claveErronea: boolean = false
  mensajeClave: String = ""
  contadorTemporizadorDeInactividad: number = 30000
  temporizadorDeInactividad: any
  sinActividad: boolean = false

  constructor(private http: ProyectosService, private elementRef: ElementRef, private loginService: LoginService, private feeService: FeeService, private router: Router) {
  
  }

  // ngOnInit(){
  //   this.temporizadorDeInactividad = 8000
  //   this.iniciarTemporizador();
  // }

  ngDoCheck() {
    if (sessionStorage['token'] != null && this.logado == false) {
      this.logado = true
      this.usuario = sessionStorage['user']
    }
    if (!this.logado && this.router.url != "/landing") {
      this.router.navigateByUrl("landing")
    }
    if (!this.sinActividad && this.logado){
      //this.contadorTemporizadorDeInactividad = 8000
      clearTimeout(this.temporizadorDeInactividad)
      this.temporizadorDeInactividad = setTimeout(() => {
        console.log("deslogado por inactividad!!")
        this.sinActividad = true
        this.deslogarse()
      }, this.contadorTemporizadorDeInactividad)
    }    
  }

  logarse() {
    let body = document.body;
    //body.classList.add("bloqueado");
    //body.style.overflow = "hidden";
    body.setAttribute("style", "overflow: hidden")
    let modalConectando = this.elementRef.nativeElement.querySelector('#modalConectando')
    modalConectando.classList.remove('oculto')

    setTimeout(() => {
      this.loginService.identificar("http://localhost:8080/login", this.inputUsuario, this.inputPassword)
        .pipe(
          catchError(error => {
            console.log(error)
            if (error.status == 0) {
              //console.log("cucu")
              this.mensajeClaveErronea("No ha sido posible establecer la conexión. Intentelo más tarde")
            }
            modalConectando.classList.add('oculto')
            //body.classList.remove("bloqueado");
            body.removeAttribute("style")
            return ""
          })
        )
        .subscribe((datos: any) => {
          console.log(datos)
          if (datos.token == null) {
            this.limpiarFormulario()
            // let cont = this.elementRef.nativeElement.querySelector('.contenido')
            // cont.innerHTML = "El Usuario o la Clave son incorrectos"
            // cont.classList.add('bg-danger')
            this.elementRef.nativeElement.querySelector('#inputP').blur()
            this.elementRef.nativeElement.querySelector('#inputU').blur()
            this.mensajeClaveErronea("El Usuario o la Clave introducidos no son correctos")
          }
          if (datos.token != null) {
            console.log("acceso correcto")
            let userM = this.inputUsuario
            let passM = this.inputPassword
            //this.usuario = this.inputUsuario
            //this.logado = true
            sessionStorage['user'] = datos.user
            console.log(userM + passM)
            sessionStorage['token'] = datos.token;
            this.sinActividad = false
            let cont = this.elementRef.nativeElement.querySelector('.contenido')
            cont.innerHTML = "Bienvenido"
            cont.classList.add('bg-success')
            console.log(datos.token)
          }
          modalConectando.classList.add('oculto')
          //body.classList.remove("bloqueado");
          body.removeAttribute("style")

        }
        )
      // catchError(err => {
      //   console.log('caught mapping error and rethrowing', err)
      //   this.mensajeClaveErronea("No ha sido posible establecer la conexión")
      //   modalConectando.classList.add('oculto')
      //   //body.classList.remove("bloqueado");
      //   body.removeAttribute("style")
      //   return throwError(err);
      // }) 

    }, 1000)


  }
  deslogarse() {
    //sessionStorage['token'] = null;
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
      this.claveErronea = false
    }
  }
  mensajeClaveErronea(mensaje: String) {
    this.claveErronea = true
    this.mensajeClave = mensaje
  }

  getFees() {
    console.log("Sacando Fees con token: " + sessionStorage['token'])
    this.feeService.getDatos("http://localhost:8080/once/fees")
    .subscribe({
      next: (response) => {
        console.log("status ok:"+response.status)
      }, 
      error: (error:any) =>{
        console.log("status ko:"+error.status)
      }
    })
      // .subscribe((datos: any) => {
      //   console.log(datos)
      //   datos._embedded.fees.forEach((element: any) => {
      //     console.log(element.current)
      //   });
      // })
  }

  meterTokenfalso() {
    sessionStorage['token'] = "EsteEsUnTokenFalso"
    console.log("token: " + sessionStorage['token'])
  }
}
