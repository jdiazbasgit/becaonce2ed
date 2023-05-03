import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';

import { GeneralesComponent } from './generales/generales.component';
import { GeograficosComponent } from './geograficos/geograficos.component';
import { BanderasComponent } from './banderas/banderas.component';
import { FronterasComponent } from './fronteras/fronteras.component';
import { PipePersonalizadoComponent } from './pipe-personalizado/pipe-personalizado.component';
import { MiPipePipe } from './mi-pipe.pipe';
import { PipeSelectPipe } from './pipe-select.pipe';
import { NombreFronteraPipe } from './nombre-frontera.pipe';
import { NombreFronteraComponent } from './nombre-frontera/nombre-frontera.component';


@NgModule({
  declarations: [
    AppComponent,
    GeneralesComponent,
    GeograficosComponent,
    BanderasComponent,
    FronterasComponent,
    PipePersonalizadoComponent,
    MiPipePipe,
    PipeSelectPipe,
    NombreFronteraPipe,
    NombreFronteraComponent
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
