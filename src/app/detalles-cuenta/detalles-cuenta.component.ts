import { Component, OnInit } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import { CurrentAccountService } from '../servicios/current-account.service';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-detalles-cuenta',
  templateUrl: './detalles-cuenta.component.html',
  styleUrls: ['./detalles-cuenta.component.css']
})
export class DetallesCuentaComponent implements OnInit {

  cuentaElegida: string;
  url: string = "http://localhost:8080/once/";
  urlCurrentsAccounts: string = "http://localhost:8080/once/currentsAccounts";
  datosAdicionales: any;
  interes: any;
  description: any;
  saldoCuenta: any;
  cuentaCreacion: string | undefined;

  constructor(private service: ProyectosService, private currentAccountService: CurrentAccountService) {
    this.cuentaElegida = "";
  }

  ngOnInit() {
    this.cuentaElegida = sessionStorage['cuenta'];
    console.log(this.cuentaElegida + "numero de cuenta ");

    this.service.getDatos(this.url + "balance/" + this.cuentaElegida).subscribe((datos: any) => {
      // console.log(datos);
      this.saldoCuenta = datos;
      console.log(this.saldoCuenta + "saldo")

      this.currentAccountService.getDatos(this.urlCurrentsAccounts).subscribe((datos: any) => {
        console.log("datos de cuenta", datos);
        datos._embedded.currentAccounts.forEach((cuenta: any) => {
          console.log("Número de cuenta:", cuenta.number);
          console.log("Fecha de creación:", cuenta.creationDate);
          console.log(cuenta._links.fee.href);

          if (this.cuentaElegida == cuenta.number) {
            this.service.getDatos(cuenta._links.fee.href).subscribe((datosAdicionales: any) => {
              this.datosAdicionales = datosAdicionales;
              this.interes = datosAdicionales.current;
              console.log("Datos adicionales:", datosAdicionales.current);
              this.service.getDatos(cuenta._links.typeAccount.href).subscribe((description) => {
                this.description = description.description;
              });

              this.cuentaCreacion =cuenta.creationDate
            });
          }
        });
      });
    });
  }

  
}
