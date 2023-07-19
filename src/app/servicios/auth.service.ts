import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private logado: boolean = false;
  constructor() { }

  getLogado(): boolean {
    return this.logado;
  }

  iniciarSesion() {
    // Lógica para iniciar sesión
    this.logado = true;
  }

  cerrarSesion() {
    // Lógica para cerrar sesión
    this.logado = false;
  }
}
