import { Component, ElementRef } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  mostrarCuenta: boolean = false
  cuenta: string = ""

  constructor(private elementRef: ElementRef, private router: Router) { }

  ngDoCheck() {
    //console.log("hola soy ngDoCheck :)")
    if (sessionStorage['cuenta'] != undefined || sessionStorage['cuenta'] == this.cuenta && !this.mostrarCuenta) {
      this.mostrarCuenta = true
      this.cuenta = sessionStorage['cuenta']
    }

    if (this.router.url == "/cuentas" || this.router.url == "/paneladministrador" && this.mostrarCuenta)
       this.mostrarCuenta = false

    if (this.router.url == "/cuentas" && !this.elementRef.nativeElement.querySelector("#home")?.classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#home")?.classList.add("seleccionado")
    }
    if (this.router.url == "/detalles" && !this.elementRef.nativeElement.querySelector("#detalles")?.classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#detalles")?.classList.add("seleccionado")
    }
    if (this.router.url == "/movimientos" && !this.elementRef.nativeElement.querySelector("#movimientos")?.classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#movimientos")?.classList.add("seleccionado")
    }
    if (this.router.url == "/operaciones" && !this.elementRef.nativeElement.querySelector("#operaciones")?.classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#operaciones")?.classList.add("seleccionado")
    }
    if (this.router.url == "/paneladministrador" && !this.elementRef.nativeElement.querySelector("#admin")?.classList.contains("seleccionado")) {
      this.limpiarActives()
      this.elementRef.nativeElement.querySelector("#admin")?.classList.add("seleccionado")
    }
  }

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

  comprobarCuentaElegida() {
    if (sessionStorage['cuenta'] != undefined)
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