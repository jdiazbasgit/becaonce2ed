import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import SubcategoryBean from '../../beans/SubcategoryBean';
import { SubcategoryService } from 'src/app/servicios/subcategories.service';

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
  subcategory: string = ""
  subcategoryPlaceHolder: string = ""
  subcategory_id: string = ""
  categoria: number = 0
  categorias: Array<any>
  @Output() eventoAComunicar = new EventEmitter();

  constructor(private service: SubcategoryService) {
    this.descripcion = "";
    this.subcategory_id = "";
    this.categorias = []
  }

  ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      this.categoria = this.id;
      console.log("id entrada: " + this.id);
      this.service.getDatos("http://localhost:8080/once/subcategories/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true;
          // if (this.descripcion !== datos.description)
          this.subcategoryPlaceHolder = datos.description;
        });

    }
    this.service.getDatos("http://localhost:8080/once/categories")
      .subscribe((datos: any) => {
        this.categorias = datos._embedded.categories
      });
  }

  realizarComunicacion() {
    this.id = 0;
    this.eventoAComunicar.emit({ salida: "OK" });
  }

  grabar() {
    this.fin = false;
    if (this.descripcion.trim() !== "") {
      this.service.saveOrUpdate("http://localhost:8080/once/subcategories",
        new SubcategoryBean(this.id, this.descripcion, "http://localhost:8080/once/categories" + this.categoria))
        .subscribe((dato: boolean) => {
          if (dato) {
            this.mensaje = "Grabación realizada correctamente";
            this.subcategoryPlaceHolder = "";
          } else {
            this.mensaje = "La grabación no se ha realizado";
          }
        });
    } else {
      this.mensaje = "Debes introducir un valor";
    }
  }
}
