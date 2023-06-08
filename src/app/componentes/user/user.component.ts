import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ModalUserComponent } from '../modal-user/modal-user.component';
import { UserService } from 'src/app/servicios/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  @ViewChild(ModalUserComponent) modal: any
  id: number = 0
  titulo: string;
  descripciones: any[];
  mensaje: string = ""
  @Input() eventoDelHijo: string = ""
  constructor(private service: UserService) {
    this.titulo = "TIPOS DE DESCRIPCIONES"
    this.descripciones = [];
  }

  eliminar(id: any) {
    if (confirm("¿Esta seguro de borrar el tipo de documento?")) {
      this.service.delete("http://localhost:8080/once/users/" + id)
        .subscribe((dato: boolean) => {
          if (!dato) {
            this.mensaje = "Se ha borrado correctamente"
            this.ngOnInit();
          }
          else
            this.mensaje = "El registro no se ha borrado"
        })
    }
  }


  realizarComunicacion(event: any) {
    //this.eventoDelHijo=event.salida
    this.mensaje = ""
    if (event.salida === "OK")
      this.ngOnInit();
  }

  ngOnInit(): void {

    this.descripciones = []
    this.service.getDatos("http://localhost:8080/once/users")
      .subscribe((datos: any) => {
        this.descripciones =datos._embedded.users;
      })
  }

  modificar(descripcion: any) {
    this.mensaje = ""
    let ruta = descripcion._links.self.href
    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf("/") + 1))
    // console.log(this.id )

  }

}
