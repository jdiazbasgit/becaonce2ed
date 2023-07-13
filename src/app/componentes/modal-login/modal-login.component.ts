import { Component, ElementRef, Inject } from '@angular/core';
import { DialogData } from '../login/login.component';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { LoginService } from 'src/app/servicios/login.service';
import { catchError } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modal-login',
  templateUrl: './modal-login.component.html'
})
export class ModalLoginComponent {
  hide = true;
  logado = false;
  user: string ="";
  inputUser: string = "";
  inputPassword: string = "";
  incorrectKey: boolean = false;
  keyMessage: String = "";
  sinActividad: boolean = false,
  constructor(
    public dialogRef: MatDialogRef<ModalLoginComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    private loginService: LoginService,
    private dialog: MatDialog,
    private elementRef: ElementRef,
    private router: Router
    
  ){}

  isLoading=false;
  closeDialog(): void {
    this.dialogRef.close();
  }
  ngDoCheck() {
    if (sessionStorage.getItem('token') != null && !this.logado == false) {
      this.logado = true;
      this.user = sessionStorage.getItem('user') ?? '';
    }
    if (!this.logado && this.router.url !== "/home") {
      this.router.navigateByUrl("home");
    }
    if(!this.sinActividad && this.logado){
    }
    
  }
  logarse() {

    this.loginService.identificar("http://localhost:8080/login",
      this.inputUser, this.inputPassword)
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
          //this.notActive = false;
          console.log(datos.token);
        }
      });
  }
  closeSession() {
    sessionStorage.removeItem('user');
    sessionStorage.removeItem('token');
    this.logado = false;
  }

  mensajeClaveErronea(mensaje: String) {
    this.incorrectKey = true;
    this.keyMessage = mensaje;
  }
  
}
