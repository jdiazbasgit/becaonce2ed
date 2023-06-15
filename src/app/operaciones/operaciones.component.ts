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
    this.saldo += this.monto;

    let currentDate = new Date();


    let jsonParaEnviar = {
      "date": currentDate.toISOString(),
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
    this.monto = 0;
  }
  realizarRetiro() {
    this.saldo -= this.monto;
    let currentDate = new Date();


    let jsonParaEnviar = {
      "date": currentDate.toISOString(),
      "current": "-"+this.monto,
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
      this.monto = 0;
  }
}






