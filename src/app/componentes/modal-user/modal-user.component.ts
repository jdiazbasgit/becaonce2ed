import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import { UserService } from 'src/app/servicios/user.service';

@Component({
  selector: 'app-modal-user',
  templateUrl: './modal-user.component.html',
  styleUrls: ['./modal-user.component.css']
})
export class ModalUserComponent implements DoCheck {
  id :number=0
  descripcion :string= "";
  mensaje : string= "";
  fin: boolean=false
  descripcionPlaceHolder:string=""; 
  @Output() eventoAComunicar = new EventEmitter();
  constructor(private service : UserService){
    this.descripcion ="";
  }

  ngDoCheck(): void {
    if(this.id !== 0 && !this.fin){
      console.log("id entrada :"+ this.id)
      this.service.getDatos("http//localhost:8080/once/users"+ this.id)
      .subscribe((datos:any)=>{
        this.fin = true
        this.descripcionPlaceHolder = datos.descripcion;
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
      this.service.saveOrUpdate("http://localhost:8080/once/user", new  (this.id, this.descripcion))
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
