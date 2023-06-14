import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import CategoryBean from '../../beans/CategoryBean'
import { CategoryService } from '../../servicios/category.service';

@Component({
  selector: 'app-modal-category',
  templateUrl: './modal-category.component.html',
  styleUrls: ['./modal-category.component.css']
})
export class ModalCategoryComponent implements DoCheck {
  id: number = 0
  descripcion: string
  mensaje: string = "";
  fin: boolean = false
  category:string=""
  categoryPlaceHolder:string=""
  @Output() eventoAComunicar=new EventEmitter();
  constructor(private service: CategoryService) {
    this.descripcion = "";
  }
 
  
  ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/categories/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true
          //  if (this.descripcion !== datos.description)
            this.categoryPlaceHolder= datos.description;
          
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
      this.service.saveOrUpdate("http://localhost:8080/once/categories", new CategoryBean(this.id, this.descripcion))
        .subscribe((dato: boolean) => {
          if (dato) {
            this.mensaje = "Grabacion realizada correctamente"
            this.categoryPlaceHolder = ""
          }
          else
            this.mensaje = "La grabación no se ha realizado"
        })
    }
    else
      this.mensaje = "Debes introducir un valor"
  }

}
