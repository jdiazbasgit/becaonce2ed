import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-hijo1',
  templateUrl: './hijo1.component.html',
  styleUrls: ['./hijo1.component.css']
})
export class Hijo1Component {
  @Input("mensaje") mensajeDePapa: string = ""
  @Output() mensajeAPapaEventoHijo1 = new EventEmitter();
  mensajeAPapa: string = ""


  realizarComunicacioConPapa(mensaje: string) {
    console.log(mensaje)
    this.mensajeAPapaEventoHijo1.emit({ texto: mensaje })
  }

  realizarCominicacioConPapa1() {
    this.mensajeAPapaEventoHijo1.emit({ texto: this.mensajeAPapa })
  }
}
