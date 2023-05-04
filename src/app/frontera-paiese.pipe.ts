import { HttpClient } from '@angular/common/http';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'fronteraPaiese'
})
export class NombreFronteraPipe implements PipeTransform {

  constructor(private http: HttpClient) {}

  transform(value: string, ...args: string[]): string  {
    return value;
  
  }

}