import { Directive, ElementRef, Input, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appDirectivaEjemplo]'
})
export class DirectivaEjemploDirective implements OnInit {
@Input() appDirectivaEjemplo:any=""
  constructor(private el:ElementRef, private render:Renderer2) { 
   
  }
  ngOnInit(): void {
    let h1=document.createElement("h1")
    h1.innerHTML=this.appDirectivaEjemplo
    this.render.appendChild(this.el.nativeElement,h1)

  }
  

  

}
