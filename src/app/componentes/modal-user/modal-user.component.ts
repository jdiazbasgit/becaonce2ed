import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import UserBean from 'src/app/beans/UserBean';
import { UserService } from 'src/app/servicios/users.service';

@Component({
  selector: 'app-modal-user',
  templateUrl: './modal-user.component.html'
})
export class ModalUserComponent implements DoCheck{
  
  id : number = 0;
  usuario: string;
  password: string = "";
  enabled: string = "";
  mensaje: string = "";
  fin: boolean = false;
  usuarioPlaceHolder: string = "";
  passwordPlaceHolder: string = "";
  enabledPlaceHolder: string = "";
  rolPlaceHolder: string = "";
  rol_Id: string = "";
  rol: number = 0;
  roles: Array<any>;
  subtitulo: string="";
  @Output() eventoAComunicar = new EventEmitter();
  constructor(private service: UserService){
    this.usuario = "";
    this.password = "";
    this.enabled = "";
    this.rol_Id = "";
    this.roles = [];
  }

  ngDoCheck(): void {
    if(this.id === 0){
      this.subtitulo="ALTA";
    }else{
      this.subtitulo="MODIFICACION";
    }
    if(this.id !== 0 && !this.fin){
      this.rol = this.id;
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/users" + this.id)
      .subscribe((datos: any)=>{
        this.fin = true
        this.usuarioPlaceHolder = datos.user;
        this.passwordPlaceHolder = datos.password;
        this.enabledPlaceHolder = datos.enabled;
        this.rolPlaceHolder = datos.rol;
      })
    }
  }

  realizarComunicacion(){
    this.id = 0;
    this.usuarioPlaceHolder="";
    this.passwordPlaceHolder="";
    this.enabledPlaceHolder=""
    this.rolPlaceHolder=""
    this.fin=false;
    
    this.eventoAComunicar.emit({salida:"OK"})
  }

  grabar(){
    this.fin = false;
    if(this.usuario.trim() !== ""){
      this.service.saveOrUpdate("http://localhost:8080/once/users", new UserBean(this.id, this.usuario, this.password, this.enabled,"http://localhost:8080/once/roles"+ this.rol ))
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
