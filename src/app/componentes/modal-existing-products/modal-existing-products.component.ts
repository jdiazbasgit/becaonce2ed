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

export class ModalExistingProductsComponent {
  id: string = ""
  image: string = ""
  description: string = ""
  price: string = ""
  stock: string = ""
  total: string = "0"

  @Output() eventoAComunicar = new EventEmitter();
  message: string = ""

  constructor(private service: ExistingProductService) {}

  close() {
    $('#myModal').modal('hide');
  }

  getImage(imageBytes: string): string {
    if (imageBytes) {
      return 'data:image/jpeg;base64,' + imageBytes
    }

    return 'assets/placeholder-image.jpg'
  }

  /*fileUpload(event: any) {
    const file = event.target.files[0]
    const blob = new Blob([file])
    this.image = blob.toString()
    $("#setImage").attr("src",this.image)
    console.log(blob)
  }*/

  fileUpload(event: any) {
    const file = event.target.files[0]
    console.log(file)
  }

  saveData(Id: string) {
    if (this.description.trim() !== "") {
      const existingProduct = new ExistingProductBean(this.image, this.description, this.price, this.stock);
      this.service.saveOrUpdate("http://localhost:8080/once/products", existingProduct)
        .subscribe((dato: boolean) => {
          if (dato) {
            this.message = "Producto se ha añadido correctamente.";
            this.description = "";
            this.price = "";
            this.stock = "";
          } else {
            this.message = "Producto no se ha añadido.";
          }
        });
    } else {
      this.message = "Por favor, rellene todos los campos obligatorios";
    }

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
