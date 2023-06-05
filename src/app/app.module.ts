import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NavComponent } from './nav/nav.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';

import { HeaderComponent } from './componentes/header/header.component';
import { LoginComponent } from './login/login.component';

import { FooterComponent } from './componentes/footer/footer.component';

import { ProfileComponent } from './componentes/profile/profile.component';
import { ProductComponent } from './product/product.component';
import { OfferComponent } from './offer/offer.component';

import { HeaderComponent } from './componentes/header/header.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatTableModule } from '@angular/material/table';
import { ProductDataComponent } from './product-data/product-data.component';
import { MatPaginatorModule } from '@angular/material/paginator';

import { ProductDataComponent } from './product-data/product-data.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { CategoryComponent } from './category/category.component';
import { SubcategoryComponent } from './componentes/subcategory/subcategory.component';
import { DocumentTypeComponent } from './componentes/document-type/document-type.component';



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
    HeaderComponent,
    FooterComponent,
    CategoryComponent,
    SubcategoryComponent,
    DocumentTypeComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatSlideToggleModule,
    MatTableModule,
    MatPaginatorModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {

}
