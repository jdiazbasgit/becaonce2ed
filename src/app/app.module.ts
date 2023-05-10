import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { CuentasComponent } from './cuentas/cuentas.component';
import { FooterComponent } from './footer/footer.component';
import { MovimientosComponent } from './movimientos/movimientos.component';
import { OperacionesComponent } from './operaciones/operaciones.component';
import { ProductosComponent } from './productos/productos.component';
import { DetallesCuentaComponent } from './detalles-cuenta/detalles-cuenta.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    LandingPageComponent,
    CuentasComponent,
    FooterComponent,
    MovimientosComponent,
    OperacionesComponent,
    ProductosComponent,
    DetallesCuentaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
