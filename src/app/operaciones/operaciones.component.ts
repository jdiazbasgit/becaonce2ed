import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-operaciones',
  templateUrl: './operaciones.component.html',
  styleUrls: ['./operaciones.component.css']
})
export class OperacionesComponent {
  monto: number = 0;
  saldo: number = 0;

  constructor(private http: HttpClient) { }

  realizarDeposito() {
    if (this.monto <= 0) {
      alert('El monto del depósito debe ser mayor que cero');
      return;
    }

    this.http.post('/once/transactions', { amount: this.monto })
      .subscribe(
        () => {
          this.saldo += this.monto;
          this.monto = 0;
        },
        error => {
          alert('Error al realizar el depósito');
        }
      );
  }

  realizarRetiro() {
    if (this.monto <= 0) {
      alert('El monto del retiro debe ser mayor que cero');
      return;
    }

    if (this.monto > this.saldo) {
      alert('Saldo insuficiente');
      return;
    }

    this.http.post('/once/transactions', { amount: -this.monto })
      .subscribe(
        () => {
          this.saldo -= this.monto;
          this.monto = 0;
        },
        error => {
          alert('Error al realizar el retiro');
        }
      );
  }
}
