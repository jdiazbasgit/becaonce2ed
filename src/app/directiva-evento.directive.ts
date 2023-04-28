import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appDirectivaEvento]'
})
export class DirectivaEventoDirective {

  constructor(private el: ElementRef) { }

  @HostListener("mouseout")
  cambiarImagen(): void {
    this.el.nativeElement.src = "https://media-cdn.tripadvisor.com/media/photo-s/05/5d/47/6f/la-cusquenita-tradicional.jpg";
  }

  @HostListener("click")
  quitarImagen(): void {
    this.el.nativeElement.src = "nada";
  }

}
