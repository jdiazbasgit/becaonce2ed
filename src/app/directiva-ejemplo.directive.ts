import { Directive, ElementRef, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appDirectivaEjemplo]'
})
export class DirectivaEjemploDirective {

@Input() appDirectivaEjemplo:string=""

  constructor(private el:ElementRef, private render:Renderer2) {
  
   }

   ngOnInit(){
    let h1=document.createElement("h1")
    h1.innerHTML=this.appDirectivaEjemplo
    this.render.appendChild(this.el.nativeElement,h1)
   }

}
