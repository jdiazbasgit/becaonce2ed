import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-nombre-frontera',
  templateUrl: './nombre-frontera.component.html',
  styleUrls: ['./nombre-frontera.component.css']
})
export class NombreFronteraComponent {
  title:string = 'nombreFrontera';

  cambiar(){
    this.title="he cambiado el title";
  }
  verTitle(){
    console.log(this.title)
  }

}
