import { Component, ElementRef, Output, Inject, Input, EventEmitter } from '@angular/core';
import { DialogData } from '../login/login.component';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { LoginService } from 'src/app/servicios/login.service';
import { catchError } from 'rxjs';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { NavComponent } from '../nav/nav.component';

@Component({
  selector: 'app-modal-login',
  templateUrl: './modal-login.component.html'
})
export class ModalLoginComponent {
  @Output() registerclicked: EventEmitter<void> = new EventEmitter<any>();
  isBlurred : boolean = false;
  hide = true;
  logado = false;
  user: string = "";
  inputUser: string = "";
  inputPassword: string = "";
  incorrectKey: boolean = false;
  keyMessage: String = "";
  sinActividad: boolean = false;
  InactivityTimer: any;
  timeout: number = 6000000;
  isLoading = false;
  notActive: boolean = false;
  constructor(
    private dialogRef: MatDialogRef<NavComponent>,
    private loginService: LoginService,
    private dialog: MatDialog,
    private elementRef: ElementRef,
    private router: Router

  ) { }

  handlerRegisterClick(): void{
    this.registerclicked.emit();
  }

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



  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean{
    const userrole = sessionStorage.getItem('rol');
    if(this.user === 'adimn'){
      return true;
    }else{
      this.router.navigateByUrl('/home');
      return false;
    }
  }

  handleLogin() {
    this.isLoading = true;
    setTimeout(() => {
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
            this.isBlurred = true;
            this.mensajeClaveErronea("El Usuario o la Clave introducidos no son correctos");
          }
          if (datos.token != null) {
            console.log("inicio de sesion correcto")
            let userM = this.inputUser;
            let passM = this.inputPassword;
            sessionStorage.setItem('user', datos.user);
            console.log(userM + passM);
            sessionStorage.setItem('token', datos.token);
            sessionStorage.setItem('rol', datos.roles[0].rol)
            this.notActive = false;
            console.log(datos.token);
            this.isLoading = false;
            this.closeDialog();
          }
        })
    }, 1000);
  }

  closeSession() {
    sessionStorage.removeItem('user');
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('rol');
    this.logado = false;
  }

  mensajeClaveErronea(mensaje: String) {
    this.incorrectKey = true;
    this.keyMessage = mensaje;
  }

  closeDialog(): void {
    this.dialogRef.close();
  }

  ModoPruebaMeterTokenValidoYampliarInactividad() {
    this.timeout += 10000000
    sessionStorage['token'] = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJvbmNlQmFuY28iLCJzdWIiOiJQRVBFIiwicm9sZXMiOlt7ImlkIjoyLCJyb2wiOiJST0xFX1VTRVIiLCJsaW5rcyI6W119XSwiaWF0IjoxNjg2MTc3NjkzfQ.bx3WrdovUG-Mn1pl2yp8K996E3e2JvSnjIoN3MBGddCaQK-JCIv5vAE5QOmXqyiI3cuyp3wsZAE2hbAqq-j9KQ"
    sessionStorage['user'] = "BOTIN"
    sessionStorage['rol'] = "ROLE_USER"
    console.log("**Modo pruebas, cargando sesión en ngOnInit de Login.ts**\nTiempo de inactividad ampliado a: " + this.timeout + "ms" +
      "\ntoken: " + sessionStorage['token'] +
      "\nuser: " + sessionStorage['user'] +
      "\nrol: " + sessionStorage['rol']
    )
  }
}
