import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-productos-asociados',
  templateUrl: './productos-asociados.component.html',
  styleUrls: ['./productos-asociados.component.css']
})
export class ProductosAsociadosComponent {
  menuVisible: boolean = false

constructor(private router: Router, private activatedRoute: ActivatedRoute) {}

isRouteActive(route: string): boolean {
  return this.router.isActive(route, false);
}
}