import { Component } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import { DescriptionService } from '../servicios/description.service';
import { GeneradorCuentasComponent } from '../generador-cuentas/generador-cuentas.component';

interface Cuenta {
  id: number;
  numero: string;
}

@Component({
  selector: 'app-operaciones',
  templateUrl: './operaciones.component.html',
  styleUrls: ['./operaciones.component.css']
})
export class OperacionesComponent {
  urlDescription="http://localhost:8080/once/descriptions"
  description:string=""
  descriptions:Array<any>=[]
  monto: number = 0;
  saldo: number = 0;
  concepto: string = ''; //  propiedad para almacenar el concepto del movimiento
  ultimoMovimiento: { tipo: string, concepto: string, fecha: Date } | null = null; //  propiedad para almacenar el último movimiento
  
  cuentas: Cuenta[] = [];

  cuentaOrigen: number = 0; // Declaración de cuenta de origen
  cuentaDestino: number = 0; // Declaración de cuenta de destino
  constructor(private service: ProyectosService, private descriptionService:DescriptionService) {}

  ngOnInit(){
    this.descriptionService.getDatos(this.urlDescription).subscribe((datos:any)=>{
      this.descriptions= datos._embedded.descriptions
      console.log ("conceptos:" + this.description)

      const generadorCuentasComponent = new GeneradorCuentasComponent();
      generadorCuentasComponent.generarCuentasAleatorias(5); // Genera 5 cuentas aleatorias
  
      this.cuentas = generadorCuentasComponent.cuentas;

    })
  }

  realizarMovimiento(tipo: string) {
    let currentDate = new Date();

    let jsonParaEnviar = {
      "date": currentDate.toISOString(),
      "current": tipo === 'Ingreso' ? this.monto : -this.monto, // Determinar el signo del monto según el tipo de movimiento
      "description": "description/"+ this.description,
      "currentAccount": "currentAccounts/"+ sessionStorage['idCuenta'],
    }

    this.service.saveOrUpdate("http://localhost:8080/once/transactions", jsonParaEnviar)
      .subscribe((dato: boolean) => {
        if (dato) {
          console.log("Grabación realizada correctamente")
          this.actualizarUltimoMovimiento(tipo, this.concepto, currentDate); // Actualizar el último movimiento con el tipo, concepto y fecha
          this.monto = 0;
          this.concepto = ''; // Restablecer el concepto a un valor vacío
          this.description='';
        } else {
          console.log("La grabación no se ha realizado")
        }
      });
  }

  realizarTransferencia() {
    let currentDate = new Date();
  
    let jsonParaEnviar = {
      "date": currentDate.toISOString(),
      "current": -this.monto, // El monto se resta de la cuenta actual para realizar la transferencia
      "description": "description/" + this.description,
      "currentAccount": "currentAccounts/" + sessionStorage['idCuenta'],
    };
  
    this.service.saveOrUpdate("http://localhost:8080/once/transactions", jsonParaEnviar)
      .subscribe((dato: boolean) => {
        if (dato) {
          console.log("Transferencia realizada correctamente")
          this.actualizarUltimoMovimiento('Transferencia', this.concepto, currentDate); // Actualizar el último movimiento con el tipo, concepto y fecha
          this.monto = 0;
          this.concepto = ''; // Restablecer el concepto a un valor vacío
          this.description = '';
        } else {
          console.log("La transferencia no se ha realizado")
        }
      });
  }
  
  private actualizarUltimoMovimiento(tipo: string, concepto: string, fecha: Date) {
    this.ultimoMovimiento = { tipo, concepto, fecha }; // Actualizar la propiedad del último movimiento con el tipo, concepto y fecha
  }
}
