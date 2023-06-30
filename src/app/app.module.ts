import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { LandingComponent } from './landing/landing.component';
import { CuentasComponent } from './cuentas/cuentas.component';
import { DetallesCuentaComponent } from './detalles-cuenta/detalles-cuenta.component';
import { MovimientosComponent } from './movimientos/movimientos.component';
import { OperacionesComponent } from './operaciones/operaciones.component';
import { ProductosComponent } from './productos/productos.component';
import { AwardsFineComponent } from './componentes/awards-fine/awards-fine.component';
import { AwardsFinesConfigurationComponent } from './componentes/awards-fines-configuration/awards-fines-configuration.component';
import { AwardsFinesTypeComponent } from './componentes/awards-fines-type/awards-fines-type.component';
import { ConfigurationComponent } from './componentes/configuration/configuration.component';
import { CurrentAccountComponent } from './componentes/current-account/current-account.component';
import { DescriptionComponent } from './componentes/description/description.component';
import { FeeComponent } from './componentes/fee/fee.component';
import { IdentificationTypeComponent } from './componentes/identification-type/identification-type.component';
import { ProfileComponent } from './componentes/profile/profile.component';
import { RolComponent } from './componentes/rol/rol.component';
import { TransactionComponent } from './componentes/transaction/transaction.component';
import { TransactionsAwardsFineComponent } from './componentes/transactions-awards-fine/transactions-awards-fine.component';
import { TypeAccountComponent } from './componentes/type-account/type-account.component';
import { UserComponent } from './componentes/user/user.component';
import { ModalUserComponent } from './componentes/modal-user/modal-user.component';
import { ModalTransactionsAwardsFineComponent } from './componentes/modal-transactions-awards-fine/modal-transactions-awards-fine.component';
import { ModalConfigurationComponent } from './componentes/modal-configuration/modal-configuration.component';
import { HazteClienteComponent } from './hazte-cliente/hazte-cliente.component';
import { PanelAdministradorComponent } from './panel-administrador/panel-administrador.component';
import { ModalAwardsFineComponent } from './componentes/modal-awards-fine/modal-awards-fine.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';





@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    LoginComponent,
    FooterComponent,
    LandingComponent,
    CuentasComponent,
    DetallesCuentaComponent,
    MovimientosComponent,
    OperacionesComponent,
    ProductosComponent,
    AwardsFineComponent,
    AwardsFinesConfigurationComponent,
    AwardsFinesTypeComponent,
    ConfigurationComponent,
    CurrentAccountComponent,
    DescriptionComponent,
    FeeComponent,
    IdentificationTypeComponent,
    ProfileComponent,
    RolComponent,
    TransactionComponent,
    TransactionsAwardsFineComponent,
    TypeAccountComponent,
    UserComponent,
    ModalUserComponent,
    ModalTransactionsAwardsFineComponent,
    ModalConfigurationComponent,
    HazteClienteComponent,
    PanelAdministradorComponent,
    ModalAwardsFineComponent,

    PanelAdministradorComponent,
    ModalAwardsFineComponent,

 
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
   MatFormFieldModule, 
   MatInputModule,
    MatButtonModule,
     MatIconModule,
     MatCardModule
    
    
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }