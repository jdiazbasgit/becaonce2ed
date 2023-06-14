import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { CategoryService } from '../../servicios/category.service';
import { ModalCategoryComponent } from '../modal-category/modal-category.component';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  @ViewChild(ModalCategoryComponent) modal: any
  id: number = 0
  titulo: string;
  categories: any[];
  mensaje: string = ""
  @Input() eventoDelHijo: string = ""
  constructor(private service: CategoryService) {
    this.titulo = "TIPOS DE CATEGORIAS"
    this.categories = [];
  }

  eliminar(id: any) {
    if (confirm("¿Esta seguro de borrar esta categoria?")) {
      this.service.delete("http://localhost:8080/once/categories/" + id)
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
    //this.eventoDelHijo=event.salida
    this.mensaje = ""
    if (event.salida === "OK")
      this.ngOnInit();
  }

  ngOnInit(): void {

    this.categories = []
    this.service.getDatos("http://localhost:8080/once/categories")
      .subscribe((datos: any) => {
        this.categories = datos._embedded.categories;
      })
  }

  modificar(category: any) {
    this.mensaje = ""
    let ruta = category._links.self.href
    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf("/") + 1))
    // console.log(this.id )

  }

}
