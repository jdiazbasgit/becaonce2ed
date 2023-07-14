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
  //counterAfkTimer: number = 30000;//contadortemporizador de inactividad
  //afkTimer: any;//temporizadorDeInactividad notActive incorrectKey keyMessage
  //notActive: boolean = false;//sin actividad
  hide = true;
  constructor(
    private dialog: MatDialog,
    private elementRef: ElementRef,
    private loginService: LoginService,
    private documentType: DocumentTypeService,
    private router: Router
  ) { }

  openDialog() {
    this.dialog.open(ModalLoginComponent);
  }

 
  closeSession() {
    sessionStorage.removeItem('user');
    sessionStorage.removeItem('token');
    this.logado = false;
  }

  

}
