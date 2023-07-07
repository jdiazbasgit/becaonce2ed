import { Component, ElementRef } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import { LoginService } from '../servicios/login.service';
import { FeeService } from '../servicios/fee.service';
import { Router } from '@angular/router';
import { catchError } from 'rxjs';

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
  contadorTemporizadorDeInactividad: number = 600000
  temporizadorDeInactividad: any
  sinActividad: boolean = false
  collapseLoginAbierto: boolean = false
  collapseHazteClienteAbierto: boolean = false

  constructor(private elementRef: ElementRef, private loginService: LoginService, private feeService: FeeService, private router: Router) {

  }

  ngOnInit() {
    //remover despues de hacer pruebas***{
    //this.ModoPruebaMeterTokenValidoYampliarInactividad();
    //this.router.navigateByUrl("paneladministrador")
    //this.router.navigateByUrl("cuentas")
    //****}
    //this.deslogarse()
  }

  ngDoCheck() {
    if (sessionStorage['token'] != null && this.logado == false) {
      this.logado = true
      this.usuario = sessionStorage['user']
    }
    if (!this.logado && this.router.url != "/landing") {
      this.router.navigateByUrl("landing")
    }
    if (!this.sinActividad && this.logado) {
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
            if (error.status === 0 || error.status === 404) {
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
          let delay: number = 0
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
            sessionStorage['rol'] = datos.roles[0].rol
            this.sinActividad = false
            let cont = this.elementRef.nativeElement.querySelector('.contenido')
            cont.innerHTML = "Bienvenido"
            cont.classList.add('bg-success')
            console.log(datos.token)
            this.router.navigateByUrl("cuentas")
            delay = 1000
          }
          setTimeout(() => {
            modalConectando.classList.add('oculto')
            //body.classList.remove("bloqueado");
            body.removeAttribute("style")
          }, delay);

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
    sessionStorage.clear()
    this.logado = false
  }
  limpiarFormulario() {
    this.inputUsuario = ""
    this.inputPassword = ""
  }
  mensajeClaveErronea(mensaje: String) {
    this.claveErronea = true
    this.mensajeClave = mensaje
  }

  colorearBotonLoginHazteSwap(){
    let btnLogin = this.elementRef.nativeElement.querySelector('.btnLogin')
    let btnHazteCliente = this.elementRef.nativeElement.querySelector('.btnHazteCliente')
    if (this.collapseHazteClienteAbierto && !this.collapseLoginAbierto){
      btnLogin.setAttribute('data-bs-target', '.zonaColapsable')
      btnHazteCliente.setAttribute('data-bs-target', '#zonaColapsableHazteCliente')
    }
    if (!this.collapseHazteClienteAbierto && this.collapseLoginAbierto){
      btnHazteCliente.setAttribute('data-bs-target', '.zonaColapsable')
      btnLogin.setAttribute('data-bs-target', '#zonaColapsableLogin')
    }
    if (!this.collapseHazteClienteAbierto && !this.collapseLoginAbierto){
      btnHazteCliente.setAttribute('data-bs-target', '#zonaColapsableHazteCliente')
      btnLogin.setAttribute('data-bs-target', '#zonaColapsableLogin')
    }
  }

  colorearBotonLoginAlPulsar() {
    this.limpiarFormulario()
    let btnLogin = this.elementRef.nativeElement.querySelector('.btnLogin')
    let btnHazteCliente = this.elementRef.nativeElement.querySelector('.btnHazteCliente') 
    setTimeout(() => {
      if (btnLogin.classList.contains('collapsed')) {
        btnLogin.classList.remove('pulsado')
        this.collapseLoginAbierto = false
      }
      else {
        btnLogin.classList.add('pulsado')
        this.collapseLoginAbierto = true
        this.collapseHazteClienteAbierto = false
        btnHazteCliente.classList.remove('pulsado')
        this.claveErronea = false
      }
      this.colorearBotonLoginHazteSwap()
    }, 0)
    
  }
  colorearBotonHazteClienteAlPulsar() {
    //this.limpiarFormulario()
    let btnLogin = this.elementRef.nativeElement.querySelector('.btnLogin')
    let btnHazteCliente = this.elementRef.nativeElement.querySelector('.btnHazteCliente')    
    setTimeout(() => {
      if (btnHazteCliente.classList.contains('collapsed')) {
        btnHazteCliente.classList.remove('pulsado')
        this.collapseHazteClienteAbierto = false
      }
      else {
        btnHazteCliente.classList.add('pulsado')
        this.collapseHazteClienteAbierto = true
        btnLogin.classList.remove('pulsado')
        this.collapseLoginAbierto = false
        //this.claveErronea = false
      }
      this.colorearBotonLoginHazteSwap()
    }, 0)
  
  }

  ModoPruebaMeterTokenValidoYampliarInactividad() {
    this.contadorTemporizadorDeInactividad += 10000000
    sessionStorage['token'] = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJvbmNlQmFuY28iLCJzdWIiOiJQRVBFIiwicm9sZXMiOlt7ImlkIjoyLCJyb2wiOiJST0xFX1VTRVIiLCJsaW5rcyI6W119XSwiaWF0IjoxNjg2MTc3NjkzfQ.bx3WrdovUG-Mn1pl2yp8K996E3e2JvSnjIoN3MBGddCaQK-JCIv5vAE5QOmXqyiI3cuyp3wsZAE2hbAqq-j9KQ"
    sessionStorage['user'] = "BOTIN"
    sessionStorage['rol'] = "ROLE_USER"
    console.log("**Modo pruebas, cargando sesión en ngOnInit de Login.ts**\nTiempo de inactividad ampliado a: " + this.contadorTemporizadorDeInactividad + "ms" +
      "\ntoken: " + sessionStorage['token'] +
      "\nuser: " + sessionStorage['user'] +
      "\nrol: " + sessionStorage['rol']
    )
  }

  // getFees() {
  //   console.log("Sacando Fees con token: " + sessionStorage['token'])
  //   this.feeService.getDatos("http://localhost:8080/once/fees")
  //     .subscribe({

  //       next: (response) => {
  //         console.log("status ok:" + response.status)
  //         console.log(response)
  //         response._embedded.fees.forEach((element: any) => {
  //           console.log(element.current)
  //         });
  //       },
  //       error: (error: any) => {
  //         console.log("status ko:" + error.status)
  //       }
  //     })
  //   .subscribe((datos: any) => {
  //     console.log(datos)
  //     datos._embedded.fees.forEach((element: any) => {
  //       console.log(element.current)
  //     });
  //   })
  // }

  // meterTokenfalso() {
  //   sessionStorage['token'] = "EsteEsUnTokenFalso"
  //   console.log("token: " + sessionStorage['token'])
  // }

}
