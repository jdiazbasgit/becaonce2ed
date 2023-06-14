import { Component } from '@angular/core';

@Component({
  selector: 'app-operaciones',
  templateUrl: './operaciones.component.html',
  styleUrls: ['./operaciones.component.css']
})
export class OperacionesComponent {
  monto: number = 0;
  saldo: number = 0;
  
  realizarDeposito() {
    this.saldo += this.monto;
    this.monto = 0;
}
realizarRetiro() {
  if (this.monto > this.saldo) {
    alert('Saldo insuficiente');
  } else {
    this.saldo -= this.monto;
    this.monto = 0;
  }
}
}