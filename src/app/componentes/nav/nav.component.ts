import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ModalLoginComponent } from '../modal-login/modal-login.component';
import { AuthService } from 'src/app/servicios/auth.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  logado: boolean = false;

  constructor(
    private authService: AuthService
  ){}
  getlogado(): boolean {
    return this.authService.getLogado();
  }

  closeSession() {
    this.authService.cerrarSesion();
  }
}
