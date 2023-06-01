import { Component, OnInit } from '@angular/core';

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
  public elementsProduct: string | undefined;
  htmlContent: string = '';

  products: Product[] = [
    {
      image: 'https://images.byflou.com/13/3/images/products/0/0/bies-bryghus-oel-bies-bryghus-oel-anno-1841-3628185.gif',
      title: 'Cerveza del Bies Bryghus 1',
      description: 'Bies Bryghus Beer',
      price: 19.99,
      symbol: "€"
    },
    {
      image: 'https://images.byflou.com/13/3/images/products/0/0/bies-bryghus-oel-bies-bryghus-oel-anno-1841-3628185.gif',
      title: 'Cerveza del Bies Bryghus 2',
      description: 'Bies Bryghus Beer',
      price: 24.99,
      symbol: "€"
    },
    {
      image: 'https://images.byflou.com/13/3/images/products/0/0/bies-bryghus-oel-bies-bryghus-oel-anno-1841-3628185.gif',
      title: 'Cerveza del Bies Bryghus 3',
      description: 'Bies Bryghus Beer',
      price: 14.99,
      symbol: "€"
    },
    {
      image: 'https://images.byflou.com/13/3/images/products/0/0/bies-bryghus-oel-bies-bryghus-oel-anno-1841-3628185.gif',
      title: 'Cerveza del Bies Bryghus 3',
      description: 'Bies Bryghus Beer',
      price: 14.99,
      symbol: "€"
    },
    {
      image: 'https://images.byflou.com/13/3/images/products/0/0/bies-bryghus-oel-bies-bryghus-oel-anno-1841-3628185.gif',
      title: 'Cerveza del Bies Bryghus 3',
      description: 'Bies Bryghus Beer',
      price: 14.99,
      symbol: "€"
    }
  ];
}
