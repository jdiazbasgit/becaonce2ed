import { Pipe, PipeTransform } from '@angular/core';
import { FronterasComponent } from 'src/app/fronteras/fronteras.component';

const countries = [
  { code: 'USA', name: 'Estados Unidos' },
  { code: 'CAN', name: 'Canadá' },
  { code: 'MEX', name: 'México' },
  // Agrega más países aquí...
];

@Pipe({
  name: 'nombreFrontera1'
})
export class NombreFrontera1Pipe implements PipeTransform {
  
  transform(value: string, ...args: string[]): string {
    const countryCode = value.substring(0, 3);
    const country = countries.find((c: { code: string; }) => c.code === countryCode);

    if (country) {
      return `${country.name} - ${value.substring(3)}`;
    } else {
      return `País no encontrado para el código "${countryCode}"`;
    }
  }
  }


