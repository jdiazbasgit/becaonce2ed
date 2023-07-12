import { Component } from '@angular/core';
import { ExistingProductService } from 'src/app/servicios/existingproduct.service';

interface Product {
  image: string;
  description: string;
  price: number;
  _links: any;
}

interface Subcategory {
  description: string;
  _links: any;
}

interface Category {
  description: string;
  _links: any;
}

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})

export class ProductComponent{
  titleSubcategory: string = 'PORTÁTILES';
  constructor(private service: ExistingProductService) {}

  products: Product[] | undefined;
  categories: Category[] | undefined;
  subcategories: Subcategory[] = [];

  ngOnInit() {
    this.getData();
  }

  addToCart(product:Product) {
    alert(product);
  }

  getImageProduct(imageBytes: string): string {
    if (imageBytes) {
      return 'data:image/jpeg;base64,' + imageBytes
    }
    return 'assets/placeholder-image.jpg'
  }

  getCategory(category: Category) {
    const categoryId = category._links.self.href.split('/').pop();
    this.service.getDatos("http://localhost:8080/once/subcategories")
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            const subcategorias = response._embedded.subCategories;
            this.subcategories = [];
            subcategorias.forEach((subcategory: any) => {
              const subcategoryId = subcategory._links.category.href.split('/').pop();
              if (subcategoryId === categoryId) {
                const subcategoryObject: Subcategory = {
                  description: subcategory.description,
                  _links: subcategory._links
                };
                this.subcategories.push(subcategoryObject);
              }
            });
          } else {
            console.error('La propiedad _embedded no existe en el JSON.');
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos: ', error);
        }
      });
  }

  getSubcategory(subcategory: Subcategory){
    this.titleSubcategory = subcategory.description;
    const categoryId = subcategory._links.category.href.split('/').pop();
    const subcategoryId = subcategory._links.self.href.split('/').pop();
    this.service.getDatos("http://localhost:8080/once/products/"+categoryId+'/'+subcategoryId)
    .subscribe({
      next: (response: any) => {
        if (response) {
          this.products = [];
          this.products = response._embedded.existingProducts;
        } else {
          console.error('La propiedad _embedded no existe en el JSON.')
        }
      },
      error: (error: any) => {
        console.error('Error al obtener los datos: ', error)
      }
    })
  }

  getData() {
    this.service.getDatos("http://localhost:8080/once/products")
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            this.products = response._embedded.existingProducts;
          } else {
            console.error('La propiedad _embedded no existe en el JSON.')
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos: ', error)
        }
      })

      this.service.getDatos("http://localhost:8080/once/categories")
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            this.categories = response._embedded.categories;
          } else {
            console.error('La propiedad _embedded no existe en el JSON.')
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos: ', error)
        }
      })
  }

  numberFormat(amount: number | bigint){
    return new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(amount);
  }
}
