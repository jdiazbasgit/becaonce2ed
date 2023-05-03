import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'nombreFrontera'
})
export class NombreFronteraPipe implements PipeTransform {

  transform(value: string, ...args: number[]): string {
    
    return "hola";
  }

}
