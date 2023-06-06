import { Component } from '@angular/core';

@Component({
  selector: 'app-ejemplo',
  templateUrl: './ejemplo.component.html',
  styleUrls: ['./ejemplo.component.css']
})
export class EjemploComponent {

  titulo:string;
  constructor(){
    this.titulo="TIPOS DE DESCRIPCIONES"
  }
}
