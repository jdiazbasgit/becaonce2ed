import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ProyectosService } from 'src/app/servicios/proyectos.service';
import { ModalAwardsFineComponent } from '../modal-awards-fine/modal-awards-fine.component';

@Component({
  selector: 'app-awards-fine',
  templateUrl: './awards-fine.component.html',
  styleUrls: ['./awards-fine.component.css']
})

export class AwardsFineComponent implements OnInit {

  @ViewChild(ModalAwardsFineComponent) modal: any
  id: number = 0
  titulo: string;
  descripciones: any[];
  mensaje: string = ""

  @Input() eventoDeHijo: string = ""
  constructor(private service: ProyectosService) {
    this.titulo = "PREMIOS Y MULTAS"
    this.descripciones = [];
  }

  eliminar(id: any) {
    if (confirm("Esta seguro de borrar el tipo de documento")) {
      this.service.delete("http://localhost:8080/once/awardsFines/" + id)
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
    //this.eventoDeHijo = event.salida
    this.mensaje = ""
    if (event.salida === "OK")
      this.ngOnInit();
  }

  ngOnInit(): void {

    this.descripciones = []
    this.service.getDatos("http://localhost:8080/once/awardsFines/")
      .subscribe((datos: any) => {
        this.descripciones = datos._embedded.awardsFines;
      })
  }

  modificar(descripcion: any) {
    this.mensaje = ""
    let ruta = descripcion.links.self.href
    this.modal.id = parseInt(ruta.subscribe(ruta.lastIndexOf("/") + 1))
    console.log(this.id)
  }
}
