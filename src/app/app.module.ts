import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
<<<<<<< HEAD
import { PrimerComponenteComponent } from './primer-componente/primer-componente.component';
import { UnoComponent } from './uno/uno.component';
import { DosComponent } from './dos/dos.component';
import { TresComponent } from './tres/tres.component';
import { MenuComponent } from './menu/menu.component';
=======
import { LoginComponent } from './login/login.component';
>>>>>>> 184b25c0d034011f4f3dabb3ba52d0c463d84587

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    PrimerComponenteComponent,
    UnoComponent,
    DosComponent,
    TresComponent,
    MenuComponent
=======
    LoginComponent
>>>>>>> 184b25c0d034011f4f3dabb3ba52d0c463d84587
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
