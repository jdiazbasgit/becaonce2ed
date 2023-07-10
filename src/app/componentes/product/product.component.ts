import { Component, OnInit } from '@angular/core';
import { ExistingProductService } from 'src/app/servicios/existingproduct.service';

interface Product {
  image: string;
  description: string;
  price: number;
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
  constructor(private service: ExistingProductService) {}

  products: Product[] | undefined;
  categories: Category[] | undefined;

  ngOnInit() {
    this.getData();
  }

  addToCart(id:string) {
    /* LUIS FERNANDO TIENES QUE HACER TU */
    alert(id);
  }

  getImageProduct(imageBytes: string): string {
    if (imageBytes) {
      return 'data:image/jpeg;base64,' + imageBytes
    }
    return 'assets/placeholder-image.jpg'
  }

  getCategory(category: string) {
    alert(category)
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
