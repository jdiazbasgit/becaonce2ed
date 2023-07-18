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
  urlCuentaCorriente: string = "http://localhost:8080/once/currentsAccounts";
  concepto: any[] = [];
  currentPage: number = 1;
  itemsPerPage: number = 10;
  totalPages: number = 0;

  constructor(private proyectosService: ProyectosService) { }

  ngOnInit(): void {
    this.filtrarMovimientosCuentaSeleccionada();
  }

  filtrarMovimientosCuentaSeleccionada() {
    const cuentaSeleccionada = sessionStorage['cuenta'];
    this.proyectosService.patch(this.urlTransaction, new CurrentAccountBean(cuentaSeleccionada, null, null, null, null)).subscribe(
      (movimientos: any) => {
        console.log(this.getPaginatedMovimientos);
        this.operaciones = movimientos;
        this.operaciones.sort((a, b) => {
          if(a.date>= b.date)
          return -1;
          else return 1;
        })
        this.totalPages = Math.ceil(this.operaciones.length / this.itemsPerPage);
      }
    );
  }

  getPaginatedMovimientos() {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.operaciones.slice(startIndex, endIndex);
  }

  goToPage(pageNumber: number) {
    if (pageNumber >= 1 && pageNumber <= this.totalPages) {
      this.currentPage = pageNumber;
    }
  }
}
