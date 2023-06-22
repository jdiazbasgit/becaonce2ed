import { Component, EventEmitter, Output } from '@angular/core'
import { ExistingProductService } from '../../servicios/existingproduct.service'
import ExistingProductBean from '../../beans/ExistingProductBean'

@Component({
  selector: 'app-modal-existing-products',
  templateUrl: './modal-existing-products.component.html',
  styleUrls: ['./modal-existing-products.component.css']
})

export class ModalExistingProductsComponent {
  id: string = ""
  image: string | null = null
  description: string = ""
  price: string = ""
  stock: string = ""
  total: string = "0"
  subcategory: string = ''
  message: string = ""

  imageContent: string = ""
  selectedImage: File | null = null

  @Output() eventoExistingProduct = new EventEmitter()

  constructor(private service: ExistingProductService) { }

  getImage(imageBytes: string | null): string {
    if (imageBytes) {
      this.image = imageBytes.toString()
      return 'data:image/jpeg;base64,' + imageBytes
    }
    return 'assets/placeholder-image.jpg'
  }

  selectImage() {
    const fileInput = document.querySelector('#file-input') as HTMLInputElement
    if (fileInput) {
      fileInput.click()
    }
  }

  fileUpload(event: any) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.imageContent = reader.result as string;
        const base64Match = this.imageContent.match(/^data:image\/[a-z]+;base64,([\s\S]+)/i);
  
        if (base64Match && base64Match.length > 1) {
          this.imageContent = base64Match[1];
          const imgElement = document.querySelector('#setImage') as HTMLImageElement;
          if (imgElement) {
            imgElement.src = this.getImage(this.imageContent);
          }
        }
      };
      reader.readAsDataURL(file);
      file.close;
    }
  }

  stockChange(price: any, stock: any) {
    const priceValue = price.replace(/[^\d,]/g, '').replace(',', '.')
    this.total = new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(priceValue * stock)
  }

  saveData() {
    if (this.imageContent) {
      this.image = this.imageContent.toString()
    }

    const priceValue = this.price.replace(/[^\d,]/g, '').replace(',', '.')
    this.price = priceValue.toString()

    const existingProduct = new ExistingProductBean(this.id, this.image || '', this.description, this.price, this.stock, this.subcategory || 'http://localhost:8080/once/subcategory/6'); //De momento con el numero 6

    this.service.saveOrUpdate('http://localhost:8080/once/products/', existingProduct)
      .subscribe((dato: boolean) => {
        if (dato) {
          this.id = ''
          this.image = null
          this.message = ''
          this.description = ''
          this.price = ''
          this.stock = ''
          this.selectedImage = null
        } else {
          this.message = 'Producto no se ha añadido.'
        }
      });
  }

  openModal(id: string, data: any) {
    if (data != '') {
      this.id = id
      this.image = data.image
      this.description = data.description
      this.price = new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(data.price)
      this.stock = data.stock
      this.total = new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(data.price * data.stock)
      this.subcategory = data._links.subcategory.href
    } else {
      this.id = ''
      this.image = null
      this.description = ''
      this.price = ''
      this.stock = ''
      this.total = '0'
      this.subcategory = ''
    }
  }

  cerrar() {
    this.eventoExistingProduct.emit({ salida: "OK" })
  }
}
