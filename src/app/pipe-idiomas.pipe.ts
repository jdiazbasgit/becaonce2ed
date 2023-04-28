import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pipeIdiomas'
})
export class PipeIdiomasPipe implements PipeTransform {

transform(value: number, ...args: string[]): string {
    if(args[0]!='')
    {
      if(args[0]=='ingles'){
        switch(value)
        {
          case 1: return 'one';
          case 2: return 'two';
          case 3: return 'three';
          case 4: return 'four';
          case 5: return 'five';
          case 6: return 'six';
          case 7: return 'seven'; 
          default: return 'Translation not found for number '+value
        }
      }
      if(args[0]=='portugues'){
        switch (value) {
          case 1: return 'um';
          case 2: return 'dois';
          case 3: return 'três';
          case 4: return 'quatro';
          case 5: return 'cinco';
          case 6: return 'seis';
          case 7: return 'sete';   
          default: return 'Traducione non disponible un este momientu por digito '+value+ ', amigo'                    
        }        
      }
      if(args[0]=='spain'){
        switch (value) {
          case 1: return 'uno';
          case 2: return 'dos';
          case 3: return 'tres';
          case 4: return 'cuatro';
          case 5: return 'cinco';
          case 6: return 'seis';
          case 7: return 'siete'; 
          default: return 'Traducción no disponible para el número ' +value                       
        }  
      }
      switch (value) {
        case 1: return 'uno';
        case 2: return 'dos';
        case 3: return 'tres';
        case 4: return 'cuatro';
        case 5: return 'cinco';
        case 6: return 'seis';
        case 7: return 'siete'; 
        default: return 'Traducción no disponible para el número ' +value                        
      }  
    }
    return "No has escrito ningun idioma";
  }

}