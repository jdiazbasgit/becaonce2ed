import { Component } from '@angular/core';

@Component({
  selector: 'app-pipe-personalizado',
  templateUrl: './pipe-personalizado.component.html',
  styleUrls: ['./pipe-personalizado.component.css']
})
export class PipePersonalizadoComponent {
  numeros:Array<number>=[1,2,3,4,5,6,7]
}
