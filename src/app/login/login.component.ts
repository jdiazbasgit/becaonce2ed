import { Component, ElementRef } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  logado:boolean=false
  inputUsuario:string=""
  inputPassword:string=""
  usuario:string=""

  constructor(private http:ProyectosService, private elementRef:ElementRef){
  }

  logarse(){    
    this.http.getDatos('https://restcountries.com/v3.1/name/spain')
    .subscribe((datos: any) => {
      let userM = datos[0].name.common
      let passM = datos[0].capital;
      console.log(userM+passM)
      if (this.inputUsuario == userM && this.inputPassword == passM){
        this.logado=true
        this.usuario=userM
      }
      else {
        this.limpiarFormulario()      
        let cont = this.elementRef.nativeElement.querySelector('.contenido')
        cont.innerHTML = "Aqui pondremos mensaje error de autenticación y se restablece al cerrar el collapse"
        cont.classList.add('bg-danger')
      }
      }
    )
    
  }
  deslogarse(){
    this.logado=false
  }
  limpiarFormulario(){
    this.inputUsuario=""
    this.inputPassword=""
  }
  colorearBotonLoginAlPulsar() {
    this.limpiarFormulario()
    let btnLogin = this.elementRef.nativeElement.querySelector('.btnLogin');    
    // console.log("hola!")
    if (btnLogin.classList.contains('collapsed')) {
      btnLogin.classList.remove('pulsado');
      // console.log("hola2!")
    }
    else {
      btnLogin.classList.add('pulsado');
    }
  }
}
