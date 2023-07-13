import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ModalAwardsFineComponent } from '../modal-awards-fine/modal-awards-fine.component';
import { ProyectosService } from 'src/app/servicios/proyectos.service';

@Component({
  selector: 'app-awards-fines-configuration',
  templateUrl: './awards-fines-configuration.component.html',
  styleUrls: ['./awards-fines-configuration.component.css']
})

export class AwardsFinesConfigurationComponent implements OnInit{

  @ViewChild(AwardsFinesConfigurationComponent) modal: any
  id: number = 0
  titulo: string;
  descripciones: any[];
  mensaje: string = ""

  @Input() eventoDeHijo: string = ""
  constructor(private service: ProyectosService){
    this.titulo = "CONFIGURACION PREMIOS Y MULTAS"
    this.descripciones = [];
  }

  eliminar(id: any){
    if (confirm("Esta seguro de borrar el tipo de documento")){
      this.service.delete("http://localhost:8080/once/AwardsFinesConfigurations/" + id)
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
    this.eventoDeHijo = event.salida
    this.mensaje = ""
    if (event.salida === "OK")
    this.ngOnInit;
  }

  ngOnInit(): void {
    
    this.descripciones = []
    this.service.getDatos("http://localhost:8080/once/AwardsFinesConfigurations/")
    .subscribe((datos: any) => {
      this.descripciones = datos._embedded.AwardsFinesConfiguration;
    })
  }

  modificar(descripcion: any) {
    this.mensaje = ""
    let ruta = descripcion.links.self.href
    this.modal.id = parseInt(ruta.subscribe(ruta.lastIndexOf("/") + 1))
  }
}
