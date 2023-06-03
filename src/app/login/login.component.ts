import { Component, ElementRef } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import { LoginService } from '../servicios/login.service';
import { FeeService } from '../servicios/fee.service';

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

  constructor(private http: ProyectosService, private elementRef: ElementRef, private loginService: LoginService, private feeService: FeeService) {
  }


  getFees() {
    console.log("Sacando Fees con token: " + sessionStorage['token'])
    this.feeService.getDatos("http://localhost:8080/once/fees")
      .subscribe((datos: any) => {
        console.log(datos)
        datos._embedded.fees.forEach((element: any) => {
          console.log(element.current)
        });
      })
  }

  meterTokenfalso() {
    sessionStorage['token'] = "EsteEsUnTokenFalso"
    console.log("token: " + sessionStorage['token'])
  }

  logarse() {    
    let cont = this.elementRef.nativeElement.querySelector('#modalConectando')
    cont.classList.remove('oculto')
    setTimeout(() => {
      this.loginService.identificar("http://localhost:8080/login", this.inputUsuario, this.inputPassword)
        .subscribe((datos: any) => {
          console.log(datos)
          if (datos.token == null) {
            this.limpiarFormulario()
            // let cont = this.elementRef.nativeElement.querySelector('.contenido')
            // cont.innerHTML = "El Usuario o la Clave son incorrectos"
            // cont.classList.add('bg-danger')
            this.elementRef.nativeElement.querySelector('#inputP').blur()
            this.elementRef.nativeElement.querySelector('#inputU').blur()
            this.mensajeClaveErronea()
          }
          if (datos.token != null) {
            console.log("acceso correcto")
            let userM = this.inputUsuario
            let passM = this.inputPassword
            this.usuario = this.inputUsuario
            this.logado = true
            console.log(userM + passM)
            sessionStorage['token'] = datos.token;
            let cont = this.elementRef.nativeElement.querySelector('.contenido')
            cont.innerHTML = "Bienvenido"
            cont.classList.add('bg-success')
            console.log(datos.token)
          }

        }
        )
      cont.classList.add('oculto')
    }, 3000)

  }
  deslogarse() {
    this.logado = false
    sessionStorage['token'] = null;
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
  mensajeClaveErronea() {
    this.claveErronea = true
    setTimeout(() => {
      this.claveErronea = false
    }, 3000);
  }
}
