import { Component, ElementRef } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import { Observable, ObservableInput, concat, concatMap, delay, finalize, forkJoin, map } from 'rxjs';
import { tick } from '@angular/core/testing';

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
  selectsIdyDescr: any[] = []
  jsonForaneas: { [key: string]: any } = {}
  //grupoIdyDescripciones: string[] = []
  mostrarLoading: boolean = false


  constructor(private service: ProyectosService, private elementRef: ElementRef) {

  }
  activarTabla() {
    this.mostrarTabla = true
  }


  consultarTabla(nombre: string) {
    this.datosBrutos = []
    this.mappingNombres = []
    this.linksForaneosTabla = []
    this.linkForaneoAka = []
    this.tablaAConsultar = nombre
    this.mostrarTabla = false
    this.mostrarGrabador = false
    this.mostrarLoading = true
    this.selectsIdyDescr = []
    this.jsonForaneas = {}
    this.service.getDatos(this.url + nombre)
      .subscribe({
        next: (response) => {
          let tablas = Object.keys(response._embedded)
          let cabeceras = Object.keys(response._embedded[tablas[0]][0])
          let tamanoDatos = Object.keys(response._embedded[tablas[0]]).length
          let links = Object.keys(response._embedded[tablas[0]][0]._links)
          let unaVuelta: boolean = true
          for (let index = 0; index < tamanoDatos; index++) {
            let linkself = response._embedded[tablas[0]][index]._links.self.href
            let id = parseInt(linkself.substring(linkself.lastIndexOf("/") + 1))
            let filaDatos: any = []
            filaDatos.push(id)
            cabeceras.forEach(cabecera => {
              if (cabecera !== "_links")
                filaDatos.push(response._embedded[tablas[0]][index][cabecera])
            })
            links.forEach(linkForaneo => {
              if (linkForaneo !== "self") {
                let hrefLink = response._embedded[tablas[0]][index]._links[linkForaneo].href
                let idLink = parseInt(hrefLink.substring(hrefLink.lastIndexOf("/") + 1))
                filaDatos.push(idLink)
                if (unaVuelta) {
                  let enPartes = hrefLink.split("/");                  
                  if (enPartes[enPartes.length - 2] !== nombre)
                    this.linksForaneosTabla.push(enPartes[enPartes.length - 2])
                }
              }
            })
            unaVuelta = false
            this.datosBrutos.push(filaDatos)
          }
          cabeceras.unshift("id")
          cabeceras.splice(cabeceras.length - 1)
          this.propiedadesLocales = cabeceras
          this.linksForaneos = links
          links.forEach((link: string) => {
            if (link !== "self") {
              cabeceras.push(link)
              this.mappingNombres.push(link)
            }
          })
          this.cabecerasTabla = cabeceras
          if (this.mappingNombres.length >= 1) {
            this.service.getDatos(this.url + "mappingFKDescriptions")
              .subscribe({
                next: (mapping) => {
                  let i: number = 0
                  let observablesMapping: Observable<any>[] = []
                  mapping.forEach((mapped: any) => {
                    if (this.linksForaneosTabla.includes(mapped.table)) {
                      this.jsonForaneas[mapped.table] = []
                      i++

                      console.log(this.linksForaneosTabla)
                      let observable = this.service.getDatos(this.url + mapped.table)
                      observablesMapping.push(
                        observable.pipe(
                          map((tablaForaneaCompleta) => {
                            let entradaIdyDescricion: string[] = [];
                            let grupoIdyDescripciones: any = [];
                            let embeddedNext = Object.keys(tablaForaneaCompleta._embedded);
  
                            tablaForaneaCompleta._embedded[embeddedNext[0]].forEach((fila: any) => {
                              let lineaId = fila._links.self.href
                              let numeroId: string = lineaId.substring(lineaId.lastIndexOf("/") + 1)
                              entradaIdyDescricion.push(numeroId)
                              entradaIdyDescricion.push(fila[(mapped.description).toLowerCase()])
                              grupoIdyDescripciones.push(entradaIdyDescricion)
                              entradaIdyDescricion = []
                            });
  
                            this.jsonForaneas[mapped.table] = [grupoIdyDescripciones];
                          })
                        )
                      )                      
                    }
                  })
                  forkJoin(observablesMapping).subscribe(() => {
                  console.log(this.jsonForaneas);
                  this.mostrarTabla = true
                  this.mostrarGrabador = true
                  this.mostrarLoading = false
                })
                }
              })
          }
          else{
            this.mostrarTabla = true
            this.mostrarGrabador = true
            this.mostrarLoading = false
          }          
        },
        error: (error: any) => {
          console.log("status ko:" + error.status)
        }
      })
  }


  consultarTablaSincrona(nombre: string) {
    this.datosBrutos = []
    this.mappingNombres = []
    this.linksForaneosTabla = []
    this.linkForaneoAka = []
    this.tablaAConsultar = nombre
    this.mostrarTabla = false
    this.selectsIdyDescr = []
    this.jsonForaneas = {}
    //this.grupoIdyDescripciones = []
    this.service.getDatos(this.url + nombre)
      .subscribe({
        next: (response) => {
          //console.log("status ok:" + response.subscribeStatus)
          //console.log(response)

          let tablas = Object.keys(response._embedded) //aka profiles
          let cabeceras = Object.keys(response._embedded[tablas[0]][0]) //aka profiles[0]
          let tamanoDatos = Object.keys(response._embedded[tablas[0]]).length //aka profiles 0,1,2,3...
          //cabeceras.unshift("id")
          //console.log(cabeceras)
          //console.log(tamanoDatos)
          // tablas.forEach(tabla => {
          //   cabeceras.push(" " + response[0].currencies[tabla].name)
          // })
          let links = Object.keys(response._embedded[tablas[0]][0]._links)
          //console.log(links)


          let unaVuelta: boolean = true
          for (let index = 0; index < tamanoDatos; index++) {
            let linkself = response._embedded[tablas[0]][index]._links.self.href
            let id = parseInt(linkself.substring(linkself.lastIndexOf("/") + 1))
            let filaDatos: any = []
            filaDatos.push(id)
            cabeceras.forEach(cabecera => {
              if (cabecera !== "_links")
                filaDatos.push(response._embedded[tablas[0]][index][cabecera])
            })
            links.forEach(linkForaneo => {
              if (linkForaneo !== "self") {
                //console.log(response._embedded[tablas[0]][index]._links[linkForaneo])
                let hrefLink = response._embedded[tablas[0]][index]._links[linkForaneo].href
                let idLink = parseInt(hrefLink.substring(hrefLink.lastIndexOf("/") + 1))
                //console.log("cucuuuuu " + idLink)
                //console.log("cucuuuuu " + hrefLink)
                filaDatos.push(idLink)
                if (unaVuelta) {
                  let enPartes = hrefLink.split("/");
                  if (enPartes[enPartes.length - 2] !== nombre)
                    this.linksForaneosTabla.push(enPartes[enPartes.length - 2])
                }

              }
            })
            unaVuelta = false
            this.datosBrutos.push(filaDatos)
          }
          //console.log(this.datosBrutos)
          //console.log(this.linksForaneosTabla)

          cabeceras.unshift("id")
          cabeceras.splice(cabeceras.length - 1) // aka sin _links
          //console.log(cabeceras)

          this.propiedadesLocales = cabeceras
          this.linksForaneos = links

          links.forEach((link: string) => {
            if (link !== "self") {
              cabeceras.push(link)
              this.mappingNombres.push(link)
            }

          })
          //console.log(this.mappingNombres)
          this.cabecerasTabla = cabeceras
          //console.log(cabeceras)
          //console.log("ATENCION" + this.mappingNombres)

          if (this.mappingNombres.length >= 1) {
            this.service.getDatos(this.url + "mappingFKDescriptions").pipe(delay(0))
              .subscribe({
                next: (mapping) => {
                  //console.log("status ok:" + mapping.status)
                  //console.log("tablamappings: "+mapping)               
                  //let jsonForaneas: { [key: string]: any } = {}


                  let i: number = 0
                  mapping.forEach((mapped: any, index: number) => {
                    // console.log(this.linksForaneosTabla)
                    // console.log(mapped.table)
                    // console.log(this.cabecerasTabla)
                    // console.log(this.mappingNombres[index])
                    // console.log(index)
                    if (this.linksForaneosTabla.includes(mapped.table)) {
                      this.jsonForaneas[mapped.table] = []

                      // console.log(this.cabecerasTabla)
                      // console.log(indiceEnCabecera)
                      // console.log(this.mappingNombres[index])
                      // console.log(this.datosBrutos)
                      i++
                      //console.log(this.datosBrutos[index][indiceEnCabecera])

                      //
                      this.service.getDatos(this.url + mapped.table).subscribe({
                        next: (tablaForaneaCompleta) => {
                          //console.log(tablaForaneaCompleta)
                          let entradaIdyDescricion: string[] = []
                          let grupoIdyDescripciones: any = []
                          //console.log(mapped.table)
                          let embeddedNext = Object.keys(tablaForaneaCompleta._embedded)
                          //console.log(embeddedNext)
                          //console.log(tablaForaneaCompleta._embedded[embeddedNext[0]])
                          tablaForaneaCompleta._embedded[embeddedNext[0]].forEach((fila: any) => {
                            let lineaId = fila._links.self.href
                            let numeroId: string = lineaId.substring(lineaId.lastIndexOf("/") + 1)
                            entradaIdyDescricion.push(numeroId)
                            entradaIdyDescricion.push(fila[(mapped.description).toLowerCase()])
                            grupoIdyDescripciones.push(entradaIdyDescricion)
                            entradaIdyDescricion = []

                            // this.jsonForaneas[mapped.table] = [grupoIdyDescripciones]
                            // this.linksForaneosTabla.forEach(link => {
                            //   this.selectsIdyDescr.push(this.jsonForaneas[link][0])
                            // })
                          })
                          //this.selectsIdyDescr.push(grupoIdyDescripciones)


                          this.jsonForaneas[mapped.table] = [grupoIdyDescripciones]
                          // this.linksForaneosTabla.forEach(link => {
                          //   this.selectsIdyDescr.push(this.jsonForaneas[link][0])
                          // })
                          //console.log(this.selectsIdyDescr)
                          //console.log(this.jsonForaneas)


                          // entradaIdyDescricion = []
                          // grupoIdyDescripciones = []
                          // this.jsonForaneas[mapped.table][0].forEach((linea: any) => {
                          //   entradaIdyDescricion.push(linea[0])
                          //   entradaIdyDescricion.push(linea[1])
                          //   grupoIdyDescripciones.push(entradaIdyDescricion)                            
                          // })
                          // this.selectsIdyDescr.push(grupoIdyDescripciones)
                        }

                      })

                      // this.jsonForaneas[mapped.table] = [this.grupoIdyDescripciones]
                      // this.linksForaneosTabla.forEach(link => {
                      //   this.selectsIdyDescr.push(this.jsonForaneas[link][0])
                      // }) 
                      // console.log(this.selectsIdyDescr)

                      //*******Cambia el dato resuelto directamente en el array de datosBrutos*********//

                      /*
                      let indiceEnCabecera = this.cabecerasTabla.indexOf(this.mappingNombres[i])
                      this.datosBrutos.forEach((dato: any, index2: number) => {
                        this.service.getDatos(this.url + mapped.table + "/" + dato[indiceEnCabecera]).pipe(delay(0))
                          .subscribe({
                            next: (datosAMostrar) => {                              
                              this.datosBrutos[index2][indiceEnCabecera] = datosAMostrar[(mapped.description).toLowerCase()]
                            }
                          })
                      })
                      */
                      //*************************************************************************** */

                      //console.log(this.linkForaneoAka)
                    }



                    //this.mappingNombres.push(mapped)
                  })
                  //console.log(this.selectsIdyDescr)
                  console.log(this.jsonForaneas)

                  // this.mappingNombres.forEach((mn: any) => {
                  //   //console.log("guuuuu " + mn)
                  // })
                  // this.linkForaneoAka.forEach((lfk: any) => {
                  //   console.log("link: " + lfk)
                  // })
                }
              })
          }





          // response._embedded[tablas[0]].forEach((element: any) => {
          //   console.log(element)
          // });
          this.mostrarGrabador = true

          //**

          //**
        },
        error: (error: any) => {
          console.log("status ko:" + error.status)
        }
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
      let inputsALimpiar = this.elementRef.nativeElement.getElementsByTagName("input")
      for (let index = 0; index < inputsALimpiar.length; index++) {
        inputsALimpiar[index].value = ""
      }
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
