import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { HijoComponent } from '../hijo/hijo.component';

@Component({ 
  selector: 'app-padre',
  templateUrl: './padre.component.html',
  styleUrls: ['./padre.component.css'],
})
export class PadreComponent implements OnInit {
  salidaAlHijo: string;
  entradaDelHijo: string;
  @ViewChild(HijoComponent) hijo: any

  @Input() eventoDelHijo:string
  constructor() {
    this.entradaDelHijo = '';
    this.salidaAlHijo = '';
    this.eventoDelHijo=""
  }
  
  ngAfterViewInit(): void {
  this.entradaDelHijo=this.hijo.mensajeAPapa
 }
 ngAfterViewChecked(){
  this.entradaDelHijo=this.hijo?.mensajeAPapa
 }

  

  realizarComunicacion(event:any){
    this.eventoDelHijo=event.salida
  }

  ngOnInit(): void {}
}
