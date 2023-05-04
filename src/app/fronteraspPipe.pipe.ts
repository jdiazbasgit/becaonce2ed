import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'fronteras'
})
export class FronterasPipePipe implements PipeTransform {

  transform(value: string, paises: any[]): string {
    let nombreCompleto = '';
    paises.forEach(pais =>{
      if(pais.cca3=== value){
        nombreCompleto = pais.name.common;
      }
    });
    return nombreCompleto;
  }

}
