import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { OdinComponent } from './odin/odin.component';
import { ThorComponent } from './thor/thor.component';
import { LokiComponent } from './loki/loki.component';

@NgModule({
  declarations: [
    AppComponent,
    OdinComponent,
    ThorComponent,
    LokiComponent
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
