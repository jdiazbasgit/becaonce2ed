import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import { ExistingProductService } from '../../servicios/existingproduct.service';
import ExistingProductBean from '../../beans/ExistingProductBean';

declare var $: any;
declare var atob: any;

@Component({
  selector: 'app-modal-existing-products',
  templateUrl: './modal-existing-products.component.html',
  styleUrls: ['./modal-existing-products.component.css']
})

export class ModalExistingProductsComponent { //implements DoCheck {
  //id: number = 0;
  descripcion: string = "";
  mensaje: string = ""
  //fin: boolean = false
  image: string =""
  description: string = ""
  price: string = ""
  stock: string = ""
  total: string = "0";

  @Output() eventoAComunicar = new EventEmitter();
  

  constructor(private service: ExistingProductService) {}

  /*ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      console.log("id entrada:" + this.id);
      this.service.getDatos("http://localhost:8080/once/products/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true;
          this.image = datos.image;
          this.description = datos.description;
          this.price = datos.price;
          this.stock = datos.stock;
        });
    }
  }*/

  realizarComunicacion() {
    //this.id = 0;
    this.eventoAComunicar.emit({ salida: "OK" });
  }

  getImage(image: string): string {
    if (image) {
      const decodedImage = atob(image);
      return 'data:image/jpeg;base64,' + decodedImage;
    }
    return '';
  }

  grabar() {
    //this.fin = false;
   /* if (this.description.trim() !== "") {
      const existingProduct = new ExistingProductBean(this.id, this.image, this.description, this.price, this.stock);
      this.service.saveOrUpdate("http://localhost:8080/once/products", existingProduct)
        .subscribe((dato: boolean) => {
          if (dato) {
            this.mensaje = "Grabación realizada correctamente";
            this.description = "";
            this.price = "";
            this.stock = "";
          } else {
            this.mensaje = "La grabación no se ha realizado";
          }
        });
    } else {
      this.mensaje = "Debes introducir un valor";
    }*/
  }

  openModal() {
    $('#myModal').modal('show');
  }
}