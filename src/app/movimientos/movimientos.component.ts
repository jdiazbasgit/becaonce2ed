import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../servicios/transaction.service';


@Component({
  selector: 'app-movimientos',
  templateUrl: './movimientos.component.html',
  styleUrls: ['./movimientos.component.css']
})
export class MovimientosComponent implements OnInit {
  operaciones: any[] = [];

  constructor(private transactionService: TransactionService) {}

  ngOnInit(): void {
    this.obtenerMovimientos();
  }

  urlTransaction:string="http://localhost:8080/once/transactions"
  obtenerMovimientos() {
    this.transactionService.getDatos(this.urlTransaction).subscribe(
      (datos: any) => {
        this.operaciones = datos._embedded.transactions;
      }
    );
  }
}
