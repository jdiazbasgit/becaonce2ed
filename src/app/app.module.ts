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
import { PruebasPipesComponent } from './pruebas-pipes/pruebas-pipes.component';
import { PipeIdiomasPipe } from './pipe-idiomas.pipe';
import { PipeColoresPipe } from './pipe-colores.pipe';
import { PipeAcronimosPipe } from './pipe-acronimos.pipe';
import { DirectivaEjemploDirective } from './directiva-ejemplo.directive';

@NgModule({
  declarations: [
    AppComponent,
    GeneralesComponent,
    GeograficosComponent,
    BanderasComponent,
    FronterasComponent,
    PipeIdiomasPipe,
    PruebasPipesComponent,
    PipeColoresPipe,
    PipeAcronimosPipe,
    DirectivaEjemploDirective,
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
