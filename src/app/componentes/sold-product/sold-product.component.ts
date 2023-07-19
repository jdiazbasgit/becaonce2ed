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

    this.cestas = [];

    
    console.log(" ");
    console.log(" - ngOnInit() de sold-product.ts");
    

      // Podemos cambiar el valor de opcion, solo 1 o 2
      // opcion 1: Aun no funciona bien, user usa con sessionStorage.
      // opcion 2: funciona OK con user FALSO --> siempre user = 'Paco' (id=109 y id_profile=9)
    let opcion = 1;
      //    opcion 1, estoy trabajando con la opcion 1 hasta que lo funcione bien.
      //    mientras, deja la opcion 2 para que funcione bien con el mismo user falso (Paco)
      // Deberia dejar la opcion 1, pero no esta arreglado totalmente, de momento deja la opcion 2.
      //    Cuando la opcion 1 funciona correctamente, pongamos 1, así -->    let opcion = 1;
      //    NO BORRAMOS la opcion 2


    if (opcion == 1) { // opscion1: user con sessionStorage, "Deberia asi"
  

      console.log("sold-product.ts - ngOnInit() - sessionStorage.getItem('user'): "+sessionStorage.getItem('user')); //borrar linea
      console.log("sold-product.ts - ngOnInit() - sessionStorage.getItem('token'): "+sessionStorage.getItem('token')); //borrar linea

      this.service.getDatos("http://localhost:8080/once/soldProducts/cesta/"+sessionStorage.getItem('user'))
      .subscribe((datos: any) => {

        if (datos._embedded) {

          console.table(datos._embedded); //borrar linea
          console.log("sold-product.ts - ngOnInit() - datos._embedded.soldProducts.length: "+datos._embedded.soldProducts.length); //borrar linea

          let cestaPushed: any[] = [];

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
              //let description = e.description + " (" + id + ")";
              let description = e.description;
              let priceUnitario = e.price;
              let priceTotal = priceUnitario*quantity;
              let estado = basket ? "Pagado" : "Cesta";
              let fecha = basket ? date.toLocaleDateString("en-GB") : " ";
  
              let detalleExistingProduct = {id: id, quantity: quantity, existingProduct: existingProduct, price: price, date: date, profile: profile, basket: basket, description: description, priceUnitario: priceUnitario, priceTotal: priceTotal, estado: estado, fecha: fecha};
  
              cestaPushed.push(detalleExistingProduct);
              cestaPushed.sort((a, b) => a.id - b.id);
            });
          });
          this.cestas = cestaPushed;
        };
      })


    } else { // opcion 2: user FALSO. OJO! No es correcto, pero por lo menos funciona bien

      
      let profileConectadoFALSO = "http://localhost:8080/once/profiles/9";
      console.log("sold-product.ts - ngOnInit() - profileConectadoFALSO: "+profileConectadoFALSO); //borrar linea

      this.service.getDatos("http://localhost:8080/once/soldProducts/")
      .subscribe((datos: any) => {

        if (datos._embedded) {
  
          console.table(datos._embedded); //borrar linea
          console.log("sold-product.ts - ngOnInit() - datos._embedded.soldProducts.length: "+datos._embedded.soldProducts.length); //borrar linea
  
          let cestaPushed: any[] = [];
          let FilterSoldProducts: any[] = datos._embedded.soldProducts;
  
          const filteredSoldProduct = FilterSoldProducts.filter(soldProducts => soldProducts._links.profile.href === profileConectadoFALSO);
          if (filteredSoldProduct) {

            console.table(filteredSoldProduct); //borrar linea
            console.log("sold-product.ts - ngOnInit() - filteredSoldProduct.length: "+filteredSoldProduct.length); //borrar linea
            
            filteredSoldProduct.forEach((fs:any) => {
              this.service.getDatos(fs._links.existingProduct.href)
              .subscribe((e:any) => {
  
                let soldProductBean = new SoldProductBean(parseInt(fs._links.self.href.substring(fs._links.self.href.lastIndexOf("/")+1)),fs.quantity,fs._links.existingProduct.href,fs.price,fs.date,fs._links.profile.href,fs.basket);
  
                let id = soldProductBean.id;
                let quantity = soldProductBean.quantity;
                let existingProduct = soldProductBean.existingProduct;
                let price = soldProductBean.price;
                let date = new Date(soldProductBean.date);
                let profile = soldProductBean.profile;
                let basket = soldProductBean.basket;
                //let description = e.description + " (" + id + ")";
                let description = e.description;
                let priceUnitario = e.price;
                let priceTotal = priceUnitario*quantity;
                let estado = basket ? "Pagado" : "Cesta";
                let fecha = basket ? date.toLocaleDateString("en-GB") : " ";
    
                let detalleExistingProduct = {id: id, quantity: quantity, existingProduct: existingProduct, price: price, date: date, profile: profile, basket: basket, description: description, priceUnitario: priceUnitario, priceTotal: priceTotal, estado: estado, fecha: fecha};
    
                cestaPushed.push(detalleExistingProduct);
                cestaPushed.sort((a, b) => a.id - b.id);
              });
            });
          }
          this.cestas = cestaPushed;
        };
      })


    }


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
    } else this.mensaje = "CANCELADO, no se ha eliminado";
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
        if (confirm("¿Esta seguro de comprar el producto seleccionado?")) {

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
