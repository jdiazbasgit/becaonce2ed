import { Component, DoCheck } from '@angular/core';
import SoldProductBean from 'src/app/beans/SoldProductBean';
import { SoldProductService } from 'src/app/servicios/soldProduct.service';

@Component({
  selector: 'app-modal-sold-product',
  templateUrl: './modal-sold-product.component.html'
})
export class ModalSoldProductComponent implements DoCheck{

  id: number = 0;
  quantity: number;
  existingProduct: string;
  price: number;
  date: Date;
  profile: string;
  basket: boolean;

  productPlaceHolder: string = "";
  pricePlaceHolder: number = 0;
  quantityPlaceHolder: number = 0;

  mensaje: string = "";
  fin: boolean = false;
  
  constructor (private service: SoldProductService){
    this.quantity = 0;
    this.existingProduct = "";
    this.price = 0;
    this.date = new Date("1900-01-01")
    this.profile = "";
    this.basket = false;
  }

  ngDoCheck(): void {
    if(this.id !== 0 && !this.fin){
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/products/" + this.id)
      .subscribe((datos: any)=> {
        this.fin = true;
        this.productPlaceHolder = datos.description;
        this.pricePlaceHolder = datos.price;
      })
    }
  }

  realizarComunicacion(){
    this.quantity = 0;
    this.mensaje="";
    this.fin=false;
  }

  aniadir(){
    this.fin = false;
    if (this.quantity !== 0) {
      console.log("id entrada:" + this.id)
      console.log("quantity:" + this.quantity)
      console.log("existingProduct:" + this.existingProduct)
      console.log("price:" + this.price)
      console.log("date:" + this.date)
      console.log("profile:" + this.profile)
      console.log("basket:" + this.basket)
      this.service.saveOrUpdate("http://localhost:8080/once/soldProducts", new SoldProductBean(this.id, this.quantity, this.existingProduct, this.price, this.date, this.profile, this.basket))
      .subscribe((dato: boolean) => {
        if (dato) {
          this.mensaje = "Grabacion realizada correctamente"
          this.quantity = 0
        }
        else
          this.mensaje = "La grabación no se ha realizado"
      })
    }
    else this.mensaje = "Debes introducir un valor"
  }

}
