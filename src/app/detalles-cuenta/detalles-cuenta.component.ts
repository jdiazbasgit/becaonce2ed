import { Component } from '@angular/core';

@Component({
  selector: 'app-detalles-cuenta',
  templateUrl: './detalles-cuenta.component.html',
  styleUrls: ['./detalles-cuenta.component.css']
})
export class DetallesCuentaComponent {
  
  cuentaElegida:string

  constructor(){
    this.cuentaElegida=""
  }

  ngOnInit(){
    this.cuentaElegida= sessionStorage['cuenta']
    console.log(this.cuentaElegida)
  }
}
