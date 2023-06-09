import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import ProfileBean from '../../beans/ProfileBean';
import { ProfileService } from 'src/app/servicios/profile.service';


@Component({
  selector: 'app-modal-profiles',
  templateUrl: './modal-profiles.component.html',
  styleUrls: ['./modal-profiles.component.css']
})
export class ModalProfilesComponent implements DoCheck {
  id: number = 0
  descripcion: string
  mensaje: string = ""
  fin: boolean = false
  descripcionPlaceHolder:string=""
  @Output() eventoAComunicar=new EventEmitter()
  constructor(private service: ProfileService) {
    this.descripcion = "";
  }

  ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/profiles/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true
          //  if (this.descripcion !== datos.description)
            this.descripcionPlaceHolder= datos.description;

        })
    }
  }

  realizarComunicacion(){
    this.id=0;
    this.eventoAComunicar.emit({salida:"OK"})
  }

  grabar() {
    this.fin = false;
    if (this.descripcion.trim() !== "") {
      this.service.saveOrUpdate("http://localhost:8080/once/profiles", new ProfileBean(this.id, this.descripcion))
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
