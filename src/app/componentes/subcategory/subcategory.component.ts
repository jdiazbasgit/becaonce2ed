import { Component, OnInit, ViewChild, Input } from "@angular/core";
import { SubcategoryService } from "src/app/servicios/subcategories.service";
import { ModalSubcategoryComponent } from "../modal-subcategory/modal-subcategory.component";


@Component({
  selector: 'app-subcategory',
  templateUrl: './subcategory.component.html',
  styleUrls: ['./subcategory.component.css']
})
export class SubcategoryComponent implements OnInit {

  @ViewChild(ModalSubcategoryComponent) modal: any
  id: number = 0
  titulo: string;
  subcategories: any[];
  mensaje: string = ""
  @Input() eventoDelHijo: string = ""
  constructor(private service: SubcategoryService) {
    this.titulo = "TIPOS DE SUBCATEGORIAS"
    this.subcategories = [];
  }

  eliminar(id: any) {
    if (confirm("¿Esta seguro de borrar esta subcategoria?")) {
      this.service.delete("http://localhost:8080/once/subcategories/" + id)
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

    this.subcategories = []
    this.service.getDatos("http://localhost:8080/once/subcategories")
      .subscribe((datos: any) => {
        this.subcategories = datos._embedded.subCategories;
      })
  }

  modificar(subcategory: any) {
    this.mensaje = ""
    let ruta = subcategory._links.self.href
    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf("/") + 1))
    // console.log(this.id )

  }

}
