import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ConfigurationService } from 'src/app/servicios/configuration.service';
import { ModalConfigurationComponent } from '../modal-configuration/modal-configuration.component';

@Component({
  selector: 'app-configuration',
  templateUrl: './configuration.component.html'
})

export class ConfigurationComponent implements OnInit {

  @ViewChild(ModalConfigurationComponent) modal: any
  id: number = 0
  titulo: string;
  alarmados: any[];
  contador: number = 0;
  mensaje: string = ""
  mensajeAlta: string = ""
  @Input() eventoDelHijo: string = ""
  constructor(private service: ConfigurationService) {
    this.titulo = "CONFIGURACION - STOCK"
    this.alarmados = [];
  }

  eliminar(id: any) {
    if (confirm("¿Esta seguro de borrar alarma de stock?")) {
      this.service.delete("http://localhost:8080/once/configurations/" + id)
        .subscribe((dato: boolean) => {
          if (dato) {
            this.mensaje = "Se ha borrado correctamente"
            this.ngOnInit();
          }
          else
            this.mensaje = "El registro no se ha borrado"
        })
    }
  }

  realizarComunicacion(event: any) {
    this.mensaje = ""
    if (event.salida === "OK")
      this.ngOnInit();
  }

  ngOnInit(): void {
    this.alarmados = []
    
    this.service.getDatos("http://localhost:8080/once/configurations")
      .subscribe((datos: any) => {
        this.alarmados = datos._embedded.configurations;
      })

    this.service.getDatos("http://localhost:8080/once/configurations/count")
      .subscribe((contador: number) => {
        this.contador = contador;
        if (contador>0) {
          this.mensajeAlta = "Botón DESACTIVADO"
        }
        else
          this.mensajeAlta = "Botón ACTIVADO"
      })
  }

  modificar(alarmaStock: any) {
    this.mensaje = ""
    let ruta = alarmaStock._links.self.href
    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf("/") + 1))
  }

}
