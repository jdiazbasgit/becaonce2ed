import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import ExistingProductBean from 'src/app/beans/ExistingProductBean';
import SoldProductBean from 'src/app/beans/SoldProductBean';
import { SoldProductService } from 'src/app/servicios/soldProduct.service';

@Component({
  selector: 'app-modal-sold-product',
  templateUrl: './modal-sold-product.component.html'
})
export class ModalSoldProductComponent implements DoCheck{

  id: number;
  quantity: number;
  existingProduct: string;
  price: number;
  date: Date;
  profile: string;
  basket: boolean;

  quantityPlaceHolder: number = 0;
  productPlaceHolder: string = "";
  priceUnitarioPlaceHolder: number = 0;

  mensaje: string = "";
  fin: boolean = false;
  botonAccion:string="";
  
  @Output() eventoAComunicar=new EventEmitter();

  constructor (private service: SoldProductService){
    this.id = 0;
    this.quantity = 0;
    this.existingProduct = "";
    this.price = 0;
    this.date = new Date("1900-01-01")
    this.profile = "";
    this.basket = false;
  }

  ngDoCheck(): void {
    console.log(" ")
    console.log("modal-sold-product.ts this.id: "+this.id)
    console.log("modal-sold-product.ts quantity: "+this.quantity);
    console.log("modal-sold-product.ts existingProduct: "+this.existingProduct);
    console.log("modal-sold-product.ts price: "+this.price);
    console.log("modal-sold-product.ts date: "+this.date);
    console.log("modal-sold-product.ts profile: "+this.profile);
    console.log("modal-sold-product.ts this.fin: "+this.fin)

    if(this.id===0){
      this.botonAccion ="AÑADIR"
    } else {
      this.botonAccion = "MODIFICAR"
    }

//    if (this.id !== 0 && !this.fin) {
    if (!this.fin) {
    // MODIFICACION
      console.log("modal-sold-product.ts MODIFICACION existingProduct: "+this.existingProduct);
      if (this.existingProduct !== "") {
        this.service.getDatos(this.existingProduct)
        .subscribe((datos: any)=> {
          this.quantityPlaceHolder = datos.quantity;
          this.productPlaceHolder = datos.description;
          this.priceUnitarioPlaceHolder = datos.price;
          this.fin = true;
        })
      }
    } else { // EL GRUPO ELSE SOBRA, LO BORRAMOS
      console.log("modal-sold-product.ts ALTA existingProduct: "+this.existingProduct);
    }
  }

  realizarComunicacion(){
    this.id = 0;
    this.quantity = 0;
    this.existingProduct = "";
    this.price = 0;
    this.date = new Date("1900-01-01")
    this.profile = "";
    this.basket = false;

    this.mensaje="";
    this.fin=false;
    this.eventoAComunicar.emit({salida:"OK"})
  }

  saveOrUpdateSoldProduct(){
    this.fin = false;
    console.log(" SAVE OR UPDATE");
    console.log("modal-sold-product.ts this.id: "+this.id)
    console.log("modal-sold-product.ts quantity: "+this.quantity);
    console.log("modal-sold-product.ts existingProduct: "+this.existingProduct);
    console.log("modal-sold-product.ts price: "+this.price);
    console.log("modal-sold-product.ts date: "+this.date);
    console.log("modal-sold-product.ts profile: "+this.profile);
    console.log("modal-sold-product.ts this.fin: "+this.fin)
    if (this.quantity !== 0) {
      if (this.existingProduct !== "") {
        this.service.getDatos(this.existingProduct)
        .subscribe((e: any)=> {
          if (this.quantity<=e.stock) {
            this.service.saveOrUpdate("http://localhost:8080/once/soldProducts", new SoldProductBean(this.id, this.quantity, this.existingProduct, e.price*this.quantity, this.date, this.profile, this.basket))
            .subscribe((dato: boolean) => {
              if (dato) {
                this.mensaje = "Grabacion realizada correctamente"

                /* DESCONTAR CANTIDAD 
                this.service.saveOrUpdate("http://localhost:8080/once/products", new ExistingProductBean(e.id, e.image, e.description, e.price, (e.stock + -this.quantity), e.subcategory))
                .subscribe((p: boolean) => {
                })
                */

                this.id = 0;
                this.quantity = 0;
                this.existingProduct = "";
                this.price = 0;
                this.date = new Date("1900-01-01")
                this.profile = "";
                this.basket = false;

              }
              else this.mensaje = "La grabación no se ha realizado"
            })
          }
          else this.mensaje = "No quedan "+this.quantity+". De momento quedan: "+e.stock
        })
      }
    }
    else this.mensaje = "Debes introducir un valor"
  }

}
