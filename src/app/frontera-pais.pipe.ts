import { Pipe, PipeTransform } from '@angular/core';
import { PaisesService } from './paises.service';

@Pipe({
  name: 'fronteraPais'
})
export class FronteraPaisPipe implements PipeTransform {

  constructor(private service: PaisesService) {}

  async transform(value: string): Promise<any> {
    const datos = await this.service.dameDatos(`https://restcountries.com/v3.1/name/${value}`);
    let fronteras = await Promise.all(datos[0].borders.map(async (border: string) => {
      const borderData = await this.service.dameDatos(`https://restcountries.com/v3.1/alpha/${border}`);
      return borderData[0].name.common;
    }));
    return fronteras;
  }
}

