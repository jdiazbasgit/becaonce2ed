import { Component } from '@angular/core';

@Component({
  selector: 'app-pruebas-pipes',
  templateUrl: './pruebas-pipes.component.html',
  styleUrls: ['./pruebas-pipes.component.css']
})
export class PruebasPipesComponent {
  numeros:Array<number>=[1,2,3,4,5,6,7,8,9,255]
  rojo:string='rojo'
  negro:string='negro'
}