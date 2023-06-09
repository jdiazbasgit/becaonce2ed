import { AfterContentChecked, Component, DoCheck, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { DocumentTypeService } from '../../servicios/document-type.service';
import DocumentTypeBean from '../../beans/DocumentTypeBean'
@Component({
  selector: 'app-modal-document-types',
  templateUrl: './modal-document-types.component.html',
  styleUrls: ['./modal-document-types.component.css']
})
export class ModalDocumentTypesComponent implements DoCheck {
  id: number = 0
  descripcion: string
  mensaje: string = "";
  fin: boolean = false
  descripcionPlaceHolder:string=""
  @Output() eventoAComunicar=new EventEmitter();
  constructor(private service: DocumentTypeService) {
    this.descripcion = "";
  }
 
  
  ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/documentsTypes/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true
          //  if (this.descripcion !== datos.description)
            this.descripcionPlaceHolder= datos.description;
          
        })
    }
  }

  realizarComunicacion(){
    this.id=0;
    this.eventoAComunicar.emit({salida:"OK"})
  }

  grabar() {
    this.fin = false;
    if (this.descripcion.trim() !== "") {
      this.service.saveOrUpdate("http://localhost:8080/once/documentsTypes", new DocumentTypeBean(this.id, this.descripcion))
        .subscribe((dato: boolean) => {
          if (dato) {
            this.mensaje = "Grabacion realizada correctamente"
            this.descripcion = ""
          }
          else
            this.mensaje = "La grabación no se ha realizado"
        })
    }
    else
      this.mensaje = "Debes introducir un valor"
  }

}
