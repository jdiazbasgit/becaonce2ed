import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import CategoryBean from '../../beans/SubcategoryBean'
import { CategoryService } from '../../servicios/subcategory.service';

@Component({
  selector: 'app-modal-subcategory',
  templateUrl: './modal-subcategory.component.html',
  styleUrls: ['./modal-subcategory.component.css']
})
export class ModalSubcategoryComponent implements DoCheck {
  id: number = 0
  descripcion: string
  mensaje: string = "";
  fin: boolean = false
  subcategory:string=""
  subcategoryPlaceHolder:string=""
  @Output() eventoAComunicar=new EventEmitter();
  constructor(private service: SubcategoryService) {
    this.descripcion = "";
  }
 
  
  ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/category/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true
          //  if (this.descripcion !== datos.description)
            this.subcategoryPlaceHolder= datos.description;
          
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
      this.service.saveOrUpdate("http://localhost:8080/once/category", new SubcategoryBean(this.id, this.descripcion))
        .subscribe((dato: boolean) => {
          if (dato) {
            this.mensaje = "Grabacion realizada correctamente"
            this.subcategoryPlaceHolder = ""
          }
          else
            this.mensaje = "La grabación no se ha realizado"
        })
    }
    else
      this.mensaje = "Debes introducir un valor"
  }

}
