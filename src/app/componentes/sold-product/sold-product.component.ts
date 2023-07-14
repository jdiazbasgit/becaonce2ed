import { Component, OnInit, ViewChild } from '@angular/core';
import { SoldProductService } from 'src/app/servicios/soldProduct.service';
import { ModalSoldProductComponent } from '../modal-sold-product/modal-sold-product.component';
import SoldProductBean from 'src/app/beans/SoldProductBean';

@Component({
  selector: 'app-sold-product',
  templateUrl: './sold-product.component.html'
})

export class SoldProductComponent implements OnInit {

  @ViewChild(ModalSoldProductComponent) modal: any

  mensaje: string = "";
  titulo: string;
  cestas: any[];
  id: number = 0

  constructor(private service: SoldProductService) {
    this.titulo = "MI CESTA"
    this.cestas = [];
  }

  ngOnInit(): void {
    this.cestas = []
    this.service.getDatos("http://localhost:8080/once/soldProducts")
      .subscribe((datos: any) => {
        datos._embedded.soldProducts.forEach((s:any) => {
          this.service.getDatos(s._links.existingProduct.href).subscribe((e:any) => {
//            let soldProductBean = new SoldProductBean(parseInt(s._links.self.href.substring(s._links.self.href.lastIndexOf("/")+1)),s.quantity,e.description,e.price,s.date,"usuario",s.basket)
            let soldProductBean = new SoldProductBean(parseInt(s._links.self.href.substring(s._links.self.href.lastIndexOf("/")+1)),s.quantity,s._links.existingProduct.href,e.price,s.date,"usuario",s.basket)
            this.cestas.push(soldProductBean)
          })
        });
      })
  }

  modificar(cesta: any) {
    this.mensaje = "";
//    let ruta = cesta._links.existingProduct.href;
    let ruta = cesta.existingProduct;
    console.log("ruta: "+ruta)
//    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf('/') + 1));
    this.modal.id = cesta.id;
    this.modal.existingProduct = ruta;
    this.modal.price = cesta.price;
    this.modal.profile = "http://localhost:8080/once/profiles/9"   // profile falso
  }

  eliminar(id: any) {
    if (confirm("¿Esta seguro de borrar alarma de stock?")) {
      this.service.delete("http://localhost:8080/once/soldProducts/" + id)
        .subscribe((dato: boolean) => {
          if (dato) {
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

}
