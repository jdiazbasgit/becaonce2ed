import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';

import { GeneralesComponent } from './generales/generales.component';
import { GeograficosComponent } from './geograficos/geograficos.component';
import { BanderasComponent } from './banderas/banderas.component';
import { FronterasComponent } from './fronteras/fronteras.component';
import { PipeFronteraComponent } from './pipe-frontera/pipe-frontera.component';
import { NombrePaisPipe } from './fronteras/nombre-pais.pipe';
import { NombreFronterasPipe } from './nombre-fronteras.pipe';

@NgModule({
  declarations: [
    AppComponent,
    GeneralesComponent,
    GeograficosComponent,
    BanderasComponent,
    FronterasComponent,
    PipeFronteraComponent,
    NombrePaisPipe,
    NombreFronterasPipe,
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
