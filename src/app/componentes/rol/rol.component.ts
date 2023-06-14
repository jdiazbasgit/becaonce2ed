import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ModalRolComponent } from '../modal-rol/modal-rol.component';
import { RolesService } from 'src/app/servicios/roles.service';

@Component({
  selector: 'app-rol',
  templateUrl: './rol.component.html'
})
export class RolComponent implements OnInit{

  @ViewChild(ModalRolComponent) modal: any
  id : number = 0;
  titulo: string;
  roles: any[];
  mensaje: string = "";
  @Input() eventoDelHijo: string = ""
  constructor(private service: RolesService){
    this.titulo = "Tipos de Roles"
    this.roles = [];
  }

  eliminar(id: any){
    if(confirm("Esta seguro de borrar el tipo de rol")){
      this.service.delete("http://localhost:8080/once/roles/"+ id)
      .subscribe((dato: boolean)=>{
        if(!dato){
          this.mensaje = "se ha borrado correctamente"
          this.ngOnInit();
        }else
          this.mensaje = "el registro no se ha borrado"
      })
    }
  }

  realizarComunicacion(event: any){
    this.mensaje = ""
    if(event.salida == "OK")
      this.ngOnInit();
  }

  ngOnInit(): void {
    this.roles = []
    this.service.getDatos("http://localhost:8080/once/roles")
    .subscribe((datos: any) => {
      this.roles = datos._embedded.rols;
    })
  }
  modificar(rol: any){
    this.mensaje = ""
    let ruta = rol._links.self.href
    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf('/') + 1))
  }

}
