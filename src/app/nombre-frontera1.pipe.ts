import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'nombreFrontera1'
})
export class NombreFrontera1Pipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
