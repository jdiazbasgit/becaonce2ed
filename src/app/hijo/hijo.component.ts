import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-hijo',
  templateUrl: './hijo.component.html',
  styleUrls: ['./hijo.component.css']
})
export class HijoComponent implements OnInit {
 @Input() entradaDelPadre:string
 @Output() eventoAComunicar=new EventEmitter();
 mensajeAPapa:string
 mensajeAPapaEnEvento:string
  constructor() { 
    this.entradaDelPadre=""
    this.mensajeAPapa="Hola papa, necesito tu coche"
    this.mensajeAPapaEnEvento=""
  }

  ngOnInit(): void {
  }
  realizarComunicacion(dato:string){
    this.eventoAComunicar.emit({salida:dato})
  }

}
