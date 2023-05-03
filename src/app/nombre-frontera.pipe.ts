import { Pipe, PipeTransform } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Pipe({
  name: 'nombreFrontera'
})
export class NombreFronteraPipe implements PipeTransform {

  constructor(private http: HttpClient) {}

  transform(value: string, ...args: string[]): string  {
    let nombrePais = '';
    this.http.get<any[]>('https://restcountries.com/v2/all').subscribe(data => {
      const pais = data.find(p => p.name === value);
      if (pais) {
        nombrePais = pais.name;
      }
    });
    return nombrePais;
  }

}