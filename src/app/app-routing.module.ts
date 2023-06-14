import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { CuentasComponent } from './cuentas/cuentas.component';
import { MovimientosComponent } from './movimientos/movimientos.component';
import { OperacionesComponent } from './operaciones/operaciones.component';
import { DetallesCuentaComponent } from './detalles-cuenta/detalles-cuenta.component';
import { ProductosComponent } from './productos/productos.component';
import { PanelAdministradorComponent } from './panel-administrador/panel-administrador.component';

const routes: Routes = [
  {path:`landing`, component:LandingComponent},
  {path:`cuentas`, component:CuentasComponent},
  {path:`movimientos`, component:MovimientosComponent},
  {path:`operaciones`, component:OperacionesComponent},
  {path:`detalles`, component:DetallesCuentaComponent},
  {path:`productos`, component:ProductosComponent},
  {path:`paneladministrador`, component:PanelAdministradorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
