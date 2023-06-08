import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NavComponent } from './componentes/nav/nav.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './componentes/login/login.component';
import { ProfileComponent } from './componentes/profile/profile.component';
import { ProductComponent } from './componentes/product/product.component';
import { OfferComponent } from './componentes/offer/offer.component';
import { HeaderComponent } from './componentes/header/header.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';

import { EjemploComponent } from './ejemplo/ejemplo.component';
import { CardTypeComponent } from './componentes/card-type/card-type.component';
import { CategoryComponent } from './componentes/category/category.component';
import { ConfigurationComponent } from './componentes/configuration/configuration.component';
import { DocumentTypeComponent } from './componentes/document-type/document-type.component';
import { ExistingProductComponent } from './componentes/existing-product/existing-product.component';
import { RolComponent } from './componentes/rol/rol.component';
import { SoldProductComponent } from './componentes/sold-product/sold-product.component';
import { SubcategoryComponent } from './componentes/subcategory/subcategory.component';
import { UserComponent } from './componentes/user/user.component';
import { ModalDocumentTypesComponent } from './componentes/modal-document-types/modal-document-types.component';
import { ModalCardTypesComponent } from './componentes/modal-card-types/modal-card-types.component';

@NgModule({
  declarations: [
    NavComponent,
    AppComponent,
    HeaderComponent,
    LoginComponent,
    ProfileComponent,
    ProductComponent,
    OfferComponent,
    FooterComponent,
    CategoryComponent,
    SubcategoryComponent,
    DocumentTypeComponent,
    UserComponent,
    RolComponent,
    SoldProductComponent,
    ExistingProductComponent,
    CardTypeComponent,
    ConfigurationComponent,
    EjemploComponent,
    ModalDocumentTypesComponent,
    ModalCardTypesComponent

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
