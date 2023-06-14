import { Component, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { ExistingProductService } from 'src/app/servicios/existingproduct.service';
import { ModalExistingProductsComponent } from '../modal-existing-products/modal-existing-products.component';

declare var atob: any;

@Component({
  selector: 'app-existing-product',
  templateUrl: './existing-product.component.html',
  styleUrls: ['./existing-product.component.css']
})

export class ExistingProductComponent implements AfterViewInit {
  @ViewChild(ModalExistingProductsComponent, { static: false })
  modal: ModalExistingProductsComponent | undefined;

  title = "Lista de productos"
  columns: string[] = ['image', 'description', 'price', 'stock', 'actions'];
  elements: any[] = [];
  modalMode: 'add' | 'edit' = 'add';
  modalData: any = {};
  
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor(private service: ExistingProductService) { }

  ngAfterViewInit() {
    this.getData();
  }

  getData() {
    this.service.getDatos("http://localhost:8080/once/products")
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            this.elements = response._embedded.existingProducts;
          } else {
            console.error('La propiedad _embedded no existe en el JSON de respuesta.');
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos:', error);
        }
      })
  }

  getImage(image: string): string {
    if (image) {
      const decodedImage = atob(image);
      return 'data:image/jpeg;base64,' + decodedImage;
    }
    return 'assets/placeholder-image.jpg';
  }

  abrirModal(mode: 'add' | 'edit', element?: any) {
    this.modalMode = mode;
    this.modalData = element ? { ...element } : {};

    console.log('Modificar elemento:', element);

    if (this.modal) {
      this.modal.image=""
      this.modal.description=""
      this.modal.price=""
      this.modal.stock=""
      this.modal.total="0"

      if (element !== undefined && element !== null) {
        this.modal.image=element.image
        this.modal.description=element.description
        this.modal.price=element.price
        this.modal.stock=element.stock
        this.modal.total=(element.price*element.stock).toString()
      }
      this.modal.openModal();
    }
  }

  eliminar(Id: string) {
    console.log('Eliminar elemento:', Id);

    if (confirm("¿Esta seguro de eliminar el producto? "+Id)) {
      this.service.delete(Id)
        .subscribe({
          next: (response: any) => {
            if (response._embedded) {
              this.elements = response._embedded.existingProducts; // Actualizar
            } else {
              console.error('Producto eliminado correctamente.');
            }
          },
          error: (error: any) => {
            console.error('Error al obtener los datos:', error);
          }
        });
    }
  }
}




/*import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ModalExistingProductsComponent } from '../modal-existing-products/modal-existing-products.component';
import { ExistingProductService } from '../../servicios/existingproduct.service';

@Component({
  selector: 'app-existing-product',
  templateUrl: './existing-product.component.html',
  styleUrls: ['./existing-product.component.css']
})

export class ExistingProductComponent implements OnInit {
  @ViewChild(ModalExistingProductsComponent) modal: any
  id: number = 0
  titulo: string
  mensaje: string = ""

  elements: any[]

  @Input() eventoDelHijo: string = ""

    constructor(private service: ExistingProductService) {
    this.titulo = "Lista de productos"
    this.elements = [];
  }

  ngOnInit(): void {
    this.elements = []
    this.service.getDatos("http://localhost:8080/once/products")
      .subscribe((datos: any) => {
        this.elements = datos._embedded.existingProducts;
      })
  }

  eliminar(id: any) {
    if (confirm("¿Esta seguro de borrar el perfil?")) {
      this.service.delete("http://localhost:8080/once/products/"+id)
      .subscribe((dato: boolean) => {
        if (!dato) {
          this.mensaje = "Se ha borrado correctamente"
          this.ngOnInit();
        }
        else
          this.mensaje = "El registro no se ha borrado"
      })
    }
  }

  realizarComunicacion(event: any) {
    this.mensaje = ""
    if (event.salida === "OK")
      this.ngOnInit();
  }

  modificar(position: any) {
    this.mensaje = ""
    let ruta = position._links.self.href
    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf("/") + 1))
  }
}*/


