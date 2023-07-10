import { Component, OnInit } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import CurrentAccountBean from '../beans/currentAccountBean';
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
  concepto:any[]=[];

  constructor(private proyectosService: ProyectosService) { }

  ngOnInit(): void {
    this.filtrarMovimientosCuentaSeleccionada();
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
