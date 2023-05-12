import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-thor',
  template: `<h2>Estoy dentro de Thor</h2>
  <ng-content></ng-content>
  <h1>Me esta llegando el parametro saludo con valor:{{saludo}}</h1>
  `
})
export class ThorComponent {
@Input() saludo:string=""


}
