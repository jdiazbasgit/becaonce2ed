import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ModalUserComponent } from '../modal-user/modal-user.component';
import { UserService } from 'src/app/servicios/users.service';
import { forkJoin } from 'rxjs';
import { map } from 'rxjs/operators';
import { RolesService } from 'src/app/servicios/roles.service';


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
  rol: any[];
  mensaje: string = "";
  roles: any[];
  @Input() eventoDelHijo: string = "";

    constructor(private service: UserService, private rolesService: RolesService){
    this.titulo = "Tipos de Usuarios"
    this.usuarios = [];
    this.claves = [];
    this.habilitados = [];
    this.rol = [];
    this.roles = [];
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

    this.service.getDatos("http://localhost:8080/once/users")
      .subscribe((datos: any) => {
        this.usuarios = datos._embedded.users;
      });
      this.rolesService.getDatos("http://localhost:8080/once/roles").subscribe((roles: any)=> {
        console.log(roles);
        this.roles = roles._embedded.rols;
      });
  }

  modificar(usuario: any){
    this.mensaje = "";
    let ruta = usuario._links.self.href
    this.modal.id= parseInt(ruta.substring(ruta.lastIndexOf("/") +1))
  }

}
