import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NavComponent } from './nav/nav.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';

import { LoginComponent } from './login/login.component';

import { ProfileComponent } from './profile/profile.component';
import { ProductComponent } from './product/product.component';
import { OfferComponent } from './offer/offer.component';

import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

import { MatTableModule } from '@angular/material/table';
 
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
// import { MatToolbarModule } from '@angular/material/toolbar';
@NgModule({
  declarations: [
    
    NavComponent,
    AppComponent,
    HeaderComponent,
    LoginComponent, 
    ProfileComponent,
    ProductComponent,
    NavComponent,
    OfferComponent,
    HeaderComponent,
    FooterComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatSlideToggleModule,
   // MatToolbarModule,
    MatTableModule,
    MatPaginatorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {

}
