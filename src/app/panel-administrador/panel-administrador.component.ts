import { Component } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';

@Component({
  selector: 'app-panel-administrador',
  templateUrl: './panel-administrador.component.html',
  styleUrls: ['./panel-administrador.component.css']
})
export class PanelAdministradorComponent {

  tablaAConsultar: string = ''
  mostrarTabla: boolean = false

  constructor(private service: ProyectosService) {

  }

  elegirTabla(nombre: string) {
    this.tablaAConsultar = nombre
    this.mostrarTabla = true
    console.log("Sacando Fees con token: " + sessionStorage['token'])
    this.service.getDatos("http://localhost:8080/once/" + nombre)
      .subscribe({
        next: (response) => {
          console.log("status ok:" + response.status)
          console.log(response)
          response._embedded.fees.forEach((element: any) => {
            console.log(element.current)
          });
        },
        error: (error: any) => {
          console.log("status ko:" + error.status)
        }
      })
  }
}
