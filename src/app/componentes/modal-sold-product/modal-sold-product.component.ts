import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
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
  
  @Output() eventoAComunicar=new EventEmitter();

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
      this.service.getDatos(this.existingProduct)
      .subscribe((datos: any)=> {
        this.fin = true;
        this.productPlaceHolder = datos.description;
        this.pricePlaceHolder = datos.price;
      })
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

  aniadir(){
    this.fin = false;
    if (this.quantity !== 0) {
      this.service.saveOrUpdate("http://localhost:8080/once/soldProducts", new SoldProductBean(0, this.quantity, this.existingProduct, this.price*this.quantity, this.date, this.profile, this.basket))
      .subscribe((dato: boolean) => {
        if (dato) {
          this.mensaje = "Grabacion realizada correctamente"
          this.quantity = 0;
          this.existingProduct = "";
          this.price = 0;
          this.date = new Date("1900-01-01")
          this.profile = "";
          this.basket = false;
        }
        else
          this.mensaje = "La grabación no se ha realizado"
      })
    }
    else this.mensaje = "Debes introducir un valor"
  }

}
