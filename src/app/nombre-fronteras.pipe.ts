import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'nombreFronteras'
})
export class NombreFronterasPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
