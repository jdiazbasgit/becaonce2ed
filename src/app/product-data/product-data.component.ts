import { Component, OnInit, TemplateRef } from '@angular/core';
import { Router } from '@angular/router';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-product-data',
  templateUrl: './product-data.component.html',
  styleUrls: ['./product-data.component.css']
})
export class ProductDataComponent {
  public filteredData: any[];
  public sortKey: string | undefined;
  public sortDirection: string = 'asc';
  public searchText: any | undefined;
  public elements: string | undefined;
  public modalRef: BsModalRef | undefined;

  public data = [
    { id: 1, image:'https://images.byflou.com/13/3/images/products/0/0/bies-bryghus-oel-bies-bryghus-oel-anno-1841-3628185.gif', description: 'botellas de cervezas 1', price: 22.85, stock: 5, subcategories_id:1},
    { id: 2, image:'https://images.byflou.com/13/3/images/products/0/0/bies-bryghus-oel-bies-bryghus-oel-anno-1841-3628185.gif', description: 'botellas de cervezas 2', price: 14.66, stock: 20, subcategories_id:1},
    { id: 3, image:'https://images.byflou.com/13/3/images/products/0/0/bies-bryghus-oel-bies-bryghus-oel-anno-1841-3628185.gif', description: 'botellas de cervezas 3', price: 20.99, stock: 45, subcategories_id:2}
  ];

  constructor(private router: Router, private modalService: BsModalService) {
    this.filteredData = this.data;
    if(this.data.length>0){
      this.elements = this.data.length+" elementos";
    } else{
      this.elements = this.data.length+" elemento";
    };
  }

  public sortData(key: string) {
    if (this.sortKey === key) {
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortKey = key;
      this.sortDirection = 'asc';
    }

    this.filteredData.sort((a, b) => {
      if (a[key] < b[key]) {return this.sortDirection === 'asc' ? -1 : 1;}
      if (a[key] > b[key]) {return this.sortDirection === 'asc' ? 1 : -1;}
      return 0;
    });
  }

  public filterData() {
    if (this.searchText && this.searchText.trim() !== '') {
      this.filteredData = this.data.filter(item => item.description && item.description.toLowerCase().includes(this.searchText.toLowerCase())
      );
    } else {
      this.filteredData = this.data;
    }
  }

  ProductAdd() {
    this.router.navigate(['/productadd']);
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  closeModal() {
    this.modalRef?.hide();
  }
}


