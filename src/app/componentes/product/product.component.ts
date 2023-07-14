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
  titleSubcategory: string = 'Catálogo de productos';
  constructor(private service: ExistingProductService) {}

  products: Product[] | undefined;
  categories: Category[] | undefined;
  subcategories: Subcategory[] = [];

  navVisible: boolean = false;
  currentPage = 1;
  pageSize = 12;
  totalItems = 0;

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

  getSubcategory(subcategory: Subcategory) {
    this.navVisible = false;
    this.titleSubcategory = subcategory.description;
    const categoryId = subcategory._links.category.href.split('/').pop();
    const subcategoryId = subcategory._links.self.href.split('/').pop();

    this.currentPage = 1;

    this.service.getDatos(`http://localhost:8080/once/products/${categoryId}/${subcategoryId}`)
      .subscribe({
        next: (response: any) => {
          if (response) {
            this.products = [];
            this.products = response._embedded.existingProducts;
          } else {
            console.error('La propiedad _embedded no existe en el JSON.');
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos: ', error);
        }
      });
  }

  getData() {
    this.clearAll();
    const url = `http://localhost:8080/once/productsPaginado?size=${this.pageSize}&page=${this.currentPage - 1}&sort=id,asc`;
    this.service.getDatos(url)
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            this.products = response._embedded.existingProducts;
            this.totalItems = response.page.totalElements;
            this.navVisible = true;
          } else {
            console.error('La propiedad _embedded no existe en el JSON.');
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos: ', error);
        }
      });

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

  goToPage(page: number) {
    this.currentPage = page;
    this.getData();
  }

  goToPreviousPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.getData();
    }
  }

  goToNextPage() {
    const lastPage = this.getLastPage();
    if (this.currentPage < lastPage) {
      this.currentPage++;
      this.getData();
    }
  }

  getLastPage(): number {
    return Math.ceil(this.totalItems / this.pageSize);
  }

  getPageNumbers(): number[] {
    const lastPage = this.getLastPage();
    return Array.from({ length: lastPage } /*ejemplo console.log(Array.from('foo')); output: Array ["f", "o", "o"] */, (_, index) => index + 1 /*ejemplo console.log(Array.from([1, 2, 3], x => x + 1)); output: Array [2, 3, 4] */);
  }

  clearAll(){
    Object.assign(this, {
      navVisible: false,
      products: [],
      titleSubcategory: 'Todos los productos'
    });
  }
}
