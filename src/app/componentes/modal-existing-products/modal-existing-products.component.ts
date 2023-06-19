import { Component, Inject } from '@angular/core';
import { ExistingProductService } from '../../servicios/existingproduct.service';
import ExistingProductBean from '../../beans/ExistingProductBean';


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
  saleprice: string = ""
  stock: string = ""
  total: string = "0"
  subcategory: string=''
  message: string = ""

  selectedImage: Blob | null = null

  constructor(private service: ExistingProductService) {}

  getImage(imageBytes: string): string {
    if (imageBytes) {
      this.image = imageBytes.toString()
      return 'data:image/jpeg;base64,' + imageBytes;
    }
    return 'assets/placeholder-image.jpg';
  }

  getFormat(amount: number): string {
    const formattedAmount = amount.toLocaleString('es-ES', {
      style: 'currency',
      currency: 'EUR'
    });

    return formattedAmount;
  }

  selectImage() {
    const fileInput = document.querySelector('#file-input') as HTMLImageElement;
    if (fileInput) {
      fileInput.click();
    }
  }

  fileUpload(event: any) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        const imageContent = reader.result;
        this.selectedImage = file;
        const imgElement = document.querySelector('#setImage') as HTMLImageElement;
        if (imgElement) {
          imgElement.src = imageContent as string;
        }
      };
      reader.readAsDataURL(file);
    }
  }

  saveData(id: string) {
    if (this.selectedImage) {
      this.image = this.selectedImage.toString()
    }

    const existingProduct = new ExistingProductBean(this.image, this.description, this.price, this.stock, this.subcategory);

    this.service.saveOrUpdate('http://localhost:8080/once/products/', existingProduct)
      .subscribe((dato: boolean) => {
        if (dato) {
          this.message = 'Producto se ha añadido correctamente.'
          this.description = ''
          this.price = ''
          this.saleprice=''
          this.stock = ''
          this.selectedImage = null;
        } else {
          this.message = 'Producto no se ha añadido.';
        }
      });

    /*} else {
      this.message = 'Por favor, rellene todos los campos obligatorios'
    }*/
  }

  openModal(id: string, data: any) {
    if (data!=''){
      this.id = id
      this.image = data.image
      this.description = data.description
      this.saleprice = new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(data.price)
      this.price = data.price
      this.stock = data.stock
      this.total = new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(data.price * data.stock)
      this.subcategory = data._links.subcategory.href
    } else {
      this.image=''
      this.description=''
      this.price=''
      this.saleprice=''
      this.stock=''
      this.total='0'
    }


   /* $('#myModal').modal('show')
  }

  close() {
    $('#myModal').modal('hide');
  }*/

  //document.querySelector('#myModal')?.classList.remove("d-none")

}

close() {
  //document.querySelector('#hide')?.classList.add("d-none")
}
}
