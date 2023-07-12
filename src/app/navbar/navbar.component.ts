import { Component, Directive, ElementRef, OnInit, Renderer2 } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  // menuVisible: boolean = false;
  cuentaElegida: boolean = false
  cuenta: string = ""

  constructor(private elementRef: ElementRef) { }

  ngDoCheck() {
    if (sessionStorage['cuenta'] != undefined && !this.cuentaElegida) {
      this.cuentaElegida = true
      this.cuenta = sessionStorage['cuenta']
      this.elementRef.nativeElement.querySelector("#home").classList.remove("seleccionado")
    }
  }

  deselegirCuenta() {
    sessionStorage.removeItem('cuenta')
    this.cuentaElegida = false
    this.elementRef.nativeElement.querySelector("#home").classList.add("seleccionado")
    this.elementRef.nativeElement.querySelector("#admin").classList.remove("seleccionado")
  }

  abrirPanelAdmin(){
    this.elementRef.nativeElement.querySelector("#home").classList.remove("seleccionado")
    this.elementRef.nativeElement.querySelector("#admin").classList.add("seleccionado")
  }

  comprobarRolAdmin(){
    if(sessionStorage['rol'] == "ROLE_ADMIN")
    return true
    return false
  }
  
}



// toggleMenu(): void {
//   this.menuVisible = !this.menuVisible;
// }

// isRouteActive(route: string): boolean {
//   return this.router.isActive(route, true);
// }


// function highlightActiveButton(activeButtonId: string) {
//   const buttons = document.querySelectorAll('.nav-link button');

//   buttons.forEach(button => {
//     button.classList.remove('active');
//   });

//   const activeButton = document.getElementById(activeButtonId);
//   if (activeButton) {
//     activeButton.classList.add('active');
//   }
// }

// @Directive({
//   selector: '[highlightActiveButton]'
// })
// export class HighlightActiveButtonDirective implements OnInit {
//   constructor(private router: Router, private el: ElementRef, private renderer: Renderer2) {}

//     ngOnInit() {
//       this.router.events.subscribe(event => {
//         if (event instanceof NavigationEnd) {
//           const currentRoute = this.router.url.slice(1);

//           if (currentRoute === this.el.nativeElement.id) {
//             this.renderer.addClass(this.el.nativeElement, 'active');
//           } else {
//             this.renderer.removeClass(this.el.nativeElement, 'active');
//           }
//         }
//       });
//     }
//   }
