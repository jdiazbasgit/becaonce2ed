import { Component } from '@angular/core';
import { AuthService } from 'src/app/servicios/auth.service';

@Component({
    selector: 'app-nav',
    templateUrl: './nav.component.html',
    styleUrls: ['./nav.component.css'],
    standalone: false
})
export class NavComponent {
  logado: boolean = false;

  constructor(
    private authService: AuthService
  ){}
  getlogado(): boolean {
    return this.authService.getLogado();
  }

  getSessionStorage():any{
    return sessionStorage;
  }

  closeSession() {
    sessionStorage.setItem("token","")
    this.authService.cerrarSesion();
  }
}
