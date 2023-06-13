import { Component, ElementRef } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import { Observable, concat, concatMap, delay, forkJoin } from 'rxjs';

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

  propiedadesLocales: string[] = []
  linksForaneos: string[] = []
  linksForaneosTabla: string[] = []
  //jsonParaEnviar: any[] = []
  mostrarGrabador: boolean = false
  datosDeUnaSolaLinea: string[] = []
  nuevaEntrada: boolean = false
  url: string = "http://localhost:8080/once/"
  mappingNombres: string[] = []
  linkForaneoAka: string[] = []


  constructor(private service: ProyectosService, private elementRef: ElementRef) {

  }

  consultarTabla(nombre: string) {
    this.datosBrutos = []
    this.mappingNombres = []
    this.linksForaneosTabla = []
    this.tablaAConsultar = nombre
    this.mostrarTabla = true
    this.service.getDatos(this.url + nombre)
      .subscribe({
        next: (response) => {
          console.log("status ok:" + response.subscribeStatus)
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


          let unaVuelta: boolean = true
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
                console.log("cucuuuuu " + idLink)
                console.log("cucuuuuu " + hrefLink)
                filaDatos.push(idLink)
                if (unaVuelta) {
                  let enPartes = hrefLink.split("/");
                  this.linksForaneosTabla.push(enPartes[enPartes.length - 2])
                }

              }
            });
            unaVuelta = false
            this.datosBrutos.push(filaDatos)
          }
          console.log(this.datosBrutos)

          cabeceras.unshift("id")
          cabeceras.splice(cabeceras.length - 1) // aka sin _links
          console.log(cabeceras)

          this.propiedadesLocales = cabeceras
          this.linksForaneos = links

          links.forEach((link: string) => {
            if (link !== "self") {
              cabeceras.push(link)
              console.log("cucuuuuu " + link)
              this.mappingNombres.push(link)
            }

          })

          if (this.mappingNombres.length >= 1) {
            this.service.getDatos(this.url + "mappingFKDescriptions").pipe(delay(1000))
              .subscribe({
                next: (mapping) => {
                  console.log("status ok:" + mapping.status)
                  console.log(mapping)

                  mapping.forEach((mapped: any) => {
                    if (this.linksForaneosTabla.includes(mapped.table)) {

                      console.log(mapped.table)
                      this.service.getDatos(this.url + mapped.table).pipe(delay(1000))
                        .subscribe({
                          next: (t) => {
                            this.linkForaneoAka.push(t._embedded[mapped.table])
                            //console.log(t._embedded.users[0])
                            //console.log(table[mapped.description])
                            console.log(this.linkForaneoAka + "guayy1")
                          }
                        })
                      console.log(this.linkForaneoAka + "guayy2")
                    }



                    //this.mappingNombres.push(mapped)
                  });

                  this.mappingNombres.forEach((mn: any) => {
                    console.log("guuuuu " + mn)
                  })
                  this.linkForaneoAka.forEach((lfk: any) => {
                    console.log(lfk)
                  }) 
                }
              })
          }




          this.cabecerasTabla = cabeceras
          console.log(cabeceras)


          response._embedded[tablas[0]].forEach((element: any) => {
            console.log(element)
          });
          this.mostrarGrabador = true

          //**

          //**
        },
        error: (error: any) => {
          console.log("status ko:" + error.status)
        }
      })
  }




  /*ejemplo*/
  fetchData(nombre: string) {
    this.datosBrutos = []
    this.mappingNombres = []
    this.linksForaneosTabla = []
    this.tablaAConsultar = nombre
    this.mostrarTabla = true


    this.service.getDatos(this.url + nombre)
      .pipe(
        concatMap((response: any) => {
          console.log("status ok:" + response.subscribeStatus)
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

          let unaVuelta: boolean = true

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
                console.log("cucuuuuu " + idLink)
                console.log("cucuuuuu " + hrefLink)
                filaDatos.push(idLink)
                if (unaVuelta) {
                  let enPartes = hrefLink.split("/");
                  this.linksForaneosTabla.push(enPartes[enPartes.length - 2])
                }

              }
            });
            unaVuelta = false
            this.datosBrutos.push(filaDatos)
          }
          console.log(this.datosBrutos)

          cabeceras.unshift("id")
          cabeceras.splice(cabeceras.length - 1) // aka sin _links
          console.log(cabeceras)

          this.propiedadesLocales = cabeceras
          this.linksForaneos = links

          links.forEach((link: string) => {
            if (link !== "self") {
              cabeceras.push(link)
              console.log("cucuuuuu " + link)
              this.mappingNombres.push(link)
            }

          })
          this.cabecerasTabla = cabeceras
          console.log(cabeceras)
          // if (this.mappingNombres.length >= 1) {
          // }
          const observables: any = this.service.getDatos(this.url + "mappingFKDescriptions")

          return forkJoin(observables);

        }),
        concatMap((response2: any) => {
          const observables: any = response2.map((fk: string) => {
            this.service.getDatos(this.url + "mappingFKDescriptions")
            console.log(fk)
          }
          )

          return forkJoin(observables);
        }),
        concatMap((response3: any) => {
          const observables: any = response3.map((mapped: any) => {
            if (this.linksForaneosTabla.includes(mapped.table)) {
              console.log(mapped.table)
              this.service.getDatos(this.url + mapped.table)
                .subscribe({
                  next: (t) => {
                    this.linkForaneoAka.push(t._embedded[mapped.table])
                    console.log(t._embedded.users[0])
                    //console.log(table[mapped.description])
                  },
                })
              console.log(this.linkForaneoAka + "guayy")
            }
          }
          )

          return forkJoin(observables);
        })
      )
      .subscribe((datos: any) => {
        //countries = capitals;
        //console.log(datos)
        //console.log(this.linksForaneosTabla)
        // datos.forEach((mapped: any) => {
        //   if (this.linksForaneosTabla.includes(mapped.table)) {

        //     console.log(mapped.table)
        //     this.service.getDatos(this.url + mapped.table)
        //       .subscribe({
        //         next: (t) => {
        //           this.linkForaneoAka.push(t._embedded[mapped.table])
        //           console.log(t._embedded.users[0])
        //           //console.log(table[mapped.description])
        //         },
        //       })
        //     console.log(this.linkForaneoAka + "guayy")
        //   }



        //   //this.mappingNombres.push(mapped)
        // });

        // this.mappingNombres.forEach((mn: any) => {
        //   console.log("guuuuu " + mn)
        // })
      })
  }


  grabarEntrada() {
    // console.log(this.datosBrutos[0])
    // this.datosBrutos[0][0] = 0
    // this.datosBrutos[0][1] = 0.7
    // console.log(this.datosBrutos[0])
    let inputsGrabar: string[] = []
    console.log(this.propiedadesLocales)
    console.log(this.cabecerasTabla)
    console.log(this.linksForaneos)
    for (let index = 0; index < this.cabecerasTabla.length; index++) {
      if (index < this.propiedadesLocales.length - this.linksForaneos.length + 1) {
        inputsGrabar.push(this.elementRef.nativeElement.querySelector('#input' + index).value)
      }
      else
        inputsGrabar.push(this.cabecerasTabla[index] + "/" + this.elementRef.nativeElement.querySelector('#input' + index).value)
    }
    //this.elementRef.nativeElement.querySelector('#input')
    console.log(inputsGrabar)


    // var z = this.construirJson(this.cabecerasTabla, this.datosBrutos[0]);
    let jsonParaEnviar = this.construirJson(this.cabecerasTabla, inputsGrabar);
    //var json = JSON.stringify(z);

    console.log(jsonParaEnviar);
    // z.id = 0
    // z.current = 0.50
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
    this.service.saveOrUpdate(this.url + this.tablaAConsultar, jsonParaEnviar)
      .subscribe((dato: boolean) => {
        if (dato) {
          console.log("Grabacion realizada correctamente")
        }
        else
          console.log("La grabación no se ha realizado")
        this.consultarTabla(this.tablaAConsultar)
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

  cargarDatosDeLinea(numero: number, nuevo: boolean) {
    if (nuevo) {
      this.nuevaEntrada = true
      this.datosDeUnaSolaLinea = []
    }
    else {
      this.datosDeUnaSolaLinea = this.datosBrutos[numero]
      this.nuevaEntrada = false
    }
  }

  borrarLinea(id: number) {
    console.log(this.datosBrutos[id][0])
    if (confirm("¿Esta seguro de borrar el tipo de documento?")) {
      this.service.delete(this.url + this.tablaAConsultar + "/" + this.datosBrutos[id][0])
        .subscribe((dato: boolean) => {
          console.log(dato)
          if (!dato) {
            this.consultarTabla(this.tablaAConsultar)
            alert("borrado")
          }
          else
            alert("no borrado")
        })
    }
  }
}
