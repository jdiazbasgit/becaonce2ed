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
  concepto: string = ''; //  propiedad para almacenar el concepto del movimiento
  ultimoMovimiento: { tipo: string, concepto: string, fecha: Date } | null = null; //  propiedad para almacenar el último movimiento

  constructor(private service: ProyectosService) {}

  realizarMovimiento(tipo: string) {
    let currentDate = new Date();

    let jsonParaEnviar = {
      "date": currentDate.toISOString(),
      "current": tipo === 'Ingreso' ? this.monto : -this.monto, // Determinar el signo del monto según el tipo de movimiento
      "description": "descriptions/1",
      "currentAccount": "currentAccounts/1",
    }

    this.service.saveOrUpdate("http://localhost:8080/once/transactions", jsonParaEnviar)
      .subscribe((dato: boolean) => {
        if (dato) {
          console.log("Grabación realizada correctamente")
          this.actualizarUltimoMovimiento(tipo, this.concepto, currentDate); // Actualizar el último movimiento con el tipo, concepto y fecha
          this.monto = 0;
          this.concepto = ''; // Restablecer el concepto a un valor vacío
        } else {
          console.log("La grabación no se ha realizado")
        }
      });
  }

  private actualizarUltimoMovimiento(tipo: string, concepto: string, fecha: Date) {
    this.ultimoMovimiento = { tipo, concepto, fecha }; // Actualizar la propiedad del último movimiento con el tipo, concepto y fecha
  }
}





