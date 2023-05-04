import { HttpClient } from '@angular/common/http';
import { Pipe, PipeTransform } from '@angular/core';
import { map  } from 'rxjs/operators';

@Pipe({
  name: 'nombreFrontera'
})
export class NombreFronteraPipe implements PipeTransform {
  constructor(private http: HttpClient) {}

  transform(countryCode: string): Promise<string> {
    return this.http
    .get<any>('https://restcountries.com/v3.1/alpha/')
    .pipe(map(response => response[0].name.common))
    .toPromise();
  }

}
