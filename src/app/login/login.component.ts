import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  template: `<form class="d-flex">
  <input class="form-control me-2" type="text" placeholder="Usuario">
  <input class="form-control me-2" type="text" placeholder="Contraseña">
  <button class="btn btn-secondary" type="button">Ingresar</button>
  &nbsp;
  <button class="btn btn-secondary" type="button">Registrar</button>
</form>`
})
export class LoginComponent {

}
