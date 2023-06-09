import { AfterContentChecked, Component, DoCheck, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { CardTypeService } from '../../servicios/card-type.service';
import CardTypeBean from '../../beans/CardTypeBean';

@Component({
  selector: 'app-modal-card-types',
  templateUrl: './modal-card-types.component.html',
  styleUrls: ['./modal-card-types.component.css']
})
export class ModalCardTypesComponent implements DoCheck {
  id: number = 0
  descripcion: string
  mensaje: string = "";
  cardType:string=""
  fin: boolean = false
  descripcionPlaceHolder: string = ""
  @Output() eventoAComunicar = new EventEmitter();
  constructor(private service: CardTypeService) {
    this.descripcion = "";

  }
  ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/cardTypes/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true
          //  if (this.descripcion !== datos.description)
          this.descripcionPlaceHolder = datos.description;

        })
    }
  }
  realizarComunicacion() {
    this.id = 0;
    this.eventoAComunicar.emit({ salida: "OK" })
  }
  grabar() {
    this.fin = false;
    if (this.descripcion.trim() !== "") {
      this.service.saveOrUpdate("http://localhost:8080/once/cardTypes", new CardTypeBean(this.id, this.descripcionPlaceHolder))
        .subscribe((dato: boolean) => {
          if (dato) {
            this.mensaje = "Grabacion realizada correctamente"
            this.descripcion = ""
          }
          else
            this.mensaje = "La grabación no se ha realizado"
        })
    }
    else
      this.mensaje = "Debes introducir un valor"
  }

}
