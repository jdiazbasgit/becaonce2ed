import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appMiDirectiva]'
})
export class MiDirectivaDirective {

  constructor(private el:ElementRef, private render:Renderer2) {

    let h1= document.createElement("h1");
    h1.innerHTML="soy el h1 incrustado";
    render.appendChild(el.nativeElement,h1)

   }

}
