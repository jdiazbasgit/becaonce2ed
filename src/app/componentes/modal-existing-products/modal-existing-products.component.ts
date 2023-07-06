import { Component, EventEmitter, Output } from '@angular/core';
import { ExistingProductService } from '../../servicios/existingproduct.service';
import ExistingProductBean from '../../beans/ExistingProductBean';

@Component({
  selector: 'app-modal-existing-products',
  templateUrl: './modal-existing-products.component.html',
  styleUrls: ['./modal-existing-products.component.css']
})

export class ModalExistingProductsComponent {
  id: string = "";
  image: string | null = null;
  description: string = '';
  price: string = '';
  stock: string = '';
  total: string = '0';
  subcategory: string = '';

  message: string = '';

  imageContent: string = '';

  categories: any[] = [];
  subcategories: any[] = [];

  categoria: string ='';
  subcategoria: string ='';

  @Output() eventoExistingProduct = new EventEmitter();
  constructor(private service: ExistingProductService) { }

  getImage(imageBytes: string | null): string {
    if (imageBytes) {
      this.image = imageBytes.toString()
      return 'data:image/jpeg;base64,' + imageBytes;
    }
    return 'assets/placeholder-image.jpg';
  }

  selectImage() {
    const fileInput = document.querySelector('#file-input') as HTMLInputElement;
    if (fileInput) {
      fileInput.click();
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
    const priceValue = price.replace(/[^\d,]/g, '').replace(',', '.');
    this.total = new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(priceValue * stock);
  }

  saveData() {
    if(this.description.trim()==''){
      this.message = 'Por favor, introduzca descripción.';
    } else {

      if (this.imageContent) {
        this.image = this.imageContent.toString();
      }

      const priceValue = this.price.replace(/[^\d,]/g, '').replace(',', '.');
      this.price = priceValue.toString();

      const existingProduct = new ExistingProductBean(this.id, this.image || '', this.description, this.price, this.stock, this.subcategory);

      this.service.saveOrUpdate('http://localhost:8080/once/products/', existingProduct)
        .subscribe((dato: boolean) => {
          if (dato) {
            /*this.id = '';
            this.image = null;
            this.message = '';
            this.description = '';
            this.price = '';
            this.stock = '';*/
            this.message = '¡El producto ha sido guardado correctamente!';
            //this.eventoExistingProduct.emit({ salida: "OK" });
          } else {
            this.message = 'Error al guardar el producto.';
          }
        });
      }
  }

  getCategories(){
    this.service.getDatos("http://localhost:8080/once/categories")
    .subscribe({
      next: (response: any) => {
        if (response._embedded) {
          this.categories = response._embedded.categories;
        } else {
          console.error('La propiedad _embedded no existe en el JSON.')
        }
    },error: (error: any) => {
      console.error('Error al obtener los datos: ', error);
    }});
  }

  getSubCategories(){
    this.service.getDatos("http://localhost:8080/once/subcategories")
    .subscribe({
      next: (response: any) => {
        if (response._embedded) {
          this.subcategories = response._embedded.subCategories;

        } else {
          console.error('La propiedad _embedded no existe en el JSON.')
        }
    },error: (error: any) => {
      console.error('Error al obtener los datos: ', error);
    }});
  }

  openModal(id: string, data: any, action: string) {
    if (data !== '') {
      this.id = id;
      this.image = data.image;
      this.description = data.description;
      this.price = data.price.toString().replace(/\./g, ',');
      this.stock = data.stock;
      this.total = new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(data.price * data.stock);

      this.getSubCategories();
      this.getCategories();

      /*if(action==='edit'){*/

        const subcategoryId = data._links.subcategory.href.substring(data._links.subcategory.href.lastIndexOf('/') + 1);
        this.service.getDatos("http://localhost:8080/once/subcategories/"+subcategoryId)
        .subscribe({
          next: (rsp: any) => {
            this.subcategoria = rsp.description;
        },error: (error: any) => {
          console.error('Error al obtener los datos: ', error);
        }});

        const categoryId = data._links.category.href.substring(data._links.category.href.lastIndexOf('/') + 1);

        this.service.getDatos("http://localhost:8080/once/categories/"+categoryId)
        .subscribe({
          next: (rsp: any) => {
            this.categoria = rsp.description;
        },error: (error: any) => {
          console.error('Error al obtener los datos: ', error);
        }});
      /*}*/


    } else {
      this.clearAll();
    }
  }

  closeModal(): void {
    this.eventoExistingProduct.emit({ salida: "OK" });
  }

  getDataCategory(id:string) {
    this.service.getDatos("http://localhost:8080/once/category/"+id)
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            this.categories = response._embedded.profiles;
          } else {
            console.error('La propiedad _embedded no existe en el JSON.');
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos: ', error);
        }
      })
  }

  clearAll(){
    Object.assign(this, {
      id: '',
      image: null,
      description:'',
      price: '',
      stock: '',
      total: '0',
      subcategoryhref: ''
    });
  }
}
