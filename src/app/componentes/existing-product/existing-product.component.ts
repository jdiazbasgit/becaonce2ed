import { Component, ViewChild, OnInit } from '@angular/core';
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

  title = "Lista de productos";
  columns: string[] = ['image', 'description', 'price', 'stock', 'actions'];
  elements: any[] = [];
  message: string | undefined;

  navVisible: boolean = false;
  currentPage = 1;
  pageSize = 6;
  totalItems = 0;

  constructor(private service: ExistingProductService) {}

  ngOnInit() {
    this.getData();
  }

  getData() {
    const url = `http://localhost:8080/once/productsPaginado?size=${this.pageSize}&page=${this.currentPage - 1}&sort=id,asc`;
    this.service.getDatos(url)
    .subscribe({
      next: (response: any) => {
          if (response._embedded) {
            this.elements = response._embedded.existingProducts;
            this.totalItems = response.page.totalElements;
            this.navVisible = true;
          } else {
            console.error('La propiedad _embedded no existe en el JSON.')
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos: ', error)
        }
      })
  }

  getImageProduct(imageBytes: string): string {
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

  openModal(id: string, element?: any) {
    if (this.modal) {
      this.modal.image = '';
      this.modal.description = '';
      this.modal.price = '';
      this.modal.stock = '';
      this.modal.total = '0';

      this.modal.subcategory='0';

      this.modal.message='';

      this.modal.categoriaInput = '';
      this.modal.subcategoriaInput = '';

      this.modal.subcategories = [];

      this.modal.openModal(id, element);
    }
  }

  delProduct(id: string) {
    if (confirm("¿Esta seguro de eliminar el producto?")) {
      this.service.delete("http://localhost:8080/once/products/" + id)
      .subscribe((dato: boolean) => {
        if (dato) {
          this.message = 'Producto eliminado correctamente.';
          this.getData();
        } else {
          this.message ='Producto no se ha eliminado';
        }
      })
    }
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

  handleEventoProduct(event: any) {
    if (event.actualizar === "OK") {
      this.getData();
    }
  }
}
