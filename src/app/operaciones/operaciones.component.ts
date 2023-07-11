import { Component, OnInit } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import { DescriptionService } from '../servicios/description.service';
import UserNameBean from '../beans/UserNameBean';
import { catchError } from 'rxjs';
import { HttpClient } from '@angular/common/http';


interface Cuenta {
  id: number;
  number: string;
}

@Component({
  selector: 'app-operaciones',
  templateUrl: './operaciones.component.html',
  styleUrls: ['./operaciones.component.css']
})
export class OperacionesComponent implements OnInit {
  urlDescription = "http://localhost:8080/once/descriptions"
  description: string = ""
  descriptions: Array<any> = []
  monto: number = 0;
  saldo: number = 0;
  url: string = "http://localhost:8080/once/"
  concepto: string = ''; //  propiedad para almacenar el concepto del movimiento
  ultimoMovimiento: { tipo: string, concepto: string, fecha: Date } | null = null; //  propiedad para almacenar el último movimiento

  cuentas: Cuenta[] = [];

  cuentaOrigen: number = 0; // Declaración de cuenta de origen
  cuentaDestino: number = 0; // Declaración de cuenta de destino
  constructor(private service: ProyectosService, private descriptionService: DescriptionService, private http: HttpClient) { }

  ngOnInit() {
    this.descriptionService.getDatos(this.urlDescription).subscribe((datos: any) => {
      this.descriptions = datos._embedded.descriptions
      console.log("conceptos:" + this.description)
      this.obtenerCuentas()

    })
  }
  obtenerCuentaElegida() {
    return sessionStorage['cuenta']
  }

  obtenerCuentas() {
    this.service.patch(this.url + "currentsAccounts", new UserNameBean(sessionStorage['user']))
      .pipe(
        catchError(error => {
          console.log(error)
          console.log(sessionStorage['token'])
          if (error.status === 401 || error.status === 403) {

            sessionStorage.clear()
            console.log("no autorizado")
            //this.router.navigateByUrl('/landing')
          }
          return ""
        })
      )
      .subscribe({
        next: (cuentas) => {
          console.log(cuentas)
          this.cuentas = cuentas
        }
      })
  }

  realizarMovimiento(tipo: string) {
    let currentDate = new Date();

    let jsonParaEnviar = {
      "date": currentDate.toISOString(),
      "current": tipo === 'Ingreso' ? this.monto : -this.monto, // Determinar el signo del monto según el tipo de movimiento
      "description": "description/" + this.description,
      "currentAccount": "currentAccounts/" + sessionStorage['idCuenta'],
    }

    this.service.saveOrUpdate("http://localhost:8080/once/transactions", jsonParaEnviar)
      .subscribe((dato: boolean) => {
        if (dato) {
          console.log("Grabación realizada correctamente")
          this.actualizarUltimoMovimiento(tipo, this.concepto, currentDate); // Actualizar el último movimiento con el tipo, concepto y fecha
          this.monto = 0;
          this.concepto = ''; // Restablecer el concepto a un valor vacío
          this.description = '';
        } else {
          console.log("La grabación no se ha realizado")
        }
      });
  }

  realizarTransferencia() {
    let currentDate = new Date();
  
    // let jsonParaEnviar = {
    //   "date": currentDate.toISOString(),
    //   "current": -this.monto, // El monto se resta de la cuenta actual para realizar la transferencia
    //   "description": "description/" + this.description,
    //   "currentAccount": "currentAccounts/" + sessionStorage['idCuenta'],
    // };
  
    let jsonParaRestar = {
      "date": currentDate.toISOString(),
      "current": -this.monto, // El monto se resta de la cuenta actual para realizar la transferencia
      "description": "description/" + this.description,
      "currentAccount": "currentAccounts/" + sessionStorage['idCuenta'],
    };
  
    let jsonParaSumar = {
      "date": currentDate.toISOString(),
      "current": this.monto,
      "description": "description/" + this.description,
      "currentAccount": "currentAccounts/" + sessionStorage["idCuentaDestino"],
    };
  
    this.service.saveOrUpdate("http://localhost:8080/once/transactions", jsonParaRestar)
    .subscribe((restarExitoso: boolean) => {
        if (restarExitoso) {
            // Si se restó el monto de la cuenta seleccionada, realizar la solicitud para sumarlo en la cuenta destino
            this.service.saveOrUpdate("http://localhost:8080/once/transactions", jsonParaSumar)
                .subscribe((sumarExitoso: boolean) => {
                    if (sumarExitoso) {
                        console.log('Transferencia realizada correctamente');
                        this.actualizarUltimoMovimiento('Transferencia', this.concepto, currentDate);
                        this.monto = 0;
                        this.concepto = '';
                        this.description = '';
                    } else {
                        console.log('Error al sumar el monto en la cuenta destino');
                    }
                }, errorSumar => {
                    console.log('Error al realizar la transferencia: ', errorSumar);
                });
        } else {
            console.log('Error al restar el monto de la cuenta seleccionada');
        }
    }, errorRestar => {
        console.log('Error al realizar la transferencia: ', errorRestar);
    });
}
  private actualizarUltimoMovimiento(tipo: string, concepto: string, fecha: Date) {
    this.ultimoMovimiento = { tipo, concepto, fecha }; // Actualizar la propiedad del último movimiento con el tipo, concepto y fecha
  }
}
