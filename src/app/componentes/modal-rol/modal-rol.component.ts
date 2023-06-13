import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import RolBean from 'src/app/beans/RolBean';
import { RolesService } from 'src/app/servicios/roles.service';

@Component({
  selector: 'app-modal-rol',
  templateUrl: './modal-rol.component.html'
})
export class ModalRolComponent implements DoCheck{
  
  id: number = 0;
  rol: string;
  mensaje: string = "";
  fin: boolean = false;
  rolPlaceHolder: string = "";
  @Output() eventoAComunicar = new EventEmitter();
  constructor (private service: RolesService){
    this.rol = "";
  }

  ngDoCheck(): void {
    if(this.id !== 0 && !this.fin){
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/roles" + this.id)
      .subscribe((datos: any)=> {
        this.fin = true;
        this.rolPlaceHolder = datos.rol;
      })
    }
  }

  realizarComunicacion(){
    this.id = 0;
    this.eventoAComunicar.emit({salida:"OK"})
  }

  grabar(){
    this.fin = false;
    if (this.rol.trim()!== ""){
      this.service.saveOrUpdate("http://localhost:8080/once/roles", new RolBean(this.id, this.rol))
      .subscribe((dato: boolean)=> {
        if(dato){
          this.mensaje = "Grabacion realizada correctamente"
          this.rol = "";
        }else
        this.mensaje = "La grabacion no se ha realizado"
      })
    }else
      this.mensaje = "Debes introducir un valor"
  }
  
}
