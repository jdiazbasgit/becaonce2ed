import { Component, OnInit, ViewChild, Input } from "@angular/core";
import { SubcategoryService } from "src/app/servicios/subcategories.service";
import { ModalSubcategoryComponent } from "../modal-subcategory/modal-subcategory.component";
import SubcategoryBean from "src/app/beans/SubcategoryBean";



@Component({
  selector: 'app-subcategory',
  templateUrl: './subcategory.component.html',
  styleUrls: ['./subcategory.component.css']
})
export class SubcategoryComponent implements OnInit {

  @ViewChild(ModalSubcategoryComponent) modal: any
  id: number = 0
  titulo: string;
  subcategories: Array<SubcategoryBean>;
  mensaje: string = ""
  @Input() eventoDelHijo: string = ""
  constructor(private service: SubcategoryService) {
    this.titulo = "SUBCATEGORIAS"
    this.subcategories = [];
  }
  alta(){
    this.mensaje = ""
    //let ruta = subcategory._links.self.href
    this.modal.id = 0
    this.modal.ngOnInit()
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
          datos._embedded.subCategories.forEach((s:any) => {
            this.service.getDatos(s._links.category.href).subscribe((c:any)=>{
              let subcategoryBean = new SubcategoryBean(parseInt(s._links.self.href.substring(s._links.self.href.lastIndexOf("/")+1)),s.description,c.description)
              this.subcategories.push(subcategoryBean)
            })
          });
 
      })
  }

  modificar(id: number) {
    this.mensaje = ""
    //let ruta = subcategory._links.self.href
    this.modal.id = id
    this.modal.ngOnInit()
    // console.log(this.id )

  }

}
