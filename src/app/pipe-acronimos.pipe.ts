import { Pipe, PipeTransform } from '@angular/core';
import { PaisesService } from './paises.service';
import { ActivatedRoute, Router } from '@angular/router';

@Pipe({
  name: 'pipeAcronimos'
})
export class PipeAcronimosPipe implements PipeTransform {

  constructor(private service: PaisesService, private router:Router, private rutaActiva: ActivatedRoute) { }

  transform(value: string[], ...args: string[]): string[] {
    //console.log(value + " acronimo que llega al pipe")
    for (let index = 0; index < value.length; index++) {
      if (value[index].length == 3) {
        this.service.dameDatosPorHTTPService("https://restcountries.com/v3.1/alpha/" + value[index])
        .subscribe((datosPaisAcronimo: any) => {
          value[index] = datosPaisAcronimo[0].name.common;
          //console.log(value + " nombre del pais que sale del pipe tras el fetch");
        }
        )
      }
    }
    // if (value.length == 3) {
    //   this.service.dameDatosPorHTTPService("https://restcountries.com/v3.1/alpha/" + value)
    //   .subscribe((datosPaisAcronimo: any) => {
    //     value = datosPaisAcronimo[0].name.common;
    //     console.log(value + " nombre del pais que sale del pipe tras el fetch");
    //   }
    //   )
    // }
    //console.log(value + " nombre del pais que sale del pipe tras el fetch")
    return value
  }

  // async comprobar(value:string):Promise<string>{
  //   await this.service.dameDatosPorHTTPService("https://restcountries.com/v3.1/alpha/" + value)
  //     .subscribe((datosPaisAcronimo: any) => {
  //       value = datosPaisAcronimo[0].name.common;
  //       console.log(value + " nombre del pais que sale del pipe tras el fetch");
  //     }
  //     );
  //     return value
  // }

}
