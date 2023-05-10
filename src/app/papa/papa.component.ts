import { Component, Input, ViewChild } from '@angular/core';
import { Hijo1Component } from '../hijo1/hijo1.component';

@Component({
  selector: 'app-papa',
  templateUrl: './papa.component.html',
  styleUrls: ['./papa.component.css']
})
export class PapaComponent {
@Input() mensajeAPapaEventoHijo1:string=""
@ViewChild(Hijo1Component) hijo: any
  mensajeAHijo1:string="hola hijo 1, como estas?"
  mensajeAHijo2:string="Hola hijo 2, como estas?"
  mensajeDelHijo1EnEvento:string=""

    realizarComunicacioConPapa(event:any){
    this.mensajeAPapaEventoHijo1=event.texto;
  }
}
