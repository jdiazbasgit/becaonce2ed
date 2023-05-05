import { Component } from '@angular/core';
import { PaisesService } from '../paises.service';
import { NombrePaisPipe } from '../fronteras/nombre-pais.pipe';


@Component({
  selector: 'app-pipe-frontera',
  templateUrl: './pipe-frontera.component.html',
  styleUrls: ['./pipe-frontera.component.css']
})
export class PipeFronteraComponent {
  fronteras: Array<string> = [];

  constructor(private service: PaisesService, private nombrePais: NombrePaisPipe) {}

  async transformarFronteras() {
    for (let frontera of this.fronteras) {
      let nombre = await this.nombrePais.transform(frontera);
      console.log(nombre);
    }
  }
}
