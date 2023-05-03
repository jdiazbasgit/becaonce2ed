import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'nombreFrontera'
})
export class NombreFronteraPipe implements PipeTransform {

  transform(value: string, ...args: number[]): string {
    let salida:string=""
    for (let i=0 ; i<args[0]; i++)
    return "hola";
  }

}
