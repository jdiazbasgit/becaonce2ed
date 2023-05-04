import { HttpClient } from '@angular/common/http';
import { Pipe, PipeTransform } from '@angular/core';


//const countries = [
  //{ code: 'USA', name: 'Estados Unidos' },
 // { code: 'CAN', name: 'Canadá' },
 // { code: 'MEX', name: 'México' },
  // Agrega más países aquí...
//];

@Pipe({
  name: 'nombreFrontera1'
})
export class NombreFrontera1Pipe implements PipeTransform {
  constructor(private http: HttpClient){}

  transform(value: string) : Promise<string>{

    const codigo = value.substring(0, 3);
    const url = `https://restcountries.com/v3.1/alpha/${codigo}`;

    return this.http.get(url)
    .toPromise()
    .then((Response: any) =>{
const nombreFrontera = Response.borders[value];

if  (nombreFrontera) {
  return nombreFrontera;
} else{
  return `Nombre de frontera no encontrado para el código "${codigo}"`;
}

    })
    .catch(() => {

      return `Error al obtener información de la frontera para el código "${codigo}"`;
    });
    
  }
  
  //transform(value: string, ...args: string[]): string {
    /*const countryCode = value.substring(0, 3);
    const country = countries.find((c: { code: string; }) => c.code === countryCode);

    if (country) {
      return `${country.name} - ${value.substring(3)}`;
    } else {
      return `País no encontrado para el código "${countryCode}"`;
    }
  }*/
  }


