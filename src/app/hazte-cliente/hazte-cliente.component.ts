import { Component } from '@angular/core';

@Component({
  selector: 'app-hazte-cliente',
  templateUrl: './hazte-cliente.component.html',
  styleUrls: ['./hazte-cliente.component.css']
})


export class HazteClienteComponent {
  nombre: string;
  apellidos: string;
  documentodeidentidad: string;
  telefono: string;
  email: string;


  constructor() {
    this.nombre = "";
    this.apellidos = "";
    this.documentodeidentidad = "";
    this.telefono = "";
    this.email = "";

  }

}

