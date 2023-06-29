import { Component, OnInit } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';

@Component({
  selector: 'app-movimientos',
  templateUrl: './movimientos.component.html',
  styleUrls: ['./movimientos.component.css']
})
export class MovimientosComponent implements OnInit {
  operaciones: any[] = [];
  cuentasCorrientes: any[] = [];
  urlTransaction: string = "http://localhost:8080/once/transactions";
  urlCuentaCorriente: string = "http://localhost:8080/once/currentsAccounts"

  constructor(private proyectosService: ProyectosService) { }

  ngOnInit(): void {
    this.filtrarMovimientosCuentaSeleccionada();
  }

  obtenerMovimientos() {
    this.proyectosService.getDatos(this.urlTransaction).subscribe(
      (datos: any) => {
        this.operaciones = datos._embedded.transactions;
        this.obtenerCuentasCorrientes();
      }
    );
  }

  obtenerCuentasCorrientes() {
    this.proyectosService.getDatos(this.urlCuentaCorriente).subscribe(
      (cuentas: any) => {
        this.cuentasCorrientes = cuentas._embedded.currentAccounts;
        this.vincularMovimientosCuentasCorrientes();
      }
    );
  }

  vincularMovimientosCuentasCorrientes() {
    this.operaciones.forEach((movimiento: any) => {
      const cuentaCorriente = this.cuentasCorrientes.find((cuenta: any) => cuenta.id === movimiento.cuentaCorrienteId);
      movimiento.cuentaCorriente = cuentaCorriente;
    });
  }

  filtrarMovimientosCuentaSeleccionada() {

    const cuentaSeleccionada = sessionStorage['cuenta']
    this.proyectosService.patch(this.urlTransaction, new CurrentAccountBean(cuentaSeleccionada, null, null, null, null)).subscribe(
      (cuentas: any) => {
        console.log(cuentas)
        this.operaciones = cuentas;
      }
    )



  }
}
