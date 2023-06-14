import { Component } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';

@Component({
  selector: 'app-operaciones',
  templateUrl: './operaciones.component.html',
  styleUrls: ['./operaciones.component.css']
})
export class OperacionesComponent {
  monto: number = 0;
  saldo: number = 0;

  constructor(private service: ProyectosService) {

  }

  realizarDeposito() {
    // this.saldo += this.monto;
    // this.monto = 0;

    let jsonParaEnviar = {
      "date": "2022-12-31T23:00:00.000+00:00",
      "current": this.monto,
      "description": "descriptions/1",
      "currentAccount": "currentAccounts/1",
    }

    this.service.saveOrUpdate("http://localhost:8080/once/transactions", jsonParaEnviar)
      .subscribe((dato: boolean) => {
        if (dato) {
          console.log("Grabacion realizada correctamente")
        }
        else
          console.log("La grabación no se ha realizado")
       
      })
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
    





