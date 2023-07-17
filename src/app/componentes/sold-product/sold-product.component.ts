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
  id: number = 0;

  constructor(private service: SoldProductService) {
    this.titulo = "MI CESTA";
    this.cestas = [];
    this.detalleExistingProducts = [];
  }

  ngOnInit(): void {
    console.log(" ");
    console.log(" - ngOnInit() de sold-product.ts");
    this.cestas = [];
    this.service.getDatos("http://localhost:8080/once/soldProducts")
    .subscribe((datos: any) => {
      if (datos._embedded) {
        datos._embedded.soldProducts.forEach((s:any) => {
          this.service.getDatos(s._links.existingProduct.href)
          .subscribe((e:any) => {
            let soldProductBean = new SoldProductBean(parseInt(s._links.self.href.substring(s._links.self.href.lastIndexOf("/")+1)),s.quantity,s._links.existingProduct.href,s.price,s.date,s._links.profile.href,s.basket);

            let id = soldProductBean.id;
            let quantity = soldProductBean.quantity;
            let existingProduct = soldProductBean.existingProduct;
            let price = soldProductBean.price;
            let date = new Date(soldProductBean.date);
            let profile = soldProductBean.profile;
            let basket = soldProductBean.basket;
            let description = e.description;
            let priceUnitario = e.price;
            let priceTotal = priceUnitario*quantity;
            let estado = basket ? "Pagado" : "Cesta";
            let fecha = basket ? date.toLocaleDateString("en-GB") : " ";

            let detalleExistingProduct = {id: id, quantity: quantity, existingProduct: existingProduct, price: price, date: date, profile: profile, basket: basket, description: description, priceUnitario: priceUnitario, priceTotal: priceTotal, estado: estado, fecha: fecha};
            this.cestas.push(detalleExistingProduct);
          })
        });
      } else console.log("Datos de la cesta esta vacio");
    })
  }

  modificar(cesta: any) {
    this.mensaje = "";
    this.modal.id = cesta.id; // SIEMPRE DISTINTO DE CERO, es para modificar (update, no save) el registro seleccionado en la tabla soldProduct
    this.modal.quantity = cesta.quantity;
    this.modal.existingProduct = cesta.existingProduct;
    this.modal.price = cesta.price;
    this.modal.date = cesta.date;
    this.modal.profile = cesta.profile;
    this.modal.basket = cesta.basket;

    /*
    console.log(" ");
    console.log(" - modificar() de sold-product.ts");
    console.log("sold-product.ts - modificar() - modal.id: "+this.modal.id);
    console.log("sold-product.ts - modificar() - modal.quantity: "+this.modal.quantity);
    console.log("sold-product.ts - modificar() - modal.existingProduct: "+this.modal.existingProduct);
    console.log("sold-product.ts - modificar() - modal.price: "+this.modal.price);
    console.log("sold-product.ts - modificar() - modal.date: "+this.modal.date);
    console.log("sold-product.ts - modificar() - modal.profile: "+this.modal.profile);
    console.log("sold-product.ts - modificar() - modal.basket: "+this.modal.basket);
    */

  }

  eliminar(id: number) {
    console.log("id: "+id);
    if (confirm("¿Esta seguro de borrar el producto de cesta?")) {
      this.service.delete("http://localhost:8080/once/soldProducts/" + id)
        .subscribe((dato: boolean) => {
          if (dato) {
            this.mensaje = "Se ha borrado correctamente";
            this.ngOnInit();
          }
          else
            this.mensaje = "El registro no se ha borrado";
        })
    }
  }

  comprar(cesta: any) {

    /*
    console.log(" ");
    console.log(" - comprar() de sold-product.ts");
    console.log("sold-product.ts - comprar() - cesta.id: "+cesta.id);
    console.log("sold-product.ts - comprar() - cesta.quantity: "+cesta.quantity);
    console.log("sold-product.ts - comprar() - cesta.existingProduct: "+cesta.existingProduct);
    console.log("sold-product.ts - comprar() - cesta.price: "+cesta.price);
    console.log("sold-product.ts - comprar() - cesta.date: "+cesta.date);
    console.log("sold-product.ts - comprar() - cesta.profile: "+cesta.profile);
    console.log("sold-product.ts - comprar() - cesta.basket: "+cesta.basket);
    */

    this.service.getDatos(cesta.existingProduct)
    .subscribe((e: any)=> {

      /*
      console.log(" ");
      console.log(" - service.getDatos(cesta.existingProduct)");
      console.log("sold-product.ts - comprar() - e.existingProduct: "+e._links.self.href);
      console.log("sold-product.ts - comprar() - e.description: "+e.description);
      console.log("sold-product.ts - comprar() - e.price: "+e.price);
      console.log("sold-product.ts - comprar() - e.image: OK");
      console.log("sold-product.ts - comprar() - e.stock: "+e.stock);
      console.log("sold-product.ts - comprar() - e.subcategory: "+e._links.subcategory.href);
      */

      if (cesta.quantity<=e.stock) {
        console.log("Ubicacion del paso de PREGUNTAR")
        if (confirm("¿Esta seguro de comprar la cesta seleccionada?")) {

          // DESCONTAR CANTIDAD DE STOCK

          let stringIdExistingProduct = e._links.self.href.substring(e._links.self.href.lastIndexOf("/")+1);
          let stringPrice = e.price.toString();
          let stringStockQueda = (e.stock-cesta.quantity).toString();
          let subcategoryId = e._links.subcategory.href;

          /*
          console.log(" ");
          console.log(" - let para new ExistingProductBean");
          console.log("sold-product.ts - comprar() - stringIdExistingProduct: "+stringIdExistingProduct);
          console.log("sold-product.ts - comprar() - stringPrice: "+stringPrice);
          console.log("sold-product.ts - comprar() - stringStockQueda: "+stringStockQueda);
          console.log("sold-product.ts - comprar() - subcategoryId: "+subcategoryId);
          */

          const saveOrUpdateExistingProduct = new ExistingProductBean(stringIdExistingProduct, e.image, e.description, stringPrice, stringStockQueda, subcategoryId);

          /*
          console.log(" ");
          console.log(" - service.saveOrUpdate(new ExistingProduct)");
          console.log("sold-product.ts - comprar() - saveOrUpdateExistingProduct.id: "+saveOrUpdateExistingProduct.id);
          console.log("sold-product.ts - comprar() - saveOrUpdateExistingProduct.image: FOTO-OK");
          console.log("sold-product.ts - comprar() - saveOrUpdateExistingProduct.description: "+saveOrUpdateExistingProduct.description);
          console.log("sold-product.ts - comprar() - saveOrUpdateExistingProduct.price: "+saveOrUpdateExistingProduct.price);
          console.log("sold-product.ts - comprar() - saveOrUpdateExistingProduct.stock: "+saveOrUpdateExistingProduct.stock);
          console.log("sold-product.ts - comprar() - saveOrUpdateExistingProduct.subcategory: "+saveOrUpdateExistingProduct.subcategory);
          */

          this.service.saveOrUpdate("http://localhost:8080/once/products", saveOrUpdateExistingProduct)
          .subscribe((p: boolean) => {
            if (p) {
              this.mensaje = "...";
              this.service.saveOrUpdate("http://localhost:8080/once/soldProducts", new SoldProductBean(cesta.id, cesta.quantity, cesta.existingProduct, e.price*cesta.quantity, new Date(), cesta.profile, true))
              .subscribe((s: boolean) => {
                if (s) {
                  this.mensaje = "Se ha comprado correctamente";
                  this.ngOnInit();
                } else this.mensaje = "El registro no se ha comprado (IF 2)";
              });
            } else this.mensaje = "El registro no se ha comprado (IF 1)";
          });
        } else this.mensaje = "CANCELADO, no se ha comprado";
      } else this.mensaje = "No quedan "+cesta.quantity+". De momento solo quedan: "+e.stock;
    });
  }

  realizarComunicacion(event: any) {
    this.mensaje = "";
    if (event.salida === "OK")
      this.ngOnInit();
  }

  numberFormat(amount: number | bigint){
    return new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(amount);
  }


}
