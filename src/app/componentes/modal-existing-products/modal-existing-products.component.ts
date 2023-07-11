import { Component, EventEmitter, Output } from '@angular/core';
import { ExistingProductService } from '../../servicios/existingproduct.service';
import ExistingProductBean from '../../beans/ExistingProductBean';

@Component({
  selector: 'app-modal-existing-products',
  templateUrl: './modal-existing-products.component.html',
  styleUrls: ['./modal-existing-products.component.css']
})

export class ModalExistingProductsComponent{
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

  categoriaInput: string ='';
  subcategoriaInput: string ='';

  @Output() eventoExistingProduct = new EventEmitter();

  constructor(private service: ExistingProductService) {}

  getImageProduct(imageBytes: string | null): string {
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

  fileUploadProduct(event: any) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.imageContent = reader.result as string;
        const base64Match = this.imageContent.match(/^data:image\/[a-z]+;base64,([\s\S]+)/i);

        if (base64Match && base64Match.length > 1) {
          this.imageContent = base64Match[1];
          const imgElement = document.querySelector('#setImageProduct') as HTMLImageElement;
          if (imgElement) {
            imgElement.src = this.getImageProduct(this.imageContent);
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
    if (this.description.trim() == '') {
      this.message = 'Por favor, introduzca descripción.';
    } else {
      if (this.imageContent) {
        this.image = this.imageContent.toString();
      }
  
      const priceValue = this.price.replace(/[^\d,]/g, '').replace(',', '.');
      this.price = priceValue.toString();
  
      const selectedSubcategory = this.subcategories.find(subcategory => subcategory.description === this.subcategoriaInput);

      if (selectedSubcategory) {
        this.subcategory = "http://localhost:8080/once/categories/" + selectedSubcategory._links.self.href.split('/').pop();
  
        const existingProduct = new ExistingProductBean(this.id, this.image || '', this.description, this.price, this.stock, this.subcategory);
  
        this.service.saveOrUpdate('http://localhost:8080/once/products/', existingProduct)
          .subscribe((dato: boolean) => {
            if (dato) {
              this.message = '¡El producto ha sido guardado correctamente!';
              this.eventoExistingProduct.emit({ actualizar: "OK" });
            } else {
              this.message = 'Error al guardar el producto.';
            }
          });
      } else {
        console.error('No se encontró la subcategoría seleccionada.');
      }
    }
  }

  onCategoryChange() {
    const selectedCategory = this.categories.find(category => category.description === this.categoriaInput);
  
    if (selectedCategory) {
      const categoryId = selectedCategory._links.self.href.split('/').pop();
      this.getSubCategories(categoryId);
    }
  }

  getSubCategoriesByCategory(categoryId: string) {
    const categoryUrl = 'http://localhost:8080/once/categories/' + categoryId;
    this.service.getDatos(categoryUrl).subscribe({
      next: (response: any) => {
        if (response._embedded && response._embedded.subCategories) {
          this.subcategories = response._embedded.subCategories;
        } else {
          console.error('No se encontraron subcategorías para la categoría seleccionada.');
        }
      },
      error: (error: any) => {
        console.error('Error al obtener las subcategorías: ', error);
      }
    });
  }

  getSubCategories(categoryId: string) {
    this.service.getDatos("http://localhost:8080/once/subcategories")
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            const subcategorias = response._embedded.subCategories;
  
            this.subcategories = subcategorias.filter((subcategory: any) => {
              const subcategoryId = subcategory._links.category.href.split('/').pop();
              return subcategoryId === categoryId;
            });

          } else {
            console.error('La propiedad _embedded no existe en el JSON de subcategorías.');
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos de subcategorías: ', error);
        }
      });
  }
  
  openModal(id: string, data: any) {
    this.getCategories('');
    if (data !== '' && data._links && data._links.self && data._links.self.href) {
      this.id = id;
      this.image = data.image;
      this.description = data.description;
      this.price = data.price.toString().replace(/\./g, ',');
      this.stock = data.stock;
      this.total = new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(data.price * data.stock);

      this.service.getDatos(data._links.subcategory.href)
      .subscribe({
        next: (rsp: any) => {
          const categoryId = rsp._links.category.href.split('/').pop();
          this.getSubCategories(categoryId);
          this.subcategoriaInput=rsp.description
          this.getCategories(categoryId);
      },error: (error: any) => {
        console.error('Error al obtener los datos: ', error);
      }});

    } else {
      this.clearAll();
    }
  }

  closeModalProduct() {
    this.clearAll();
  }

  getCategories(id:string) {
    this.service.getDatos("http://localhost:8080/once/categories/"+id)
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            this.categories = response._embedded.categories;
          } else {
            this.categoriaInput = response.description;
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos de categorías: ', error);
        }
      });
  }

  clearAll(){
    Object.assign(this, {
      id: '',
      image: null,
      description:'',
      price: '',
      stock: '',
      total: '0',
      subcategory: '0',
      categoriaInput: '',
      subcategoriaInput:'',
      subcategories:[]
    });
  }
}
