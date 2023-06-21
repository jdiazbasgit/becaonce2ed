import { Component, ViewChild, OnInit } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { ExistingProductService } from 'src/app/servicios/existingproduct.service';
import { ModalExistingProductsComponent } from '../modal-existing-products/modal-existing-products.component';

@Component({
  selector: 'app-existing-product',
  templateUrl: './existing-product.component.html',
  styleUrls: ['./existing-product.component.css']
})

export class ExistingProductComponent implements OnInit {
  @ViewChild(ModalExistingProductsComponent, { static: false })
  modal: ModalExistingProductsComponent | undefined

  title = "Lista de productos"
  columns: string[] = ['image', 'description', 'price', 'stock', 'actions']
  elements: any[] = []
  message: string | undefined

  @ViewChild(MatPaginator)
  paginator!: MatPaginator

  constructor(private service: ExistingProductService) {}

  ngOnInit() {
    this.getData()
  }

  refreshData(event: any){
    this.getData()
  }

  getData() {
    this.service.getDatos("http://localhost:8080/once/products")
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            this.elements = response._embedded.existingProducts;
          } else {
            console.error('La propiedad _embedded no existe en el JSON.')
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos: ', error)
        }
      })
  }

  getImage(imageBytes: string): string {
    if (imageBytes) {
      return 'data:image/jpeg;base64,' + imageBytes
    }
    return 'assets/placeholder-image.jpg'
  }

  getFormatterEuro(amount: number): string {
    const formattedEuro = amount.toLocaleString('es-ES', {
      style: 'currency',
      currency: 'EUR'
    });

    return formattedEuro;
  }

  abrirModal(id: string, element?: any) {
   /* const modalElement = document.querySelector('#myModal')
    if (modalElement) {
      modalElement.dispatchEvent(new Event('click'))
    }*/

    if (this.modal) {
      this.modal.image = ''
      this.modal.description = ''
      this.modal.price = ''
      this.modal.stock = ''
      this.modal.total = '0'
      this.message=''

      if (element !== undefined && element !== null && element !== '') {
        this.modal.openModal(id, element)
      } else {
        this.modal.openModal('','')
      }
    }
  }

  eliminar(id: string) {
    if (confirm("¿Esta seguro de eliminar el producto?")) {
      this.service.delete("http://localhost:8080/once/products/" + id)
      .subscribe((dato: boolean) => {
        if (dato) {
          this.message = 'Producto eliminado correctamente.'
          this.ngOnInit()
        }
        else
          this.message ='Producto no se ha eliminado'
      })
    }
  }
}
