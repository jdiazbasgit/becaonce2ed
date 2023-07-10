import { Component, OnInit } from '@angular/core';

interface Cuenta {
  id: number;
  numero: string;
}

@Component({
  selector: 'app-generador-cuentas',
  templateUrl: './generador-cuentas.component.html',
  styleUrls: ['./generador-cuentas.component.css']
})
export class GeneradorCuentasComponent implements OnInit {
  cuentas: Cuenta[] = [];

  constructor() {}
  asignarNumeroCuenta(datosCliente: any): string {
    const numeroCuenta = this.generarNumeroCuentaAleatorio();
    const nuevaCuenta: Cuenta = {
      id: this.cuentas.length + 1,
      numero: numeroCuenta
    };
    this.cuentas.push(nuevaCuenta);
    return numeroCuenta;
  }
  
  ngOnInit() {
    this.generarCuentasAleatorias(1); 
  }

  generarCuentasAleatorias(cantidad: number) {
    for (let i = 0; i < cantidad; i++) {
      const numeroCuenta = this.generarNumeroCuentaAleatorio();
      const nuevaCuenta: Cuenta = {
        id: this.cuentas.length + 1,
        numero: numeroCuenta
      };
      this.cuentas.push(nuevaCuenta);
    }
  }

  generarNumeroCuentaAleatorio() {
    const longitud = 10;
    let numeroCuenta = '';
    for (let i = 0; i < longitud; i++) {
      const digito = Math.floor(Math.random() * 10);
      numeroCuenta += digito.toString();
    }
    return numeroCuenta;
  }
}
