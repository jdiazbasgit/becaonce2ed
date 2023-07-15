import { Component, OnInit, ViewChild } from '@angular/core';
import { SoldProductService } from 'src/app/servicios/soldProduct.service';
import { ModalSoldProductComponent } from '../modal-sold-product/modal-sold-product.component';
import SoldProductBean from 'src/app/beans/SoldProductBean';
import ExistingProductBean from 'src/app/beans/ExistingProductBean';

@Component({
  selector: 'app-sold-product',
  templateUrl: './sold-product.component.html'
})

export class SoldProductComponent implements OnInit {

  @ViewChild(ModalSoldProductComponent) modal: any

  mensaje: string = "";
  titulo: string;
  cestas: any[];
  detalleExistingProducts: any[];
  id: number = 0

  constructor(private service: SoldProductService) {
    this.titulo = "MI CESTA"
    this.cestas = [];
    this.detalleExistingProducts = [];
  }

  ngOnInit(): void {
    this.cestas = []
    this.service.getDatos("http://localhost:8080/once/soldProducts")
      .subscribe((datos: any) => {
        datos._embedded.soldProducts.forEach((s:any) => {
          this.service.getDatos(s._links.existingProduct.href).subscribe((e:any) => {
            let soldProductBean = new SoldProductBean(parseInt(s._links.self.href.substring(s._links.self.href.lastIndexOf("/")+1)),s.quantity,s._links.existingProduct.href,s.price,s.date,"usuario",s.basket)
            this.cestas.push(soldProductBean);
//            let detalleExistingProduct = {nomProduct: e.description + " (" + soldProductBean.id + ")", priceUnitario: e.price}
            let detalleExistingProduct = {nomProduct: e.description, priceUnitario: e.price}
            this.detalleExistingProducts.push(detalleExistingProduct);
          })
        });
      })
  }

  modificar(cesta: any) {
    console.log(" ");

    this.mensaje = "";

    let rutaExistingProduct = cesta.existingProduct;
    console.log("sold-product.ts - rutaExistingProduct: "+rutaExistingProduct);

    this.modal.id = cesta.id; // SIEMPRE DISTINTO DE CERO, es para modificar (update, no save) el registro seleccionado en la tabla soldProduct
    console.log("sold-product.ts - modal.id: "+this.modal.id);

    this.modal.quantity = cesta.quantity;
    console.log("sold-product.ts - modal.quantity: "+this.modal.quantity);
//    this.modal.existingProduct = rutaExistingProduct;
    this.modal.existingProduct = cesta.existingProduct;
    console.log("sold-product.ts - modal.existingProduct: "+this.modal.existingProduct);
    this.modal.price = cesta.price;
    console.log("sold-product.ts - modal.price: "+this.modal.price);
    this.modal.date = cesta.date;
    console.log("sold-product.ts - modal.date: "+this.modal.date);
    this.modal.profile = "http://localhost:8080/once/profiles/9";   // profile falso
    console.log("sold-product.ts - modal.profile (FALSO): "+this.modal.profile);
    //this.modal.fin = false;
    //console.log("sold-product.ts - modal.fin: "+this.modal.fin);
  }

  eliminar(id: any) {
    console.log("id: "+id);
    if (confirm("¿Esta seguro de borrar el producto de cesta?")) {
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

  comprar(cesta: any) {
    console.log("sold-product.ts - cesta.existingProduct: "+cesta.existingProduct);

    this.service.getDatos(cesta.existingProduct)
    .subscribe((e: any)=> {
      if (cesta.quantity<=e.stock) {
    
        if (confirm("¿Esta seguro de comprar la cesta seleccionada?")) {

          // DESCONTAR CANTIDAD DE STOCK
          let stockQueda = e.stock-cesta.quantity;

          this.service.saveOrUpdate("http://localhost:8080/once/products", new ExistingProductBean(e.id, e.image, e.description, e.price, stockQueda.toString(), e.subcategory))
          .subscribe((p: boolean) => {
            if (p) {
              this.mensaje = ""
            }
          })

          this.service.saveOrUpdate("http://localhost:8080/once/soldProducts", new SoldProductBean(cesta.id, cesta.quantity, cesta.existingProduct, e.price*cesta.quantity, new Date(), cesta.profile, true))
          .subscribe((s: boolean) => {
            if (s) {
              this.mensaje = "Se ha comprado correctamente"
              this.ngOnInit();
            } else this.mensaje = "El registro no se ha comprado"
          })
        }
      } else this.mensaje = "No quedan "+cesta.quantity+". De momento quedan: "+e.stock
    })

  }

  realizarComunicacion(event: any) {
    this.mensaje = ""
    if (event.salida === "OK")
      this.ngOnInit();
  }

}
