import { Component } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements AfterViewInit {
  displayedColumns: string[] = ['position', 'name', 'photo', 'lastname', 'identification', 'creditcard', 'email', 'province', 'nuser', 'ncreditcard', 'number', 'ndocument', 'number'
];
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
  {position: 1, name: 'Hydrogen', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email:'x', province: 'H', nuser:1, ncreditcard:1, ndocument:1},
  {position: 2, name: 'Helium', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email:'x', province: 'He', nuser:1, ncreditcard:1, ndocument:1},
  {position: 3, name: 'Lithium', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email:'x', province: 'Li', nuser:1, ncreditcard:1, ndocument:1},
  {position: 4, name: 'Beryllium', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email:'x', province: 'Be', nuser:1, ncreditcard:1, ndocument:1},
  {position: 5, name: 'Boron', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'B', nuser:1, ncreditcard:1, ndocument:1},
  {position: 6, name: 'Carbon', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'C', nuser:1, ncreditcard:1, ndocument:1},
  {position: 7, name: 'Nitrogen', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'N', nuser:1, ncreditcard:1, ndocument:1},
  {position: 8, name: 'Oxygen', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'O', nuser:1, ncreditcard:1, ndocument:1},
  {position: 9, name: 'Fluorine', lastname:'x', photo: 'x',  identification:'x', creditcard:'1', email: 'x', province: 'F', nuser:1, ncreditcard:1, ndocument:1},
  {position: 10, name: 'Neon', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'Ne', nuser:1, ncreditcard:1, ndocument:1},
  {position: 11, name: 'Sodium', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'Na', nuser:1, ncreditcard:1, ndocument:1},
  {position: 12, name: 'Magnesium', lastname:'x', photo: ' x', identification:'x', creditcard:'1', email: 'x', province: 'Mg', nuser:1, ncreditcard:1, ndocument:1},
  {position: 13, name: 'Aluminum', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'Al', nuser:1, ncreditcard:1, ndocument:1},
  {position: 14, name: 'Silicon', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'Si', nuser:1, ncreditcard:1, ndocument:1},
  {position: 15, name: 'Phosphorus', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'P', nuser:1, ncreditcard:1, ndocument:1},
  {position: 16, name: 'Sulfur', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'S', nuser:1, ncreditcard:1, ndocument:1},
  {position: 17, name: 'Chlorine', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'Cl', nuser:1, ncreditcard:1, ndocument:1},
  {position: 18, name: 'Argon', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'Ar', nuser:1, ncreditcard:1, ndocument:1},
  {position: 19, name: 'Potassium', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'K', nuser:1, ncreditcard:1, ndocument:1},
  {position: 20, name: 'Calcium', lastname:'x', photo: 'x', identification:'x', creditcard:'1', email: 'x', province: 'Ca', nuser:1, ncreditcard:1, ndocument:1}
];
