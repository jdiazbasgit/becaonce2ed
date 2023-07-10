import { Component, OnInit } from '@angular/core';
import { ExistingProductService } from 'src/app/servicios/existingproduct.service';

interface Product {
  image: string;
  title: string;
  description: string;
  price: number;
  symbol: string;
}

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})

export class ProductComponent  {
  constructor(private service: ExistingProductService) {}

  products: Product[] | undefined;

  ngOnInit() {
    this.getData();
  }

  getImageProduct(imageBytes: string): string {
    if (imageBytes) {
      return 'data:image/jpeg;base64,' + imageBytes
    }
    return 'assets/placeholder-image.jpg'
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
  }
}
