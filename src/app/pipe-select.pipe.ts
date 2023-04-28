import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pipeSelect'
})
export class PipeSelectPipe implements PipeTransform {

  transform(value: string, ...args: number[]): string {
    let salida = "Selecciona " + value;
    for (let i = 0; i < args[0]; i++) {
      salida = salida + ".";
    }
    return salida;
  }

}
