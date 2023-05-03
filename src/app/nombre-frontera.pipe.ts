import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'nombreFrontera'
})
export class NombreFronteraPipe implements PipeTransform {

  transform(value: string, ...args: number[]): string {
    let salida: string = "Selecciona " + value
    for (let i = 0; i < args[0]; i++) {
      salida = "*" + salida;
    }
    for (let i = 0; i < args[1]; i++) {
      salida = salida + ".";
    }
    return salida;
  }
}

