import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NavComponent } from './nav/nav.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { ProfileComponent } from './profile/profile.component';
import { ProductComponent } from './product/product.component';
import { OfferComponent } from './offer/offer.component';
import { ProductDataComponent } from './product-data/product-data.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
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
    ProductDataComponent,
    ProductEditComponent,
    HeaderComponent,
    FooterComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatSlideToggleModule,
    // MatToolbarModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {

}
