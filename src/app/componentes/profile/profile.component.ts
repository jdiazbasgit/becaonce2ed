import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ModalProfilesComponent } from '../modal-profiles/modal-profiles.component';
import { ProfileService } from '../../servicios/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  @ViewChild(ModalProfilesComponent) modal: any
  id: number = 0
  titulo: string
  mensaje: string = ""

  elements: any[]

  @Input() eventoDelHijo: string = ""

  constructor(private service: ProfileService) {
    this.titulo = "Lista de perfiles"
    this.elements = [];
  }

  ngOnInit(): void {
    this.elements = []
    this.service.getDatos("http://localhost:8080/once/profiles")
      .subscribe((datos: any) => {
        this.elements = datos._embedded.profiles;
      })
  }

  eliminar(id: any) {
    if (confirm("¿Esta seguro de borrar el perfil?")) {
      this.service.delete("http://localhost:8080/once/profiles/"+id)
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





/*import { Component, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements AfterViewInit {
  displayedColumns: string[] = ['position', 'name', 'photo', 'lastname', 'identification', 'creditcard', 'email', 'province', 'nuser', 'ncreditcard', 'ndocument'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

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
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'David', photo: '', lastname: '', identification: '', creditcard: '', email: '', province: 'Madrid', nuser: 0, ncreditcard: 0, ndocument: 0},
  {position: 2, name: 'David', photo: '', lastname: '', identification: '', creditcard: '', email: '', province: 'Madrid', nuser: 0, ncreditcard: 0, ndocument: 0},
  {position: 1, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email:'', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 2, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email:'', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 3, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email:'', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 4, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email:'', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 5, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 6, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 7, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 8, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 9, name: 'David', lastname:'', photo: '',  identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 10, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 11, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 12, name: 'David', lastname:'', photo: ' x', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 13, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 14, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 15, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 16, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 17, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 18, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 19, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1},
  {position: 20, name: 'David', lastname:'', photo: '', identification:'', creditcard:'', email: '', province: 'Madrid', nuser:1, ncreditcard:1, ndocument:1}
];*/
