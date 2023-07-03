import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { DocumentTypeService } from '../../servicios/document-type.service';
import { ModalDocumentTypesComponent } from '../../componentes/modal-document-types/modal-document-types.component';

@Component({
  selector: 'app-document-types',
  templateUrl: './document-types.component.html',
  styleUrls: ['./document-types.component.css']
})
<<<<<<< HEAD:src/app/componentes/document-types/document-types.component.ts
export class DocumentTypesComponent implements OnInit {
=======
>>>>>>> feature/front/proyectos-tienda-dlg:src/app/ejemplo/ejemplo.component.ts

export class EjemploComponent implements OnInit {
  @ViewChild(ModalDocumentTypesComponent) modal: any
  id: number = 0
  titulo: string;
  descripciones: any[];
  mensaje: string = ""
  @Input() eventoDelHijo: string = ""
  constructor(private service: DocumentTypeService) {
    this.titulo = "DOCUMENTOS DESCRIPCIONES"
    this.descripciones = [];
  }

  eliminar(id: any) {
    if (confirm("¿Esta seguro de borrar el tipo de documento?")) {
      this.service.delete("http://localhost:8080/once/documentsTypes/" + id)
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
    this.mensaje = ""
    if (event.salida === "OK")
      this.ngOnInit();
  }

  ngOnInit(): void {

    this.descripciones = []
    this.service.getDatos("http://localhost:8080/once/documentsTypes")
      .subscribe((datos: any) => {
        this.descripciones = datos._embedded.documentTypes;
      })
  }

  modificar(descripcion: any) {
    this.mensaje = ""
    let ruta = descripcion._links.self.href
    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf("/") + 1))
  }

}
