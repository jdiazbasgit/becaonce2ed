import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { RolesService } from 'src/app/servicios/roles.service';
import { UserService } from 'src/app/servicios/users.service';
import { ModalUserComponent } from '../modal-user/modal-user.component';
import UserBean from 'src/app/beans/UserBean';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent implements OnInit{

  @ViewChild(ModalUserComponent,) modal: any
  id: number = 0;
  titulo: string;
  usuarios: any[];
  claves: any[];
  habilitados: any[];
  //roles: any[];
  mensaje: string = "";
  @Input() eventoDelHijo: string = "";

    constructor(private service: UserService, private rolesService: RolesService){
    this.titulo = "USUARIOS"
    this.usuarios = [];
     this.claves = [];
     this.habilitados = [];
    // this.roles = [];
  }

  alta(){
    this.modal.id = 0;
    this.modal.ngOnInit()
  }

  eliminar(id: any){
    if(confirm("¿Esta seguro de borrar el tipo de usuario?")){
      this.service.delete("http://localhost:8080/once/users/" + id).
      subscribe((dato:boolean)=>{
        if(!dato){
          this.mensaje = "Se ha eliminado usuario correctamente"
          this.ngOnInit();
        }else{
          this.mensaje = "El registro no se ha borrado"
        }
      });
    }
  }

  realizarComunicacion(event: any){
    this.mensaje = "";
    if(event.salida === "OK")
    this.ngOnInit();
  }

  ngOnInit(): void {
    this.usuarios=[];
    this.service.getDatos("http://localhost:8080/once/users")
      .subscribe((datos: any) => {
        datos._embedded.users.forEach((u:any)=>{
          this.service.getDatos(u._links.rol.href).subscribe((r:any)=>{
            let userBean = new UserBean(parseInt(u._links.self.href.substring(u._links.self.href.lastIndexOf("/")+1)),u.user, u.password, u.enabled, r.rol)
            this.usuarios.push(userBean)
          })
        })
      });
  }
  
  modificar(usuario: any){
    this.mensaje = "";
    let ruta = usuario._links.self.href
    this.modal.id= parseInt(ruta.substring(ruta.lastIndexOf("/") +1))
  }
}
