import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pipeColores'
})
export class PipeColoresPipe implements PipeTransform {

  transform(value: string, ...args: string[]): string {
  
    if(args[0]=='foreground'){
      switch(value){
        case 'rojo': return 'text-danger'
        case 'verde': return 'text-success'
        case 'blanco': return 'text-white'
        case 'negro': return 'text-dark'
        case 'amarillo': return 'text-warning'
      }
    }
    if(args[0]=='background'){
      switch(value){
        case 'rojo': return 'bg-danger'
        case 'verde': return 'bg-success'
        case 'blanco': return 'bg-white'
        case 'negro': return 'bg-dark'
        case 'amarillo': return 'bg-warning'
        case 'France': return 'Gabacholand'
      }
    }
    return value
}
}