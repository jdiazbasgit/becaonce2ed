import { Pipe, PipeTransform } from '@angular/core';
import { PaisesService } from './paises.service';

@Pipe({
  name: 'pipeAcronimos'
})
export class PipeAcronimosPipe implements PipeTransform {

  constructor(private service: PaisesService) { }

  transform(value: string, ...args: string[]): string {
    console.log(value + " acronimo que llega al pipe")
    if (value.length == 3) {
      this.service.dameDatosPorHTTPService("https://restcountries.com/v3.1/alpha/" + value)
        .subscribe((datosPaisAcronimo: any) => {
          value = datosPaisAcronimo[0].name.common
          console.log(value + " nombre del pais que sale del pipe tras el fetch")
        }
        )
      //this.comprobar(value)
    }
    return value;
  }

  // async comprobar(value:string){
  //   await this.service.dameDatosPorHTTPService("https://restcountries.com/v3.1/alpha/" + value)
  //       .subscribe((datosPaisAcronimo: any) => {
  //         value = datosPaisAcronimo[0].name.common
  //         console.log(value + " nombre del pais que sale del pipe tras el fetch")
  //         return value
  //       }
  //     )
  // }

}
