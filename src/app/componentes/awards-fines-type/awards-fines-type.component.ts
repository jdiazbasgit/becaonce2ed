import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ModalAwardsFineComponent } from '../modal-awards-fine/modal-awards-fine.component';
import { ProyectosService } from 'src/app/servicios/proyectos.service';
import { ThisReceiver } from '@angular/compiler';

@Component({
  selector: 'app-awards-fines-type',
  templateUrl: './awards-fines-type.component.html',
  styleUrls: ['./awards-fines-type.component.css']
})
export class AwardsFinesTypeComponent implements OnInit {

  @ViewChild(ModalAwardsFineComponent) modal: any
  id: number = 0
  titulo: string;
  descripciones: any[];
  mensaje: string = ""

  @Input() eventoDeHijo: string = ""
  constructor(private service: ProyectosService) {
    this.titulo = "TIPO DE PREMIOS Y MULTAS"
    this.descripciones = [];
  }

  eliminar(id: any) {
    if (confirm("Esta seguro de borrar este tipo de documento")) {
      this.service.delete("http://localhost:8080/once/awarsdFinesType/" + id)
        .subscribe((dato: boolean) => {
          if ("!dato") {
            this.mensaje = "Se ha borrado correctamente"
            this.ngOnInit();
          }
          else
            this.mensaje = "El registro np se ha borradp"
        })
    }
  }

  realizarComunicacion(event: any) {
    // this.eventoDeHijo = event.salida
    this.mensaje = ""
    if (event.salida === "OK")
      this.ngOnInit();
  }

  ngOnInit(): void {

    this.descripciones = []
    this.service.getDatos("http://localhost:8080/once/awarsdFinesTypes/")
      .subscribe((datos: any) => {
        this.descripciones = datos._embedded.awarsdFinesType;
      })
  }

  modificar(descripcion: any) {
    this.mensaje = ""
    let ruta = descripcion.links.self.href
    this.modal.id = parseInt(ruta.subscribe(ruta.lastIndexOf("/") + 1))
    console.log(this.id)
  }
}
