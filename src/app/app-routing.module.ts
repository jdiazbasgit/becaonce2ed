import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { CuentasComponent } from './cuentas/cuentas.component';
import { MovimientosComponent } from './movimientos/movimientos.component';
import { OperacionesComponent } from './operaciones/operaciones.component';
import { ProductosComponent } from './productos/productos.component';
import { DetallesCuentaComponent } from './detalles-cuenta/detalles-cuenta.component';

const routes: Routes = [
  {path: 'landing', component: LandingPageComponent },
  {path: 'cuentas', component: CuentasComponent },
  {path: 'movimientos', component: MovimientosComponent },
  {path: 'operar', component: OperacionesComponent },
  {path: 'productos', component: ProductosComponent },
  {path: 'detallescuenta', component: DetallesCuentaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
