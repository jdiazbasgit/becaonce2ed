import { Component, Input, OnInit, ViewChild } from '@angular/core';
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
    //this.eventoDelHijo=event.salida
    this.mensaje = ""
    if (event.salida === "OK")
      this.ngOnInit();
  }

  modificar(position: any) {
    this.mensaje = ""
    let ruta = position._links.self.href
    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf("/") + 1))
    // console.log(this.id )
  }
}


/*import { Component, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements AfterViewInit {
  displayedColumns: string[] = ['position', 'name', 'photo', 'lastname', 'identification', 'creditcard', 'email', 'province', 'nuser', 'ncreditcard', 'ndocument'];
  dataSource = new MatTableDataSource<PeriodicElement>();

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor(private http: HttpClient) {}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
}

export interface PeriodicElement {
  position: number;
  name: string;
  photo: string;
  lastname: string;
  identification: string;
  creditcard: string;
  email: string;
  province: string;
  nuser: number;
  ncreditcard: number;
  ndocument: number;
}*/
