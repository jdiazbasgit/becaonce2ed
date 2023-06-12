import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import { ConfigurationService } from 'src/app/servicios/configuration.service';
import ConfigurationBean from '../../beans/ConfigurationBean';

@Component({
  selector: 'app-modal-configuration',
  templateUrl: './modal-configuration.component.html',
  styleUrls: ['./modal-configuration.component.css']
})
export class ModalConfigurationComponent implements DoCheck {

  id: number = 0
  stockAlarm: string
  mensaje: string = "";
  fin: boolean = false
  stockAlarmPlaceHolder:string=""
  @Output() eventoAComunicar=new EventEmitter();
  constructor(private service: ConfigurationService) {
    this.stockAlarm = "";
  }

  ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/configurations/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true
            this.stockAlarmPlaceHolder= datos.stockAlarm;
        })
    }
  }

  realizarComunicacion(){
    this.id=0;
    this.eventoAComunicar.emit({salida:"OK"})
  }

  grabar() {
    this.fin = false;
    if (this.stockAlarm.trim() !== "") {
      this.service.saveOrUpdate("http://localhost:8080/once/configurations", new ConfigurationBean(this.id, this.stockAlarm))
        .subscribe((dato: boolean) => {
          if (dato) {
            this.mensaje = "Grabacion realizada correctamente"
            this.stockAlarm = ""
          }
          else
            this.mensaje = "La grabación no se ha realizado"
        })
    }
    else
      this.mensaje = "Debes introducir un valor"
  }

}
