import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import UserBean from 'src/app/beans/UserBean';
import { UserService } from 'src/app/servicios/users.service';

@Component({
  selector: 'app-modal-user',
  templateUrl: './modal-user.component.html',
  styleUrls: ['./modal-user.component.css']
})
export class ModalUserComponent implements DoCheck{
  
  id : number = 0;
  usuario: string;
  mensaje: string = "";
  fin: boolean = false;
  usuarioPlaceHolder: string = "";
  @Output() eventoAComunicar = new EventEmitter();
  constructor(private service: UserService){
    this.usuario = "";
  }

  ngDoCheck(): void {
    if(this.id !== 0 && !this.fin){
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/users" + this.id)
      .subscribe((datos: any)=>{
        this.fin = true
        this.usuarioPlaceHolder = datos.user;
      })
    }
  }

  realizarComunicacion(){
    this.id = 0;
    this.eventoAComunicar.emit({salida:"OK"})
  }

  grabar(){
    this.fin = false;
    if(this.usuario.trim() !== ""){
      this.service.saveOrUpdate("http://localhost:8080/once/users", new UserBean(this.id, this.usuario, this.))
      .subscribe((dato: boolean) => {
        if(dato){
          this.mensaje = "grabacion realizada corerectamente"
          this.usuario = ""
        }else
          this.mensaje = "la grabacion no se ha realizado"
      })
    }else
      this.mensaje = "Debes introducir un valor"
  }
}
