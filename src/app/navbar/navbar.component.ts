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

  constructor(private elementRef: ElementRef, private router: Router) { }

  ngDoCheck() {
    //if (sessionStorage['cuenta'] != undefined && !this.cuentaElegida) {
      //this.cuentaElegida = true
      //this.cuenta = sessionStorage['cuenta']
      // this.elementRef.nativeElement.querySelector("#home").classList.remove("seleccionado")
    //}
    // if (this.router.url == "/cuentas" && sessionStorage['cuenta'] != undefined){
    //   this.deselegirCuenta()
    // }

    if (this.router.url == "/cuentas" && !this.elementRef.nativeElement.querySelector("#home").classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#home").classList.add("seleccionado")
    }
    if (this.router.url == "/detalles" && !this.elementRef.nativeElement.querySelector("#detalles").classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#detalles").classList.add("seleccionado")
    }
    if (this.router.url == "/movimientos" && !this.elementRef.nativeElement.querySelector("#movimientos").classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#movimientos").classList.add("seleccionado")
    }
    if (this.router.url == "/operaciones" && !this.elementRef.nativeElement.querySelector("#operaciones").classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#operaciones").classList.add("seleccionado")
    }
    if (this.router.url == "/paneadministrador" && !this.elementRef.nativeElement.querySelector("#admin").classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#admin").classList.add("seleccionado")
    }
  }

  // deselegirCuenta() {
  //   sessionStorage.removeItem('cuenta')
  //   this.cuentaElegida = false
  //   this.elementRef.nativeElement.querySelector("#home").classList.add("seleccionado")
  //   this.elementRef.nativeElement.querySelector("#admin")?.classList.remove("seleccionado")
  // }

  abrirPanelAdmin() {
    this.elementRef.nativeElement.querySelector("#home").classList.remove("seleccionado")
    this.elementRef.nativeElement.querySelector("#admin").classList.add("seleccionado")
  }

  comprobarRuta() {
    return this.router.url
  }

  comprobarRolAdmin() {
    if (sessionStorage['rol'] == "ROLE_ADMIN")
      return true
    return false
  }

  limpiarActives() {
    let links = this.elementRef.nativeElement.querySelectorAll(".nav-link")
    links.forEach((link: any) => {
      link.classList.remove("seleccionado")
    });
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
