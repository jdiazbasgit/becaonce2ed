import { Component } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import Fee from '../beans/Fee';

@Component({
  selector: 'app-panel-administrador',
  templateUrl: './panel-administrador.component.html',
  styleUrls: ['./panel-administrador.component.css']
})
export class PanelAdministradorComponent {

  tablaAConsultar: string = ''
  mostrarTabla: boolean = false
  cabecerasTabla: string[] = []
  datosBrutos: any[] = []
  jsonParaEnviar: any[] = []


  constructor(private service: ProyectosService) {

  }

  consultarTabla(nombre: string) {
    this.datosBrutos = []
    this.tablaAConsultar = nombre
    this.mostrarTabla = true
    console.log("Sacando Fees con token: " + sessionStorage['token'])
    this.service.getDatos("http://localhost:8080/once/" + nombre)
      .subscribe({
        next: (response) => {
          console.log("status ok:" + response.status)
          console.log(response)

          let tablas = Object.keys(response._embedded) //aka profiles
          let cabeceras = Object.keys(response._embedded[tablas[0]][0]) //aka profiles[0]
          let tamanoDatos = Object.keys(response._embedded[tablas[0]]).length //aka profiles 0,1,2,3...
          //cabeceras.unshift("id")
          console.log(cabeceras)
          console.log(tamanoDatos)
          // tablas.forEach(tabla => {
          //   cabeceras.push(" " + response[0].currencies[tabla].name)
          // })
          let links = Object.keys(response._embedded[tablas[0]][0]._links)
          console.log(links)



          for (let index = 0; index < tamanoDatos; index++) {
            let linkself = response._embedded[tablas[0]][index]._links.self.href
            let id = parseInt(linkself.substring(linkself.lastIndexOf("/") + 1))
            let filaDatos: any = []
            filaDatos.push(id)
            cabeceras.forEach(cabecera => {
              if (cabecera !== "_links")
                filaDatos.push(response._embedded[tablas[0]][index][cabecera])
            });
            links.forEach(linkForaneo => {
              if (linkForaneo !== "self") {
                //console.log(response._embedded[tablas[0]][index]._links[linkForaneo])
                let hrefLink = response._embedded[tablas[0]][index]._links[linkForaneo].href
                let idLink = parseInt(hrefLink.substring(hrefLink.lastIndexOf("/") + 1))
                filaDatos.push(idLink)
              }
            });

            this.datosBrutos.push(filaDatos)
          }
          console.log(this.datosBrutos)

          cabeceras.unshift("id")
          cabeceras.splice(cabeceras.length - 1) // aka sin _links
          console.log(cabeceras)

          links.forEach((link: string) => {
            if (link !== "self")
              cabeceras.push(link)
          })

          this.cabecerasTabla = cabeceras
          console.log(cabeceras)


          response._embedded[tablas[0]].forEach((element: any) => {
            console.log(element)
          });
        },
        error: (error: any) => {
          console.log("status ko:" + error.status)
        }
      })
  }

  duplicarUltimoDato() {
    // console.log(this.datosBrutos[0])
    // this.datosBrutos[0][0] = 0
    // this.datosBrutos[0][1] = 0.7
    // console.log(this.datosBrutos[0])

    var z = this.construirJson(this.cabecerasTabla, this.datosBrutos[0]);

    //var json = JSON.stringify(z);

    console.log(z);
    z.id = 0
    z.current = 0.50
    //console.log(json);
    // console.log(this.cabecerasTabla[0])
    // console.log(this.cabecerasTabla)

    // for (let index = 0; index < this.cabecerasTabla.length; index++) {
    //   jsonable = jsonable + this.cabecerasTabla[index] + ":" + this.datosBrutos[index]

    // }
    // let pulido: JSON = JSON.parse('{"id": "0", "current": "0.91"}')
    // this.datosBrutos[0].forEach((element: any) => {
    //   pulido.push(element)
    // });
    //pulido = {"id": "0", "current": "0.98"}
    // console.log(pulido)
    this.service.saveOrUpdate("http://localhost:8080/once/fees", z)
      .subscribe((dato: boolean) => {
        if (dato) {
          console.log("Grabacion realizada correctamente")
        }
        else
          console.log("La grabación no se ha realizado")
      })
  }


  construirJson(claves: string[], valores: any[]): any {
    let objeto: any = {};    
    for (let i = 0; i < claves.length; i++) {
      let clave = claves[i];
      let valor = valores[i];
      objeto[clave] = valor;
    }    
    return objeto;
  }
}
