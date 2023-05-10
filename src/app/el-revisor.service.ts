import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ElRevisorService {
  logado:boolean=false;
  cuentaElegida:boolean=false

  constructor() { }

  logarse(){
    this.logado=!this.logado
  }

}
