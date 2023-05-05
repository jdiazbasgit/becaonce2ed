import { Pipe, PipeTransform } from '@angular/core';
import { PaisesService } from '../paises.service';

@Pipe({
  name: 'nombrePais'
})
export class NombrePaisPipe implements PipeTransform {

  constructor(private service: PaisesService) {}

  transform(value: string): Promise<string> {
    return new Promise((resolve, reject) => {
      this.service.dameDatos("https://restcountries.com/v3.1/alpha/" + value)
        .subscribe((datos: any) => {
          resolve(datos[0].name.common);
        }, (error: any) => {
          reject(error);
        });
    });
  }

}


